package org.exparity.hamcrest.date.core;

import java.time.temporal.ChronoUnit;
import java.util.Locale;

import org.exparity.hamcrest.date.core.types.Interval;

/**
 * Suite of temporal functions for a temporal type
 * 
 * @author Stewart Bissett
 *
 * @param <T> the temporal type
 */
public interface TemporalFunction<T> {

	/**
	 * Describe a temporal type
	 * @param temporal the temporal instance to describe
	 * @param locale the locale to describe the temporal in
	 * @return a string description of the temporal
	 */
	String describe(T temporal, Locale locale);

	/**
	 * Test if a temporal is the same as another temporal
	 * @param temporal the temporal to test for
	 * @param other the temporal to test against
	 * @return a boolean
	 */
	boolean isSame(T temporal, T other);

	/**
	 * Test if a temporal is after another temporal
	 * @param temporal the temporal to test for
	 * @param other the temporal to test against
	 * @return a boolean
	 */
	boolean isAfter(T temporal, T other);

	/**
	 * Test if a temporal is before another temporal
	 * @param temporal the temporal to test for
	 * @param other the temporal to test against
	 * @return a boolean
	 */
	boolean isBefore(T temporal, T other);

	/**
	 * Return the interval between two temporals
	 * @param temporal the temporal to test for
	 * @param other the temporal to test against
	 * @param unit the unit to measure the interval in
	 * @return an {@link Interval}
	 */
	Interval interval(T temporal, T other, ChronoUnit unit);
}
