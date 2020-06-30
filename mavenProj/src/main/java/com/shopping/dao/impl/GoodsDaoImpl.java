package com.shopping.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shopping.common.Goods;
import com.shopping.dao.IGoodsDao;
import com.shopping.util.DBUtil;

public class GoodsDaoImpl implements IGoodsDao {

	public boolean insert (Goods goods) 
	{
		String sql ="insert into goods(category_id, name,subtitle, main_image,sub_image,detail,price,stock,status,create_time,update_time) values(?,?,?,?,?,?,?,?,?,NOW(),NOW()) " ;
		Object[] params = {goods.getCategory_id(),goods.getName(),goods.getSubtile(),goods.getMain_image(),goods.getSub_image(),goods.getDetail(),goods.getPrice(),goods.getStock(),goods.getStatus()};
		return DBUtil.executeUpdate(sql, params) ;
	}
	public boolean updateById(Goods goods) 
	{
		String sql = "update goods set category_id=?,name=?,subtitle=?, main_image=?,sub_image=?,detail=?,price=?,stock=?,status=?,update_time=NOW() where id=?" ;
		Object[] params = {goods.getCategory_id(),goods.getName(),goods.getSubtile(),goods.getMain_image(),goods.getSub_image(),goods.getDetail(),goods.getPrice(),goods.getStock(),goods.getStatus(),goods.getId()};
		return DBUtil.executeUpdate(sql, params) ;
	}
	public boolean updateStatusById(Integer id,Integer status) 
	{
		String sql = "update goods set status=? where id=?" ;
		Object[] params = {status,id};
		return DBUtil.executeUpdate(sql, params) ;
	}
	public boolean selectGoodsById(Integer id) 
	{
		 PreparedStatement pstmt = null ;
		 ResultSet rs = null ;
		 boolean pwd=false;
		try {
			  String sql = "select * from goods where id=? " ;
			  Object[] params = {id} ;
			  rs = DBUtil.executeQuery(sql,params) ;
			  if(rs.next()) {
				  pwd=true;
			  }
			  return pwd ;
		} catch (SQLException e) {
			e.printStackTrace();
			return pwd ; 
		}catch (Exception e) {
			e.printStackTrace();
			return pwd ; 
		}
		finally {
			DBUtil.closeAll(rs, pstmt, DBUtil.connection);
		}
	}
	public Goods selectGoodsInfoById(Integer id) {
		Goods goods = null;
		 PreparedStatement pstmt = null ;
		 ResultSet rs = null ; 
		try {
			  String sql = "select * from goods where id =? " ;
			  Object[] params = {id} ;
			  rs = DBUtil.executeQuery(sql,params) ;
			  if(rs.next()) {
				  Integer id1=rs.getInt(1);
				  Integer category_id=rs.getInt(2);
				  String name =  rs.getString(3) ;
				  String subtitle= rs.getString(4);
				  String main_image = rs.getString(5) ;
				  String sub_image=rs.getString(6);
				  String detail=rs.getString(7);
				  BigDecimal price=rs.getBigDecimal(8);
				  Integer stock=rs.getInt(9);
				  Integer status=rs.getInt(10);
				  Date creat_time=(Date)rs.getObject(11);
				  Date update_time=(Date)rs.getObject(12);
				  goods=new Goods(id1,category_id,name,subtitle,main_image,sub_image,detail,price,stock,status,creat_time,update_time);
			  }
			  return goods ;
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

	public List<Goods> queryGoodsByPage(int pageNum, int pageSize)
	{
	    Goods good = null;
		String sql = "select * from goods limit ?,?";
		Object[] params = {(pageNum-1)*pageSize,pageSize}; 
		
		List<Goods> goods = new ArrayList<Goods>();
		
		ResultSet rs = DBUtil.executeQuery(sql, params) ;
		
		try {
			while(rs.next()) {
				 Integer id1=rs.getInt(1);
				  Integer category_id=rs.getInt(2);
				  String name =  rs.getString(3) ;
				  String subtitle= rs.getString(4);
				  String main_image = rs.getString(5) ;
				  String sub_image=rs.getString(6);
				  String detail=rs.getString(7);
				  BigDecimal price=rs.getBigDecimal(8);
				  Integer stock=rs.getInt(9);
				  Integer status=rs.getInt(10);
				  Date creat_time=rs.getDate(11);
				  Date update_time=rs.getDate(12);
				  good=new Goods(id1,category_id,name,subtitle,main_image,sub_image,detail,price,stock,status,creat_time,update_time);
				  goods.add(good) ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.connection);
		}
		return goods;
	}
	public List<Goods> selectGoodsByCategoryId(Integer categoryid)
	{
    Goods good = null;
	String sql = "select * from goods where category_id=?";
	Object[] params = {categoryid}; 
	
	List<Goods> goods = new ArrayList<Goods>();
	
	ResultSet rs = DBUtil.executeQuery(sql, params) ;
	
	try {
		while(rs.next()) {
			 Integer id1=rs.getInt(1);
			  Integer category_id=rs.getInt(2);
			  String name =  rs.getString(3) ;
			  String subtitle= rs.getString(4);
			  String main_image = rs.getString(5) ;
			  String sub_image=rs.getString(6);
			  String detail=rs.getString(7);
			  BigDecimal price=rs.getBigDecimal(8);
			  Integer stock=rs.getInt(9);
			  Integer status=rs.getInt(10);
			  Date creat_time=rs.getDate(11);
			  Date update_time=rs.getDate(12);
			  good=new Goods(id1,category_id,name,subtitle,main_image,sub_image,detail,price,stock,status,creat_time,update_time);
			  goods.add(good) ;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.connection);
	}
	return goods;

}
	public List<Goods> selectGoodsByCategoryIdAndKeyword(Integer categoryid,String keyword)
	{
    Goods good = null;
	String sql = "select * from goods where category_id=? and name like ?";
	Object[] params = {categoryid,keyword}; 
	
	List<Goods> goods = new ArrayList<Goods>();
	
	ResultSet rs = DBUtil.executeQuery(sql, params) ;
	
	try {
		while(rs.next()) {
			 Integer id1=rs.getInt(1);
			  Integer category_id=rs.getInt(2);
			  String name =  rs.getString(3) ;
			  String subtitle= rs.getString(4);
			  String main_image = rs.getString(5) ;
			  String sub_image=rs.getString(6);
			  String detail=rs.getString(7);
			  BigDecimal price=rs.getBigDecimal(8);
			  Integer stock=rs.getInt(9);
			  Integer status=rs.getInt(10);
			  Date creat_time=rs.getDate(11);
			  Date update_time=rs.getDate(12);
			  good=new Goods(id1,category_id,name,subtitle,main_image,sub_image,detail,price,stock,status,creat_time,update_time);
			  goods.add(good) ;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}catch (Exception e) {
		e.printStackTrace();
	}
	finally {
		DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.connection);
	}
	return goods;

}
	public List<Goods> findGoodsByName(String productName,int pageNum, int pageSize)
	{
		    Goods good = null;
			String sql = "select * from goods where name like ? limit ?,?";
			Object[] params = {productName,(pageNum-1)*pageSize,pageSize}; 
			
			List<Goods> goods = new ArrayList<Goods>();
			
			ResultSet rs = DBUtil.executeQuery(sql, params) ;
			
			try {
				while(rs.next()) {
					 Integer id1=rs.getInt(1);
					  Integer category_id=rs.getInt(2);
					  String name =  rs.getString(3) ;
					  String subtitle= rs.getString(4);
					  String main_image = rs.getString(5) ;
					  String sub_image=rs.getString(6);
					  String detail=rs.getString(7);
					  BigDecimal price=rs.getBigDecimal(8);
					  Integer stock=rs.getInt(9);
					  Integer status=rs.getInt(10);
					  Date creat_time=rs.getDate(11);
					  Date update_time=rs.getDate(12);
					  good=new Goods(id1,category_id,name,subtitle,main_image,sub_image,detail,price,stock,status,creat_time,update_time);
					  goods.add(good) ;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.connection);
			}
			return goods;

		}
	public List<Goods> findByName(String productName)
	{
		    Goods good = null;
			String sql = "select * from goods where name like ? ";
			Object[] params = {productName}; 
			
			List<Goods> goods = new ArrayList<Goods>();
			
			ResultSet rs = DBUtil.executeQuery(sql, params) ;
			
			try {
				while(rs.next()) {
					 Integer id1=rs.getInt(1);
					  Integer category_id=rs.getInt(2);
					  String name =  rs.getString(3) ;
					  String subtitle= rs.getString(4);
					  String main_image = rs.getString(5) ;
					  String sub_image=rs.getString(6);
					  String detail=rs.getString(7);
					  BigDecimal price=rs.getBigDecimal(8);
					  Integer stock=rs.getInt(9);
					  Integer status=rs.getInt(10);
					  Date creat_time=rs.getDate(11);
					  Date update_time=rs.getDate(12);
					  good=new Goods(id1,category_id,name,subtitle,main_image,sub_image,detail,price,stock,status,creat_time,update_time);
					  goods.add(good) ;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.connection);
			}
			return goods;

		}
	
	public List<Goods> mFindAllGoods(){
		 Goods good = null;
		String sql = "select * from goods where status!=0";
		Object[] params = {}; 
		
		List<Goods> goods = new ArrayList<Goods>();
		
		ResultSet rs = DBUtil.executeQuery(sql, params) ;
		
		try {
			while(rs.next()) {
				 Integer id1=rs.getInt(1);
				  Integer category_id=rs.getInt(2);
				  String name =  rs.getString(3) ;
				  String subtitle= rs.getString(4);
				  String main_image = rs.getString(5) ;
				  String sub_image=rs.getString(6);
				  String detail=rs.getString(7);
				  BigDecimal price=rs.getBigDecimal(8);
				  Integer stock=rs.getInt(9);
				  Integer status=rs.getInt(10);
				  Date creat_time=rs.getDate(11);
				  Date update_time=rs.getDate(12);
				  good=new Goods(id1,category_id,name,subtitle,main_image,sub_image,detail,price,stock,status,creat_time,update_time);
				  goods.add(good) ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.connection);
		}
		return goods;
	}
	public List<Goods> mFindGoodsByName(String productName){
		 Goods good = null;
			String sql = "select * from goods where name like ? and status != 0";
			Object[] params = {productName}; 
			
			List<Goods> goods = new ArrayList<Goods>();
			
			ResultSet rs = DBUtil.executeQuery(sql, params) ;
			
			try {
				while(rs.next()) {
					 Integer id1=rs.getInt(1);
					  Integer category_id=rs.getInt(2);
					  String name =  rs.getString(3) ;
					  String subtitle= rs.getString(4);
					  String main_image = rs.getString(5) ;
					  String sub_image=rs.getString(6);
					  String detail=rs.getString(7);
					  BigDecimal price=rs.getBigDecimal(8);
					  Integer stock=rs.getInt(9);
					  Integer status=rs.getInt(10);
					  Date creat_time=rs.getDate(11);
					  Date update_time=rs.getDate(12);
					  good=new Goods(id1,category_id,name,subtitle,main_image,sub_image,detail,price,stock,status,creat_time,update_time);
					  goods.add(good) ;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.connection);
			}
			return goods;
	}
}


