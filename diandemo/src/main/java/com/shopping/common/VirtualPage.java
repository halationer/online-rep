package com.shopping.common;

import java.util.ArrayList;
import java.util.List;

public class VirtualPage <T>{

	private int pageNum;		//当前是第x页
	private int pageSize;		//当前页最多容纳x条数据
	private int size;			//当前页有x条数据
	private String orderBy;		//排序方式
	private int startRow;		//当前页面从查询结果的第x行开始
	private int endRow;			//当前页面的结尾是查询结果的第x行
	private int total;			//查询结果总条数
	private int pages;			//总页数 = total / pageSize + 1
	private ArrayList<T> list;
	private int firstPage;				//首页的编号
	private int prePage;				//前一页的编号
	private int nextPage;				//后一页的编号
	private int lastPage;				//尾页的编号
	private boolean isFirstPage;		//是否是第一页
	private boolean isLastPage;			//是否是最后一页
	private boolean hasPreviousPage;	//是否有前一页
	private boolean hasNextPage;		//是否有后一页
	private int navigatePages;			//导航栏中最多存在的页数
	private ArrayList<Integer> navigatepageNums;	//导航栏中的页列表
	
	public VirtualPage (ServerResponse<List<T>> res, int pagesize, int pagenum) {
		//计算分页数据
		int total = res.getData().size();
		int pages = (int)Math.ceil((double)total/pagesize);
		if(pagenum > pages) pagenum = pages;
		if(pagenum < 1) pagenum = 1;
		int size = pagenum==pages? total-(pagenum-1)*pagesize : pagesize;
		System.out.println("servlet get total: " + total);
		this.setPageNum(pagenum);
		this.setPageSize(pagesize);
		this.setSize(size);
		this.setOrderBy(null);
		this.setStartRow((pagenum-1)*pagesize+1);
		this.setEndRow(Math.min(pagenum*pagesize, total));
		this.setTotal(total);
		this.setPages(pages);
		List<T> table = res.getData();
		list = new ArrayList<>();
		for(int i=this.getStartRow()-1; i<this.getEndRow(); i++)
			list.add(table.get(i));
		this.setFirstPage(1);
		this.setPrePage(pagenum-1);
		this.setNextPage(pagenum+1);
		this.setLastPage(pages);
		this.setFirstPage(pagenum==1);
		this.setLastPage(pagenum==pages);
		this.setHasPreviousPage(pagenum>1);
		this.setHasNextPage(pagenum<pages);
		this.setNavigatePages(8);
		ArrayList<Integer> pagenums = new ArrayList<>();
		int startnav = 1, endnav = pages;
		if(pages > this.getNavigatePages())
		{
			endnav = this.getNavigatePages();
			if(pagenum > (startnav + endnav) / 2)
			{
				startnav = pagenum - this.getNavigatePages() / 2;
				endnav = startnav + this.getNavigatePages() - 1;
			}
		}
		for(int i = startnav; i <= endnav; i++)
			pagenums.add(i);
		this.setNavigatepageNums(pagenums);
	}
	
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

	public ArrayList<T> getList() {
		return list;
	}

	public void setList(ArrayList<T> items) {
		this.list = items;
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

		
	public VirtualPage() {}

}
