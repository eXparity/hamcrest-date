/**
 * 
 */
package org.exparity.hamcrest.date.core;

import java.time.LocalDate;

/**
 * Implementation of a {@link TemporalFormatter} that can format a
 * {@link LocalDate}
 * 
 * @author Stewart Bissett
 */
public class LocalDateFormatter implements TemporalFormatter<LocalDate> {

	@Override
	public String describe(LocalDate temporal) {
		return temporal.toString();
	}

}
