package org.exparity.hamcrest.date.core;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is on the specified minute
 *
 * @author Stewart Bissett
 */
public class IsMillisecond<T> extends DateMatcher<T> {

	private final int expected;
	private final TemporalAdapter<T> accessor;

	public IsMillisecond(final int expected, final TemporalAdapter<T> accessor) {
		this.expected = expected;
		this.accessor = accessor;
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
		int actualMillis = accessor.asTemporal(actual).get(ChronoField.MILLI_OF_SECOND);
		if (expected == actualMillis) {
			return true;
		} else {
			mismatchDescription.appendText("the date has the millisecond " + actualMillis);
			return false;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the date has the millisecond " + expected);
	}

	@Override
	public DateMatcher<T> atZone(ZoneId zone) {
		return new IsMillisecond<>(expected, (T t) -> ZonedDateTime
			.from(accessor.asTemporal(t)).withZoneSameInstant(zone));
	}

}