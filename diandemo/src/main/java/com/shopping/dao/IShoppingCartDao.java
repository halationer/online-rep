package com.shopping.dao;

import java.util.List;

import com.shopping.common.CartProductVoList;
import com.shopping.common.ShoppingCart;

public interface IShoppingCartDao {
	public List<ShoppingCart> ShoppingCartList(Integer userId);//列表
	
	public boolean ShoppingCartAdd(ShoppingCart cart1);//添加新品
	
	public Integer getShoppingCartQuantity(Integer userid);//更新某个产品数量
	
	public boolean deleteByPrimaryKey(ShoppingCart cart1);//移除某一个产品
	
	public List<ShoppingCart> selectCartByUserid(Integer userid);//
	
	public ShoppingCart selectPrimaryKey(Integer id);//按照userid查询
	
	public ShoppingCart selectCartByUserIdAndPrductId(Integer userid,Integer productId);//选择某一个产品
	
	//取消全选
	
    public boolean isCheckedAll(Integer userid);//全选
	
	public void isCancelCheckedAll(Integer userid);//取消全选
	
	public List<ShoppingCart>selectAll();//检查是否全选
	
	public boolean updateByPrimaryKey(ShoppingCart cart1);//按照userid更新
	
	public boolean insert(ShoppingCart cart1);//插入

	public Integer deleteByPrimaryKey(Integer userid);

	public ShoppingCart ShoppingCartVO(Integer userId);
	
	public boolean deleteById(ShoppingCart cart1);
	
	public List<ShoppingCart> findCartListByUserIdAndChecked(Integer userId);
}