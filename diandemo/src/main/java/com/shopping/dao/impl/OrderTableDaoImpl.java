package com.shopping.dao.impl;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.shopping.common.OrderDetail;
import com.shopping.common.OrderTable;
import com.shopping.dao.IOrderTableDao;
import com.shopping.util.DBUtil;

public class OrderTableDaoImpl implements IOrderTableDao{

	public OrderTable findOrderByOrderNo(Integer orderNo) {
		if(orderNo == null || orderNo == 0) return null;
		
		PreparedStatement pstmt = null ;
		OrderTable orderTable = null;
		ResultSet rs = null ;
		try {
			String sql = "select * from order_table where order_no=?" ;
			Object[] params = {orderNo};
			rs = DBUtil.executeQuery(sql,params) ;
			  while(rs.next()) {
				  Integer id=rs.getInt(1);
				  Integer order_no=rs.getInt(2);
				  Integer user_id=rs.getInt(3);
				  Integer shipping_id = rs.getInt(4) ;
				  BigDecimal payment=rs.getBigDecimal(5);
				  Integer payment_type=rs.getInt(6);
				  BigDecimal postage=rs.getBigDecimal(7);
				  Integer status = rs.getInt(8) ;
				  orderTable = new OrderTable(id, order_no, user_id, shipping_id,payment,payment_type,postage,status);
			  }
			  return orderTable;
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
	
	public boolean insert(OrderTable orderTable) {
		ResultSet rs = null ;
		String sql = "insert into order_table(id,order_no,user_id,shipping_id,payment,payment_type,postage,status) values(?,?,?,?,?,?,?,?)" ;
		Object[] params = {orderTable.getId(),orderTable.getOrder_no(),orderTable.getUser_id(),orderTable.getShopping_id(),orderTable.getPayment(),orderTable.getPaymentType(),orderTable.getPostage(),orderTable.getStatus()};
		return DBUtil.executeUpdate(sql, params) ;
	}

	@Override
	public OrderTable findOrderTableByUserIdAndOrderNo(Integer userId, Integer orderNo) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null ;
		OrderTable orderTable = null;
     
		ResultSet rs = null ;
		try {
			String sql = "select * from order_table where user_id=? and order_no=?" ;
			Object[] params = {userId,orderNo};
			rs = DBUtil.executeQuery(sql,params) ;
			  while(rs.next()) {
				  Integer id=rs.getInt(1);
				  Integer order_no=rs.getInt(2);
				  Integer user_id=rs.getInt(3);
				  Integer shipping_id = rs.getInt(4) ;
				  BigDecimal payment=rs.getBigDecimal(5);
				  Integer payment_type=rs.getInt(6);
				  BigDecimal postage=rs.getBigDecimal(7);
				  Integer status = rs.getInt(8) ;
				  orderTable = new OrderTable(id, order_no, user_id, shipping_id,payment,payment_type,postage,status);
			  }
			  return orderTable;
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
	
	public boolean updateByPrimaryKey(OrderTable orderTable) {
		String sql = "update order_table set order_no=?,user_id=?,shipping_id=?, payment=?,payment_type=?,postage=?,status=? where id=?" ;
		Object[] params = {orderTable.getOrder_no(),orderTable.getUser_id(),orderTable.getShopping_id(),orderTable.getPayment(),orderTable.getPaymentType(),orderTable.getPostage(),orderTable.getStatus(),orderTable.getId()};
		return DBUtil.executeUpdate(sql, params) ;
		
	}
	
	@Override
	public List<OrderTable> findOrderByUserid(Integer userId) {
		// TODO Auto-generated method stub
	    PreparedStatement pstmt = null ;
	    OrderTable orderTable = null;
		List<OrderTable> orderTables = new ArrayList<OrderTable>();
		ResultSet rs = null ;
		try {
			String sql = "select * from order_table where user_id=?" ;
			Object[] params = {userId};
			rs = DBUtil.executeQuery(sql,params) ;
			  while(rs.next()) {
				  Integer id=rs.getInt(1);
				  Integer order_no=rs.getInt(2);
				  Integer user_id=rs.getInt(3);
				  Integer shipping_id = rs.getInt(4) ;
				  BigDecimal payment=rs.getBigDecimal(5);
				  Integer payment_type=rs.getInt(6);
				  BigDecimal postage=rs.getBigDecimal(7);
				  Integer status = rs.getInt(8) ;
				  orderTable = new OrderTable(id, order_no, user_id, shipping_id,payment,payment_type,postage,status);
				  orderTables.add(orderTable);
			  }
			  return orderTables;
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

	public List<OrderTable> mFindAllOrders(){
		OrderTable order = null;
		String sql = "select * from order_table";
		Object[] params = {};
		List<OrderTable> orderlist = new ArrayList<OrderTable>();
		
		ResultSet rs = DBUtil.executeQuery(sql, params) ;
		
		try {
			while(rs.next()) {
				int id = rs.getInt(1);
				int order_no = rs.getInt(2);
				int user_id = rs.getInt(3);
				int shipping_id = rs.getInt(4);
				BigDecimal payment = rs.getBigDecimal(5);
				int payment_type = rs.getInt(6);
				BigDecimal postage = rs.getBigDecimal(7);
				int status = rs.getInt(8);
				Date payment_time = (Date)rs.getObject(9);
				Date send_time = (Date)rs.getObject(10);
				Date end_time = (Date)rs.getObject(11);
				Date close_time = (Date)rs.getObject(12);
				Date create_time = (Date)rs.getObject(13);
				Date update_time = (Date)rs.getObject(14);
				order = new OrderTable(id, order_no, user_id, shipping_id, payment, payment_type, postage, status, payment_time, send_time, end_time, close_time, update_time, create_time);
				orderlist.add(order) ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.connection);
		}
		return orderlist;
	}
	public boolean mUpdateStatusByOrderNo(OrderTable orderTable)
	{
		String sql = "update order_table set status=3 where order_no=?" ;
		Object[] params = {orderTable.getOrder_no()};
		return DBUtil.executeUpdate(sql, params) ;
	}
}
