package org.exparity.hamcrest.date.core;

import java.time.ZoneId;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is the same as the reference date
 *
 * @author Stewart Bissett
 */
public class IsSame<T> extends DateMatcher<T> {

	private final TemporalWrapper<T> expected;
	private final TemporalFormatter<T> describer;

	public IsSame(final TemporalWrapper<T> expected, final TemporalFormatter<T> describer) {
		this.expected = expected;
		this.describer = describer;
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
		if (!this.expected.isSame(actual)) {
			mismatchDescription.appendText("the date is " + this.describer.describe(actual));
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the same date as " + this.describer.describe(this.expected.unwrap()));
	}

	@Override
	public DateMatcher<T> atZone(ZoneId zone) {
		return new IsSame<>(expected.withZone(zone), describer);
	}

}