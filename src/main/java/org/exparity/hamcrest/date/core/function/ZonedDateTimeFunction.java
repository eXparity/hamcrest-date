package org.exparity.hamcrest.date.core.function;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import org.exparity.hamcrest.date.core.TemporalFunction;
import org.exparity.hamcrest.date.core.TemporalFunctions;
import org.exparity.hamcrest.date.core.types.Interval;

/**
 * Implementation of {@link TemporalFunctions} for {@link ZonedDateTime} objects.
 *
 * @author Stewart Bissett
 */
public class ZonedDateTimeFunction implements TemporalFunction<ZonedDateTime> {

	private static final String DATE_TIME_PATTERN = "EEE, dd MMM yyyy hh:mm:ss.SSS a Z";
	
	@Override
	public boolean isAfter(final ZonedDateTime expected, final ZonedDateTime actual) {
		return expected.isAfter(actual);
	}

	@Override
	public boolean isBefore(final ZonedDateTime expected, final ZonedDateTime actual) {
		return expected.isBefore(actual);
	}

	@Override
	public boolean isSame(final ZonedDateTime expected, final ZonedDateTime actual) {
		return expected.isEqual(actual);
	}

	@Override
	public Interval interval(ZonedDateTime expected, ZonedDateTime other, ChronoUnit unit) {
		return Interval.of(expected.until(other, unit), unit);
	}
	
	@Override
	public String describe(final ZonedDateTime temporal, final Locale locale) {
		return temporal.format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN, locale));
	}
}
