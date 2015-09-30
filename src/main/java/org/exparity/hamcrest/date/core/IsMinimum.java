package org.exparity.hamcrest.date.core;

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
public class IsMinimum<T> extends TypeSafeDiagnosingMatcher<T> {

	private final TemporalField datePart;
	private final String datePartName;
	private final TemporalAdapter<T> adapter;

	public IsMinimum(final TemporalField datePart, final TemporalAdapter<T> adapter) {
		this.datePart = datePart;
		this.datePartName = datePart.getDisplayName(Locale.getDefault());
		this.adapter = adapter;
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDesc) {
		long actualValue = datePart.getFrom(adapter.asTemporal(actual));
		ValueRange range = datePart.rangeRefinedBy(adapter.asTemporal(actual));
		if (range.getMinimum() == actualValue) {
			return true;
		} else {
			mismatchDesc.appendText("value is " + actualValue + " instead of " + range.getMaximum());
			return false;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the minimum value of " + datePartName);
	}
}