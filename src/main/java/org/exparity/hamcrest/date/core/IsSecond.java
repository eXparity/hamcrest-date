package org.exparity.hamcrest.date.core;

import java.time.ZoneId;
import java.util.Locale;

import org.exparity.hamcrest.date.core.types.Second;
import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is on the specified second
 *
 * @author Stewart Bissett
 */
public class IsSecond<T> extends TemporalMatcher<T> {

	private final TemporalConverter<T, Second> converter;
	private final TemporalProvider<Second> expected;
	private final Locale locale;
	private final ZoneId zone;

	public IsSecond(TemporalConverter<T, Second> converter,
	        TemporalProvider<Second> expected,
	        ZoneId zone,
	        Locale locale) {
		this.expected = expected;
		this.converter = converter;
		this.locale = locale;
		this.zone = zone;
	}

	public IsSecond(TemporalConverter<T, Second> converter, TemporalProvider<Second> expected) {
		this(converter, expected, ZoneId.systemDefault(), Locale.getDefault(Locale.Category.FORMAT));
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
		Second expectedValue = expected.apply(zone), actualValue = converter.apply(actual, zone);
		if (!expectedValue.equals(actualValue)) {
			mismatchDescription.appendText("the date has the second " + actualValue);
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the date has the second " + expected.apply(zone));
	}

	@Override
	public TemporalMatcher<T> atZone(ZoneId zone) {
		return new IsSecond<>(converter, expected, zone, locale);
	}
}