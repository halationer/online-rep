package com.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.shopping.common.Address;
import com.shopping.common.Const;
import com.shopping.common.ServerResponse;
import com.shopping.common.UserInfo;
import com.shopping.service.IAddressService;
import com.shopping.service.IGoodsService;
import com.shopping.service.impl.AddressServiceImpl;
import com.shopping.service.impl.GoodsServiceImpl;


@WebServlet("/AddressServlet")
public class AddressServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String type=request.getParameter("type");
		if(type.equals("add")) {
			add(request, response);
		}
		if(type.equals("del")) {
			del(request, response);
		}
		if(type.equals("update")) {
			update(request, response);
		}
		if(type.equals("select")) {
			select(request, response);
		}
		if(type.equals("list")) {
			list(request, response);
		}
    	 
	
       
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public void add(HttpServletRequest request, HttpServletResponse response)
	{
		IAddressService addressService=new AddressServiceImpl();
		ServerResponse se;
		UserInfo userInfo=(UserInfo)request.getSession().getAttribute("userInfo");
		//Integer userId =Integer.parseInt( request.getParameter("userId"));
		String receiverName=request.getParameter("receiverName");
		String receiverPhone=request.getParameter("receiverPhone");
		String receiverMobile=request.getParameter("receiverMobile");
		String receiverProvince=request.getParameter("receiverProvince");
		String receiverCity=request.getParameter("receiverCity");
		String receiverAddress=request.getParameter("receiverAddress");
		String receiverZip=request.getParameter("receiverZip");
		if (userInfo==null) 
		{
			se= ServerResponse.serverResponseByError(Const.ResponseCodeEnum.NEED_LOGIN.getCode(),Const.ResponseCodeEnum.NEED_LOGIN.getDesc());
			
		}
		else
		{
			Address address=new Address(userInfo.getId(), receiverName, receiverPhone, receiverMobile, receiverProvince, receiverCity, receiverAddress, receiverZip);
			se=addressService.addLogic(address);
		}
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
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
	public void del(HttpServletRequest request, HttpServletResponse response)
	{
		IAddressService addressService=new AddressServiceImpl();
		ServerResponse se;
		UserInfo userInfo=(UserInfo)request.getSession().getAttribute("userInfo");
		Integer Id =Integer.parseInt( request.getParameter("shippingId"));
		if (userInfo==null) 
		{
			se= ServerResponse.serverResponseByError(Const.ResponseCodeEnum.NEED_LOGIN.getCode(),Const.ResponseCodeEnum.NEED_LOGIN.getDesc());
			
		}
		else
		{
			
			se=addressService.delLogic(Id);
		}
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
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
	public void update(HttpServletRequest request, HttpServletResponse response)
	{
		IAddressService addressService=new AddressServiceImpl();
		ServerResponse se;
		UserInfo userInfo=(UserInfo)request.getSession().getAttribute("userInfo");
		Integer Id =Integer.parseInt( request.getParameter("id"));
		String receiverName=request.getParameter("receiverName");
		String receiverPhone=request.getParameter("receiverPhone");
		String receiverMobile=request.getParameter("receiverMobile");
		String receiverProvince=request.getParameter("receiverProvince");
		String receiverCity=request.getParameter("receiverCity");
		String receiverAddress=request.getParameter("receiverAddress");
		String receiverZip=request.getParameter("receiverZip");
		if (userInfo==null) 
		{
			se= ServerResponse.serverResponseByError(Const.ResponseCodeEnum.NEED_LOGIN.getCode(),Const.ResponseCodeEnum.NEED_LOGIN.getDesc());
			
		}
		else
		{
			Address address=new Address(Id,userInfo.getId(), receiverName, receiverPhone, receiverMobile, receiverProvince, receiverCity, receiverAddress, receiverZip);
			se=addressService.updateLogic(address);
		}
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
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
	public void select(HttpServletRequest request, HttpServletResponse response)
	{
		IAddressService addressService=new AddressServiceImpl();
		ServerResponse se;
		UserInfo userInfo=(UserInfo)request.getSession().getAttribute("userInfo");
		Integer Id =Integer.parseInt( request.getParameter("shippingId"));
		if (userInfo==null) 
		{
			se= ServerResponse.serverResponseByError(Const.ResponseCodeEnum.NEED_LOGIN.getCode(),Const.ResponseCodeEnum.NEED_LOGIN.getDesc());
			
		}
		else
		{
			
			se=addressService.selectLogic(Id);
		}
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
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
	public void list(HttpServletRequest request, HttpServletResponse response)
	{
		IAddressService addressService=new AddressServiceImpl();
		ServerResponse se;
		UserInfo userInfo=(UserInfo)request.getSession().getAttribute("userInfo");
		Integer pageNum =Integer.parseInt( request.getParameter("pageNum"));
		Integer pageSize =Integer.parseInt( request.getParameter("pageSize"));
		if (userInfo==null) 
		{
			se= ServerResponse.serverResponseByError(Const.ResponseCodeEnum.NEED_LOGIN.getCode(),Const.ResponseCodeEnum.NEED_LOGIN.getDesc());
			
		}
		else
		{
			
			se=addressService.listLogic(userInfo.getId(),pageNum,pageSize);
		}
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
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
