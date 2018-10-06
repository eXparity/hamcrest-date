package org.exparity.hamcrest.date.core;

import java.time.ZoneId;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is on the same year as the
 * reference date
 *
 * @author Stewart Bissett
 */
public class IsYear<T> extends DateMatcher<T> {

	private final TemporalFieldWrapper<T> expected;
	private final TemporalFieldAdapter<T> accessor;
	private final ZoneId zone;

	private IsYear(final TemporalFieldWrapper<T> expected, final TemporalFieldAdapter<T> accessor, final ZoneId zone) {
		this.expected = expected;
		this.accessor = accessor;
		this.zone = zone;
	}

	public IsYear(final TemporalFieldWrapper<T> expected, final TemporalFieldAdapter<T> accessor) {
		this(expected, accessor, ZoneId.systemDefault());
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
		if (!this.expected.isSame(actual)) {
			mismatchDescription.appendText("the date has the year " + accessor.asTemporalField(actual, zone));
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the date has the year " + expected.unwrap());
	}

	@Override
	public DateMatcher<T> atZone(ZoneId zone) {
		return new IsYear<>(expected.withZone(zone), accessor);
	}

}