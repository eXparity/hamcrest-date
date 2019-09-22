package org.exparity.hamcrest.date.core;

import java.time.Year;
import java.time.ZoneId;
import java.util.Locale;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is on the same year as the
 * reference date
 *
 * @author Stewart Bissett
 */
public class IsYear<T> extends TemporalMatcher<T> {

	private final TemporalConverter<T, Year> converter;
	private final TemporalProvider<Year> expected;
	private final Locale locale;
	private final ZoneId zone;

	public IsYear(TemporalConverter<T, Year> converter,
	        TemporalProvider<Year> expected,
	        ZoneId zone,
	        Locale locale) {
		this.expected = expected;
		this.converter = converter;
		this.locale = locale;
		this.zone = zone;
	}

	public IsYear(TemporalConverter<T, Year> converter, TemporalProvider<Year> expected) {
		this(converter, expected, ZoneId.systemDefault(), Locale.getDefault(Locale.Category.FORMAT));
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
		Year expectedValue = expected.apply(zone), actualValue = converter.apply(actual, zone);
		if (!expectedValue.equals(actualValue)) {
			mismatchDescription.appendText("the date has the year " + actualValue);
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the date has the year " + expected.apply(zone));
	}

	@Override
	public TemporalMatcher<T> atZone(ZoneId zone) {
		return new IsYear<>(converter, expected, zone, locale);
	}
}