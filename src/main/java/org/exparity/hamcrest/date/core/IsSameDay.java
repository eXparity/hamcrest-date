package org.exparity.hamcrest.date.core;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is the same date as the reference
 * date
 * 
 * @author Stewart Bissett
 */
public class IsSameDay<T> extends TypeSafeDiagnosingMatcher<T> {

	private final TemporalWrapper<T> expected;
	private final TemporalFormatter<T> describer;

	public IsSameDay(TemporalWrapper<T> expected, TemporalFormatter<T> describer) {
		this.expected = expected;
		this.describer = describer;
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDesc) {
		if (expected.isSameDay(actual)) {
			return true;
		} else {
			mismatchDesc.appendText("date is " + describer.describe(expected.unwrap()));
			return false;
		}
	}

	public void describeTo(final Description description) {
		description.appendText("the same date as " + describer.describe(expected.unwrap()));
	}
}