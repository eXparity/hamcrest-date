package org.exparity.hamcrest.date.core;

import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

/**
 * Wrapper which wraps a temporal time so it can support the operations required
 * by the matchers
 *
 * @author Stewart Bissett
 */
public interface TemporalWrapper<T> {

	/**
	 * @param other a temporal to test against
	 * @return <code>true</code> if this temporal is after the other
	 */
	boolean isAfter(final T other);

	/**
	 * @param other a temporal to test against
	 * @return <code>true</code> if this temporal is before the other
	 */
	boolean isBefore(final T other);

	/**
	 * @param other a temporal to test against
	 * @return <code>true</code> if this temporal is the same as the other
	 */
	boolean isSame(final T other);

	/**
	 * @return a the wrapped value
	 */
	T unwrap();

	/**
	 * Return the difference in units between this time and the other time in the given units
	 */
	long difference(final T other, final ChronoUnit unit);

	/**
	 * Makes a copy of this wrapper based on a given time zone.
	 *
	 * @param zone a new reference time zone
	 * @return a copy of the wrapper based on the new reference time zone
	 */
	TemporalWrapper<T> withZone(ZoneId zone);

}
