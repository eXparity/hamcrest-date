/**
 * 
 */
package org.exparity.hamcrest.date.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

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
	public boolean isAfter(final T other);

	/**
	 * @param other a temporal to test against
	 * @return <code>true</code> if this temporal is after the other
	 */
	public boolean isBefore(final T other);

	/**
	 * @param other a temporal to test against
	 * @return <code>true</code> if this temporal is after the other
	 */
	public boolean isSame(final T other);

	/**
	 * @param other a temporal to test against
	 * @return <code>true</code> if this temporal is after the other
	 */
	public boolean isSameDay(final T other);

	/**
	 * @return a the wrapped value
	 */
	public T unwrap();

	/**
	 * Return the difference in units between this time and the other time in the given units
	 */
	public long difference(final T other, final ChronoUnit unit);

}
