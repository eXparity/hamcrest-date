/**
 * 
 */
package org.exparity.hamcrest.date.core.format;

import java.time.LocalDate;

import org.exparity.hamcrest.date.core.TemporalFormatter;

/**
 * Implementation of a {@link TemporalFormatter} that can format a
 * {@link LocalDate}
 * 
 * @author Stewart Bissett
 */
public class LocalDateFormatter implements TemporalFormatter<LocalDate> {

	@Override
	public String describe(final LocalDate temporal) {
		return temporal.toString();
	}

}
