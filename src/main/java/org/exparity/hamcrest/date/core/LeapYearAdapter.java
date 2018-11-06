package org.exparity.hamcrest.date.core;

/**
 * Adapter which can convert a temporal to a boolean value representing if the teporal is within a leap year
 *
 * @author Thomas Naskali
 */
@FunctionalInterface
public interface LeapYearAdapter<T, Z> {

	/**
	 * @param temporal a temporal to test against
	 * @param zone the reference time zone
	 * @return <code>true</code> if the temporal is q leap year
	 */
	boolean isLeapYear(final T temporal, final Z zone);

}
