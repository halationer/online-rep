package com.shopping.dao.impl;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shopping.common.Address;
import com.shopping.common.Goods;
import com.shopping.common.UserInfo;
import com.shopping.dao.IAddressDao;
import com.shopping.util.DBUtil;

public class AddressDaoImpl implements IAddressDao{

	public boolean insert (Address address) 
	{
		String sql ="insert into address(user_id,receiver_name,receiver_phone,receiver_mobile,receiver_province,receiver_city,receiver_address,receiver_zip) values(?,?,?,?,?,?,?,?) " ;
		Object[] params = {address.getUserId(),address.getReceiverName(),address.getReceiverPhone(),address.getReceiverMobile(),address.getReceiverProvince(),address.getReceiverCity(),address.getReceiverAddress(),address.getReceiverZip()};
		return DBUtil.executeUpdate(sql, params) ;
		
	}
	public Integer selectIdByAll(Address address) {
	     Integer id=null;
		 PreparedStatement pstmt = null ;
		 ResultSet rs = null ; 
		try {
			  String sql = "select id from address where user_id=? and receiver_name=? and receiver_phone=? and receiver_mobile=? and receiver_province=? and receiver_city=? and receiver_address=? and receiver_zip=?" ;
			  Object[] params = {address.getUserId(),address.getReceiverName(),address.getReceiverPhone(),address.getReceiverMobile(),address.getReceiverProvince(),address.getReceiverCity(),address.getReceiverAddress(),address.getReceiverZip()} ;
			  rs = DBUtil.executeQuery(sql,params) ;
			  if(rs.next()) {
				 id=rs.getInt(1);
			  }
			  return id ;
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
	public boolean deleteByid(Integer id) {
		String sql = "delete from address where id = ?" ;
		Object[] params = {id} ;
		return DBUtil.executeUpdate(sql, params) ;
	}
	public boolean updateByid(Address address) 
	{
		String sql = "update address set receiver_name=? , receiver_phone=? , receiver_mobile=? , receiver_province=? , receiver_city=? , receiver_address=? , receiver_zip=? where id=?" ;
		Object[] params = {address.getReceiverName(),address.getReceiverPhone(),address.getReceiverMobile(),address.getReceiverProvince(),address.getReceiverCity(),address.getReceiverAddress(),address.getReceiverZip(),address.getId()};
		return DBUtil.executeUpdate(sql, params) ;
	}
	public Address selectByid(Integer id) {
		Address address = null;
		 PreparedStatement pstmt = null ;
		 ResultSet rs = null ; 
		try {
			  String sql = "select * from address where id =? " ;
			  Object[] params = {id} ;
			  rs = DBUtil.executeQuery(sql,params) ;
			  if(rs.next()) {
				  int id1= rs.getInt(1);
				  int userId= rs.getInt(2);
				  String receiverName =   rs.getString(3) ;//??
				  String receiverPhone= rs.getString(4);
				  String receiverMobile = rs.getString(5) ;
				  String receiverProvince=rs.getString(6);
				  String receiverCity=rs.getString(7);
				  String receiverAddress=rs.getString(9);
				  String receiverZip=rs.getString(10);
				  Date creatTime=(Date)rs.getObject(11);
				  Date updateTime=(Date)rs.getObject(12);
				 address =new Address(id1, userId, receiverName, receiverPhone, receiverMobile, receiverProvince, receiverCity, receiverAddress, receiverZip, creatTime, updateTime);
			  }
			  return address ;
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
	public List<Address> selectAllByUserId(Integer id)
	{
		 Address address= null;
			String sql = "select * from address where user_id=?";
			Object[] params = {id}; 
			
			List<Address> aList = new ArrayList<Address>();
			
			ResultSet rs = DBUtil.executeQuery(sql, params) ;
			
			try {
				while(rs.next()) {
					 int id1= rs.getInt(1);
					  int userId= rs.getInt(2);
					  String receiverName =   rs.getString(3) ;//??
					  String receiverPhone= rs.getString(4);
					  String receiverMobile = rs.getString(5) ;
					  String receiverProvince=rs.getString(6);
					  String receiverCity=rs.getString(7);
					  String receiverAddress=rs.getString(9);
					  String receiverZip=rs.getString(10);
					  Date creatTime=(Date)rs.getObject(11);
					  Date updateTime=(Date)rs.getObject(12);
					  address =new Address(id1, userId, receiverName, receiverPhone, receiverMobile, receiverProvince, receiverCity, receiverAddress, receiverZip, creatTime, updateTime);
					 aList.add(address) ;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.connection);
			}
			return aList;

		}

}
