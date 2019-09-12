package org.exparity.hamcrest.date.core.function;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import org.exparity.hamcrest.date.core.TemporalFunction;
import org.exparity.hamcrest.date.core.types.Interval;

/**
 * Implementation of {@link TemporalFunction} to wrap {@link LocalTime} objects.
 *
 * @author Stewart Bissett
 */
public class LocalTimeFunction implements TemporalFunction<LocalTime> {

	private static final String TIME_PATTERN = "hh:mm:ss a";
	
	@Override
	public boolean isAfter(final LocalTime expected, final LocalTime actual) {
		return expected.isAfter(actual);
	}

	@Override
	public boolean isBefore(final LocalTime expected, final LocalTime actual) {
		return expected.isBefore(actual);
	}

	@Override
	public boolean isSame(final LocalTime expected, final LocalTime actual) {
		return expected.equals(actual);
	}
	
	@Override
	public Interval interval(LocalTime expected, LocalTime other, ChronoUnit unit) {
		return Interval.of(expected.until(other, unit), unit);
	}

	@Override
	public String describe(final LocalTime temporal, final Locale locale) {
		return temporal.format(DateTimeFormatter.ofPattern(TIME_PATTERN, locale));
	}
}
