package org.exparity.hamcrest.date.core;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Locale;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is the same date as the reference
 * date
 *
 * @author Stewart Bissett
 */
public class IsSameDay<T> extends TemporalMatcher<T> {

	private final TemporalProvider<LocalDate> expected;
	private final TemporalConverter<T, LocalDate> converter;
	private final Locale locale;
	private final ZoneId zone;

	public IsSameDay(TemporalConverter<T, LocalDate> converter,
	        TemporalProvider<LocalDate> expected,
	        ZoneId zone,
	        Locale locale) {
		this.expected = expected;
		this.converter = converter;
		this.locale = locale;
		this.zone = zone;
	}

	public IsSameDay(TemporalConverter<T, LocalDate> converter, TemporalProvider<LocalDate> expected) {
		this(converter, expected, ZoneId.systemDefault(), Locale.getDefault(Locale.Category.FORMAT));
	}
	
	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
		LocalDate expectedValue = expected.apply(zone), actualValue = converter.apply(actual, zone);
		if (!expectedValue.isEqual(actualValue)) {
			mismatchDescription.appendText("the day is " + describe(actualValue));
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the same day as " + describe(expected.apply(zone)));
	}

	@Override
	public TemporalMatcher<T> atZone(ZoneId zone) {
		return new IsSameDay<>(converter, expected, zone, locale);
	}
	
	private String describe(LocalDate actualValue) {
		return TemporalFunctions.LOCALDATE.describe(actualValue, locale);
	}

}