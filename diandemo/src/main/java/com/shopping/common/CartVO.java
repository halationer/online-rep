package com.shopping.common;

import java.math.BigDecimal;
import java.util.List;

public class CartVO {
	//购物信息集合
	private List<CartProductVoList> cartProductVoList;
	//是否全选
	private boolean isallchecked;
	//总价格
	private BigDecimal carttotalprice;
	
	public List<CartProductVoList> getCartProductVoList(){
		return cartProductVoList;
	}
	public void setCartProductVoList(List<CartProductVoList> cartProductVoList) {
		this.cartProductVoList=cartProductVoList;
	}
	
	public boolean getisallchecked(){
		return isallchecked;
	}
	public void setisallchecked(boolean isallchecked) {
		this.isallchecked=isallchecked;
	}
	public BigDecimal getcarttotalprice(){
		return carttotalprice;
	}
	public void seticarttotalprice(BigDecimal carttotalprice) {
		this.carttotalprice=carttotalprice;
	}
}
