package org.exparity.hamcrest.date.core;

import static java.time.temporal.TemporalQueries.localDate;

import java.time.temporal.TemporalAccessor;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is a leap year
 * 
 * @author Stewart Bissett
 */
public class IsLeapYear<T extends TemporalAccessor> extends TypeSafeDiagnosingMatcher<T> {

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDesc) {
		if (actual.query(localDate()).isLeapYear()) {
			return true;
		} else {
			mismatchDesc.appendText("a leap year");
			return false;
		}
	}

	public void describeTo(final Description description) {
		description.appendText("a leap year");
	}
}