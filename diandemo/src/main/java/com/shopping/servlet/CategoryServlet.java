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
import com.shopping.common.Const;
import com.shopping.common.ServerResponse;
import com.shopping.common.UserTable;
import com.shopping.service.ICategoryService;
import com.shopping.service.impl.CategoryServiceImpl;

@WebServlet("/manage/category")
public class CategoryServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("search category...");
		
		String type=request.getParameter("type");
		if(type.equals("add_category")){
			add_category(request, response);
		}
		else if(type.equals("set_category_name")) {
			set_category_name(request, response);
		}
		else if(type.equals("del_category")) {
			del_category(request, response);
		}
		else if(type.equals("get_category_treeall")) {
			get_category_treeall(request, response);
		}
    
     }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void add_category(HttpServletRequest request, HttpServletResponse response)
	{
		ICategoryService categoryService=new CategoryServiceImpl();
		ServerResponse se;
		int parentId =Integer.parseInt( request.getParameter("parentId"));
		String  categoryname=request.getParameter("categoryName");
		Object admin = request.getSession().getAttribute("admin");
		if (admin==null) {
			se= ServerResponse.serverResponseByError(Const.ResponseCodeEnum.NEED_LOGIN.getCode(),Const.ResponseCodeEnum.NEED_LOGIN.getDesc());
		}
		else {
			UserTable userinfo = new Gson().fromJson((String)admin, UserTable.class);
			if (userinfo.getRole()!=Const.RoleEnum.ROLE_ADMIN.getCode())
				se=ServerResponse.serverResponseByError(Const.ResponseCodeEnum.NO_PRIVILEGE.getCode(),Const.ResponseCodeEnum.NO_PRIVILEGE.getDesc());
			else 
				se=categoryService.add_categoryLogic(parentId,categoryname);
		}
		Gson gson=new Gson();
		String json=gson.toJson(se);
		PrintWriter pw;
		try {
			
			pw = response.getWriter();
			pw.write(json);
			pw.close();
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}
	
	public void set_category_name(HttpServletRequest request, HttpServletResponse response)//更新品类名称
	{
		ICategoryService categoryService=new CategoryServiceImpl();
		
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String categoryName=request.getParameter("categoryName");
		
		ServerResponse se;
		
		Object admin = request.getSession().getAttribute("admin");
		if (admin==null) {
			se= ServerResponse.serverResponseByError(Const.ResponseCodeEnum.NEED_LOGIN.getCode(),Const.ResponseCodeEnum.NEED_LOGIN.getDesc());
		}
		else {
			UserTable userinfo = new Gson().fromJson((String)admin, UserTable.class);
			if (userinfo.getRole()!=Const.RoleEnum.ROLE_ADMIN.getCode())
				se=ServerResponse.serverResponseByError(Const.ResponseCodeEnum.NO_PRIVILEGE.getCode(),Const.ResponseCodeEnum.NO_PRIVILEGE.getDesc());
			else 
				se=categoryService.update_category_name(categoryId, categoryName);
		}
		
		Gson gson=new Gson();
		String json=gson.toJson(se);
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write(json);
			pw.close();
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}
	
	public void del_category(HttpServletRequest request, HttpServletResponse response)
	{
		ICategoryService categoryService=new CategoryServiceImpl();
		
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		
		ServerResponse se;
		
		Object admin = request.getSession().getAttribute("admin");
		if (admin==null) {
			se= ServerResponse.serverResponseByError(Const.ResponseCodeEnum.NEED_LOGIN.getCode(),Const.ResponseCodeEnum.NEED_LOGIN.getDesc());
		}
		else {
			UserTable userinfo = new Gson().fromJson((String)admin, UserTable.class);
			if (userinfo.getRole()!=Const.RoleEnum.ROLE_ADMIN.getCode())
				se=ServerResponse.serverResponseByError(Const.ResponseCodeEnum.NO_PRIVILEGE.getCode(),Const.ResponseCodeEnum.NO_PRIVILEGE.getDesc());
			else 
				se=categoryService.delete_category(categoryId);
		}
		Gson gson=new Gson();
		String json=gson.toJson(se);
		PrintWriter pw;
		try {
			pw = response.getWriter();
			pw.write(json);
			pw.close();
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	
	public void get_category_treeall(HttpServletRequest request, HttpServletResponse response) 
	{	
		ICategoryService categoryService=new CategoryServiceImpl();
		
		//获取用户和权限
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
		
		ServerResponse se = categoryService.get_category_tree(0, onlog, access);
		Gson gson=new Gson();
		String json=gson.toJson(se);
		PrintWriter pw;
		try {
			
			pw = response.getWriter();
			pw.write(json);
			pw.close();
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
}
