package com.shopping.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import com.shopping.common.Category;
import com.shopping.common.CategoryTree;
import com.shopping.dao.ICategoryDao;
import com.shopping.util.DBUtil;

public class CategoryDaoImpl implements ICategoryDao {
	
	public List<Category> findChildCategory(Integer categoryId)
	{     	
		PreparedStatement pstmt = null ;
		Category category = null;
		List<Category> categories = new ArrayList<Category>();
		ResultSet rs = null ;
		try {
			String sql = "select * from category where parent_id=? and status=1" ;
			Object[] params = {categoryId};
			rs = DBUtil.executeQuery(sql,params) ;
			  while(rs.next()) {
				  Integer id=rs.getInt(1);
				  Integer parent_id=rs.getInt(2);
				  String name =   rs.getString(3) ;
				  Integer status=rs.getInt(4);
				  Date creat_time=rs.getDate(5);
				  Date update_time=rs.getDate(6);
				  category = new Category(id, parent_id, name, status, creat_time, update_time);
				  categories.add(category) ;
			  }
			  return categories ;
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
	
	public Category selectByPrimaryKey(Integer categoryId)
	{     	
		PreparedStatement pstmt = null ;
		Category category = null;
		ResultSet rs = null ;
		try {
			String sql = "select * from category where id=?" ;
			Object[] params = {categoryId};
			rs = DBUtil.executeQuery(sql,params) ;
			  while(rs.next()) {
				  Integer id=rs.getInt(1);
				  Integer parent_id=rs.getInt(2);
				  String name =   rs.getString(3) ;
				  Integer status=rs.getInt(4);
				  Date creat_time=rs.getDate(5);
				  Date update_time=rs.getDate(6);
				  category = new Category(id, parent_id, name, status, creat_time, update_time);
			  }
			  return category ;
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

	
	public boolean insertCategory(Category category)
	{
		String sql ="insert into category (parent_id,name,status,create_time,update_time) values(?,?,?,NOW(),NOW()) " ;
		Object[] params = {category.getParentId(),category.getName(),category.getStatus()};
		return DBUtil.executeUpdate(sql, params);
	}

	public boolean updateCategoryName(int categoryId, String categoryName) 
	{
		String sql = "update category set name=?, update_time=NOW() where id=?" ;
		Object[] params = {categoryName, categoryId};
		return DBUtil.executeUpdate(sql,params);
	}	

	public List<CategoryTree> makeCategoryTree(Integer categoryId)
	{
		List<Category> categorys = findChildCategory(categoryId);
		List<CategoryTree> categorytrees = new ArrayList<>();
		for(Category cg : categorys) {
			categorytrees.add(new CategoryTree(cg.getName(), cg.getId(), makeCategoryTree(cg.getId())));
		}
		return categorytrees;
	}
	
	public boolean deleteCategoryName(int categoryId) {
		String sql = "update category set status=?, update_time=NOW() where id=?" ;
		Object[] params = {0, categoryId};
		return DBUtil.executeUpdate(sql,params);
	}
}
