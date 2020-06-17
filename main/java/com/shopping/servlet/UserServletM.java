package com.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.shopping.common.ServerResponse;
import com.shopping.common.UserTable;
import com.shopping.service.IUserService;
import com.shopping.service.impl.UserServiceImpl;

@WebServlet("/manage/user")
public class UserServletM extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static IUserService service = new UserServiceImpl();

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
				String pageSize = request.getParameter("pageSize");
				String pageNum = request.getParameter("pageNum");
				int pagesize = pageSize==null ? 10 : Integer.parseInt(pageSize);
				int pagenum = pageNum==null ? 1 : Integer.parseInt(pageNum);
				System.out.println(pagesize + " " + pagenum);
				response.sendRedirect("../acontent/auser.jsp");
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
		HttpSession session= request.getSession();
		session.setAttribute("admin", admin);
	}
}
