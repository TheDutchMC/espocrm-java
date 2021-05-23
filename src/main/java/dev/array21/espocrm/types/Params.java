package dev.array21.espocrm.types;

import java.util.List;

/**
 * Query parameters for a GET request to EspoCRM<br>
 * Refer to the <a href="https://docs.espocrm.com/development/api-search-params/"> EspoCRM documentation </a>for more information
 * @author Tobias de Bruijn
 * @since 1.0.0
 */
public class Params {
	private Long offset, maxSize;
	private String select, primaryFilter, orderBy;
	private String[] boolFilterList;
	private Where[] where;
	private Order order;
	
	/**
	 * An offset for pagination.
	 * @param offset The offset
	 * @return Returns an instance of Params for easy chaining
	 */
	public Params setOffset(long offset) {
		this.offset = offset;
		return this;
	}
	
	/**
	 * An offset for pagination.
	 * @return Returns the offset
	 */
	public Long getOffset() {
		return this.offset;
	}
	
	/**
	 * How much records to return.
	 * @param maxSize The maxSize
	 * @return Returns an instance of Params for easy chaining
	 */
	public Params setMaxSize(long maxSize) {
		this.maxSize = maxSize;
		return this;
	}
	
	/**
	 * How much records to return.
	 * @return The maxSize
	 */
	public Long getMaxSize() {
		return this.maxSize;
	}
	
	/**
	 * What record <a href="https://docs.espocrm.com/administration/terms-and-naming/#attribute">attributes</a> to return. Separated by comma. Whitespaces are not allowed. Specify only attributes that you need, it can improve performance.<br>
	 * <br>
	 * Example: <pre>id,name,status,assignedUserId</pre>
	 * @param select The select parameters
	 * @return Returns an instance of Params for easy chaining
	 */
	public Params setSelect(String select) {
		this.select = select;
		return this;
	}
	
	/**
	 * What record <a href="https://docs.espocrm.com/administration/terms-and-naming/#attribute">attributes</a> to return. Separated by comma. Whitespaces are not allowed. Specify only attributes that you need, it can improve performance.<br>
	 * <br>
	 * Example: <pre>id,name,status,assignedUserId</pre>
	 * @return Returns the select String
	 */
	public String getSelect() {
		return this.select;
	}
	
	/**
	 * A primary filter. Primary filters are usualy defined in Select Manager class.
	 * @param primaryFilter The primaryFilter
	 * @return Returns an instance of Params for easy chaining
	 */
	public Params setPrimaryFilter(String primaryFilter) {
		this.primaryFilter = primaryFilter;
		return this;
	}
	
	/**
	 * A primary filter. Primary filters are usualy defined in Select Manager class.
	 * @return Returns the primaryFilter
	 */
	public String getPrimaryFilter() {
		return this.primaryFilter;
	}
	
	/**
	 * An attribute to order by.
	 * @param orderBy The orderBy
	 * @return Returns an instance of Params for easy chaining
	 */
	public Params setOrderBy(String orderBy) {
		this.orderBy = orderBy;
		return this;
	}
	
	/**
	 * An attribute to order by.
	 * @return Returns the orderBy
	 */
	public String getOrderBy() {
		return this.orderBy;
	}
	
	/**
	 * Bool filters. E.g. onlyMy, followed.
	 * @param boolFilterList The boolFilterList
	 * @return Returns an instance of Params for easy chaining
	 */
	public Params setBoolFilterList(String[] boolFilterList) {
		this.boolFilterList = boolFilterList;
		return this;
	}
	
	/**
	 * Bool filters. E.g. onlyMy, followed.
	 * @param boolFilterList The boolFilterList
	 * @return Returns an instance of Params for easy chaining
	 */
	public Params setBoolFilterList(List<String> boolFilterList) {
		this.boolFilterList = boolFilterList.toArray(new String[0]);
		return this;
	}
	
	/**
	 * Bool filters. E.g. onlyMy, followed.
	 * @return Returns the boolFilterList
	 */
	public String[] getBoolFilterList() {
		return this.boolFilterList;
	}
	
	/**
	 * Search criteria. Can contain nested arrays and objects.
	 * @param where The where
	 * @return Returns an instance of Params for easy chaining
	 * @see Where
	 */
	public Params setWhere(Where[] where) {
		this.where = where;
		return this;
	}
	
	/**
	 * Search criteria. Can contain nested arrays and objects.
	 * @param where The where
	 * @return Returns an instance of Params for easy chaining
	 * @see Where
	 */
	public Params setWhere(List<Where> where) {
		this.where = where.toArray(new Where[0]);
		return this;
	}
	
	/**
	 * Search criteria. Can contain nested arrays and objects
	 * @return Returns the where
	 */
	public Where[] getWhere() {
		return this.where;
	}
	
	/**
	 * A direction of order: 'desc' or 'asc'.
	 * @param order The order
	 * @return Returns an instance of Params for easy chaining
	 */
	public Params setOrder(Order order) {
		this.order = order;
		return this;
	}
	
	/**
	 * A direction of order: 'desc' or 'asc'.
	 * @return Returns the order
	 */
	public Order getOrder() {
		return this.order;
	}
}