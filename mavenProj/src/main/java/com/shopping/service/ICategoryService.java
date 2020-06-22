package com.shopping.service;

import com.shopping.common.ServerResponse;

public interface ICategoryService {
	
	public  ServerResponse add_categoryLogic(Integer parentId,String categoryname);
	public ServerResponse update_category_name(int categoryId, String categoryName);
	public ServerResponse delete_category(int categoryId);
	
	public ServerResponse get_category_tree(int parentId, boolean onlog, boolean access);
}
