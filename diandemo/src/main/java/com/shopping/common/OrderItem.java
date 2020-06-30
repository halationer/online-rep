package com.shopping.common;

import java.math.BigDecimal;
import java.util.Date;

public class OrderItem {
	public OrderItem(Integer id, Integer userId, Long orderNo, Integer productId, String productName,
			String productImage, BigDecimal currentUnitprice, Integer quantity, BigDecimal totalPrice, Date creatTime,
			Date updateTime) {
		
		this.id = id;
		this.userId = userId;
		this.orderNo = orderNo;
		this.productId = productId;
		this.productName = productName;
		this.productImage = productImage;
		this.currentUnitprice = currentUnitprice;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.creatTime = creatTime;
		this.updateTime = updateTime;
	}
	private Integer id;
	private Integer userId;
	private Long orderNo;
	private Integer productId;
	private String productName;
	private String productImage;
	private BigDecimal currentUnitprice;
	private Integer quantity;
	private BigDecimal totalPrice;
	private Date creatTime;
	private Date updateTime;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getCurrentUnitprice() {
		return currentUnitprice;
	}
	public void setCurrentUnitprice(BigDecimal currentUnitprice) {
		this.currentUnitprice = currentUnitprice;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
