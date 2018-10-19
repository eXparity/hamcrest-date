package org.exparity.hamcrest.date.joda.format;

import org.exparity.hamcrest.date.core.TemporalFormatter;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Implementation of a {@link TemporalFormatter} that can format a
 * {@link LocalDate}
 *
 * @author Stewart Bissett
 */
public class JodaLocalDateFormatter implements TemporalFormatter<LocalDate> {

	private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormat.forPattern("EEE, dd MMM yyyy");
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormat.forPattern("EEE, dd MMM yyyy");

	@Override
	public String describe(final LocalDate temporal) {
		return temporal.toString(DATE_TIME_FORMAT);
	}

	@Override
	public String describeDate(final LocalDate temporal) {
		return temporal.toString(DATE_FORMAT);
	}

}
