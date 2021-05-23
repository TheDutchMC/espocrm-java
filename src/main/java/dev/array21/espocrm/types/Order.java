package dev.array21.espocrm.types;

/**
 * The direction to order by, either ascending or descending.
 * @author Tobias de Bruijn
 * @since 1.0.0
 */
public enum Order {
	ASC("asc"),
	DESC("desc");
	
	private final String order;
	private Order(String order) {
		this.order = order;
	}
	
	/**
	 * Returns the String value of this Enum in lowerCamelCase as required by the EspoCRM API
	 */
	@Override
	public String toString() {
		return this.order;
	}
}
