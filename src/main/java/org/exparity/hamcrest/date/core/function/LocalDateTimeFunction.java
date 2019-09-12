package org.exparity.hamcrest.date.core.function;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import org.exparity.hamcrest.date.core.TemporalFunction;
import org.exparity.hamcrest.date.core.types.Interval;

/**
 * Implementation of {@link TemporalFunction} for {@link LocalDateTime} objects.
 *
 * @author Stewart Bissett
 */
public class LocalDateTimeFunction implements TemporalFunction<LocalDateTime> {

	private static final String DATE_TIME_PATTERN = "EEE, dd MMM yyyy hh:mm:ss.SSS a";
	
	@Override
	public boolean isAfter(final LocalDateTime expected, final LocalDateTime actual) {
		return expected.isAfter(actual);
	}

	@Override
	public boolean isBefore(final LocalDateTime expected, final LocalDateTime actual) {
		return expected.isBefore(actual);
	}

	@Override
	public boolean isSame(final LocalDateTime expected, final LocalDateTime actual) {
		return expected.equals(actual);
	}
	
	@Override
	public Interval interval(LocalDateTime expected, LocalDateTime other, ChronoUnit unit) {
		return Interval.of(expected.until(other, unit), unit);
	}

	@Override
	public String describe(final LocalDateTime temporal, final Locale locale) {
		return temporal.format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN, locale));
	}
}
