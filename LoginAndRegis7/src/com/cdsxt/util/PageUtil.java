package com.cdsxt.util;

public class PageUtil {
	//当前页
	private int curPage;
	//总条数
	private int count;
	//总导航数
	private int navCount;
	//起始行
	private int startRow;
	//每页显示多少条   
	private int pageRow=10;
	//上一页
	private int prevPage;
	//下一页
	private int nextPage;
	//首页
	private int firstPage=1;
	//尾页
	private int lastPage;
	//起始导航
	private int startNav;
	//结束导航
	private int endNav;
	
	/**
	 * 
	 * @param curPage 当前页  由页面传入
	 * @param count  数据总条数   从数据库查
	 */
	public PageUtil(int curPage,int count){
		this.curPage=curPage;
		this.count=count;
		this.navCount=count%this.pageRow==0?count/this.pageRow:count/this.pageRow+1;
		this.startRow=(this.curPage-1)*10;
		this.lastPage=navCount;
		this.prevPage=this.curPage-1>0?this.curPage-1:this.firstPage;
		this.nextPage=this.curPage+1>this.lastPage?this.lastPage:this.curPage+1;
		if(navCount<10){
			this.startNav=this.firstPage;
			this.endNav=this.lastPage;
		}else{
			if(this.curPage+4>=this.lastPage){
				//靠近尾页的情况
				this.startNav=this.lastPage-9;
				this.endNav=this.lastPage;
			}else if(this.curPage-5<=this.firstPage){
				//靠近首页的情况
				this.startNav=this.firstPage;
				this.endNav=10;
			}else{
				//一般情况
				this.startNav=this.curPage-5;
				this.endNav=this.curPage+4;
			}
		}
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getNavCount() {
		return navCount;
	}
	public void setNavCount(int navCount) {
		this.navCount = navCount;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getPageRow() {
		return pageRow;
	}
	public void setPageRow(int pageRow) {
		this.pageRow = pageRow;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getStartNav() {
		return startNav;
	}
	public void setStartNav(int startNav) {
		this.startNav = startNav;
	}
	public int getEndNav() {
		return endNav;
	}
	public void setEndNav(int endNav) {
		this.endNav = endNav;
	}
	
}
