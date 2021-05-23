package dev.array21.espocrm.types;

/**
 * The FilterType to use in a Where filter.<br>
 * Refer to the <a href="https://docs.espocrm.com/development/api-search-params/"> EspoCRM documentation </a>for more information
 * @author Tobias de Bruijn
 * @since 1.0.0
 */
public enum FilterType {
	EQUALS("equals"),
	NOT_EQUALS("notEquals"),
	GREATER_THAN("greaterThan"),
	LESS_THAN("lessThan"),
	GREATER_THAN_OR_EQUALS("greaterThanOrEquals"),
	LESS_THAN_OR_EQUALS("lessThanOrEquals"),
	IS_NULL("isNull"),
	IS_NOT_NULL("isNotNull"),
	IS_TRUE("isTrue"),
	IS_FALSE("isFalse"),
	LINKED_WITH("linkedWith"),
	NOT_LINKED_WIDTH("notLinkedWith"),
	IS_LINKED("isLinked"),
	IS_NOT_LINKED("isNotLinked"),
	IN("in"),
	NOT_IN("notIn"),
	CONTAINS("contains"),
	NOT_CONTAINS("notContains"),
	STARTS_WITH("startsWith"),
	ENDS_WITH("endsWith"),
	LIKE("like"),
	NOT_LIKE("notLike"),
	OR("or"),
	AND("and"),
	TODAY("today"),
	PAST("past"),
	FUTURE("future"),
	LAST_SEVEN_DAYS("lastSevenDays"),
	CURRENT_MONTH("currentMonth"),
	LAST_MONTH("lastMonth"),
	CURRENT_QUARTER("currentQuarter"),
	LAST_QUARTER("lastQuarter"),
	CURRENT_YEAR("currentYear"),
	LAST_YEAR("lastYear"),
	CURRENT_FISCAL_YEAR("currentFiscalYear"),
	LAST_FISCAL_YEAR("lastFiscalYear"),
	CURRENT_FISCAL_QUARTER("currentFiscalQuarter"),
	LAST_FISCAL_QUARTER("lastFiscalQuarter"),
	LAST_X_DAYS("lastXDays"),
	NEXT_X_DAYS("nextXDays"),
	OLDER_THAN_X_DAYS("olderThanXDays"),
	AFTER_X_DAYS("afterXDays"),
	BETWEEN("between"),
	ARRAY_ANY_OF("arrayAnyOf"),
	ARRAY_NONE_OF("arrayNoneOf"),
	ARRAY_ALL_OF("arrayAllOf"),
	ARRAY_IS_EMPTY("arrayIsEmpty"),
	ARRAY_IS_NOT_EMPTY("arrayIsNotEmpty");
	
	private final String type;
	private FilterType(String type) {
		this.type = type;
	}
	
	/**
	 * Returns the String value of this Enum in lowerCamelCase as required by the EspoCRM API
	 */
	@Override
	public String toString() {
		return this.type;
	}
}
