package org.exparity.hamcrest.date.joda.format;

import org.exparity.hamcrest.date.core.TemporalFormatter;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Implementation of a {@link TemporalFormatter} that can format a
 * {@link LocalDateTime}
 *
 * @author Stewart Bissett
 */
public class JodaLocalDateTimeFormatter implements TemporalFormatter<LocalDateTime> {

	private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormat.forPattern("EEE, dd MMM yyyy hh:mm:ss.SSS a");
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormat.forPattern("EEE, dd MMM yyyy");

	@Override
	public String describe(final LocalDateTime temporal) {
		return temporal.toString(DATE_TIME_FORMAT);
	}

	@Override
	public String describeDate(final LocalDateTime temporal) {
		return temporal.toString(DATE_FORMAT);
	}
}
