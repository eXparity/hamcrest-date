package org.exparity.hamcrest.date.core;

/**
 * Return the description of a temporal unit
 *
 * @author Thomas Naskali
 * @param <U> The temporal unit type
 */
public interface TemporalUnitFormatter<U> {

	/**
	 * @param unit the temporal unit to describe
	 * @return a pretty description of the temporal unit
	 */
	String describe(U unit);
}
