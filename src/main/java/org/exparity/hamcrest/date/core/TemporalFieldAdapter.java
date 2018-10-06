package org.exparity.hamcrest.date.core;

import java.time.ZoneId;

/**
 * Adapter which can convert a value to a temporal field
 *
 * @see java.time.temporal.TemporalField
 * @author Thomas Naskali
 */
@FunctionalInterface
public interface TemporalFieldAdapter<T> {

	/**
	 * Return the value as a temporal field
	 * @param source the source value to convert
	 * @param zone the reference time zone
	 * @return the value of the temporal field
	 */
	int asTemporalField(final T source, final ZoneId zone);

}
