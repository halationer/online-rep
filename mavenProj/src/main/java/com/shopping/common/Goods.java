package com.shopping.common;

import java.math.BigDecimal;
import java.util.Date;

public class Goods {
	public Goods(Integer id, Integer category_id, String name, String subtile, String main_image, String sub_image,
			String detail, BigDecimal price, Integer stock, Integer status, Date creat_time, Date update_time) {

		this.id = id;
		this.category_id = category_id;
		this.name = name;
		this.subtile = subtile;
		this.main_image = main_image;
		this.sub_image = sub_image;
		this.detail = detail;
		this.price = price;
		this.stock = stock;
		this.status = status;
		this.creat_time = creat_time;
		this.update_time = update_time;
	}
	public Goods( Integer category_id, String name, String subtile, String sub_image,
			String detail, BigDecimal price, Integer stock, Integer status) {

	
		this.category_id = category_id;
		this.name = name;
		this.subtile = subtile;
		this.sub_image = sub_image;
		this.detail = detail;
		this.price = price;
		this.stock = stock;
		this.status = status;
	
	}
	public Goods( Integer id,Integer category_id, String name, String subtile, String sub_image,
			String detail, BigDecimal price, Integer stock, Integer status) {

	    this.id=id;
	 	this.category_id = category_id;
		this.name = name;
		this.subtile = subtile;
		this.sub_image = sub_image;
		this.detail = detail;
		this.price = price;
		this.stock = stock;
		this.status = status;
	
	}
	public Goods( Integer category_id, String name, String subtile, String main_image, String sub_image,
			String detail, BigDecimal price, Integer stock, Integer status) {

		
		this.category_id = category_id;
		this.name = name;
		this.subtile = subtile;
		this.main_image = main_image;
		this.sub_image = sub_image;
		this.detail = detail;
		this.price = price;
		this.stock = stock;
		this.status = status;
	}
	public Goods() {
		
	}
	private   Integer id;
	private   Integer category_id;
	private   String name;
	private  String subtile;
	private String  main_image;
	private  String sub_image;
	private String detail;
	private BigDecimal price;
	private Integer stock;
	private Integer status;
	private Date creat_time;
	private Date update_time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubtile() {
		return subtile;
	}
	public void setSubtile(String subtile) {
		this.subtile = subtile;
	}
	public String getMain_image() {
		return main_image;
	}
	public void setMain_image(String main_image) {
		this.main_image = main_image;
	}
	public String getSub_image() {
		return sub_image;
	}
	public void setSub_image(String sub_image) {
		this.sub_image = sub_image;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreat_time() {
		return creat_time;
	}
	public void setCreat_time(Date creat_time) {
		this.creat_time = creat_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	
	


}
