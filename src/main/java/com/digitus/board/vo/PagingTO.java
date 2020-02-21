package com.digitus.board.vo;


import lombok.ToString;

/**
 * 페이징 객체
 * Created by kulc78 on 2016. 10. 20.
 */

@ToString
public class PagingTO {

    private int pages = 1;
    private int rowCountPerPage;
    private int listCountLimit = 10;
    private int totalRowCount;
    private int startRow;
    private int endRow;
    private int totalPageCount;
    private String parameterFlag;
    private int listView= 1;

    public void init() {

        int startRow = (getPages() - 1) * getRowCountPerPage();
        int endRow = getRowCountPerPage();

        setStartRow(startRow);
        setEndRow(endRow);
    }

    public PagingTO() {

    }

    public PagingTO(int startRow, int endRow) {

        setStartRow(startRow);
        setEndRow(endRow);
    }

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getRowCountPerPage() {
		return rowCountPerPage;
	}

	public void setRowCountPerPage(int rowCountPerPage) {
		this.rowCountPerPage = rowCountPerPage;
	}

	public int getListCountLimit() {
		return listCountLimit;
	}

	public void setListCountLimit(int listCountLimit) {
		this.listCountLimit = listCountLimit;
	}

	public int getTotalRowCount() {
		return totalRowCount;
	}

	public void setTotalRowCount(int totalRowCount) {
		this.totalRowCount = totalRowCount;
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

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public String getParameterFlag() {
		return parameterFlag;
	}

	public void setParameterFlag(String parameterFlag) {
		this.parameterFlag = parameterFlag;
	}

	public int getListView() {
		return listView;
	}

	public void setListView(int listView) {
		this.listView = listView;
	}
    
    
}