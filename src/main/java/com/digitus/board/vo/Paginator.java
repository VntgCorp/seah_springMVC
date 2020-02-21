package com.digitus.board.vo;

/**
 * 페이징 HTML Generate
 * Created by Davis
 */
public class Paginator {

	private int totalCount;
    private int currentPage;
    private int listLimit;
    private int pageLimit;
    private int totalPage;
    private int startPage;
    private int endPage;
    private int startNum;
    private int endNum;
    private String btnStart;
    private String btnEnd;
    private String btnListPrev;
    private String btnListNext;
    private String btnPageList;
    private String btnPagePrev;
    private String btnPageNext;
    private String pageInfo;
    private String pageHtml;
    private String parameterFlag;
    private PagingTO pagingTO;

    public Paginator(PagingTO pagingTO) {

        this.pagingTO = pagingTO;
        this.totalCount = pagingTO.getTotalRowCount();
        this.currentPage = pagingTO.getPages();
        this.listLimit = pagingTO.getListCountLimit();
        this.pageLimit = pagingTO.getRowCountPerPage();

        if (null != pagingTO.getParameterFlag()) {
            this.parameterFlag = pagingTO.getParameterFlag();
        }
    }

    public void makeFrontPagingHtml(String functionName) {

        int nowBlock = (int)((currentPage - 1) / listLimit);

        totalPage = (totalCount - 1) / pageLimit + 1;
        startPage = nowBlock * listLimit + 1;
        endPage = listLimit * (nowBlock + 1);

        if (totalPage < endPage) {
            endPage = totalPage;
        }

        if (totalCount == 0) {
            totalPage = 0;
        }

        startNum = (currentPage - 1) * listLimit;
        endNum = listLimit;
        
        // 제일 처음 페이지로 (맨앞)
        if (currentPage > 1) {
        	btnStart = "<li class=\"page-item\"><a class=\"page-link\" href=\"javascript:"+functionName+"('1');\">&#60;&#60;</a></li>";
        } else {
        	btnStart = "<li class=\"page-item disabled\"><a class=\"page-link\" href=\"#\" tabindex=\"-1\" aria-disabled=\"true\">&#60;&#60;</a></li>";
        }

        // 바로 이전 페이지 목록으로 (이전)
        if (currentPage > listLimit) {
            int prevListPage = currentPage - listLimit;
            btnListPrev = "<li class=\"page-item\"><a class=\"page-link\" href=\"javascript:\"+functionName+\"('\" + prevListPage + \"');\">&#60;</a></li>";
        } else {
        	btnListPrev = "<li class=\"page-item disabled\"><a class=\"page-link\" href=\"#\" tabindex=\"-1\" aria-disabled=\"true\">&#60;</a></li>";
        }
        // 페이지 목록
        StringBuffer btnPageListBuffer = new StringBuffer();

        for (int i = startPage; i <= endPage; i++) {
            if (currentPage == i) {
            	btnPageListBuffer.append("<li class=\"page-item active\"><a href=\"javascript:void(0)\" class=\"page-link\">");
                btnPageListBuffer.append(i);
                btnPageListBuffer.append("</a></li>");
            } else {
            	btnPageListBuffer.append("<li class=\"page-item\"><a class=\"page-link\" href=\"javascript:"+functionName+"('");
                btnPageListBuffer.append(i);
                btnPageListBuffer.append("');\">");
                btnPageListBuffer.append(i);
                btnPageListBuffer.append("</a></li>");
            }
        }

        btnPageList = btnPageListBuffer.toString();

        // 바로 다음 페이지 목록으로 (다음)
        if (endPage < totalPage) {
            int nextListPage = (currentPage + listLimit > totalPage) ? startPage + listLimit : currentPage + listLimit;
            btnListNext = "<li class=\"page-item\"><a class=\"page-link\" href=\"javascript:"+functionName+"('" + nextListPage + "');\">&#62;</a></li>";
        } else {
        	btnListNext = "<li class=\"page-item\"><a class=\"page-link\" href=\"javascript:void(0);\">&#62;</a></li>";
        }

        // 제일 마지막 페이지로 (맨뒤)
        if (currentPage < totalPage) {
        	btnEnd = "<li class=\"page-item\"><a class=\"page-link\" href=\"javascript:"+functionName+"('" + totalPage + "');\">&#62;&#62;</a></li>";
        } else {
        	btnEnd = "<li class=\"page-item\"><a class=\"page-link\" href=\"javascript:void(0);\">&#62;&#62;</a></li>";
        }

        StringBuffer pageHtml = new StringBuffer();
        pageHtml.append(btnStart);
        pageHtml.append(btnListPrev);
        pageHtml.append(btnPageList);
        pageHtml.append(btnListNext);
        pageHtml.append(btnEnd);

        setPageHtml(pageHtml.toString());
    }

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getListLimit() {
		return listLimit;
	}

	public void setListLimit(int listLimit) {
		this.listLimit = listLimit;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public String getBtnStart() {
		return btnStart;
	}

	public void setBtnStart(String btnStart) {
		this.btnStart = btnStart;
	}

	public String getBtnEnd() {
		return btnEnd;
	}

	public void setBtnEnd(String btnEnd) {
		this.btnEnd = btnEnd;
	}

	public String getBtnListPrev() {
		return btnListPrev;
	}

	public void setBtnListPrev(String btnListPrev) {
		this.btnListPrev = btnListPrev;
	}

	public String getBtnListNext() {
		return btnListNext;
	}

	public void setBtnListNext(String btnListNext) {
		this.btnListNext = btnListNext;
	}

	public String getBtnPageList() {
		return btnPageList;
	}

	public void setBtnPageList(String btnPageList) {
		this.btnPageList = btnPageList;
	}

	public String getBtnPagePrev() {
		return btnPagePrev;
	}

	public void setBtnPagePrev(String btnPagePrev) {
		this.btnPagePrev = btnPagePrev;
	}

	public String getBtnPageNext() {
		return btnPageNext;
	}

	public void setBtnPageNext(String btnPageNext) {
		this.btnPageNext = btnPageNext;
	}

	public String getPageInfo() {
		return pageInfo;
	}

	public void setPageInfo(String pageInfo) {
		this.pageInfo = pageInfo;
	}

	public String getPageHtml() {
		return pageHtml;
	}

	public void setPageHtml(String pageHtml) {
		this.pageHtml = pageHtml;
	}

	public String getParameterFlag() {
		return parameterFlag;
	}

	public void setParameterFlag(String parameterFlag) {
		this.parameterFlag = parameterFlag;
	}

	public PagingTO getPagingTO() {
		return pagingTO;
	}

	public void setPagingTO(PagingTO pagingTO) {
		this.pagingTO = pagingTO;
	}
    
    
}