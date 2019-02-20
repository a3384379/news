package cn.mycase.entity;

import java.util.ArrayList;
import java.util.List;


public class PageBean<T> {
	//当前页
	private Integer currentPage;
	//当前页显示的条数
	private Integer currentCount;
	//总条数
	private Integer totalCount;
	//总页数
	private Integer totalPage;
	//每页显示的数据
	private List<T> data = new ArrayList<T>();
	//分页时的左边数据
	private Integer leftLimt;
	//查询类型cid
	private Integer cid;
	
	
	
	
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getLeftLimt() {
		return leftLimt;
	}
	public void setLeftLimt(Integer leftLimt) {
		this.leftLimt = leftLimt;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(Integer currentCount) {
		this.currentCount = currentCount;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
}
