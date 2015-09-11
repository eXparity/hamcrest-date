package org.exparity.hamcrest.date.core;

import java.time.temporal.Temporal;
import java.time.temporal.TemporalQueries;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is the same date as the reference
 * date
 * 
 * @author Stewart Bissett
 */
public class IsSameDay<T extends Temporal> extends TypeSafeDiagnosingMatcher<T> {

	private final T expected;

	public IsSameDay(final T expected) {
		this.expected = expected;
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDesc) {
		if (expected.query(TemporalQueries.localDate()).equals(actual.query(TemporalQueries.localDate()))) {
			return true;
		} else {
			mismatchDesc.appendText("date is " + actual);
			return false;
		}
	}

	public void describeTo(final Description description) {
		description.appendText("the same date as " + expected);
	}
}