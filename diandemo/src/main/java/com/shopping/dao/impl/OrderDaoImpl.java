package com.shopping.dao.impl;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shopping.common.Goods;
import com.shopping.common.Order;
import com.shopping.common.OrderItem;
import com.shopping.common.PayInfo;
import com.shopping.dao.IOrderDao;
import com.shopping.util.DBUtil;


public class OrderDaoImpl implements IOrderDao{
	
	public boolean updateByPrimarykey(Order order) 
	{
		String sql = "update order_table set user_id=?,order_no=?,shipping_id=?,payment=?,payment_type=?,postage=?,status=?,payment_time=?,send_time=?,end_time=?,close_time=?,create_time=?,update_time=? where id=?" ;
		Object[] params = {order.getUserId(),order.getOrderNo(),order.getShippingId(),order.getPayment(),order.getPaymentType(),order.getPostage(),order.getStatus(),order.getPaymentTime(),order.getSendTime(),order.getEndTime(),order.getCloseTime(),order.getCreatTime(),order.getUpdateTime(),order.getId()};
		return DBUtil.executeUpdate(sql, params) ;
	}
	public boolean insertPayInfo (PayInfo payInfo) 
	{
		String sql ="insert into pay(user_id,order_no,pay_platform,platform_number,platform_status) values(?,?,?,?,?) " ;
		Object[] params = {payInfo.getUserId(),payInfo.getOrderNo(),payInfo.getPayPlatForm(),payInfo.getPlatformNumber(),payInfo.getPlatformStatus()};
		return DBUtil.executeUpdate(sql, params) ;
	}
	
	
	
	
	
	
	public Order findOrderByOrderNo(Long orderNo) 
	{
		 Order order= null;
		 PreparedStatement pstmt = null ;
		 ResultSet rs = null ; 
		try {
			  String sql = "select * from order_table where order_no =? " ;
			  Object[] params = {orderNo} ;
			  rs = DBUtil.executeQuery(sql,params) ;
			  if(rs.next()) {
				Integer id=rs.getInt(1);
				Long orderNo1=rs.getLong(2);
				Integer userId=rs.getInt(3);
				Integer shippingId=rs.getInt(4);
				BigDecimal payment=rs.getBigDecimal(5);
				int paymentType=rs.getInt(6);
				Integer postage=rs.getInt(7);
				Integer status=rs.getInt(8);
				Date paymentTime=(Date)rs.getObject(9);
				Date sendTime=(Date)rs.getObject(10);
				Date endTime=(Date)rs.getObject(11);
				Date closeTime=(Date)rs.getObject(12);
				Date creatTime=(Date)rs.getObject(13);
				Date updateTime=(Date)rs.getObject(14);
				order=new Order(id, userId, orderNo1, shippingId, payment, paymentType, postage, status, paymentTime, sendTime, endTime, closeTime, creatTime, updateTime);
			  }
			  return order ;
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
	public List<OrderItem> findOrderItemByOrderNo(Long orderNo)
	{
		 OrderItem orderItem = null;
			String sql = "select * from order_detial where order_no=?";
			Object[] params = {orderNo}; 
			
			List<OrderItem> orderItems = new ArrayList<OrderItem>();
			
			ResultSet rs = DBUtil.executeQuery(sql, params) ;
			
			try {
				while(rs.next()) {
					Integer id=rs.getInt(1);
					Integer userId=rs.getInt(2);
					Long orderNo1=rs.getLong(3);
					Integer productId=rs.getInt(4);
					String productName=rs.getString(5);
					String productImage=rs.getString(6);
					BigDecimal currentUnitPrice=rs.getBigDecimal(7);
					Integer quantity=rs.getInt(8);
					BigDecimal totalPrice=rs.getBigDecimal(9);
					Date creatTime=(Date)rs.getObject(10);
					Date updateTime=(Date)rs.getObject(11);
			        orderItem=new OrderItem(id, userId, orderNo1, productId, productName, productImage, currentUnitPrice, quantity, totalPrice, creatTime, updateTime);
					orderItems.add(orderItem) ;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.connection);
			}
			return orderItems;
		
		
		
		
		
		
	}

}
