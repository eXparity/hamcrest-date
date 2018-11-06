package org.exparity.hamcrest.date.core;

/**
 * Adapter which can convert a value to a temporal field.
 *
 * @author Thomas Naskali
 */
@FunctionalInterface
public interface TemporalFieldAdapter<T, Z> {

	/**
	 * Return the value as a temporal field
	 * @param source the source value to convert
	 * @param zone the reference time zone
	 * @return the value of the temporal field
	 */
	long asTemporalField(final T source, final Z zone);

}
