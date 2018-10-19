package org.exparity.hamcrest.date.core;

/**
 * Wrapper which wraps a temporal field so it can support the operations required
 * by the matchers
 *
 * @author Thomas Naskali
 */
public interface TemporalFieldWrapper<T, Z> {

	/**
	 * @param other a temporal to test against
	 * @return <code>true</code> if this temporal field is after the other
	 */
	boolean isAfter(final T other);

    /**
     * @param other a temporal to test against
     * @return <code>true</code> if this temporal field is before the other
     */
    boolean isBefore(final T other);

    /**
     * @param other a temporal to test against
     * @return <code>true</code> if this temporal field is the same as the other
     */
    boolean isSame(final T other);

    /**
     * @return a the wrapped value
     */
    int unwrap();

	/**
	 * Makes a copy of this wrapper based on a given time zone.
	 *
	 * @param zone a new reference time zone
	 * @return a copy of the wrapper based on the new reference time zone
	 */
	TemporalFieldWrapper<T, Z> withZone(Z zone);

}
