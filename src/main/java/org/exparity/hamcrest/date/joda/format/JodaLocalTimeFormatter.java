package org.exparity.hamcrest.date.joda.format;

import org.exparity.hamcrest.date.core.TemporalFormatter;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Implementation of a {@link TemporalFormatter} that can format a
 * {@link LocalTime}
 *
 * @author Stewart Bissett
 */
public class JodaLocalTimeFormatter implements TemporalFormatter<LocalTime> {

	private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormat.forPattern("hh:mm:ss a");

	@Override
	public String describe(final LocalTime temporal) {
		return temporal.toString(DATE_TIME_FORMAT);
	}

	@Override
	public String describeDate(final LocalTime temporal) {
		throw new UnsupportedOperationException("describeDate is not supported against LocalTime");
	}
}
