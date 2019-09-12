package org.exparity.hamcrest.date.core.function;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import org.exparity.hamcrest.date.core.TemporalFunction;
import org.exparity.hamcrest.date.core.types.Interval;

/**
 * Implementation of {@link TemporalFunction} to wrap {@link LocalDate} objects.
 *
 * @author Stewart Bissett
 */
public class LocalDateFunction implements TemporalFunction<LocalDate> {

	private static final String DATE_PATTERN = "EEE, dd MMM yyyy";
	
	@Override
	public boolean isAfter(final LocalDate expected, final LocalDate actual) {
		return expected.isAfter(actual);
	}

	@Override
	public boolean isBefore(final LocalDate expected, final LocalDate actual) {
		return expected.isBefore(actual);
	}

	@Override
	public boolean isSame(final LocalDate expected, final LocalDate actual) {
		return expected.equals(actual);
	}
	
	@Override
	public Interval interval(LocalDate expected, LocalDate other, ChronoUnit unit) {
		return Interval.of(expected.until(other, unit), unit);
	}

	@Override
	public String describe(final LocalDate temporal, final Locale locale) {
		return temporal.format(DateTimeFormatter.ofPattern(DATE_PATTERN, locale));
	}
}
