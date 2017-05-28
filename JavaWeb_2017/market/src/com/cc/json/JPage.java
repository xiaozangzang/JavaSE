package com.cc.json;

public class JPage {
	private int startNum = 0;
	private int pageCount = 10;
	private String orderColumn;
	private String orderType;
	private String filter;
	public JPage() {
		
	}

	public JPage(int startNum, int pageCount) {
		this.setPageCount(pageCount);
		this.setStartNum(startNum);
	}
	
	public int getStartNum() {
		return startNum;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(final int pageCount) {
		this.pageCount = pageCount;
		
		if (pageCount < 0) {
			this.pageCount = 0;
		}
	}
	/**
	 * 设置每页的记录数量, 低于1时自动调整为1.
	 */
	public void setStartNum(final int startNum) {
		this.startNum = startNum;

		if (startNum < 0) {
			this.startNum = 0;
		}
	}

	public String getOrderColumn() {
		return orderColumn;
	}

	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}
	
	
}
