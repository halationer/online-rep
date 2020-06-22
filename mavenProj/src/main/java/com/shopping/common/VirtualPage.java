package com.shopping.common;

import java.util.ArrayList;

public class VirtualPage {

	private int pageNum;		//当前是第x页
	private int pageSize;		//当前页最多容纳x条数据
	private int size;			//当前页有x条数据
	private String orderBy;		//排序方式
	private int startRow;		//当前页面从查询结果的第x行开始
	private int endRow;			//当前页面的结尾是查询结果的第x行
	private int total;			//查询结果总条数
	private int pages;			//总页数 = total / pageSize + 1
	private ArrayList<UserTable> list;
	private int firstPage;				//首页的编号
	private int prePage;				//前一页的编号
	private int nextPage;				//后一页的编号
	private int lastPage;				//尾页的编号
	private boolean isFirstPage;		//是否是第一页
	private boolean isLastPage;			//是否是最后一页
	private boolean hasPreviousPage;	//是否有前一页
	private boolean hasNextPage;		//是否有后一页
	private int navigatePages;			//导航栏中最多存在的页数
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public ArrayList<UserTable> getList() {
		return list;
	}

	public void setList(ArrayList<UserTable> list) {
		this.list = list;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public boolean isFirstPage() {
		return isFirstPage;
	}

	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	public boolean isLastPage() {
		return isLastPage;
	}

	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public int getNavigatePages() {
		return navigatePages;
	}

	public void setNavigatePages(int navigatePages) {
		this.navigatePages = navigatePages;
	}

	public ArrayList<Integer> getNavigatepageNums() {
		return navigatepageNums;
	}

	public void setNavigatepageNums(ArrayList<Integer> navigatepageNums) {
		this.navigatepageNums = navigatepageNums;
	}

	private ArrayList<Integer> navigatepageNums;
		
	public VirtualPage() {}

}
