package dev.array21.espocrm.types;

import java.util.List;

/**
 * Where parameter is an array if items, that can contain nested items. The data should be URL-encoded. API clients provided in the documentation handle encoding.<br>
 * Refer to the <a href="https://docs.espocrm.com/development/api-search-params/"> EspoCRM documentation </a>for more information
 * @author Tobias de Bruijn
 * @since 1.0.0
 */
public class Where {
	private FilterType filterType;
	private String attribute;
	private Object value;
	
	/**
	 * Create a new Where filter
	 * @param filterType The FilterType. See: {@link #setFilterType(FilterType)}
	 * @param attribute The attribute. See {@link #setAttribute(String)}
	 */
	public Where(FilterType filterType, String attribute) {
		this.filterType = filterType;
		this.attribute = attribute;
	}
	
	/**
	 * The FilterType to use. This may not be left null.
	 * @param filterType The filterType
	 * @return Returns an instance of Where for easy chaining
	 * @see FilterType
	 */
	public Where setFilterType(FilterType filterType) {
		this.filterType = filterType;
		return this;
	}
	
	/**
	 * The FilterType to use
	 * @return Returns the FilterType
	 */
	public FilterType getFilterType() {
		return this.filterType;
	}
	
	/**
	 * The attribute to apply the filter to. This may not be left null.s
	 * @param attribute The attribute
	 * @return Returns an instance of Where for easy chaining
	 */
	public Where setAttribute(String attribute) {
		this.attribute = attribute;
		return this;
	}
	
	/**
	 * The attribute to apply the filter to
	 * @return Returns the attribute
	 */
	public String getAttribute() {
		return this.attribute;
	}
	
	/**
	 * Set the Value field to a String
	 * @param value The value
	 * @return Returns an instance of Where for easy chaining
	 */
	public Where setValueString(String value) {
		this.value = value;
		return this;
	}
	
	/**
	 * Set the Value field to a String[]
	 * @param value The value
	 * @return Returns an instance of Where for easy chaining
	 */
	public Where setValueStringArray(String[] value) {
		this.value = value;
		return this;
	}
	
	/**
	 * Set the Value field to a List<String>, this is converted to a String[]
	 * @param value The value
	 * @return Returns an instance of Where for easy chaining
	 */
	public Where setValueStringList(List<String> value) {
		this.value = value.toArray(new String[0]);
		return this;
	}
	
	/**
	 * The value Field. Can be a String or a String[]
	 * @return The value
	 */
	public Object getValue() {
		return this.value;
	}
}
