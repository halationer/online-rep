package com.shopping.common;

import java.math.BigDecimal;
import java.util.List;

public class CartOrderDetailVO {
	 private List<OrderDetailVO> orderDetailVOList;
	    private String imageHost;
	    private BigDecimal totalPrice;

	    public List<OrderDetailVO> getOrderItemVOList() {
	        return orderDetailVOList;
	    }

	    public void setOrderItemVOList(List<OrderDetailVO> orderDetailVOList) {
	        this.orderDetailVOList = orderDetailVOList;
	    }

	    public String getImageHost() {
	        return imageHost;
	    }

	    public void setImageHost(String imageHost) {
	        this.imageHost = imageHost;
	    }

	    public BigDecimal getTotalPrice() {
	        return totalPrice;
	    }

	    public void setTotalPrice(BigDecimal totalPrice) {
	        this.totalPrice = totalPrice;
	    }
}
