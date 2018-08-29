package org.exparity.hamcrest.date.core;

import java.time.ZoneId;

import org.hamcrest.Description;

/**
 * A matcher that tests that the actual date is before or the same instant as the reference date
 *
 * @author Stewart Bissett
 */
public class IsSameOrBefore<T> extends DateMatcher<T> {

	private final TemporalWrapper<T> expected;
	private final TemporalFormatter<T> describer;

	public IsSameOrBefore(final TemporalWrapper<T> expected, final TemporalFormatter<T> describer) {
		this.expected = expected;
		this.describer = describer;
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
		if (this.expected.isBefore(actual)) {
			mismatchDescription.appendText("the date is " + this.describer.describe(actual));
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the date is on the same date or before " + this.describer.describe(this.expected.unwrap()));
	}

	@Override
	public DateMatcher<T> atZone(ZoneId zone) {
		return new IsSameOrBefore<>(expected.withZone(zone), describer);
	}

}