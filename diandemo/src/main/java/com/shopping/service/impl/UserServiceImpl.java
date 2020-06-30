package com.shopping.service.impl;

import java.util.List;
import java.util.UUID;

import com.shopping.common.ServerResponse;
import com.shopping.common.UserInfo;
import com.shopping.common.UserTable;
import com.shopping.dao.IUserDao;
import com.shopping.dao.impl.UserDaoImpl;
import com.shopping.service.IUserService;

public class UserServiceImpl implements IUserService {
	
	private static IUserDao userDao = new UserDaoImpl();
	
	public ServerResponse loginLogic(String username, String password) {
		if(username==null||username.equals(""))
		{
			return ServerResponse.serverResponseByError("用户名不能为空");
		}
		if(password==null||password.equals(""))
		{
			return ServerResponse.serverResponseByError("密码不能为空");
		}
		
		if(!userDao.checkUsername(username))
		{
			return ServerResponse.serverResponseByError("用户名不存在");
		}
		else {
			if (userDao.selectUserByUsernameandPassword(username, password)) {
				UserInfo userInfo=userDao.selectUserInfoByUsername(username);
				return ServerResponse.serverResponseBySuccess(userInfo);
			}
			return ServerResponse.serverResponseByError("密码错误");
		}
	}
	
	
	
	//新函数
	public UserInfo getUserInfo(String username) 
	{

		if(username==null||username.equals(""))
		{
			return null;
		}
		if(!userDao.checkUsername(username))
		{
			return null;
		}
		else 
		{
			
			UserInfo userInfo=userDao.selectUserInfoByUsername(username);
			return userInfo;
			
		}
		
	}

	
	
	public ServerResponse registerLogic(UserInfo userInfo)
	{
		if(userInfo==null)
		{
			return ServerResponse.serverResponseByError("参数必须");
		}
		if(userDao.checkUsername(userInfo.getUsername()))
		{
			return ServerResponse.serverResponseByError("用户名已存在");
			
		}
		if(userDao.checkEmail(userInfo.getEmail()))
		{
			return ServerResponse.serverResponseByError("邮箱已存在");
			
		}
		if (userDao.insertUserInfo(userInfo)) {
			return ServerResponse.serverResponseBySuccess("注册成功");
		}
		return ServerResponse.serverResponseBySuccess("注册失败");
		
	}
	public ServerResponse get_user_infoLogic(String username) 
	{
		if(username == null || username.equals(""))
			return ServerResponse.serverResponseByError("用户未登录，无法获取当前用户信息。");
		UserInfo userInfo=userDao.selectUserInfoByUsername(username);
		return ServerResponse.serverResponseBySuccess(userInfo);
	}
	public ServerResponse forget_return_questionLogic(String username) 
	{
		if(username==null||username.equals(""))
		{
			return ServerResponse.serverResponseByError("用户名不能为空");
		}
		
		if(!userDao.checkUsername(username))
		{
			return ServerResponse.serverResponseByError("用户名不存在,请重新输入");
		}
		
		String question=userDao.selectQuestionByUsername(username);
		if (question==null||question.equals("")) {
			return ServerResponse.serverResponseBySuccess("密保问题空");
		}
		return ServerResponse.serverResponseBySuccess(question);
	}
	public ServerResponse forget_check_answerLogic(String username, String question,String answer)
	{
		if(username==null||username.equals(""))
		{
			return ServerResponse.serverResponseByError("用户名不能为空");
		}
		if(question==null||question.equals(""))
		{
			return ServerResponse.serverResponseByError("问题不能为空");
		}
		if(answer==null||answer.equals(""))
		{
			return ServerResponse.serverResponseByError("答案不能为空");
		}
		if(!userDao.selectAnswerByUsername(username).equals(answer))
		{
			return ServerResponse.serverResponseByError("答案错误");
		}
		String forgetToken=UUID.randomUUID().toString();
		return ServerResponse.serverResponseBySuccess(forgetToken);
	}
	public ServerResponse forget_reset_passwordLogic(String username, String passwordnew, boolean c)
	{
		if(!c) 
			return ServerResponse.serverResponseByError("密钥已过期");
		if(username==null||username.equals(""))
		{
			return ServerResponse.serverResponseByError("用户名不能为空");
		}
		
		if(passwordnew==null||passwordnew.equals(""))
		{
			return ServerResponse.serverResponseByError("密码不能为空");
		}
		
		if(!userDao.updatePasswordByUsername(username,passwordnew))
		{
			return ServerResponse.serverResponseByError("密码修改失败");
		}
		return ServerResponse.serverResponseBySuccess("修改密码错误");
	}

	public ServerResponse login_replace_password(String username,String passwordOld, String passwordNew) {
		// TODO Auto-generated method stub
		if(passwordOld==null||passwordOld.equals(""))
		{
			return ServerResponse.serverResponseByError("旧密码不能为空");
		}
		else if(!passwordOld.equals(userDao.checkPassword(username))) {//旧的密码输入不正确
			return ServerResponse.serverResponseByError("旧密码不正确");
		}
		else if(passwordNew==null||passwordNew.equals(""))
		{
			return ServerResponse.serverResponseByError("新密码不能为空");
		}
		UserInfo userInfo = new UserInfo();
		userInfo.setPassword(passwordNew);
		userInfo.setUsername(username);
		if(userDao.loginReplacePassword(userInfo))
			return ServerResponse.serverResponseBySuccess("密码修改成功");
		else return ServerResponse.serverResponseByError("密码修改失败");
	}
	public ServerResponse login_renew_information(String email, String phone, String question, String answer) {
		// TODO Auto-generated method stub
		if(email==null||email.equals(""))
		{
			return ServerResponse.serverResponseByError("邮箱不能为空");
		}
		else if(phone==null||phone.equals(""))
		{
			return ServerResponse.serverResponseByError("电话号不能为空");
		}
		else if(question==null||question.equals(""))
		{
			return ServerResponse.serverResponseByError("问题不能为空");
		}
		else if(answer==null||answer.equals(""))
		{
			return ServerResponse.serverResponseByError("问题答案不能为空");
		}
		else {
			return ServerResponse.serverResponseBySuccess("信息更新成功");
		}
	
	}
	public ServerResponse login_force(String username) {
		// TODO Auto-generated method stub
		if(username == null || username.equals("")) {
			return ServerResponse.serverResponseByError(10,"用户未登录，无法获取当前用户信息,强制退出");
		}
		else {
			UserInfo user = userDao.selectUserInfo(username);
			return ServerResponse.serverResponseBySuccess(user);
			//return null;
		}
		
	}
	public ServerResponse exit_login(String username) {
		// TODO Auto-generated method stub
		//return ServerResponse.serverResponseBySuccess("成功退出");
		//return null;
		if(username == null || username.equals("")){
			return ServerResponse.serverResponseByError("服务端异常");
		}else{
			return ServerResponse.serverResponseBySuccess("退出成功");
		} 
	}
	
	public ServerResponse mLoginLogic(String username, String password)
	{
		List<UserTable> user = new UserDaoImpl().checkAdmin(username, password);
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
	public ServerResponse mUserListLogic(boolean onlog, boolean access)
	{
		if(!onlog)
			return ServerResponse.serverResponseByError(10, "用户未登录,请登录");
		else if(!access)
			return ServerResponse.serverResponseByError("没有权限");
		else 
		{
			List<UserTable> userlist = new UserDaoImpl().getUserList();
			return ServerResponse.serverResponseBySuccess(userlist);
		}
	}
	public ServerResponse mExitLogic(String admin) {
		return exit_login(admin);
	}

	@Override
	public ServerResponse mDeleteLogic(boolean onlog, boolean access, int id) {
		
		if(!onlog)
			return ServerResponse.serverResponseByError(10, "用户未登录,请登录");
		else if(!access)
			return ServerResponse.serverResponseByError("没有权限");
		else 
		{
			if(new UserDaoImpl().deleteUser(id))
				return ServerResponse.serverResponseBySuccess(null,"删除成功");
			return ServerResponse.serverResponseByError("删除失败");
		}
	}

	@Override
	public ServerResponse mUpdateLogic(boolean onlog, boolean access, UserTable user) {
		if(!onlog)
			return ServerResponse.serverResponseByError(10, "用户未登录,请登录");
		else if(!access)
			return ServerResponse.serverResponseByError("没有权限");
		else 
		{
			if(new UserDaoImpl().updateUser(user))
				return ServerResponse.serverResponseBySuccess(null,"更新成功");
			return ServerResponse.serverResponseByError("更新失败，名称不能重复");
		}
	}
}
