package com.shopping.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shopping.common.CartProductVoList;
import com.shopping.common.Goods;
import com.shopping.common.ServerResponse;
//import com.shopping.common.Category;
import com.shopping.common.ShoppingCart;
import com.shopping.common.UserInfo;
import com.shopping.dao.IShoppingCartDao;
import com.shopping.util.DBUtil;

public class ShoppingCartDaoImpl implements IShoppingCartDao{
	public List<ShoppingCart>ShoppingCartList(Integer userId)
	{     	
		    PreparedStatement pstmt = null ;
	        ShoppingCart shoppingCart = null;
	        CartProductVoList cart=null;
			List<ShoppingCart> shoppingCarts = new ArrayList<ShoppingCart>();
			ResultSet rs = null ;
			try {
				String sql = "select * from shopping_cart where user_id=?" ;
				Object[] params = {userId};
				rs = DBUtil.executeQuery(sql,params) ;
				  while(rs.next()) {
					  Integer id=rs.getInt(0);
					  Integer user_id=rs.getInt(1);
					  Integer product_id=rs.getInt(2);
					  Integer quantity = rs.getInt(3) ;
					  Integer checked=rs.getInt(4);
					  Date creat_time=rs.getDate(5);
					  Date update_time=rs.getDate(6);
					  shoppingCart = new ShoppingCart(id, user_id, product_id, quantity,checked, creat_time, update_time);
					  shoppingCarts.add(shoppingCart) ;
				  }
				  return shoppingCarts;
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
		public ShoppingCart ShoppingCartVO(Integer userId) {
	    	PreparedStatement pstmt = null ;
	        ShoppingCart shoppingCart = null;
	        CartProductVoList cart=null;
			ShoppingCart shoppingCarts =null;
			ResultSet rs = null ;
			try {
				String sql = "select * from shopping_cart where user_id=?" ;
				Object[] params = {userId};
				rs = DBUtil.executeQuery(sql,params) ;
				  while(rs.next()) {
					  Integer id=rs.getInt(1);
					  Integer user_id=rs.getInt(2);
					  Integer product_id=rs.getInt(3);
					  Integer quantity = rs.getInt(4) ;
					  Integer checked=rs.getInt(5);
					  Date creat_time=rs.getDate(6);
					  Date update_time=rs.getDate(7);
					  shoppingCart = new ShoppingCart(id, user_id, product_id, quantity,checked, creat_time, update_time);
				  }
				  return shoppingCart;
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
		public boolean ShoppingCartAdd(ShoppingCart cart1) {
			ResultSet rs = null ;
			String sql = "insert into shopping_cart(id, user_id,product_id, quantity,checked) values(?,?,?,?,?)" ;
			Object[] params = {cart1.getId(),cart1.getUser_id(),cart1.getProductId(),cart1.getQuantity(),cart1.getChecked()};
			return DBUtil.executeUpdate(sql,params) ;
		}
		
		public boolean updateByPrimaryKey(ShoppingCart cart) {
			String sql = "update shopping_cart set quantity=? where id=?" ;
			Object[] params = {cart.getQuantity(),cart.getId()};
			return DBUtil.executeUpdate(sql, params) ;
		}
		
		public boolean deleteByPrimaryKey(ShoppingCart cart1) {
			ResultSet rs = null ;
			String sql = "delete from shopping_cart where id=?, user_id=?,product_id=?, quantity=?,checked=?" ;
			Object[] params = {cart1.getId(),cart1.getUser_id(),cart1.getProductId(),cart1.getQuantity(),cart1.getChecked()};
			return DBUtil.executeUpdate(sql,params) ;
		}
		
		public boolean insert(ShoppingCart cart1) {
	        ResultSet rs = null ;
			String sql = "insert into shopping_cart(id, user_id,product_id, quantity,checked) values(?,?,?,?,?)" ;
			Object[] params = {cart1.getId(),cart1.getUser_id(),cart1.getProductId(),cart1.getQuantity(),cart1.getChecked()};
			return DBUtil.executeUpdate(sql,params) ;
			
		}
		
		public Integer getShoppingCartQuantity(Integer userid) {
			PreparedStatement pstmt = null ;
	        //ShoppingCart shoppingCart = null;
	        //CartProductVoList cart=null;
			Integer quantity=null;
			ResultSet rs = null ;
			try {
				String sql = "select quantity from shopping_cart where user_id=?" ;
				Object[] params = {userid};
				rs = DBUtil.executeQuery(sql,params) ;
				  while(rs.next()) {
					  quantity += rs.getInt(3) ;
				  }
				  return quantity;
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

		public List<ShoppingCart> selectCartByUserid(Integer userid) {
			PreparedStatement pstmt = null ;
			List<ShoppingCart> shoppingCart = new ArrayList<ShoppingCart>();
			ResultSet rs = null ;
			try {
				String sql = "select * from shopping_cart where user_id=?" ;
				Object[] params = {userid};
				rs = DBUtil.executeQuery(sql,params) ;
				  while(rs.next()) {
					  Integer id=rs.getInt(1);
					  Integer user_id=rs.getInt(2);
					  Integer product_id=rs.getInt(3);
					  Integer quantity = rs.getInt(4) ;
					  Integer checked=rs.getInt(5);
					  ShoppingCart shoppingcart=new ShoppingCart(id,user_id,product_id,quantity,checked);
					  shoppingCart.add(shoppingcart);
				  }
				  return shoppingCart;
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
			//return null;
		}
		
		public ShoppingCart selectCartByUserIdAndPrductId(Integer userid,Integer productId) {
			PreparedStatement pstmt = null ;
	        ShoppingCart shoppingCart = null;
	        Integer id=null;
	        Integer user_id=null;
	        Integer product_id=null;
	        Integer quantity=null;
	        Integer checked=null;
	        Date create_time=null;
	        Date update_time=null;
	        ResultSet rs = null ;
			try {
				String sql = "select * from shopping_cart where user_id=? and product_id=?" ;
				Object[] params = {userid,productId};
				rs = DBUtil.executeQuery(sql,params) ;
				  while(rs.next()) {
					  id=rs.getInt(1);
					  user_id=rs.getInt(2);
					  product_id=rs.getInt(3);
					  quantity=rs.getInt(4);
					  checked=rs.getInt(5);
					  shoppingCart=new ShoppingCart(id,user_id,product_id,quantity,checked);
				  }
				  return shoppingCart;
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
		
		
		
		public boolean isCheckedAll(Integer userid) {
			PreparedStatement pstmt = null ;
	        ShoppingCart shoppingCart = null;
	        //CartProductVoList cart=null;
			Integer checked=null;
			ResultSet rs = null ;
			try {
				String sql = "select checked from shopping_cart where user_id=? and checked=0" ;
				Object[] params = {userid};
				rs = DBUtil.executeQuery(sql,params) ;
//				  while(rs.next()) {
//					  checked = rs.getInt(1) ;
//				  }
				  if(rs.next()) {
					  return false;
				  }else {
					  return true;
				  }
			} catch (SQLException e) {
				e.printStackTrace();
				return false ; 
			}catch (Exception e) {
				e.printStackTrace();
				return false ; 
			}
			finally {
				DBUtil.closeAll(rs, pstmt, DBUtil.connection);
			}
		}

		public void isCancelCheckedAll(Integer userid) {
			PreparedStatement pstmt = null ;
	        ShoppingCart shoppingCart = null;
	        //CartProductVoList cart=null;
			Integer quantity=null;
			ResultSet rs = null ;
			
			String sql = "update shopping_cart set checked=0 where user_id=?" ;
			Object[] params = {userid};
		    DBUtil.executeUpdate(sql,params) ;
			
		}
		
		@Override
		public Integer deleteByPrimaryKey(Integer userid) {//删除某一个商品
			// TODO Auto-generated method stub
			PreparedStatement pstmt = null ;
	        ShoppingCart shoppingCart = null;
	        //CartProductVoList cart=null;
			Integer Id=null;
			ResultSet rs = null ;
			try {
				String sql = "delect * from shopping_cart where user_id=? " ;
				Object[] params = {userid};
				rs = DBUtil.executeQuery(sql,params) ;
				  while(rs.next()) {
					  Id = rs.getInt(0) ;
				  }
				  return Id;
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
		public ShoppingCart selectPrimaryKey(Integer id) {
			// TODO Auto-generated method stub
			PreparedStatement pstmt = null ;
	        ShoppingCart shoppingCart = null;
	        Integer Id=null;
	        Integer user_id=null;
	        Integer product_id=null;
	        Integer quantity=null;
	        Integer checked=null;
	        Date create_time=null;
	        Date update_time=null;
	        ResultSet rs = null ;
			try {
				String sql = "select * from shopping_cart where id=?" ;
				Object[] params = {id};
				rs = DBUtil.executeQuery(sql,params) ;
				  while(rs.next()) {
					  Id=rs.getInt(0);
					  user_id=rs.getInt(1);
					  product_id=rs.getInt(2);
					  quantity=rs.getInt(3);
					  checked=rs.getInt(4);
					  shoppingCart=new ShoppingCart(Id,user_id,product_id,quantity,checked);
				  }
				  return shoppingCart;
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
		public List<ShoppingCart> selectAll() {
			// TODO Auto-generated method stub
			return null;
		}
		
		
		public boolean deleteById(ShoppingCart cart1) {
			ResultSet rs = null ;
			String sql = "delete from shopping_cart where id=?" ;
			Object[] params = {cart1.getId()};
			return DBUtil.executeUpdate(sql,params) ;
		}
		
		
		public List<ShoppingCart> findCartListByUserIdAndChecked(Integer userId){
		    PreparedStatement pstmt = null ;
	        ShoppingCart shoppingCart = null;
			List<ShoppingCart> shoppingCarts = new ArrayList<ShoppingCart>();
			ResultSet rs = null ;
			try {
				String sql = "select * from shopping_cart where user_id=? and checked=1" ;
				Object[] params = {userId};
				rs = DBUtil.executeQuery(sql,params) ;
				  while(rs.next()) {
					  Integer id=rs.getInt(1);
					  Integer user_id=rs.getInt(2);
					  Integer product_id=rs.getInt(3);
					  Integer quantity = rs.getInt(4) ;
					  Integer checked=rs.getInt(5);
					  shoppingCart = new ShoppingCart(id, user_id, product_id, quantity,checked);
					  shoppingCarts.add(shoppingCart) ;
				  }
				  return shoppingCarts;
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
}
