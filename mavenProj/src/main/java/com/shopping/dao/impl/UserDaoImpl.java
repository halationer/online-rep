package com.shopping.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.shopping.common.UserInfo;
import com.shopping.common.UserTable;
import com.shopping.dao.IUserDao;
import com.shopping.util.DBUtil;
import com.shopping.util.SqlVisiter;

public class UserDaoImpl implements IUserDao {
	
	//数据访问层：原子性 的增删改查
	public boolean insertUserInfo (UserInfo userInfo) 
	{
		String sql ="insert into user_table(username, password,phone, email,role,question,answer,create_time, update_time) values(?,?,?,?,?,?,?,NOW(),NOW()) " ;
		Object[] params = {userInfo.getUsername(),userInfo.getPassword(),userInfo.getPhone(),userInfo.getEmail(),1,userInfo.getQuestion(),userInfo.getAnswer()};
		return DBUtil.executeUpdate(sql, params) ;
	}
	public boolean updatePasswordByUsername(String username,String  passwordnew) 
	{
		String sql = "update user_table set password=? where username=?" ;
		Object[] params = {passwordnew,username};
		return DBUtil.executeUpdate(sql, params) ;
	}
	public UserInfo selectUserInfoByUsername(String username) {
		UserInfo userInfo = null;
		 PreparedStatement pstmt = null ;
		 ResultSet rs = null ; 
		try {
			  String sql = "select * from user_table where username=?";
			  Object[] params = {username} ;
			  rs = DBUtil.executeQuery(sql,params) ;
			  if(rs.next()) {
				  int id=rs.getInt(1);
				  String username1 =   rs.getString(2) ;//??
				  String password= rs.getString(3);
				  String phone = rs.getString(4) ;
				  String email=rs.getString(5);
				  int role=rs.getInt(6);
				  String question=rs.getString(7);
				  String answer=rs.getString(8);
				  userInfo=new UserInfo(username1, password, email, phone,role, question, answer);
			  }
			  return userInfo ;
		} catch (SQLException e) {
			e.printStackTrace();
			return null ; 
		}catch (Exception e) {
			e.printStackTrace();
			return null ; 
		}
		finally {
			DBUtil.closeAll(rs, pstmt, DBUtil.connection);
		}
	}
	public boolean checkUsername(String username) 
	{
		return selectUserInfoByUsername(username)==null? false:true  ;
	}
	public UserInfo selectUserInfoByEmail(String email) {
		UserInfo userInfo = null;
		 PreparedStatement pstmt = null ;
		 ResultSet rs = null ; 
		try {
			  String sql = "select * from user_table where email =? " ;
			  Object[] params = {email} ;
			  rs = DBUtil.executeQuery(sql,params) ;
			  if(rs.next()) {
				  String username =   rs.getString(2) ;
				  String password= rs.getString(3);
				  String phone = rs.getString(4) ;
				  String email1=rs.getString(5);
				  int role=rs.getInt(6);
				  String question=rs.getString(7);
				  String answer=rs.getString(8);
				  userInfo=new UserInfo(username, password, email1, phone,role, question, answer);
			  }
			  return userInfo ;
		} catch (SQLException e) {
			e.printStackTrace();
			return null ; 
		}catch (Exception e) {
			e.printStackTrace();
			return null ; 
		}
		finally {
			DBUtil.closeAll(rs, pstmt, DBUtil.connection);
		}
	}
	public boolean checkEmail(String email) 
	{
			return selectUserInfoByEmail(email)==null? false:true  ;
	}
	public String selectQuestionByUsername(String username) {
		String question= null;
		 PreparedStatement pstmt = null ;
		 ResultSet rs = null ; 
		try {
			  String sql = "select question from user_table where username =? " ;
			  Object[] params = {username} ;
			  rs = DBUtil.executeQuery(sql,params) ;
			  if(rs.next()) {
				 question = rs.getString(1) ;
				
			  }
			  return question;
		} catch (SQLException e) {
			e.printStackTrace();
			return null ; 
		}catch (Exception e) {
			e.printStackTrace();
			return null ; 
		}
		finally {
			DBUtil.closeAll(rs, pstmt, DBUtil.connection);
		}
	}
	public String selectAnswerByUsername(String username) {
		 String answer= null;
		 PreparedStatement pstmt = null ;
		 ResultSet rs = null ; 
		try {
			  String sql = "select answer from user_table where username =? " ;
			  Object[] params = {username} ;
			  rs = DBUtil.executeQuery(sql,params) ;
			  if(rs.next()) {
				 answer = rs.getString(1) ;
				
			  }
			  return answer;
		} catch (SQLException e) {
			e.printStackTrace();
			return null ; 
		}catch (Exception e) {
			e.printStackTrace();
			return null ; 
		}
		finally {
			DBUtil.closeAll(rs, pstmt, DBUtil.connection);
		}
	}
	public boolean checkAnswer(String username,String question,String answer) 
	{
		return selectAnswerByUsername(username)==answer? false:true  ;
	}
	public boolean selectUserByUsernameandPassword(String username,String password) {
		 PreparedStatement pstmt = null ;
		 ResultSet rs = null ;
		 boolean pwd=false;
		try {
			  String sql = "select * from user_table where username =? and password=? " ;
			  Object[] params = {username,password} ;
			  rs = DBUtil.executeQuery(sql,params) ;
			  if(rs.next()) {
				  pwd=true;
			  }
			  return pwd ;
		} catch (SQLException e) {
			e.printStackTrace();
			return pwd ; 
		}catch (Exception e) {
			e.printStackTrace();
			return pwd ; 
		}
		finally {
			DBUtil.closeAll(rs, pstmt, DBUtil.connection);
		}
	}
	
	public String checkPassword(String username) {
		String password= null;
		 PreparedStatement pstmt = null ;
		 ResultSet rs = null ; 
		try {
			  String sql = "select password from user_table where username =?" ;
			  Object[] params = {username} ;
			  rs = DBUtil.executeQuery(sql,params) ;
			  if(rs.next()) {
				 password = rs.getString(1) ;
			  }
			  return password;
		} catch (SQLException e) {
			e.printStackTrace();
			return null ; 
		}catch (Exception e) {
			e.printStackTrace();
			return null ; 
		}
		finally {
			DBUtil.closeAll(rs, pstmt, DBUtil.connection);
		}
	}
	public boolean loginReplacePassword(UserInfo user) {//登录中重置
		// TODO Auto-generated method stub
		//String sql = "update user_table set password=? where username=?" ;
		String sql = "update students set password=? where username=?" ;
		Object[] params = {user.getPassword()};
		return DBUtil.executeUpdate(sql, params) ;
		//return false;
	}
	public boolean loginRenewPassword(UserInfo user) {//登录状态更新个人信息
		// TODO Auto-generated method stub
		String sql = "update user_table set name =?,sex=?,age=?,address=?,phonenumber=?,password=? where id=?" ;
		Object[] params = {user.getEmail(),user.getPhone(),user.getQuestion(),user.getAnswer()};
		return DBUtil.executeUpdate(sql, params) ;
	}
	public UserInfo loginForce(UserInfo user) {//登录过程获取个人信息
		// TODO Auto-generated method stub
		 //UserInfo user = null;
		 PreparedStatement pstmt = null ;
		 ResultSet rs = null ; 
		 String username  ;
		  String phone;
		  String email;
		  int role;
		  String question;
		  String answer;
		  Date createTime;
		  Date updateTime;
		try {
			  String sql = "select * from user_table where id =? " ;
			  Object[] params = {user} ;
			  rs = DBUtil.executeQuery(sql,params) ;
			  if(rs.next()) {
				  int id =   rs.getInt(0) ;
				  username =   rs.getString(1) ;
				  phone= rs.getString(3);
				  email=rs.getString(4);
				  role =   rs.getInt(5);
				  question = rs.getString(6) ;
				  answer=rs.getString(7);
				  //role=rs.getInt(5);
				  createTime=rs.getDate(8);
				  updateTime=rs.getDate(9);
				  //String password=rs.getString(2);
				  user = new UserInfo(username,phone,email,question,answer);
			  }
			  return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null ; 
		}catch (Exception e) {
			e.printStackTrace();
			return null ; 
		}
		finally {
			DBUtil.closeAll(rs, pstmt, DBUtil.connection);
		}
	}
	public UserInfo selectUserInfo(String username) {//登录过程获取个人信息
		  PreparedStatement pstmt = null ;
		  ResultSet rs = null ; 
		  UserInfo user = null;
		  int id=0;
		  String phone=null;
		  String email=null;
		  int role=0;
		  String question=null ;
		  String answer=null;
		  Date createTime=null;
		  Date updateTime=null;
		  String sql = "select * from user_table where username =? " ;
		  Object[] params = {username} ;
		  rs = DBUtil.executeQuery(sql,params) ;
		  try {
			if(rs.next()) {
				  id =   rs.getInt(0) ;
				  username =   rs.getString(1) ;
				  phone= rs.getString(3);
				  email=rs.getString(4);
				  role =   rs.getInt(5);
				  question = rs.getString(6) ;
				  answer=rs.getString(7);
				  createTime=rs.getDate(8);
				  updateTime=rs.getDate(9);
				  user = new UserInfo(username,phone,email,question,answer);
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	public List<UserTable> checkAdmin(String username, String password) 
	{	
		return SqlVisiter.executeQuery(
			"select * from user_table where username=? and password=? and role=?",
			UserTable.class, 
			username, password, 0 /*admin*/
		);
	}
	@Override
	public List<UserTable> getUserList() {
		return SqlVisiter.executeQuery(
			"select * from user_table", 
			UserTable.class
		);
	}

}



	