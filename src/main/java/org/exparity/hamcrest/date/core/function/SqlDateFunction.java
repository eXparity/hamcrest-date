package org.exparity.hamcrest.date.core.function;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import org.exparity.hamcrest.date.core.TemporalFunction;
import org.exparity.hamcrest.date.core.types.Interval;

/**
 * Implementation of {@link TemporalFunction} to wrap {@link Date} objects.
 *
 * @author Stewart Bissett
 */
public class SqlDateFunction implements TemporalFunction<Date> {

	private static final String DATE_FORMAT = "EEE, dd MMM yyyy";

	@Override
	public boolean isAfter(final Date expected, final Date actual) {
		return expected.toLocalDate().isAfter(actual.toLocalDate());
	}

	@Override
	public boolean isBefore(final Date expected, final Date actual) {
		return expected.toLocalDate().isBefore(actual.toLocalDate());
	}

	@Override
	public boolean isSame(final Date expected, final Date actual) {
		return expected.toLocalDate().equals(actual.toLocalDate());
	}

	@Override
	public Interval interval(Date temporal, Date other, ChronoUnit unit) {
		return Interval.of(temporal.toLocalDate().until(other.toLocalDate(), unit), unit);
	}

	@Override
	public String describe(final Date temporal, final Locale locale) {
		return new SimpleDateFormat(DATE_FORMAT, locale).format(temporal);
	}
}
