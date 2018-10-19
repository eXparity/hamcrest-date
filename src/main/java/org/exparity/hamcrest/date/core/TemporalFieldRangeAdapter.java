package org.exparity.hamcrest.date.core;

/**
 * Adapter which can convert a temporal value to an extremum
 *
 * @author Thomas Naskali
 */
@FunctionalInterface
public interface TemporalFieldRangeAdapter<T, Z> {

	/**
	 * Return the extremum value for a temporal
	 * @param source the source value to convert
	 * @param zone the reference time zone
	 * @return the extremum value for this temporal
	 */
	long getExtremum(final T source, final Z zone);

}
