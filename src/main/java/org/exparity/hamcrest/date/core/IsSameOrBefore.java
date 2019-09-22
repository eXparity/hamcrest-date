package org.exparity.hamcrest.date.core;

import java.time.ZoneId;
import java.util.Locale;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is before or the same instant as
 * the reference date
 *
 * @author Stewart Bissett
 */
public class IsSameOrBefore<T,E> extends TemporalMatcher<T> {

	private final TemporalProvider<E> expected;
	private final TemporalConverter<T, E> converter;
	private final TemporalFunction<E> functions;
	private final Locale locale;
	private final ZoneId zone;

	public IsSameOrBefore(TemporalConverter<T, E> converter,
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

	public IsSameOrBefore(TemporalConverter<T, E> converter, TemporalProvider<E> expected, TemporalFunction<E> functions) {
		this(converter, expected, functions, ZoneId.systemDefault(), Locale.getDefault(Locale.Category.FORMAT));
	}
	
	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
		E expectedValue = expected.apply(zone), actualValue = converter.apply(actual, zone);
		if (functions.isBefore(expectedValue, actualValue) ) {
			mismatchDescription.appendText("the date is " + functions.describe(actualValue, locale));
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the date is on the same date or before " + functions.describe(expected.apply(zone), locale));
	}

	@Override
	public TemporalMatcher<T> atZone(ZoneId zone) {
		return new IsSameOrBefore<>(converter, expected, functions, zone, locale);
	}
	
    @Override
    public TemporalMatcher<T> atLocale(Locale locale) {
        return new IsSameOrBefore<>(converter, expected, functions, zone, locale);
    }
}