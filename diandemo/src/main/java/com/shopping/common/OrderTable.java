package com.shopping.common;

import java.math.BigDecimal;
import java.util.Date;

public class OrderTable {
	private Integer id;
	private Integer order_no;
	private Integer user_id;
	private Integer shopping_id;
	private BigDecimal payment;
	private Integer payment_type;
	private BigDecimal postage;
	
	private Integer status;
	private Date payment_time;
	private Date send_time;
	private Date end_time;
	private Date close_time;
	private Date update_time;
	private Date create_time;
	public Integer getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(Integer payment_type) {
		this.payment_type = payment_type;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public OrderTable(Integer id, Integer order_no, Integer user_id, Integer shopping_id, BigDecimal payment,
			Integer payment_type, BigDecimal postage,Integer status, Date payment_time, Date send_time, Date end_time, Date close_time,
			Date update_time) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.user_id = user_id;
		this.shopping_id = shopping_id;
		this.payment = payment;
		this.postage = postage;
		this.payment_type=payment_type;
		this.status = status;
		this.payment_time = payment_time;
		this.send_time = send_time;
		this.end_time = end_time;
		this.close_time = close_time;
		this.update_time = update_time;
	}
	public OrderTable(Integer id, Integer order_no, Integer user_id, Integer shopping_id, BigDecimal payment,
			Integer payment_type, BigDecimal postage, Integer status, Date payment_time, Date send_time, Date end_time,
			Date close_time, Date update_time, Date create_time) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.user_id = user_id;
		this.shopping_id = shopping_id;
		this.payment = payment;
		this.payment_type = payment_type;
		this.postage = postage;
		this.status = status;
		this.payment_time = payment_time;
		this.send_time = send_time;
		this.end_time = end_time;
		this.close_time = close_time;
		this.update_time = update_time;
		this.create_time = create_time;
	}
	public OrderTable() {
		
	}
	public Integer getPaymentType() {
		return payment_type;
	}

	public void setPaymentType(Integer payment_type) {
		this.payment_type = payment_type;
	}

	public OrderTable(Integer id, Integer order_no2, Integer user_id, Integer shopping_id, BigDecimal payment,
			Integer payment_type,BigDecimal postage, Integer status) {
		super();
		this.id = id;
		this.order_no = order_no2;
		this.user_id = user_id;
		this.shopping_id = shopping_id;
		this.payment = payment;
		this.postage = postage;
		this.payment_type=payment_type;
		this.status = status;
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Integer order_no) {
		this.order_no = order_no;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getShopping_id() {
		return shopping_id;
	}
	public void setShopping_id(Integer shopping_id) {
		this.shopping_id = shopping_id;
	}
	public BigDecimal getPayment() {
		return payment;
	}
	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}
	public BigDecimal getPostage() {
		return postage;
	}
	public void setPostage(BigDecimal postage) {
		this.postage = postage;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getPayment_time() {
		return payment_time;
	}
	public void setPayment_time(Date payment_time) {
		this.payment_time = payment_time;
	}
	public Date getSend_time() {
		return send_time;
	}
	public void setSend_time(Date send_time) {
		this.send_time = send_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	public Date getClose_time() {
		return close_time;
	}
	public void setClose_time(Date close_time) {
		this.close_time = close_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	@Override
	public String toString() {
		return "OrderTable [id=" + id + ", order_no=" + order_no + ", user_id=" + user_id + ", shopping_id="
				+ shopping_id + ", payment=" + payment + ", payment_type=" + payment_type + ", postage=" + postage
				+ ", status=" + status + ", payment_time=" + payment_time + ", send_time=" + send_time + ", end_time="
				+ end_time + ", close_time=" + close_time + ", update_time=" + update_time + "]";
	}
	
}
