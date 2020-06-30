package com.shopping.dao;

import java.util.List;

import com.shopping.common.UserInfo;
import com.shopping.common.UserTable;

public interface IUserDao {
	
	public boolean insertUserInfo (UserInfo userInfo) ;
	public UserInfo selectUserInfoByUsername(String username);
	public boolean checkUsername(String username) ;
	public UserInfo selectUserInfoByEmail(String email);
	public boolean checkEmail(String email) ;
	public String selectQuestionByUsername(String username);
	public String selectAnswerByUsername(String username) ;
	public boolean updatePasswordByUsername(String username,String  passwordnew) ;
	public boolean checkAnswer(String username,String question,String answer) ;
	public boolean selectUserByUsernameandPassword(String username,String password);
	
	public String checkPassword(String username);
	//登录中重置密码
	public boolean loginReplacePassword(UserInfo user);
	//登录更新个人信息
	public boolean loginRenewUserInfo(UserInfo user);
	//获取个人全部信息
	public UserInfo loginForce(UserInfo user);
	public UserInfo selectUserInfo(String username);
	
	//搜索用户名、密码正确，并且权限为管理员（0）的用户
	public List<UserTable> checkAdmin(String username, String password);
	//搜索用户表
	public List<UserTable> getUserList();
}
