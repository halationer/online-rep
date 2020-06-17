package com.shopping.dao;

import java.util.List;

import com.shopping.common.UserInfo;
import com.shopping.common.UserTable;

public interface IUserServiceDao {
	
	public boolean insertUserInfo (UserInfo userInfo);
	public boolean updatePasswordByUsername(String username,String  passwordnew);
	public UserInfo selectUserInfoByUsername(String username);
	public boolean checkUsername(String username);
	public UserInfo selectUserInfoByEmail(String email);
	public boolean checkEmail(String email);
	public String selectQuestionByUsername(String username);
	public String selectAnswerByUsername(String username);
	public boolean checkAnswer(String username,String question,String answer);
	
	//忘记密码，重置密码
	public boolean forgetReplacePassword(String username,String passwordNew,String forgetToken);
	//登录中重置密码
	public boolean loginReplacePassword(String passwordOld,String passwordNew);
	//登录更新个人信息
	public boolean loginRenewPassword(String email,String phone,String question,String answer);
	//获取个人全部信息
	public boolean loginForce();
	//退出登录
	public boolean exitLogin();
	
	//搜索用户名、密码正确，并且权限为管理员（0）的用户
	public List<UserTable> checkAdmin(String username, String password);
}
