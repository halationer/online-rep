package com.shopping.common;

import java.math.BigDecimal;

public class CartProductVoList {
	private Integer id;
	private Integer user_id;
	private Integer product_id;
	private Integer quantity;
	private String productName;
	private String productSubtitle;
	private String productMainImage;
	private BigDecimal productPrice;
	private Integer productStatus;
	private BigDecimal productTotalPrice;
	private Integer productStock;
	private Integer productChecked;
	private String limitQuantity;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductSubtitle() {
		return productSubtitle;
	}
	public void setProductSubtitle(String productSubtitle) {
		this.productSubtitle = productSubtitle;
	}
	public String getProductMainImage() {
		return productMainImage;
	}
	public void setProductMainImage(String productMainImage) {
		this.productMainImage = productMainImage;
	}
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	public Integer getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}
	public BigDecimal getProductTotalPrice() {
		return productTotalPrice;
	}
	public void setProductTotalPrice(BigDecimal productTotalPrice) {
		this.productTotalPrice = productTotalPrice;
	}
	public Integer getProductStock() {
		return productStock;
	}
	public void setProductStock(Integer productStock) {
		this.productStock = productStock;
	}
	public Integer getProductChecked() {
		return productChecked;
	}
	public void setProductChecked(Integer productChecked) {
		this.productChecked = productChecked;
	}
	public String getLimitQuantity() {
		return limitQuantity;
	}
	public void setLimitQuantity(String limitQuantity) {
		this.limitQuantity = limitQuantity;
	}
	
	public CartProductVoList(Integer id,Integer user_id,Integer product_id,Integer quantity,String productName,
			String productSubtitle,String productMainImage,BigDecimal productPrice,Integer productStatus,BigDecimal productTotalPrice,
			Integer productStock,Integer productChecked,String limitQuantity) {
		this.id=id;
		this.user_id=user_id;
		this.product_id=product_id;
		this.quantity=quantity;
		this.productName=productName;
		this.productSubtitle=productSubtitle;
		this.productMainImage=productMainImage;
		this.productPrice=productPrice;
		this.productStatus=productStatus;
		this.productTotalPrice=productTotalPrice;
		this.productStock=productStock;
		this.productChecked=productChecked;
		this.limitQuantity=limitQuantity;
	}
	
	public CartProductVoList() {
		
	}
}
