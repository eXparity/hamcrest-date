package org.exparity.hamcrest.date.core;

import static java.time.temporal.TemporalQueries.localDate;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is a leap year
 *
 * @author Stewart Bissett
 */
public class IsLeapYear<T> extends TypeSafeDiagnosingMatcher<T> {

	private final TemporalAdapter<T> adapter;

	public IsLeapYear(final TemporalAdapter<T> adapter) {
		this.adapter = adapter;
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDesc) {
		if (adapter.asTemporal(actual).query(localDate()).isLeapYear()) {
			return true;
		} else {
			mismatchDesc.appendText("a leap year");
			return false;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("a leap year");
	}
}