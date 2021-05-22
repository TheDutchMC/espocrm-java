package dev.array21.espocrm.types;

import java.util.List;

public class Params {
	private Long offset, maxSize;
	private String select, primaryFilter, orderBy;
	private String[] boolFilterList;
	private Where[] where;
	private Order order;
	
	public Params setOffset(long offset) {
		this.offset = offset;
		return this;
	}
	
	public Long getOffset() {
		return this.offset;
	}
	
	public Params setMaxSize(long maxSize) {
		this.maxSize = maxSize;
		return this;
	}
	
	public Long getMaxSize() {
		return this.maxSize;
	}
	
	public Params setSelect(String select) {
		this.select = select;
		return this;
	}
	
	public String getSelect() {
		return this.select;
	}
	
	public Params setPrimaryFilter(String primaryFilter) {
		this.primaryFilter = primaryFilter;
		return this;
	}
	
	public String getPrimaryFilter() {
		return this.primaryFilter;
	}
	
	public Params setOrderBy(String orderBy) {
		this.orderBy = orderBy;
		return this;
	}
	
	public String getOrderBy() {
		return this.orderBy;
	}
	
	public Params setBoolFilterList(String[] boolFilterList) {
		this.boolFilterList = boolFilterList;
		return this;
	}
	
	public Params setBoolFilterList(List<String> boolFilterList) {
		this.boolFilterList = boolFilterList.toArray(new String[0]);
		return this;
	}
	
	public String[] getBoolFilterList() {
		return this.boolFilterList;
	}
	
	public Params setWhere(Where[] where) {
		this.where = where;
		return this;
	}
	
	public Params setWhere(List<Where> where) {
		this.where = where.toArray(new Where[0]);
		return this;
	}
	
	public Where[] getWhere() {
		return this.where;
	}
	
	public Params setOrder(Order order) {
		this.order = order;
		return this;
	}
	
	public Order getOrder() {
		return this.order;
	}
}