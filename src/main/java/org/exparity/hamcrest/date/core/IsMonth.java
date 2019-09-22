package org.exparity.hamcrest.date.core;

import java.time.Month;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Locale;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is on the same month of the year as the reference date
 *
 * @author Stewart Bissett
 */
public class IsMonth<T> extends TemporalMatcher<T> {

	private final TemporalConverter<T, Month> converter;
	private final TemporalProvider<Month> expected;
	private final Locale locale;
	private final ZoneId zone;

	public IsMonth(TemporalConverter<T, Month> converter,
	        TemporalProvider<Month> expected,
	        ZoneId zone,
	        Locale locale) {
		this.expected = expected;
		this.converter = converter;
		this.locale = locale;
		this.zone = zone;
	}

	public IsMonth(TemporalConverter<T, Month> converter, TemporalProvider<Month> expected) {
		this(converter, expected, ZoneId.systemDefault(), Locale.getDefault(Locale.Category.FORMAT));
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
		Month expectedValue = expected.apply(zone), actualValue = converter.apply(actual, zone);
		if (!expectedValue.equals(actualValue)) {
			mismatchDescription.appendText("the date has the month " + describe(actualValue));
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the date has the month " + describe(expected.apply(zone)));
	}

	@Override
	public TemporalMatcher<T> atZone(ZoneId zone) {
		return new IsMonth<>(converter, expected, zone, locale);
	}

    @Override
    public TemporalMatcher<T> atLocale(Locale locale) {
        return new IsMonth<>(converter, expected, zone, locale);
    }

	private String describe(Month actualValue) {
		return actualValue.getDisplayName(TextStyle.FULL, locale);
	}

}