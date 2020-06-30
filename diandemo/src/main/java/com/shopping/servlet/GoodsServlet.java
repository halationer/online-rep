package com.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.shopping.common.ServerResponse;
import com.shopping.common.UserInfo;
import com.shopping.service.IGoodsService;
import com.shopping.service.IUserService;
import com.shopping.service.impl.GoodsServiceImpl;
import com.shopping.service.impl.UserServiceImpl;


@WebServlet("/goods")
public class GoodsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String type=request.getParameter("type");
		if(type.equals("detail"))
		{
			detail(request, response);
		}
		if(type.equals("list")) {
			list(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public void detail(HttpServletRequest request, HttpServletResponse response)
	{
	
		Integer productId=Integer.parseInt(request.getParameter("productId"));
	    IGoodsService goodsService=new GoodsServiceImpl();
		ServerResponse se=goodsService.detail(productId);	
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		Gson gson=new Gson();
		String json=gson.toJson(se);
		PrintWriter pw;
		try 
		{
			
			pw = response.getWriter();
			pw.write(json);
			pw.close();
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}
	public void list(HttpServletRequest request, HttpServletResponse response)
	{
	
		Integer categoryId=Integer.parseInt(request.getParameter("categoryId"));
		Integer pageNum=Integer.parseInt(request.getParameter("pageNum"));
		Integer pageSize=Integer.parseInt(request.getParameter("pageSize"));
		String keyword=request.getParameter("keyword");
		String orderBy=request.getParameter("orderBy");
	    IGoodsService goodsService=new GoodsServiceImpl();
		ServerResponse se=goodsService.list(categoryId, keyword, pageNum, pageSize, orderBy);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		Gson gson=new Gson();
		String json=gson.toJson(se);
		PrintWriter pw;
		try 
		{
			pw = response.getWriter();
			pw.write(json);
			pw.close();
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}
}
