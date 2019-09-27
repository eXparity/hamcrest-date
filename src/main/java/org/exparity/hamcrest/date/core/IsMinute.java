package org.exparity.hamcrest.date.core;

import java.time.ZoneId;
import java.util.Locale;
import java.util.Optional;

import org.exparity.hamcrest.date.core.types.Minute;
import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is on the specified minute
 *
 * @author Stewart Bissett
 */
public class IsMinute<T> extends TemporalMatcher<T> {

	private final TemporalConverter<T, Minute> converter;
	private final TemporalProvider<Minute> expected;
	private final Locale locale;
	private final Optional<ZoneId> zone;

	public IsMinute(TemporalConverter<T, Minute> converter,
	        TemporalProvider<Minute> expected,
	        Optional<ZoneId> zone,
	        Locale locale) {
		this.expected = expected;
		this.converter = converter;
		this.locale = locale;
		this.zone = zone;
	}

	public IsMinute(TemporalConverter<T, Minute> converter, TemporalProvider<Minute> expected) {
		this(converter, expected, Optional.empty(), Locale.getDefault(Locale.Category.FORMAT));
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
		Minute expectedValue = expected.apply(zone), actualValue = converter.apply(actual, zone);
		if (!expectedValue.equals(actualValue)) {
			mismatchDescription.appendText("the date has the minute " + actualValue);
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the date has the minute " + expected.apply(zone));
	}

	@Override
	public TemporalMatcher<T> atZone(ZoneId zone) {
		return new IsMinute<>(converter, expected, Optional.of(zone), locale);
	}

	@Override
    public TemporalMatcher<T> atLocale(Locale locale) {
        return new IsMinute<>(converter, expected, zone, locale);
    }
}