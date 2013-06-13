
package uk.co.it.modular.hamcrest.date;

import java.util.Calendar;
import java.util.Date;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date has the minimum value for the given date part
 * 
 * @author Stewart Bissett
 */
public class IsMinimumDatePart extends TypeSafeDiagnosingMatcher<Date> {

	/**
	 * Creates a matcher that matches when the examined date has the minimum value for the datePart
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, minimumDatePart(Calendar.MONTH))
	 * </pre>
	 * 
	 * @param datePart
	 *            the part of the reference date to check
	 */
	@Factory
	public static Matcher<Date> minimumDatePart(final int datePart, final String descriptionOfDatepart) {
		return new IsMinimumDatePart(datePart, descriptionOfDatepart);
	}

	private final int datePart;
	private final String datePartName;

	public IsMinimumDatePart(final int datePart, final String datePartName) {
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
		description.appendText("the first " + datePartName + " value");
	}

	private static int extractDatePart(final Date date, final int part) {
		return convertDateToCalendar(date).get(part);
	}

	private static int extractMinimumValue(final Date date, final int part) {
		return convertDateToCalendar(date).getActualMinimum(part);
	}

	private static Calendar convertDateToCalendar(final Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

}