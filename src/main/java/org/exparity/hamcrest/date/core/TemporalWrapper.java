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
	 * @return <code>true</code> if this temporal is after the other
	 */
	boolean isBefore(final T other);

	/**
	 * @param other a temporal to test against
	 * @return <code>true</code> if this temporal is after the other
	 */
	boolean isSame(final T other);

	/**
	 * @param other a temporal to test against
	 * @return <code>true</code> if this temporal is after the other
	 */
	boolean isSameDay(final T other);

	/**
	 * @return a the wrapped value
	 */
	T unwrap();

	/**
	 * Return the difference in units between this time and the other time in the given units
	 */
	long difference(final T other, final ChronoUnit unit);

	/**
	 *
	 * @param zone a zone to apply to the wrapped value
	 * @return a copy of the wrapper at the desired zone
	 */
	TemporalWrapper<T> withZone(ZoneId zone);

}
