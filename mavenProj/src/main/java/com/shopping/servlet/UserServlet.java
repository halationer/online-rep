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
import com.shopping.common.UserInfo;
import com.shopping.service.IUserService;
import com.shopping.service.impl.UserServiceImpl;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	
	private static int num = 0;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("a new request." + num++);
		
		String type=request.getParameter("type");
		if(type.equals("login")) {
			login(request, response);
		}
		else if(type.equals("register")){
			register(request, response);
		}
        else if(type.equals("get_user_info")){
        	get_user_info(request, response);
		}
        else if(type.equals(" forget_return_question")){
    	   forget_return_question(request, response);
	
        }
        else if(type.equals("forget_check_answer")){
        	forget_check_answer(request, response);
	
        }
        else if(type.equals("forget_reset_password")){
    	   forget_reset_password(request,response);
        }
        else if(type.equals("reset_password")) {
      	  reset_password(request,response);
        }
        else if(type.equals("update_information")) {
      	  update_information(request,response);
        }
        else if(type.equals("get_inforamtion")) {
      	  get_inforamtion(request,response);
        }
        else if(type.equals("logout")) {
      	  logout(request,response);
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
		if(se.getStatus() == 0)
			request.getSession().setAttribute("flag", username);
		else
			System.out.println(se.getMsg());
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
	public void get_user_info(HttpServletRequest request, HttpServletResponse response)
	{
		String username= (String)request.getSession().getAttribute("flag");
		IUserService userService=new UserServiceImpl();
		ServerResponse se=userService.get_user_infoLogic(username);
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
		request.getSession().setAttribute("forget_check_answer_token", se.getData());
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
		String forgetToken = request.getParameter("forgetToken");
		String username=request.getParameter("username");
		String passwordnew=request.getParameter("passwordNew");
		IUserService userService=new UserServiceImpl();
		ServerResponse se=userService.forget_reset_passwordLogic(
				username,
				passwordnew,
				forgetToken.equals(request.getSession().getAttribute("forget_check_answer_token")));
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
	
	public void reset_password(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{//登录时重置密码
		String passwordOld=request.getParameter("passwordOld");
		String passwordNew=request.getParameter("passwordNew");
		String username = (String)request.getSession().getAttribute("flag");
		IUserService userService=new UserServiceImpl();
		ServerResponse se=userService.login_replace_password(username,passwordOld,passwordNew);
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
	public void update_information(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{//登录时更新个人信息
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String question=request.getParameter("question");
		String answer=request.getParameter("answer");
		IUserService userService=new UserServiceImpl();
		ServerResponse se=userService.login_renew_information(email,phone,question,answer);
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
	public void get_inforamtion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{//获取当前登录人的信息
		IUserService userService=new UserServiceImpl();
		String username = (String)request.getSession().getAttribute("flag");
		ServerResponse se=userService.login_force(username);
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
	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{//退出登录
		HttpSession session = request.getSession();
		IUserService userService=new UserServiceImpl();
		String username = (String)session.getAttribute("flag");
		ServerResponse se=userService.exit_login(username);
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
		
		if(session.getAttribute("flag") != null)
		{
			session.removeAttribute("flag");
		}
	}
}
