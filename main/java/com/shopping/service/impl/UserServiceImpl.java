package com.shopping.service.impl;

import java.util.List;
import com.shopping.common.ServerResponse;
import com.shopping.common.UserInfo;
import com.shopping.common.UserTable;
import com.shopping.dao.IUserServiceDao;
import com.shopping.dao.impl.UserServiceDaoImpl;
import com.shopping.service.IUserService;

public class UserServiceImpl implements IUserService {
	
	private static IUserServiceDao userDao = new UserServiceDaoImpl();
	
	public ServerResponse loginLogic(String username, String password) {
		if(username==null||username.equals(""))
		{
			return ServerResponse.serverResponseByError("用户名不能为空");
		}
		if(password==null||password.equals(""))
		{
			return ServerResponse.serverResponseByError("密码不能为空");
		}
		boolean result = userDao.checkUsername(username);
		if(!result)
		{
			return ServerResponse.serverResponseByError("用户名不存在");
		}
		return ServerResponse.serverResponseBySuccess("登录成功");
	
	}
//	public ServerResponse registerLogic(UserInfo userInfo) 
//	{
//		if(userInfo==null)
//		{
//			return ServerResponse.serverResponseByError("参数必须");
//		}
//		boolean result = userDao.checkUsername(userInfo.getUsername());
//		if(result)
//		{
//			return ServerResponse.serverResponseByError("用户名已存在");
//			
//		}
//		boolean result_email = userDao.checkEmail(userInfo.getEmail());
//		if(result)
//		{
//			return ServerResponse.serverResponseByError("邮箱已存在");
//			
//		}
//		int count = UserDao.insert(UserInfo);
//		if (count>0) {
//			return ServerResponse.serverResponseBySuccess("注册成功");
//		}
//		return ServerResponse.serverResponseBySuccess("注册失败");
//	}
//	public ServerResponse getUserInfoLogic(String username) 
//	{
//		UserInfo userInfo=userDao.selectUserInfoByUsername(username);
//		return ServerResponse.serverResponseBySuccess(userInfo);
//	}
//	public ServerResponse forget_return_questionLogic(String username) 
//	{
//		if(username==null||username.equals(""))
//		{
//			return ServerResponse.serverResponseByError("用户名不能为空");
//		}
//		int result =userDao.checkUsername(username);
//		if(result==0)
//		{
//			return ServerResponse.serverResponseByError("用户名不存在,请重新输入");
//		}
//		
//		String question=userDao.selectQuestionInfoByUsername(username);
//		if (question==null||question.equals("")) {
//			return ServerResponse.serverResponseBySuccess("密保问题空");
//			
//		}
//		return ServerResponse.serverResponseBySuccess(question);
//	}
//	public ServerResponse forget_check_answerLogic(String username, String question,String answer)
//	{
//		if(username==null||username.equals(""))
//		{
//			return ServerResponse.serverResponseByError("用户名不能为空");
//		}
//		if(question==null||question.equals(""))
//		{
//			return ServerResponse.serverResponseByError("问题不能为空");
//		}
//		if(answer==null||answer.equals(""))
//		{
//			return ServerResponse.serverResponseByError("答案不能为空");
//		}
//		
//		int result =userDao.selectByUsernameAndQuestionAndAnswer(username,question,answer);
//		if(result==0)
//		{
//			return ServerResponse.serverResponseByError("答案错误");
//		}
//		String forgetToken=UUID.randomUUID().toString();
//		
//		return ServerResponse.serverResponseBySuccess(forgetToken);
//	}
//	public ServerResponse forget_reset_passwordLogic(String username, String passwordnew)
//	{
//		if(username==null||username.equals(""))
//		{
//			return ServerResponse.serverResponseByError("用户名不能为空");
//		}
//		
//		if(passwordnew==null||passwordnew.equals(""))
//		{
//			return ServerResponse.serverResponseByError("密码不能为空");
//		}
//		
//		int result =userDao.updateUserPassword(username,passwordnew);
//		if(result==0)
//		{
//			return ServerResponse.serverResponseByError("密码修改失败");
//		}
//		
//		return ServerResponse.serverResponseBySuccess();
//	}
//	public ServerResponse forgrt_replace_password(String username, String passwordNew, String forgetToken) {
//		// TODO Auto-generated method stub
//		//return null;
//		if(username==null||username.equals(""))
//		{
//			return ServerResponse.serverResponseByError("用户名不能为空");
//		}
//		if(forgetToken==null||forgetToken.equals(""))
//		{
//			return ServerResponse.serverResponseByError("旧密码不能为空");
//		}
//		if(passwordNew==null||passwordNew.equals(""))
//		{
//			return ServerResponse.serverResponseByError("新密码不能为空");
//		}
//		int result =userDao.checkUsername(username);
//		if(result==0)
//		{
//			return ServerResponse.serverResponseByError("用户名不存在");
//		}
//		return ServerResponse.serverResponseBySuccess("密码修改成功");
//	}
//	public ServerResponse login_replace_password(String passwordOld, String passwordNew) {
//		// TODO Auto-generated method stub
//		if(passwordOld==null||passwordOld.equals(""))
//		{
//			return ServerResponse.serverResponseByError("旧密码不能为空");
//		}
//		if(passwordNew==null||passwordNew.equals(""))
//		{
//			return ServerResponse.serverResponseByError("新密码不能为空");
//		}
//		
//		return ServerResponse.serverResponseBySuccess("密码修改成功");
//		//return null;
//	}
//	public ServerResponse login_renew_information(String email, String phone, String question, String answer) {
//		// TODO Auto-generated method stub
//		if(email==null||email.equals(""))
//		{
//			return ServerResponse.serverResponseByError("邮箱不能为空");
//		}
//		if(phone==null||phone.equals(""))
//		{
//			return ServerResponse.serverResponseByError("电话号不能为空");
//		}
//		if(answer==null||answer.equals(""))
//		{
//			return ServerResponse.serverResponseByError("问题答案不能为空");
//		}
//		int email =userDao.checkUsername(email);
//		int phone =userDao.checkUsername(phone);
//		
//		if(email==0)
//		{
//			return ServerResponse.serverResponseByError("邮箱不存在");
//		}
//		if(phone==0)
//		{
//			return ServerResponse.serverResponseByError("电话号不存在");
//		}
//		return ServerResponse.serverResponseBySuccess("信息更新成功");
//		
//		//return null;
//	}
//	public ServerResponse login_force(String username) {
//		// TODO Auto-generated method stub
//		return ServerResponse.serverResponseBySuccess("信息获取成功");
//		//return null;
//	}
//	public ServerResponse exit_login() {
//		// TODO Auto-generated method stub
//		return ServerResponse.serverResponseBySuccess("成功退出");
//		//return null;
//	}
	
	public ServerResponse mLoginLogic(String username, String password)
	{
		List<UserTable> user = new UserServiceDaoImpl().checkAdmin(username, password);
		if(user.size() == 0)
		{
			System.out.println("userServiceImpl fail");
			return ServerResponse.serverResponseByError("用户名不存在或密码不正确");
		}
		else
		{
			UserTable iuser = user.get(0);
			System.out.println("userServiceImpl success id:" + iuser.getId());
			return ServerResponse.serverResponseBySuccess(iuser);
		}
	}
	
	@Override
	public ServerResponse registerLogic(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ServerResponse getUserInfoLogic(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ServerResponse forget_return_questionLogic(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ServerResponse forget_check_answerLogic(String username, String question, String answer) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ServerResponse forget_reset_passwordLogic(String username, String passwordnew) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ServerResponse forgrt_replace_password(String username, String passwordNew, String forgetToken) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ServerResponse login_replace_password(String passwordOld, String passwordNew) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ServerResponse login_renew_information(String email, String phone, String question, String answer) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ServerResponse login_force(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ServerResponse exit_login() {
		// TODO Auto-generated method stub
		return null;
	}
}
