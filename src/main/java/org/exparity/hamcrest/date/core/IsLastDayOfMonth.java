package org.exparity.hamcrest.date.core;

import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.ValueRange;
import java.util.Locale;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is on the first day of the month
 *
 * @author Stewart Bissett
 */
public class IsLastDayOfMonth<T> extends TemporalMatcher<T> {

	private final TemporalConverter<T, ? extends TemporalAccessor> converter;
	private final Locale locale;
	private final ZoneId zone;

	public IsLastDayOfMonth(TemporalConverter<T, ? extends TemporalAccessor> converter, ZoneId zone, Locale locale) {
		this.converter = converter;
		this.locale = locale;
		this.zone = zone;
	}

	public IsLastDayOfMonth(TemporalConverter<T, ? extends TemporalAccessor> converter) {
		this(converter, ZoneId.systemDefault(), Locale.getDefault(Locale.Category.FORMAT));
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDesc) {
		TemporalAccessor actualTemporal = converter.apply(actual, zone);
		ValueRange actualRange = ChronoField.DAY_OF_MONTH.rangeRefinedBy(actualTemporal);
		long actualValue = ChronoField.DAY_OF_MONTH.getFrom(actualTemporal), expectedValue = actualRange.getMaximum();
		if (expectedValue != actualValue) {
			mismatchDesc.appendText("date is the " + actualValue + " day of the month");
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the date is the last day of the month");
	}

	@Override
	public TemporalMatcher<T> atZone(ZoneId zone) {
		return new IsLastDayOfMonth<>(converter, zone, locale);
	}
}