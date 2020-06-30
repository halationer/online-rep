package com.shopping.dao;

import java.util.List;

import com.shopping.common.Category;
import com.shopping.common.CategoryTree;

public interface ICategoryDao {
	//根据父类查找所有子类
	public   List<Category>findChildCategory(Integer categoryId);
	
	public Category selectByPrimaryKey(Integer categoryId);
	
	//添加类别
	public   boolean insertCategory(Category category);
	//修改品类名字
	public boolean updateCategoryName(int categoryId, String categoryName);
	//删除类别
	public boolean deleteCategoryName(int categoryId);
	
	//返回品类树
	public List<CategoryTree> makeCategoryTree(Integer categoryId);
}
