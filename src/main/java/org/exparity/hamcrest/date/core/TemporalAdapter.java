package org.exparity.hamcrest.date.core;

import java.time.ZoneId;
import java.time.temporal.Temporal;

/**
 * Adapter which can convert a value to a {@link Temporal}
 *
 * @author Stewart Bissett
 */
@FunctionalInterface
public interface TemporalAdapter<T> {

	/**
	 * Return the value as a {@link Temporal}
	 * @param source the source value to convert
	 * @return the value of the field
	 */
  Temporal asTemporal(final T source, final ZoneId zone);
}
