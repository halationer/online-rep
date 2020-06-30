package com.shopping.common;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
	public Order(Integer id, Integer userId, Long orderNo, Integer shippingId, BigDecimal payment, int paymentType,
			Integer postage, Integer status, Date paymentTime, Date sendTime, Date endTime, Date closeTime,
			Date creatTime, Date updateTime) {
	
		this.id = id;
		this.userId = userId;
		this.orderNo = orderNo;
		this.shippingId = shippingId;
		this.payment = payment;
		this.paymentType = paymentType;
		this.postage = postage;
		this.status = status;
		this.paymentTime = paymentTime;
		this.sendTime = sendTime;
		this.endTime = endTime;
		this.closeTime = closeTime;
		this.creatTime = creatTime;
		this.updateTime = updateTime;
	}

	public Order(Long orderNo, BigDecimal payment, Integer status, Date paymentTime, Integer userId) {
	
		this.orderNo = orderNo;
		this.payment = payment;
		this.status = status;
		this.paymentTime = paymentTime;
		this.userId = userId;
	}

	public Order(Long orderNo, BigDecimal payment) {
	
		this.orderNo = orderNo;
		this.payment = payment;
	}
	private Integer id;
	private Integer userId;
	private Long orderNo;
	private Integer shippingId;
	private BigDecimal payment;
	private int paymentType;
	private Integer postage;
	private Integer status;
	private Date paymentTime;
	private Date sendTime;
	private Date endTime;
	private Date closeTime;
	private Date creatTime;
	private Date updateTime;
		

	public Long getOrderNo() {
		return orderNo;
		
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	public BigDecimal getPayment() {
		return payment;
	}

	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getShippingId() {
		return shippingId;
	}

	public void setShippingId(Integer shippingId) {
		this.shippingId = shippingId;
	}

	public int getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(int paymentType) {
		this.paymentType = paymentType;
	}

	public Integer getPostage() {
		return postage;
	}

	public void setPostage(Integer postage) {
		this.postage = postage;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
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
