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
import com.shopping.service.IUserService;
import com.shopping.service.impl.UserServiceImpl;


@WebServlet("/user")
public class UserServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=request.getParameter("type");
		if(type.equals("login")) {
			login(request, response);
		}
		else if(type.equals("register")){
			register(request, response);
		}
        else if(type.equals("getUserInfo")){
        	getUserInfo(request, response);
		}
       else if(type.equals("forgetanswer")){
    	   forget_return_question(request, response);
    	   forget_check_answer(request, response);
    	   forget_reset_password(request,response);
	
       }
      else if(type.equals("register")){
	
      }
      else if(type.equals("register")){
	
       }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void login(HttpServletRequest request, HttpServletResponse response)
	{
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		IUserService userService=new UserServiceImpl();
		ServerResponse se=userService.loginLogic(username, password);
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
	public void register(HttpServletRequest request, HttpServletResponse response)
	{
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String question=request.getParameter("question");
		String answer=request.getParameter("answer");
		String phone=request.getParameter("phone");
		UserInfo userInfo=new UserInfo(username, password, email, phone, question, answer);
		IUserService userService=new UserServiceImpl();
		ServerResponse se=userService.registerLogic(userInfo);
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
	public void getUserInfo(HttpServletRequest request, HttpServletResponse response)
	{
		String username= request.getParameter("username");
		IUserService userService=new UserServiceImpl();
		ServerResponse se=userService.getUserInfoLogic(username);
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
	public void forget_return_question(HttpServletRequest request, HttpServletResponse response)
	{
		String username=request.getParameter("username");
		IUserService userService=new UserServiceImpl();
		ServerResponse se=userService.forget_return_questionLogic(username);
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
	public void forget_check_answer(HttpServletRequest request, HttpServletResponse response)
	{
		String username=request.getParameter("username");
		String question=request.getParameter("question");
		String answer=request.getParameter("answer");
		IUserService userService=new UserServiceImpl();
		ServerResponse se=userService.forget_check_answerLogic(username,question,answer);
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
	public void forget_reset_password(HttpServletRequest request, HttpServletResponse response)
	{
		String username=request.getParameter("username");
		String passwordnew=request.getParameter("passwordnew");
		IUserService userService=new UserServiceImpl();
		ServerResponse se=userService.forget_reset_passwordLogic(username,passwordnew);
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
