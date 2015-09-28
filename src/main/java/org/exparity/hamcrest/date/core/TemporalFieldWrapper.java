/**
 * 
 */
package org.exparity.hamcrest.date.core;

import java.time.temporal.ChronoField;

/**
 * Accessor which can extract a temporal field from a temporal value
 * 
 * @author Stewart Bissett
 */
@FunctionalInterface
public interface TemporalFieldWrapper<T> {

	/**
	 * Return the value of the field from the wrapped temporal
	 * 
	 * @param temporal the temporal value
	 * @param field the field to return
	 * @return the value of the field
	 */
	public int get(final T temporal, final ChronoField field);
}
