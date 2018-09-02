package org.exparity.hamcrest.date.core.format;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.exparity.hamcrest.date.core.TemporalFormatter;

/**
 * Implementation of a {@link TemporalFormatter} that can format a
 * {@link LocalTime}
 *
 * @author Stewart Bissett
 */
public class LocalTimeFormatter implements TemporalFormatter<LocalTime> {

	private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("hh:mm:ss a");

	@Override
	public String describe(final LocalTime temporal) {
		return temporal.format(DATE_TIME_FORMAT);
	}

	@Override
	public String describeDate(final LocalTime temporal) {
		throw new UnsupportedOperationException("describeDate is not supported against LocalTime");
	}
}
