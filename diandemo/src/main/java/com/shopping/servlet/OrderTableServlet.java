package com.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.shopping.common.Const;
import com.shopping.common.ServerResponse;
import com.shopping.common.UserInfo;
import com.shopping.service.IOrderTableService;
import com.shopping.service.IShoppingCartService;
import com.shopping.service.IUserService;
import com.shopping.service.impl.OrderTableServiceImpl;
import com.shopping.service.impl.ShoppingCartService;
import com.shopping.service.impl.UserServiceImpl;

/**
 * Servlet implementation class OrderTableServlet
 */
@WebServlet("/OrderTableServlet")
public class OrderTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderTableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		String type=request.getParameter("type");
		System.out.println("new request");
		if(type.equals("create")) {
			create(request, response);
		}
		else if(type.equals("get_order_cart_product")){
			get_order_cart_product(request, response);
		}
		else if(type.equals("list")) {
			list(request, response);
		}
        else if(type.equals("detail")){
        	detail(request, response);
		}
       else if(type.equals("cancel")){
    	   cancel(request, response);
       }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//UserInfo userInfo=(UserInfo) request.getSession().getAttribute(Const.CURRRNTSUER);
	
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		IOrderTableService orderTableService=new OrderTableServiceImpl();
		//Integer id=1;
		
		Integer id = 1;
		if(request.getSession().getAttribute("userInfoId") != null)
		{
			id =  (Integer) request.getSession().getAttribute("userInfoId");
			System.out.println(id);
		}
		
		Integer shippingId=Integer.parseInt(request.getParameter("shippingId"));
		
		ServerResponse se=orderTableService.createOrder(id,shippingId);
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
	
	protected void get_order_cart_product(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		Integer count=Integer.parseInt(request.getParameter("count"));
		Integer productId=Integer.parseInt(request.getParameter("productId"));
		//Integer id=2;
		UserInfo userInfo=(UserInfo) request.getSession().getAttribute(Const.CURRRNTSUER);
		IOrderTableService orderTableService=new OrderTableServiceImpl();
		ServerResponse se=orderTableService.get_order_cart_product(userInfo.getId());
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
	
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		//Integer pageSize=Integer.parseInt(request.getParameter("pageSize"));
		//Integer pageNum=Integer.parseInt(request.getParameter("pageNum"));
		//UserInfo userInfo=(UserInfo) request.getSession().getAttribute(Const.CURRRNTSUER);
		
		Integer id = 1;
		if(request.getSession().getAttribute("userInfoId") != null)
		{
			id =  (Integer) request.getSession().getAttribute("userInfoId");
			System.out.println(id);
		}
		
		IOrderTableService orderTableService=new OrderTableServiceImpl();
		
		ServerResponse se=orderTableService.list(id,1,20);
		
		System.out.println(se.toString());
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
	
	protected void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		Integer count=Integer.parseInt(request.getParameter("count"));
		Integer productId=Integer.parseInt(request.getParameter("productId"));
		//Integer id=2;
		UserInfo userInfo=(UserInfo) request.getSession().getAttribute(Const.CURRRNTSUER);
		IShoppingCartService shoppingcartService=new ShoppingCartService();
		//ServerResponse se=shoppingcartService.ShoppingCartAdd(userInfo.getId(),productId,count);
		ServerResponse se=shoppingcartService.ShoppingCartAdd(1,productId,count);
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
	
	protected void cancel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		Integer orderNo=Integer.parseInt(request.getParameter("orderNo"));

		UserInfo userInfo=(UserInfo) request.getSession().getAttribute(Const.CURRRNTSUER);
		IOrderTableService orderTableService=new OrderTableServiceImpl();
		
		ServerResponse se=orderTableService.orderCancel(userInfo.getId(),orderNo);
		
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
