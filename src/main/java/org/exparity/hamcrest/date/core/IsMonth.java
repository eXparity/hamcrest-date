package org.exparity.hamcrest.date.core;

import java.time.ZoneId;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is on the same month of the year
 * as the reference date
 *
 * @author Stewart Bissett
 */
public class IsMonth<T> extends DateMatcher<T> {

	private final TemporalFieldWrapper<T> expected;
	private final TemporalFieldAdapter<T> accessor;
	private final ZoneId zone;

	private IsMonth(final TemporalFieldWrapper<T> expected, final TemporalFieldAdapter<T> accessor, final ZoneId zone) {
		this.expected = expected;
		this.accessor = accessor;
		this.zone = zone;
	}

	public IsMonth(final TemporalFieldWrapper<T> expected, final TemporalFieldAdapter<T> accessor) {
		this(expected, accessor, ZoneId.systemDefault());
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
		if (!this.expected.isSame(actual)) {
			mismatchDescription.appendText("the date has the month " + accessor.asTemporalField(actual, zone));
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the date has the month " + expected.unwrap());
	}

	@Override
	public DateMatcher<T> atZone(ZoneId zone) {
		return new IsMonth<>(expected.withZone(zone), accessor);
	}

}