package org.exparity.hamcrest.date.core;

import java.time.Year;
import java.time.ZoneId;
import java.util.Locale;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is a leap year
 *
 * @author Stewart Bissett
 */
public class IsLeapYear<T> extends TemporalMatcher<T> {

	private final TemporalConverter<T, Year> converter;
	private final Locale locale;
	private final ZoneId zone;

	public IsLeapYear(TemporalConverter<T, Year> converter, ZoneId zone, Locale locale) {
		this.converter = converter;
		this.locale = locale;
		this.zone = zone;
	}

	public IsLeapYear(TemporalConverter<T, Year> converter) {
		this(converter, ZoneId.systemDefault(), Locale.getDefault(Locale.Category.FORMAT));
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDesc) {
		Year actualValue = converter.apply(actual, zone);
		if (!actualValue.isLeap()) {
			mismatchDesc.appendText("the year " + actualValue + " is not a leap year");
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("a leap year");
	}

	@Override
	public TemporalMatcher<T> atZone(ZoneId zone) {
		return new IsLeapYear<>(converter, zone, locale);
	}

}