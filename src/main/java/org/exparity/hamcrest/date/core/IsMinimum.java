package org.exparity.hamcrest.date.core;

import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.time.temporal.ValueRange;
import java.util.Locale;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A base matcher that tests that the examined date has the minimum value for
 * the given date part
 * 
 * @author Stewart Bissett
 */
public class IsMinimum<T extends TemporalAccessor> extends TypeSafeDiagnosingMatcher<T> {

	private final TemporalField datePart;
	private final String datePartName;

	public IsMinimum(final TemporalField datePart) {
		this.datePart = datePart;
		this.datePartName = datePart.getDisplayName(Locale.getDefault());
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDesc) {
		long actualValue = datePart.getFrom(actual);
		ValueRange range = datePart.rangeRefinedBy(actual);
		if (range.getMinimum() == actualValue) {
			return true;
		} else {
			mismatchDesc.appendText("value is " + actualValue + " instead of " + range.getMaximum());
			return false;
		}
	}

	public void describeTo(final Description description) {
		description.appendText("the minimum value of " + datePartName);
	}
}