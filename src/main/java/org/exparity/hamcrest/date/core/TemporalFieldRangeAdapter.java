package org.exparity.hamcrest.date.core;

import java.time.ZoneId;
import java.time.temporal.ValueRange;

/**
 * Adapter which can convert a value to a {@link ValueRange}
 *
 * @author Thomas Naskali
 */
@FunctionalInterface
public interface TemporalFieldRangeAdapter<T> {

	/**
	 * Return the value as a {@link ValueRange}
	 * @param source the source value to convert
	 * @param zone the reference time zone
	 * @return the value of the range
	 */
	ValueRange asTemporalFieldRange(final T source, final ZoneId zone);

}
