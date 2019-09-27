package org.exparity.hamcrest.date.core;

import java.time.ZoneId;
import java.util.Locale;
import java.util.Optional;

import org.exparity.hamcrest.date.core.types.Hour;
import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is on the specified hour
 *
 * @author Stewart Bissett
 */
public class IsHour<T> extends TemporalMatcher<T> {

	private final TemporalConverter<T, Hour> converter;
	private final TemporalProvider<Hour> expected;
	private final Locale locale;
	private final Optional<ZoneId> zone;

	public IsHour(TemporalConverter<T, Hour> converter,
	        TemporalProvider<Hour> expected,
	        Optional<ZoneId> zone,
	        Locale locale) {
		this.expected = expected;
		this.converter = converter;
		this.locale = locale;
		this.zone = zone;
	}

	public IsHour(TemporalConverter<T, Hour> converter, TemporalProvider<Hour> expected) {
		this(converter, expected, Optional.empty(), Locale.getDefault(Locale.Category.FORMAT));
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
		Hour expectedValue = expected.apply(zone), actualValue = converter.apply(actual, zone);
		if (!expectedValue.equals(actualValue)) {
			mismatchDescription.appendText("the date has the hour " + actualValue);
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the date has the hour " + expected.apply(zone));
	}

	@Override
	public TemporalMatcher<T> atZone(ZoneId zone) {
		return new IsHour<>(converter, expected, Optional.of(zone), locale);
	}
	
    @Override
    public TemporalMatcher<T> atLocale(Locale locale) {
        return new IsHour<>(converter, expected, zone, locale);
    }
}