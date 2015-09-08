package org.exparity.hamcrest.date.core;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is a leap year
 * 
 * @author Stewart Bissett
 */
public class IsLeapYear<T extends ChronoLocalDate> extends TypeSafeDiagnosingMatcher<T> {

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDesc) {
		if (actual.isLeapYear()) {
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