package com.shopping.dao.impl;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.shopping.common.CartProductVoList;
import com.shopping.common.OrderDetail;
import com.shopping.common.OrderTable;
import com.shopping.common.ShoppingCart;
import com.shopping.dao.IOrderDetailDao;
import com.shopping.util.DBUtil;
import com.shopping.util.MySQLConnections;

public class OrderDetailDaoImpl implements IOrderDetailDao{

	//批量插入
	public int insertBatch(List<OrderDetail> orderDetailList) throws SQLException {
//		ResultSet rs = null ;
//		String sql = "insert into order_detail(id,order_no,user_id,product_id,product_name,product_image,current_unit_price,quantity) values(?,?,?,?,?,?,?,?)" ;
//		for(OrderDetail orderDetail:orderDetailList) {
//			Object[] params = {orderDetail.getId(),orderDetail.getOrder_no(),orderDetail.getUser_id(),orderDetail.getProduct_id(),orderDetail.getProduct_name(),orderDetail.getProduct_image(),orderDetail.getCurrent_unit_price(),orderDetail.getQuantity()};
//			return DBUtil.executeUpdate(sql,params) ;
//		}
		Connection con=(Connection) MySQLConnections.getConnection();
	    PreparedStatement stmt = null;
		int i = 0;  
        //设置批量处理的数量             
        int batchSize = orderDetailList.size();       
        stmt = con.prepareStatement("insert into order_detail(id,order_no,user_id,product_id,product_name,product_image,current_unit_price,quantity)"
                + " values(?,?,?,?,?,?,?,?)");
        // 关闭事务自动提交 ,这一行必须加上
        con.setAutoCommit(false);
        for (OrderDetail orderDetail:orderDetailList){
            i = i + 1;       
            stmt.setInt(1, orderDetail.getId());  
            stmt.setInt(2, orderDetail.getOrder_no());  
            stmt.setInt(3, orderDetail.getUser_id());
            stmt.setInt(4, orderDetail.getProduct_id());
            stmt.setString(5,orderDetail.getProduct_name());
            stmt.setString(6,orderDetail.getProduct_image());
            stmt.setBigDecimal(7,orderDetail.getCurrent_unit_price() );
            stmt.setInt(8,orderDetail.getQuantity());
            stmt.addBatch();  
            if ( i % batchSize == 0 ) {
                stmt.executeBatch();
                con.commit();
            }
        }
        if ( i % batchSize != 0 ) {
            stmt.executeBatch();
            con.commit();
        }
        return i;
		
		
//	    Connection conn = null;
//	    PreparedStatement pstmt = null;
//	    try {
//	    	conn = ThreadLocalConnection.getConnection();
//	    	String sql = "insert into order_detail(id,order_no,user_id,product_id,product_name,product_image,current_unit_price,quantity) values(?,?,?,?,?,?,?,?)" ;
//	        pstmt = conn.prepareStatement(sql);
//            for(OrderDetail orderDetail:orderDetailList){
//                 pstmt.setInt(1, orderDetail.getId());
//                 pstmt.setInt(2, orderDetail.getOrder_no());
//                 pstmt.setInt(3, orderDetail.getUser_id());
//                 pstmt.setInt(4, orderDetail.getProduct_id());
// 				 
//                 pstmt.addBatch();
//             }
//             pstmt.executeBatch();//整体更新
//	    	
//	    }catch(SQLException e){
//            e.printStackTrace();
//            return false;
//        }finally{
//            DBUtil.close(pstmt);
//            //return false;
	}

	@Override
	public List<OrderDetail> findOrderDetailByOrderNo(long orderNo) {
		// TODO Auto-generated method stub
		  PreparedStatement pstmt = null ;
		    OrderDetail orderDetail = null;
			List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
			ResultSet rs = null ;
			try {
				String sql = "select * from order_detail where order_no=?" ;
				Object[] params = {orderNo};
				rs = DBUtil.executeQuery(sql,params) ;
				  while(rs.next()) {
					  Integer id=rs.getInt(1);
					  Integer order_no=rs.getInt(2);
					  Integer user_id=rs.getInt(3);
					  Integer product_id = rs.getInt(4);
					  String product_name=rs.getString(5);
					  String product_image=rs.getString(6);
					  BigDecimal current_unit_price=rs.getBigDecimal(7);
					  Integer quantity=rs.getInt(8);
					  BigDecimal total_price=rs.getBigDecimal(9);
					  orderDetail = new OrderDetail(id, order_no, user_id, product_id,product_name,product_image,current_unit_price,quantity,total_price);
					  orderDetails.add(orderDetail) ;
				  }
				  return orderDetails;
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
	
	
	public boolean insert(OrderDetail orderDetail) {
		ResultSet rs = null ;
		String sql = "insert into order_detail(id,order_no,user_id,product_id,product_name,product_image,current_unit_price,quantity) values(?,?,?,?,?,?,?,?)" ;
		Object[] params = {orderDetail.getId(),orderDetail.getOrder_no(),orderDetail.getUser_id(),orderDetail.getProduct_id(),orderDetail.getProduct_name(),orderDetail.getProduct_image(),orderDetail.getCurrent_unit_price(),orderDetail.getQuantity()};
		return DBUtil.executeUpdate(sql,params) ;
	}
	
}
