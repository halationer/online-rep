package com.shopping.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.shopping.common.Address;
import com.shopping.common.Shipping;
import com.shopping.dao.IShippingDao;
import com.shopping.util.DBUtil;

public class ShippingDaoImpl implements IShippingDao{

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Shipping record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Shipping selectByPrimaryKey(Integer id) {
		Shipping address = null;
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
				  String receiverDistrict = rs.getString(8);
				  String receiverAddress=rs.getString(9);
				  String receiverZip=rs.getString(10);
				  Date creatTime=(Date)rs.getObject(11);
				  Date updateTime=(Date)rs.getObject(12);
				  address =new Shipping(id1, userId, receiverName, receiverPhone, receiverMobile, receiverProvince, receiverCity, receiverDistrict, receiverAddress, receiverZip, creatTime, updateTime);
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

	@Override
	public List<Shipping> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKey(Shipping record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBySelectiveKey(Shipping shipping) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteByUserIdAndShippingId(Integer userId, Integer shippingId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
