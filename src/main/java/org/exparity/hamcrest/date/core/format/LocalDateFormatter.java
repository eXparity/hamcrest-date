/**
 *
 */
package org.exparity.hamcrest.date.core.format;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.exparity.hamcrest.date.core.TemporalFormatter;

/**
 * Implementation of a {@link TemporalFormatter} that can format a
 * {@link LocalDate}
 *
 * @author Stewart Bissett
 */
public class LocalDateFormatter implements TemporalFormatter<LocalDate> {

	private static DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy");
	private static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy");

	@Override
	public String describe(final LocalDate temporal) {
		return temporal.format(DATE_TIME_FORMAT);
	}

	@Override
	public String describeDate(final LocalDate temporal) {
		return temporal.format(DATE_FORMAT);
	}

}
