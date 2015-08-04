package org.exparity.hamcrest.localdate;

import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.ValueRange;
import java.util.Locale;

import org.hamcrest.Description;

/**
 * A base matcher that tests that the examined date has the maximum value for
 * the given date part
 * 
 * @author Stewart Bissett
 */
public class IsMaximum extends AbstractLocalDateMatcher {

	private final TemporalField datePart;
	private final String datePartName;

	public IsMaximum(final TemporalField datePart) {
		this.datePart = datePart;
		this.datePartName = datePart.getDisplayName(Locale.getDefault());
	}

	@Override
	protected boolean matchesSafely(final LocalDate actual, final Description mismatchDesc) {
		long actualValue = datePart.getFrom(actual);
		ValueRange range = datePart.rangeRefinedBy(actual);
		if (range.getMaximum() == actualValue) {
			return true;
		} else {
			mismatchDesc.appendText("value is " + actualValue + " instead of " + range.getMaximum());
			return false;
		}
	}

	public void describeTo(final Description description) {
		description.appendText("the maximum value of " + datePartName);
	}
}