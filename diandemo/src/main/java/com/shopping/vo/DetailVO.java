package com.shopping.vo;

import java.math.BigDecimal;

public class DetailVO {

	private int productId;
	private String productName;
	private String productImage;
	private BigDecimal currentUnitPrice;
	private int quantity;
	private BigDecimal totalPrice;
	
	public DetailVO() {	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public BigDecimal getCurrentUnitPrice() {
		return currentUnitPrice;
	}

	public void setCurrentUnitPrice(BigDecimal currentUnitPrice) {
		this.currentUnitPrice = currentUnitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "DetailVO [productId=" + productId + ", productName=" + productName + ", productImage=" + productImage
				+ ", currentUnitPrice=" + currentUnitPrice + ", quantity=" + quantity + ", totalPrice=" + totalPrice
				+ "]";
	}
}
