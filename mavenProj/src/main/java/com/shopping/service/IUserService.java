package com.shopping.service;

import com.shopping.common.ServerResponse;
import com.shopping.common.UserInfo;

public interface IUserService {
	
	public ServerResponse loginLogic(String username,String password);
	public ServerResponse registerLogic(UserInfo userInfo) ;
	public ServerResponse get_user_infoLogic(String username) ;
	public ServerResponse forget_return_questionLogic(String username) ;
	public ServerResponse forget_check_answerLogic(String username, String question,String answer);
	public ServerResponse forget_reset_passwordLogic(String username, String passwordnew, boolean c);
	
	public ServerResponse login_replace_password(String username, String passwordOld, String passwordNew) ;
	public ServerResponse login_renew_information(String email,String phone,String question,String answer) ;
	public ServerResponse login_force(String username) ;
	public ServerResponse exit_login(String username);
	
	public ServerResponse mLoginLogic(String username, String password);
	public ServerResponse mUserListLogic(boolean onlog, boolean access);
	public ServerResponse mExitLogic(String admin);
}
