package com.shopping.common;

import java.util.Date;

public class PayInfo {
	public PayInfo(Integer id, Integer userId, Long orderNo, Integer payPlatForm, String platformNumber,
			String platformStatus, Date creatTime, Date updateTime) {
		
		this.id = id;
		this.userId = userId;
		this.orderNo = orderNo;
		this.payPlatForm = payPlatForm;
		this.platformNumber = platformNumber;
		this.platformStatus = platformStatus;
		this.creatTime = creatTime;
		this.updateTime = updateTime;
	}
	public PayInfo() {
		
	}
	private Integer id;
	private Integer userId;
	private Long orderNo;
	private Integer payPlatForm;
	private String platformNumber;
	private String platformStatus;
    private Date creatTime;
    private Date updateTime;
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getPayPlatForm() {
		return payPlatForm;
	}
	public void setPayPlatForm(Integer payPlatForm) {
		this.payPlatForm = payPlatForm;
	}
	public String getPlatformStatus() {
		return platformStatus;
	}
	public void setPlatformStatus(String platformStatus) {
		this.platformStatus = platformStatus;
	}
	public String getPlatformNumber() {
		return platformNumber;
	}
	public void setPlatformNumber(String platformNumber) {
		this.platformNumber = platformNumber;
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
