package org.exparity.hamcrest.date.core.function;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import org.exparity.hamcrest.date.core.TemporalFunction;
import org.exparity.hamcrest.date.core.TemporalFunctions;
import org.exparity.hamcrest.date.core.types.Interval;

/**
 * Implementation of {@link TemporalFunctions} for {@link OffsetDateTime} objects.
 *
 * @author Stewart Bissett
 */
public class OffsetDateTimeFunction implements TemporalFunction<OffsetDateTime> {

	private static final String DATE_TIME_PATTERN = "EEE, dd MMM yyyy hh:mm:ss.SSS a Z";
	
	@Override
	public boolean isAfter(final OffsetDateTime expected, final OffsetDateTime actual) {
		return expected.isAfter(actual);
	}

	@Override
	public boolean isBefore(final OffsetDateTime expected, final OffsetDateTime actual) {
		return expected.isBefore(actual);
	}

	@Override
	public boolean isSame(final OffsetDateTime expected, final OffsetDateTime actual) {
		return expected.equals(actual);
	}

	@Override
	public Interval interval(OffsetDateTime expected, OffsetDateTime other, ChronoUnit unit) {
		return Interval.of(expected.until(other, unit), unit);
	}
	
	@Override
	public String describe(final OffsetDateTime temporal, final Locale locale) {
		return temporal.format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN, locale));
	}
}
