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
import com.shopping.common.UserInfo;
import com.shopping.common.UserTable;
import com.shopping.service.IOrderTableService;
import com.shopping.service.IShoppingCartService;
import com.shopping.service.IUserService;
import com.shopping.service.impl.OrderTableServiceImpl;
import com.shopping.service.impl.ShoppingCartService;
import com.shopping.service.impl.UserServiceImpl;

/**
 * Servlet implementation class OrderTableServlet
 */
@WebServlet("/manage/order")
public class OrderTableServletM extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		System.out.println("new request");
		if(type.equals("list")) {
			list(request, response);
		}
		else if(type.equals("search")){
			search(request, response);
		}
        else if(type.equals("detail")){
        	detail(request, response);
		}
        else if(type.equals("send_goods")){
        	sendGoods(request, response);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

		IOrderTableService orderTableService=new OrderTableServiceImpl();
		ServerResponse se = null;
		if (!onlog) 
		{
			se = ServerResponse.serverResponseByError(Const.ResponseCodeEnum.NEED_LOGIN.getCode(),Const.ResponseCodeEnum.NEED_LOGIN.getDesc());
		}
		else if (!access) 
		{
			se = ServerResponse.serverResponseByError(Const.ResponseCodeEnum.NO_PRIVILEGE.getCode(),Const.ResponseCodeEnum.NO_PRIVILEGE.getDesc());
		}
		else
		{
			String pageSize = request.getParameter("pageSize");
			String pageNum = request.getParameter("pageNum");
			int pagesize = pageSize==null ? 10 : Integer.parseInt(pageSize);
			int pagenum = pageNum==null ? 1 : Integer.parseInt(pageNum);
			se = orderTableService.mAllOrders(pagenum, pagesize);
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
	
	protected void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int orderNo = Integer.parseInt(request.getParameter("orderNo"));
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

		IOrderTableService orderTableService=new OrderTableServiceImpl();
		ServerResponse se = null;
		if (!onlog) 
		{
			se = ServerResponse.serverResponseByError(Const.ResponseCodeEnum.NEED_LOGIN.getCode(),Const.ResponseCodeEnum.NEED_LOGIN.getDesc());
		}
		else if (!access) 
		{
			se = ServerResponse.serverResponseByError(Const.ResponseCodeEnum.NO_PRIVILEGE.getCode(),Const.ResponseCodeEnum.NO_PRIVILEGE.getDesc());
		}
		else
		{
			String pageSize = request.getParameter("pageSize");
			String pageNum = request.getParameter("pageNum");
			int pagesize = pageSize==null ? 10 : Integer.parseInt(pageSize);
			int pagenum = pageNum==null ? 1 : Integer.parseInt(pageNum);
			se = orderTableService.mSearchDetailById(pagenum, pagesize, orderNo);
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
	
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderNostr = request.getParameter("orderNo");
		if(orderNostr == null || orderNostr.equals(""))
		{
			list(request, response);
			return;
		}
		int orderNo = Integer.parseInt(orderNostr);
		IOrderTableService orderTableService=new OrderTableServiceImpl();
		ServerResponse se = null;
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
		if (!onlog) 
		{
			se = ServerResponse.serverResponseByError(Const.ResponseCodeEnum.NEED_LOGIN.getCode(),Const.ResponseCodeEnum.NEED_LOGIN.getDesc());
		}
		else if (!access) 
		{
			se = ServerResponse.serverResponseByError(Const.ResponseCodeEnum.NO_PRIVILEGE.getCode(),Const.ResponseCodeEnum.NO_PRIVILEGE.getDesc());
		}
		else
		{
			System.out.println("search detail......");
			String pageSize = request.getParameter("pageSize");
			String pageNum = request.getParameter("pageNum");
			int pagesize = pageSize==null ? 10 : Integer.parseInt(pageSize);
			int pagenum = pageNum==null ? 1 : Integer.parseInt(pageNum);
			se = orderTableService.mSearchOrderById(pagenum, pagesize, orderNo);
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
	
	protected void sendGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer orderNo=Integer.parseInt(request.getParameter("orderNo"));
		IOrderTableService orderTableService=new OrderTableServiceImpl();
		ServerResponse se = null;
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
		if (!onlog) 
		{
			se = ServerResponse.serverResponseByError(Const.ResponseCodeEnum.NEED_LOGIN.getCode(),Const.ResponseCodeEnum.NEED_LOGIN.getDesc());
		}
		else if (!access) 
		{
			se = ServerResponse.serverResponseByError(Const.ResponseCodeEnum.NO_PRIVILEGE.getCode(),Const.ResponseCodeEnum.NO_PRIVILEGE.getDesc());
		}
		else
		{
			se = orderTableService.mSendGoods(orderNo);
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
}
