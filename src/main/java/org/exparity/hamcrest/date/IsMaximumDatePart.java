
package org.exparity.hamcrest.date;

import java.util.Calendar;
import java.util.Date;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A base matcher that tests that the examined date has the maximum value for the given date part
 * 
 * @author Stewart Bissett
 */
class IsMaximumDatePart extends TypeSafeDiagnosingMatcher<Date> {

	/**
	 * Creates a matcher that matches when the examined date has the maximum value for the datePart
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, maximumDatePart(Calendar.MONTH))
	 * </pre>
	 * 
	 * @param datePart
	 *            the part of the reference date to check
	 * @param descriptionOfDatepart
	 *            the description of the date part under test e.g. "day of month", "week of year", etc
	 */
	@Factory
	public static Matcher<Date> maximumDatePart(final int datePart, final String descriptionOfDatepart) {
		return new IsMaximumDatePart(datePart, descriptionOfDatepart);
	}

	private final int datePart;
	private final String datePartName;

	public IsMaximumDatePart(final int datePart, final String datePartName) {
		this.datePart = datePart;
		this.datePartName = datePartName;
	}

	@Override
	protected boolean matchesSafely(final Date actual, final Description mismatchDesc) {
		int actualDatePart = extractDatePart(actual, datePart);
		int expected = extractMinimumValue(actual, datePart);
		if (expected != actualDatePart) {
			mismatchDesc.appendText(String.valueOf(datePartName)).appendText(" is ").appendValue(actualDatePart);
			return false;
		} else {
			return true;
		}
	}

	public void describeTo(final Description description) {
		description.appendText("the last " + datePartName + " value");
	}

	private static int extractDatePart(final Date date, final int part) {
		return convertDateToCalendar(date).get(part);
	}

	private static int extractMinimumValue(final Date date, final int part) {
		return convertDateToCalendar(date).getActualMaximum(part);
	}

	private static Calendar convertDateToCalendar(final Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

}