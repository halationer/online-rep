package com.shopping.common;

import java.util.List;

public class CategoryTree {

	public CategoryTree() { 
		this.value = (int)Math.random()*4 + 1;
	}
	public CategoryTree(String title, int id, List<CategoryTree> children) { 
		this.value = (int)(Math.random()*4) + 1;
		this.title = title;
		this.id = id;
		this.children = children;
		this.name = title;
	}

	private String title;
	private String name;
	private int id;
	private int value;
	private List<CategoryTree> children;
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<CategoryTree> getChildren() {
		return children;
	}
	public void setChildren(List<CategoryTree> children) {
		this.children = children;
	}
}
