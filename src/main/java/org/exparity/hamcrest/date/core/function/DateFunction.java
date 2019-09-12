package org.exparity.hamcrest.date.core.function;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

import org.exparity.hamcrest.date.core.TemporalFunction;
import org.exparity.hamcrest.date.core.types.Interval;

/**
 * Implementation of {@link TemporalWrapper} to wrap {@link Date} objects.
 *
 * @author Stewart Bissett
 */
public class DateFunction implements TemporalFunction<Date> {

	public static final String JAVA_SQL_DATE_UNIT = "java.sql.Date does not support time-based units. Prefer SqlDateMatchers for java.sql.Date appropriate matchers";

	private static final String DATE_TIME_FORMAT = "EEE, dd MMM yyyy hh:mm:ss.SSS a";
	private static final String DATE_FORMAT = "EEE, dd MMM yyyy";

	@Override
	public boolean isAfter(final Date expected, final Date actual) {
		if (expected instanceof java.sql.Date || actual instanceof java.sql.Date) {
			return toLocalDate(expected).isAfter(toLocalDate(actual));
		} else {
			return expected.after(actual);
		}
	}

	@Override
	public boolean isBefore(final Date expected, final Date actual) {
		if (expected instanceof java.sql.Date || actual instanceof java.sql.Date) {
			return toLocalDate(expected).isBefore(toLocalDate(actual));
		} else {
			return expected.before(actual);
		}
	}

	@Override
	public boolean isSame(final Date expected, final Date actual) {
		if (expected instanceof java.sql.Date || actual instanceof java.sql.Date) {
			return toLocalDate(expected).equals(toLocalDate(actual));
		} else {
			return expected.equals(actual);
		}
	}

	@Override
	public Interval interval(Date expected, Date actual, ChronoUnit unit) {
		if (expected instanceof java.sql.Date || actual instanceof java.sql.Date) {
			return Interval.of(toLocalDate(expected).until(toLocalDate(actual), unit), unit);
		} else {
			return Interval.of(expected.toInstant().until(actual.toInstant(), unit), unit);
		}
	}

	@Override
	public String describe(final Date temporal, final Locale locale) {
		if (temporal instanceof java.sql.Date) {
			return new SimpleDateFormat(DATE_FORMAT, locale).format(temporal);
		} else {
			return new SimpleDateFormat(DATE_TIME_FORMAT, locale).format(temporal);
		}
	}

	private LocalDate toLocalDate(Date expected) {
		if (expected instanceof java.sql.Date) {
			return ((java.sql.Date) expected).toLocalDate();
		} else {
			return expected.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		}
	}
}
