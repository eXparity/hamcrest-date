package org.exparity.hamcrest.date.core;

import java.time.ZoneId;
import java.util.Locale;
import java.util.Optional;

import org.exparity.hamcrest.date.core.types.Millisecond;
import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is on the specified minute
 *
 * @author Stewart Bissett
 */
public class IsMillisecond<T> extends TemporalMatcher<T> {

	private final TemporalConverter<T, Millisecond> converter;
	private final TemporalProvider<Millisecond> expected;
	private final Locale locale;
	private final Optional<ZoneId> zone;

	public IsMillisecond(TemporalConverter<T, Millisecond> converter,
	        TemporalProvider<Millisecond> expected,
	        Optional<ZoneId> zone,
	        Locale locale) {
		this.expected = expected;
		this.converter = converter;
		this.locale = locale;
		this.zone = zone;
	}

	public IsMillisecond(TemporalConverter<T, Millisecond> converter, TemporalProvider<Millisecond> expected) {
		this(converter, expected, Optional.empty(), Locale.getDefault(Locale.Category.FORMAT));
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
		Millisecond expectedValue = expected.apply(zone), actualValue = converter.apply(actual, zone);
		if (!expectedValue.equals(actualValue)) {
			mismatchDescription.appendText("the date has the millisecond " + actualValue);
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the date has the millisecond " + expected.apply(zone));
	}

	@Override
	public TemporalMatcher<T> atZone(ZoneId zone) {
		return new IsMillisecond<>(converter, expected, Optional.of(zone), locale);
	}

    @Override
    public TemporalMatcher<T> atLocale(Locale locale) {
        return new IsMillisecond<>(converter, expected, zone, locale);
    }
}