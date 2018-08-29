package org.exparity.hamcrest.date.core;

import static java.time.temporal.TemporalQueries.localDate;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is a leap year
 *
 * @author Stewart Bissett
 */
public class IsLeapYear<T> extends DateMatcher<T> {

	private final TemporalAdapter<T> adapter;
	private final TemporalFormatter<T> formatter;

	public IsLeapYear(final TemporalAdapter<T> adapter, final TemporalFormatter<T> formatter) {
		this.adapter = adapter;
		this.formatter = formatter;
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDesc) {
		if (!this.adapter.asTemporal(actual).query(localDate()).isLeapYear()) {
			mismatchDesc.appendText("the date " + this.formatter.describe(actual) + " is not a leap year");
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
	public DateMatcher<T> atZone(ZoneId zone) {
		return new IsLeapYear<>((T t) -> ZonedDateTime
			.from(adapter.asTemporal(t)).withZoneSameInstant(zone), formatter);
	}

}