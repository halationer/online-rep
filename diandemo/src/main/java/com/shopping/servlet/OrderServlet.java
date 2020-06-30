package com.shopping.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.demo.trade.config.Configs;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.shopping.common.Const;
import com.shopping.common.ServerResponse;
import com.shopping.common.UserInfo;
import com.shopping.service.IGoodsService;
import com.shopping.service.IOrderService;
import com.shopping.service.impl.GoodsServiceImpl;
import com.shopping.service.impl.OrderServiceImpl;


@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String type=request.getParameter("type");
		if(type.equals("pay"))
		{
			pay(request, response);
		}
		if(type.equals("alipay_callback"))
		{
			alipay_callback(request,response);
		}
		if(type.equals("query_order_pay_status"))
		{
			query_order_pay_status(request,response);
		}
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}
	public void pay(HttpServletRequest request, HttpServletResponse response)
	{
	
		Long orderNo=Long.parseLong(request.getParameter("orderNO"));
	    IOrderService orderService=new OrderServiceImpl();
		ServerResponse se;
		UserInfo userInfo=(UserInfo)request.getSession().getAttribute("userInfo");
		if (userInfo==null) 
		{
			se= ServerResponse.serverResponseByError(Const.ResponseCodeEnum.NEED_LOGIN.getCode(),Const.ResponseCodeEnum.NEED_LOGIN.getDesc());
		}
		else
		{
			 se=orderService.payLogic(orderNo);	
		}
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
	public void alipay_callback(HttpServletRequest request, HttpServletResponse response) {
		ServerResponse se=null;
		 IOrderService orderService=new OrderServiceImpl();
		System.out.print("ccccc");
		Map<String, String> requestparams=Maps.newHashMap();
		Map<String,String[]> params=request.getParameterMap();
		Iterator<String> it=params.keySet().iterator();
		while(it.hasNext())
		{
			String key=it.next();
			String[] strArr=params.get(key);
			String value="";
			for (int i = 0; i < strArr.length; i++) {
				value=(i==strArr.length-1)?value+strArr[i]:value+strArr[i]+",";				
			}
			
			requestparams.put(key, value);
		}
		try {
			requestparams.remove("sign_type");
			boolean result=AlipaySignature.rsaCheckV2(requestparams,Configs.getAlipayPublicKey(),"utf-8",Configs.getSignType());
			if (!result) {
				se=ServerResponse.serverResponseByError("非法请求，验证不通过");
			}
			
			se=orderService.alipay_callbackLogic(requestparams);
			
			
			
			
		} catch (AlipayApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public void query_order_pay_status(HttpServletRequest request, HttpServletResponse response)
	{
	
		Long orderNo=Long.parseLong(request.getParameter("orderNO"));
	    IOrderService orderService=new OrderServiceImpl();
		ServerResponse se;
		UserInfo userInfo=(UserInfo)request.getSession().getAttribute("userInfo");
		if (userInfo==null) 
		{
			se= ServerResponse.serverResponseByError(Const.ResponseCodeEnum.NEED_LOGIN.getCode(),Const.ResponseCodeEnum.NEED_LOGIN.getDesc());
			
		}
		else
		{
			
			 se=orderService.query_order_pay_statusLogic(orderNo);	
		}
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
