package org.exparity.hamcrest.date.core;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is on the specified hour
 *
 * @author Stewart Bissett
 */
public class IsHour<T> extends DateMatcher<T> {

	private final int expected;
	private final TemporalAdapter<T> accessor;

	public IsHour(final int expected, final TemporalAdapter<T> accessor) {
		this.expected = expected;
		this.accessor = accessor;
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
		int actualHour = accessor.asTemporal(actual).get(ChronoField.HOUR_OF_DAY);
		if (expected == actualHour) {
			return true;
		} else {
			mismatchDescription.appendText("the date has the hour " + actualHour);
			return false;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the date has the hour " + expected);
	}

	@Override
	public DateMatcher<T> atZone(ZoneId zone) {
		return new IsHour<>(expected, (T t) -> ZonedDateTime
			.from(accessor.asTemporal(t)).withZoneSameInstant(zone));
	}

}