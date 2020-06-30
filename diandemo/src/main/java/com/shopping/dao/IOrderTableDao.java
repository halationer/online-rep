package com.shopping.dao;

import java.util.List;

import com.shopping.common.OrderDetail;
import com.shopping.common.OrderTable;

public interface IOrderTableDao {
	public OrderTable findOrderByOrderNo(Integer orderNo);
	public boolean insert(OrderTable orderTable);
	public OrderTable findOrderTableByUserIdAndOrderNo(Integer userId,Integer orderNo);
	public boolean updateByPrimaryKey(OrderTable orderTable);
	public List<OrderTable> findOrderByUserid(Integer userId);
	
	public List<OrderTable> mFindAllOrders();
	public boolean mUpdateStatusByOrderNo(OrderTable orderTable);
}
