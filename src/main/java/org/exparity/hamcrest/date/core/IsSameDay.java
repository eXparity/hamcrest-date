package org.exparity.hamcrest.date.core;

import java.time.ZoneId;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is the same date as the reference
 * date
 *
 * @author Stewart Bissett
 */
public class IsSameDay<T> extends DateMatcher<T> {

	private final TemporalWrapper<T> expected;
	private final TemporalFormatter<T> describer;

	public IsSameDay(final TemporalWrapper<T> expected, final TemporalFormatter<T> describer) {
		this.expected = expected;
		this.describer = describer;
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDesc) {
		if (!this.expected.isSameDay(actual)) {
			mismatchDesc.appendText("the day is " + this.describer.describeDate(actual));
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the same day as " + this.describer.describeDate(this.expected.unwrap()));
	}

	@Override
	public DateMatcher<T> atZone(ZoneId zone) {
		return new IsSameDay<>(expected.withZone(zone), describer);
	}

}