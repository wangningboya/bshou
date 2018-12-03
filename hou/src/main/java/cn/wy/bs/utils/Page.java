package cn.wy.bs.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Page<T> {

	/**
	 * 当前页码
	 */
	private int pageNum;

	/**
	 * 每页行数
	 */
	private int pageSize;

	/**
	 * 偏移量
	 */
	private int offset;

	/**
	 * 总记录数
	 */
	private int total;

	/**
	 * 总页数
	 */
	private int pages;

	/**
	 * 查询条件
	 */
	private Map<String, Object> params;

	/**
	 * 数据
	 */
	private List<T> list = new ArrayList<T>();

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

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPages() {
		double a = ((double) total / pageSize);
		return (int) Math.ceil(a);
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
