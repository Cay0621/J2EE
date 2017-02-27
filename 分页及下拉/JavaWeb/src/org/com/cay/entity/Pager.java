package org.com.cay.entity;

import java.io.Serializable;
import java.util.List;

public class Pager<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int pageSize;
	private int currentPage;
	private int totalRecord;
	private int totalPages;
	private List<T> dataList;

	public Pager() {
		super();
	}

	public Pager(int pageNum, int pageSize, List<T> source) {
		if (source == null)
			return;
		this.totalRecord = source.size();
		this.pageSize = pageSize;
		this.totalPages = this.totalRecord / this.pageSize;
		if (this.totalRecord % this.pageSize != 0)
			this.totalPages++;

		this.currentPage = this.totalPages < pageNum ? this.totalPages
				: pageNum;

		int fromIndex = this.pageSize * (this.currentPage - 1);
		int toIndex = this.pageSize * this.currentPage > this.totalRecord ? this.totalRecord
				: this.pageSize * this.currentPage;

		dataList = source.subList(fromIndex, toIndex);
	}

	public Pager(int pageSize, int currentPage, int totalRecord,
			int totalPages, List<T> dataList) {
		super();
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalRecord = totalRecord;
		this.totalPages = totalPages;
		this.dataList = dataList;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

}
