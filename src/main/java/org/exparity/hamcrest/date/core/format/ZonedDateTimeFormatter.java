package org.exparity.hamcrest.date.core.format;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.exparity.hamcrest.date.core.TemporalFormatter;

/**
 * Implementation of a {@link TemporalFormatter} that can format a
 * {@link ZonedDateTime}
 *
 * @author Stewart Bissett
 */
public class ZonedDateTimeFormatter implements TemporalFormatter<ZonedDateTime> {

	private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy hh:mm:ss.SSS a Z");
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy");

	@Override
	public String describe(final ZonedDateTime temporal) {
		return temporal.format(DATE_TIME_FORMAT);
	}

	@Override
	public String describeDate(final ZonedDateTime temporal) {
		return temporal.format(DATE_FORMAT);
	}

}
