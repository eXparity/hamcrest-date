package org.exparity.hamcrest.date.core;

import java.time.ZoneId;
import java.util.Locale;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is the same as the reference date
 *
 * @author Stewart Bissett
 */
public class IsSame<T, E> extends DateMatcher<T> {

	private final TemporalProvider<E> expected;
	private final TemporalConverter<T, E> converter;
	private final TemporalFunction<E> functions;
	private final Locale locale;
	private final ZoneId zone;

	public IsSame(TemporalConverter<T, E> converter,
	        TemporalProvider<E> expected,
	        TemporalFunction<E> functions,
	        ZoneId zone,
	        Locale locale) {
		this.expected = expected;
		this.converter = converter;
		this.functions = functions;
		this.locale = locale;
		this.zone = zone;
	}

	public IsSame(TemporalConverter<T, E> converter, TemporalProvider<E> expected, TemporalFunction<E> functions) {
		this(converter, expected, functions, ZoneId.systemDefault(), Locale.getDefault(Locale.Category.FORMAT));
	}
	
	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
		E expectedValue = expected.apply(zone), actualValue = converter.apply(actual, zone);
		if (!functions.isSame(expectedValue, actualValue)) {
			mismatchDescription.appendText("the date is " + functions.describe(actualValue, locale));
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the same date as " + functions.describe(expected.apply(zone), locale));
	}

	@Override
	public DateMatcher<T> atZone(ZoneId zone) {
		return new IsSame<>(converter, expected, functions, zone, locale);
	}

}