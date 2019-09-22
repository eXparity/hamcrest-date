package org.exparity.hamcrest.date.core;

import java.time.ZoneId;
import java.util.Locale;

import org.exparity.hamcrest.date.core.types.DayOfMonth;
import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is on the specified hour
 *
 * @author Stewart Bissett
 */
public class IsDayOfMonth<T> extends TemporalMatcher<T> {

	private final TemporalConverter<T, DayOfMonth> converter;
	private final TemporalProvider<DayOfMonth> expected;
	private final Locale locale;
	private final ZoneId zone;

	public IsDayOfMonth(TemporalConverter<T, DayOfMonth> converter,
	        TemporalProvider<DayOfMonth> expected,
	        ZoneId zone,
	        Locale locale) {
		this.expected = expected;
		this.converter = converter;
		this.locale = locale;
		this.zone = zone;
	}

	public IsDayOfMonth(TemporalConverter<T, DayOfMonth> converter, TemporalProvider<DayOfMonth> expected) {
		this(converter, expected, ZoneId.systemDefault(), Locale.getDefault(Locale.Category.FORMAT));
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
	    DayOfMonth expectedValue = expected.apply(zone), actualValue = converter.apply(actual, zone);
		if (!expectedValue.equals(actualValue)) {
			mismatchDescription.appendText("the date has the day of month " + actualValue);
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the date has the day of month " + expected.apply(zone));
	}

	@Override
	public TemporalMatcher<T> atZone(ZoneId zone) {
		return new IsDayOfMonth<>(converter, expected, zone, locale);
	}

}