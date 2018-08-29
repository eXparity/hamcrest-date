package org.exparity.hamcrest.date.core;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is on the same year as the
 * reference date
 *
 * @author Stewart Bissett
 */
public class IsYear<T> extends DateMatcher<T> {

	private final int expected;
	private final TemporalAdapter<T> accessor;

	public IsYear(final int expected, final TemporalAdapter<T> accessor) {
		this.expected = expected;
		this.accessor = accessor;
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
		int actualYear = this.accessor.asTemporal(actual).get(ChronoField.YEAR);
		if (this.expected != actualYear) {
			mismatchDescription.appendText("the date has the year " + actualYear);
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the date is in the year " + this.expected);
	}

	@Override
	public DateMatcher<T> atZone(ZoneId zone) {
		return new IsYear<>(expected, (T t) -> ZonedDateTime.from(accessor.asTemporal(t)).withZoneSameInstant(zone));
	}

}