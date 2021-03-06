package com.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shopping.common.ServerResponse;
import com.shopping.common.UserTable;
import com.shopping.common.VirtualPage;
import com.shopping.service.IUserService;
import com.shopping.service.impl.UserServiceImpl;

@WebServlet("/manage/user")
public class UserServletM extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static IUserService service = new UserServiceImpl();
	private static int usernumber = 0;//伪用户数，实际用listener实现

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		switch(type)
		{
			case "login":
			{
				login(request, response);
				break;
			}
			case "list":
			{	
				list(request, response);
				break;
			}
			case "exit":
			{
				exit(request, response);
				break;
			}
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		ServerResponse<UserTable> res = service.mLoginLogic(username, password);
		
		Gson gson=new Gson();
		String json=gson.toJson(res);
		PrintWriter pw;
		pw = response.getWriter();
		pw.write(json);
		pw.close();
		
		String admin = gson.toJson(res.getData());
		if(res.getStatus() == 0)
		{
			System.out.println("on user login:" + ++usernumber);
			HttpSession session= request.getSession();
			session.setAttribute("admin", admin);
		}
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String pageSize = request.getParameter("pageSize");
		String pageNum = request.getParameter("pageNum");
		int pagesize = pageSize==null ? 10 : Integer.parseInt(pageSize);
		int pagenum = pageNum==null ? 1 : Integer.parseInt(pageNum);
		
		//访问数据库
		boolean onlog = false, access = false;
		HttpSession session = request.getSession();
		Object admin = session.getAttribute("admin");
		UserTable adminObject;
		if(admin != null) {
			onlog = true;
			adminObject = new Gson().fromJson((String)admin, UserTable.class);
			if(adminObject.getRole() == 0)
				access = true;
		}
		ServerResponse<List<UserTable>> res = service.mUserListLogic(onlog, access);
		ServerResponse<VirtualPage> pageres;
		
		if(onlog && access)
		{
			VirtualPage virtualPage = new VirtualPage(res, pagesize, pagenum);
			pageres = ServerResponse.serverResponseBySuccess(virtualPage);
		}
		else
		{
			pageres = ServerResponse.serverResponseByError("请登录管理员账号！");
		}
		
		Gson gson=new GsonBuilder().serializeNulls().create();
		String json=gson.toJson(pageres);
		PrintWriter pw;
		pw = response.getWriter();
		pw.write(json);
		pw.close();
	}

	private void exit(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		HttpSession session= request.getSession();
		String admin = (String)session.getAttribute("admin");
		
		ServerResponse res = service.mExitLogic(admin);
		
		Gson gson=new Gson();
		String json=gson.toJson(res);
		PrintWriter pw;
		pw = response.getWriter();
		pw.write(json);
		pw.close();
		
		if(session.getAttribute("admin") != null)
		{
			session.removeAttribute("admin");
			System.out.println("one user exit:" + --usernumber);
		}
	}
}
