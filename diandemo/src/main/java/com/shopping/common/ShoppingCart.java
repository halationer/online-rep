package com.shopping.common;

import java.util.Date;

public class ShoppingCart {
	private Integer id;
	private Integer user_id;
	private Integer product_id;
	private Integer quantity;
	private Integer checked;
	private Date create_time;
	private Date update_time;
	
	public ShoppingCart(Integer id, Integer user_id, Integer product_id, Integer quantity,Integer checked,Date create_time, Date update_time) {
		this.id = id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.checked=checked;
		this.create_time = create_time;
		this.update_time = update_time;
	}
	
//	public ShoppingCart(String username, String password, String email, String question, String answer, String phone) {
//		// TODO Auto-generated constructor stub
//	}
	public ShoppingCart(Integer id, Integer user_id, Integer product_id, Integer quantity,Integer checked) {
		this.id = id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.checked=checked;
	}
	
	public ShoppingCart() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getProductId() {
		return product_id;
	}
	public void setProductId(Integer product_id) {
		this.product_id = product_id;
	}
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
	public Integer getQuantity() {
		return user_id;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Integer getChecked() {
		return checked;
	}
	public void setChecked(Integer checked) {
		this.checked = checked;
	}
	
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date creat_time) {
		this.create_time = creat_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", user_id=" + user_id + ", product_id=" + product_id + ", quantity="
				+ quantity + ", checked=" + checked + ", create_time=" + create_time + ", update_time=" + update_time
				+ "]";
	}
	
	
}
