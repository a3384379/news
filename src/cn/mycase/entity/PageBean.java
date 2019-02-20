package cn.mycase.entity;

import java.util.ArrayList;
import java.util.List;


public class PageBean<T> {
	//��ǰҳ
	private Integer currentPage;
	//��ǰҳ��ʾ������
	private Integer currentCount;
	//������
	private Integer totalCount;
	//��ҳ��
	private Integer totalPage;
	//ÿҳ��ʾ������
	private List<T> data = new ArrayList<T>();
	//��ҳʱ���������
	private Integer leftLimt;
	//��ѯ����cid
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
