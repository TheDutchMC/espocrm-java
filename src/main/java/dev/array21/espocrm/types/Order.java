package dev.array21.espocrm.types;

public enum Order {
	ASC("asc"),
	DESC("desc");
	
	private final String order;
	
	private Order(String order) {
		this.order = order;
	}
	
	@Override
	public String toString() {
		return this.order;
	}
}
