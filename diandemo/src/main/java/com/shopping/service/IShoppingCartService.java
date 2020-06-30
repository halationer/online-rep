package com.shopping.service;

import java.math.BigDecimal;

import com.shopping.common.CartProductVoList;
import com.shopping.common.ServerResponse;
import com.shopping.common.ShoppingCart;

public interface IShoppingCartService {
	public ServerResponse ShoppingCartList(Integer id);//显示购物车list列表
	public ServerResponse ShoppingCartAdd(Integer userId,Integer productId,Integer count);//添加购物车新品
	public ServerResponse ShoppingCartUpdate(Integer userId,Integer productId,Integer count);//更新购物车内某个商品的数量
	public ServerResponse ShoppingCartRemove(Integer userId,Integer productId);//移除某一个产品
	public ServerResponse ShoppingCartSelectOne(Integer userId,Integer productId);//选中某一个商品
	public ServerResponse ShoppingCartQueryNumber(Integer userId);//查询产品数量
	public ServerResponse ShoppingCartSelectAll(Integer userid);//购物车全选
	public ServerResponse ShoppingCartCancelSelectAll(Integer userid);//取消全选
	
	public ServerResponse ShoppingCartRemoveById(Integer id);
}
