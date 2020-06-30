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
import com.shopping.common.ShoppingCart;
import com.shopping.common.UserInfo;
import com.shopping.service.IShoppingCartService;
import com.shopping.service.IUserService;
import com.shopping.service.impl.ShoppingCartService;
import com.shopping.service.impl.UserServiceImpl;

/**
 * Servlet implementation class ShoppingCartServlet
 */
@WebServlet("/cart")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.print("成功运行");
		request.setCharacterEncoding("utf-8");
		String type=request.getParameter("type");
		System.out.println("new request");
		if(type.equals("list")) {
			list(request, response);
		}
		else if(type.equals("add")){
			add(request, response);
		}
        else if(type.equals("update")){
        	update(request, response);
		}
       else if(type.equals("delete_product")){
    	   delete_product(request, response);
       }
       else if(type.equals("select")){
    	   select(request, response);
       }
       else if(type.equals("un_select")){
    	   un_select(request, response);
       }
       else if(type.equals("get_cart_product_count")){
    	   get_cart_product_count(request, response);
       }
       else if(type.equals("select_all")){
    	   select_all(request, response);
       }
       else if(type.equals("un_select_all")){
    	   un_select_all(request, response);
       }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//UserInfo userInfo=(UserInfo) request.getSession().getAttribute(Const.CURRRNTSUER);
		//Integer id=1;
//		if(request.getSession().getAttribute("flag")!=null)
//		{
//			//id=Integer.parseInt()
//		}
		
		
		Integer id = 1;
		if(request.getSession().getAttribute("userInfoId") != null)
		{
			id =  (Integer) request.getSession().getAttribute("userInfoId");
			System.out.println(id);
		}
		
		
		IShoppingCartService shoppingcartService=new ShoppingCartService();
		//ServerResponse se=shoppingcartService.ShoppingCartList(userInfo.getId());
		ServerResponse se=shoppingcartService.ShoppingCartList(id);
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
	
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.setContentType("text/html; charset=UTF-8");
//		response.setCharacterEncoding("utf-8");
		Integer count=Integer.parseInt(request.getParameter("count"));
		Integer productId=Integer.parseInt(request.getParameter("productId"));
		UserInfo userInfo=(UserInfo) request.getSession().getAttribute(Const.CURRRNTSUER);
		IShoppingCartService shoppingcartService=new ShoppingCartService();
		//用户id
		Integer idInteger = 1;
		if(request.getSession().getAttribute("userInfoId") != null)
		{
			idInteger =  (Integer) request.getSession().getAttribute("userInfoId");
			System.out.println(idInteger);
		}

		ServerResponse se=shoppingcartService.ShoppingCartAdd(idInteger,productId,count);
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
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer count=Integer.parseInt(request.getParameter("count"));
		Integer productId=Integer.parseInt(request.getParameter("productId"));
		UserInfo userInfo=(UserInfo) request.getSession().getAttribute(Const.CURRRNTSUER);
		IShoppingCartService shoppingcartService=new ShoppingCartService();
		ServerResponse se=shoppingcartService.ShoppingCartUpdate(userInfo.getId(),productId,count);
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
	
//	protected void delete_product(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		//Integer count=Integer.parseInt(request.getParameter("count"));
//		System.out.println("start");
//		
//		Integer productId=Integer.parseInt(request.getParameter("productId"));
//		//UserInfo userInfo=(UserInfo) request.getSession().getAttribute(Const.CURRRNTSUER);
//		IShoppingCartService shoppingcartService=new ShoppingCartService();
//		//ServerResponse se=shoppingcartService.ShoppingCartRemove(userInfo.getId(),productId);
//		ServerResponse se=shoppingcartService.ShoppingCartRemove(1,productId);
//		System.out.println(se.toString());
//		
//		Gson gson=new Gson();
//		String json=gson.toJson(se);
//		PrintWriter pw;
//		try {
//			
//			pw = response.getWriter();
//			pw.write(json);
//			pw.close();
//			
//		} catch (IOException e) {
//		
//			e.printStackTrace();
//		}
//	}
//	
	
	protected void delete_product(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("textml; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		//Integer productId=Integer.parseInt(request.getParameter("productId"));
		Integer Id=Integer.parseInt(request.getParameter("Id"));
		//UserInfo userInfo=(UserInfo) request.getSession().getAttribute(Const.CURRRNTSUER);
		IShoppingCartService shoppingcartService=new ShoppingCartService();
		//ServerResponse se=shoppingcartService.ShoppingCartRemove(userInfo.getId(),productId);
		ServerResponse se=shoppingcartService.ShoppingCartRemoveById(Id);
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
	protected void select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer count=Integer.parseInt(request.getParameter("count"));
		Integer productId=Integer.parseInt(request.getParameter("productId"));
		UserInfo userInfo=(UserInfo) request.getSession().getAttribute(Const.CURRRNTSUER);
		IShoppingCartService shoppingcartService=new ShoppingCartService();
		ServerResponse se=shoppingcartService.ShoppingCartUpdate(userInfo.getId(),productId,count);
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
	
	protected void un_select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserInfo userInfo=(UserInfo) request.getSession().getAttribute(Const.CURRRNTSUER);
		IShoppingCartService shoppingcartService=new ShoppingCartService();
		ServerResponse se=shoppingcartService.ShoppingCartCancelSelectAll(userInfo.getId());
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
	
	protected void get_cart_product_count(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserInfo userInfo=(UserInfo) request.getSession().getAttribute(Const.CURRRNTSUER);
		IShoppingCartService shoppingcartService=new ShoppingCartService();
		Integer quantity=Integer.parseInt(request.getParameter("quantity"));
		ServerResponse se=shoppingcartService.ShoppingCartQueryNumber(userInfo.getId());
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
	
	protected void select_all(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserInfo userInfo=(UserInfo) request.getSession().getAttribute(Const.CURRRNTSUER);
		IShoppingCartService shoppingcartService=new ShoppingCartService();
		//Integer quantity=Integer.parseInt(request.getParameter("quantity"));
		ServerResponse se=shoppingcartService.ShoppingCartSelectAll(userInfo.getId());
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
	
	protected void un_select_all(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserInfo userInfo=(UserInfo) request.getSession().getAttribute(Const.CURRRNTSUER);
		IShoppingCartService shoppingcartService=new ShoppingCartService();
		//Integer quantity=Integer.parseInt(request.getParameter("quantity"));
		ServerResponse se=shoppingcartService.ShoppingCartCancelSelectAll(userInfo.getId());
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
