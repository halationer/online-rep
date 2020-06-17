package com.shopping.service;

import com.shopping.common.ServerResponse;
import com.shopping.common.UserInfo;

public interface IUserService {
	public ServerResponse loginLogic(String username,String password);
	public ServerResponse registerLogic(UserInfo userInfo) ;
	public ServerResponse getUserInfoLogic(String username) ;
	public ServerResponse forget_return_questionLogic(String username) ;
	public ServerResponse forget_check_answerLogic(String username, String question,String answer);
	public ServerResponse forget_reset_passwordLogic(String username, String passwordnew);
	public ServerResponse forgrt_replace_password(String username,String passwordNew,String forgetToken);
	public ServerResponse login_replace_password(String passwordOld, String passwordNew) ;
	public ServerResponse login_renew_information(String email,String phone,String question,String answer) ;
	public ServerResponse login_force(String username) ;
	public ServerResponse exit_login();
	public ServerResponse mLoginLogic(String username, String password);
}
