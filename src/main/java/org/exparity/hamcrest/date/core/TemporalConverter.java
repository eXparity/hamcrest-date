package org.exparity.hamcrest.date.core;

import java.time.ZoneId;

/**
 * Convert one temporal type to another temporal type
 * 
 * @author Stewart Bissett
 *
 * @param <T> the source type
 * @param <R> the result type
 */
@FunctionalInterface
public interface TemporalConverter<T, R> {

	/**
	 * Convert one temporal type to another temporal type
	 * @param source the source to convert
	 * @param zone the timezone to use
	 * @return the source value as the target value
	 */
	public R apply(T source, ZoneId zone);
}
