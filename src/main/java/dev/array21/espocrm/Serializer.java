package dev.array21.espocrm;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import dev.array21.espocrm.types.Params;
import dev.array21.espocrm.types.Where;

/**
 * Serialize a Params object into a query String.
 * Refer to PHP's <a href="https://www.php.net/manual/en/function.http-build-query.php"> http_build_query </a> for more information
 * @author Tobias de Bruijn
 * @since 1.0.0
 */
public class Serializer {

	/**
	 * Serialize a Params object into a query String
	 * @param params The params object to serialize
	 * @return The query String
	 */
	public static String serialize(Params params) {
		StringBuilder qb = new StringBuilder();
		
		if(params.getSelect() != null) {
			if(qb.length() > 0) {
				qb.append('&');
			}
			
			qb.append(String.format("select=%s", params.getSelect()));
		}
		
		if(params.getOrderBy() != null) {
			if(qb.length() > 0) {
				qb.append('&');
			}
			
			qb.append(String.format("orderBy=%s", params.getOrderBy()));
		}
		
		if(params.getOrder() != null) {
			if(qb.length() > 0) {
				qb.append('&');
			}
			
			qb.append(String.format("order=%s", params.getOrder().toString()));
		}
		
		if(params.getOffset() != null) {
			if(qb.length() > 0) {
				qb.append('&');
			}
			
			qb.append(String.format("offset=%d", params.getOffset()));
		}
		
		if(params.getBoolFilterList() != null) {
			//TODO
			throw new RuntimeException("Serialization of BoolFilterList is not yet implemented!");
		}
		
		if(params.getMaxSize() != null) {
			if(qb.length() > 0) {
				qb.append('&');
			}
			
			qb.append(String.format("maxSize=%d", params.getMaxSize()));
		}
		
		if(params.getPrimaryFilter() != null) {
			if(qb.length() > 0) {
				qb.append('&');
			}
			
			qb.append(String.format("primaryFilter=%s", params.getPrimaryFilter()));
		}
		
		if(params.getWhere() != null) {
			if(qb.length() > 0) {
				qb.append('&');
			}
			
			for(int i = 0; i < params.getWhere().length; i++) {
				Where w = params.getWhere()[i];
				
				if(i > 0) {
					qb.append('&');
				}
				
				qb.append(String.format("%s=%s", URLEncoder.encode(String.format("where[%d][type]", i), StandardCharsets.UTF_8), w.getFilterType().toString()));
				qb.append('&');
				qb.append(String.format("%s=%s", URLEncoder.encode(String.format("where[%d][attribute]", i), StandardCharsets.UTF_8), w.getAttribute()));
				
				if(w.getValue() != null) {
					if(w.getValue() instanceof String[]) {
						String[] wValueStringArray = (String[]) w.getValue();
						
						for(int j = 0; j < wValueStringArray.length; i++) {
							qb.append('&');
							qb.append(String.format("%s=%s", URLEncoder.encode(String.format("where[%d][value][%d]", i, j), StandardCharsets.UTF_8), wValueStringArray[j]));
						}
					} else if(w.getValue() instanceof String) {
						String wValueString = (String) w.getValue();
						qb.append('&');
						qb.append(String.format("%s=%s", URLEncoder.encode(String.format("where[%d][value]", i), StandardCharsets.UTF_8), wValueString));
					}
				}
			}			
		}
		
		return qb.toString();
	}
}
