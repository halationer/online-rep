package com.shopping.service.impl;

import com.shopping.common.Category;
import com.shopping.common.ServerResponse;
import com.shopping.dao.ICategoryDao;
import com.shopping.dao.impl.CategoryDaoImpl;
import com.shopping.service.ICategoryService;

public class CategoryServiceImpl  implements ICategoryService{
	ICategoryDao categoryDao=new CategoryDaoImpl();

	public  ServerResponse add_categoryLogic(Integer parentId,String categoryname)
	{
		if (categoryname==null||categoryname=="") {
			return ServerResponse.serverResponseByError("类别名称不能为空");
			
		}
		Category category=new Category();
		category.setName(categoryname);
		category.setParentId(parentId);
		category.setStatus(1);
		if (categoryDao.insertCategory(category)) {
			return ServerResponse.serverResponseBySuccess(null, "添加成功");
		}
		else {
			return ServerResponse.serverResponseByError("添加失败");
		}
	}
	public ServerResponse update_category_name(int categoryId, String categoryName) {
		if(categoryName==null||categoryName=="") {
			return ServerResponse.serverResponseByError("更新品类名字失败");
		}else {
			if(categoryDao.updateCategoryName(categoryId, categoryName))
				return ServerResponse.serverResponseBySuccess(null, "更新品类名字成功");
			return ServerResponse.serverResponseByError("找不到该品类");
		}
	}
	public ServerResponse delete_category(int categoryId) {
		if(categoryDao.deleteCategoryName(categoryId))
			return ServerResponse.serverResponseBySuccess(null, "删除品类成功");
		return ServerResponse.serverResponseByError("找不到该品类");
	}

	public ServerResponse get_category_tree(int parentId, boolean onlog, boolean access)
	{
		if(!onlog)
			return ServerResponse.serverResponseByError(10, "用户未登录,请登录");
		else if(!access)
			return ServerResponse.serverResponseByError("没有权限");
		else 
			return ServerResponse.serverResponseBySuccess(categoryDao.makeCategoryTree(parentId));
	}

}
