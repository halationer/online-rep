package com.shopping.dao;

import java.sql.SQLException;
import java.util.List;

import com.shopping.common.OrderDetail;

public interface IOrderDetailDao {
	//批量插入
		public int insertBatch(List<OrderDetail> orderDetailList) throws SQLException;

		public List<OrderDetail> findOrderDetailByOrderNo(long order_no);
		
		public boolean insert(OrderDetail orderDetail);
}
