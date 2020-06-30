package com.shopping.dao;

import java.util.List;

import com.shopping.common.Order;
import com.shopping.common.OrderItem;
import com.shopping.common.PayInfo;

public interface IOrderDao {
	public Order findOrderByOrderNo(Long orderNo) ;
	public List<OrderItem> findOrderItemByOrderNo(Long orderNo);
	public boolean updateByPrimarykey(Order order) ;
	public boolean insertPayInfo (PayInfo payInfo) ;
	
	

}
