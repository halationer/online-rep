package com.shopping.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.shopping.common.UserInfo;
import com.shopping.common.UserTable;
import com.shopping.dao.IUserServiceDao;
import com.shopping.util.DBUtil;
import com.shopping.util.SqlVisiter;

public class UserServiceDaoImpl implements IUserServiceDao {
	
		//数据访问层：原子性 的增删改查
		public boolean insertUserInfo (UserInfo userInfo) 
		{
			String sql ="insert into user_table(username, password,phone, email,question,answer) values(?,?,?,?,?,?,) " ;
			Object[] params = {userInfo.getUsername(),userInfo.getPassword(),userInfo.getPhone(),userInfo.getEmail(),userInfo.getQuestion(),userInfo.getAnswer()};
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
				  String sql = "select * from user_table where username =? " ;
				  Object[] params = {username} ;
				  rs = DBUtil.executeQuery(sql,params) ;
				  if(rs.next()) {
					  String username1 =   rs.getString(2) ;
					  String password= rs.getString(3);
					  String phone = rs.getString(4) ;
					  String email=rs.getString(5);
					  String question=rs.getString(7);
					  String answer=rs.getString(8);
					  userInfo=new UserInfo(username1, password, email, phone, question, answer);
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
					  String question=rs.getString(7);
					  String answer=rs.getString(8);
					  userInfo=new UserInfo(username, password, email1, phone, question, answer);
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
		
		public boolean forgetReplacePassword(String username, String passwordNew, String forgetToken) {
			// TODO Auto-generated method stub
			return false;
		}
		public boolean loginReplacePassword(String passwordOld, String passwordNew) {
			// TODO Auto-generated method stub
			return false;
		}
		public boolean loginRenewPassword(String email, String phone, String question, String answer) {
			// TODO Auto-generated method stub
			return false;
		}
		public boolean loginForce() {
			// TODO Auto-generated method stub
			return false;
		}
		public boolean exitLogin() {
			// TODO Auto-generated method stub
			return false;
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
	}



	