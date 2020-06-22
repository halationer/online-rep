package com.shopping.common;

import java.sql.Date;


public class Category {
	public Category() {}
	public Category(Integer id, Integer parent_id, String name, Integer status, Date creat_time, Date update_time) {
		
		this.id = id;
		this.parentId = parent_id;
		this.name = name;
		this.status = status;
		this.createTime = creat_time;
		this.updateTime = update_time;
	}
	private Integer id;
	private Integer parentId;  
	private String name;
	private Integer status;
	private Date createTime;
	private Date updateTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
