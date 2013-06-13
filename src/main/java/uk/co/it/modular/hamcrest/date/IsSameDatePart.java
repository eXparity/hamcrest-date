
package uk.co.it.modular.hamcrest.date;

import java.util.Calendar;
import java.util.Date;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date has the same date part as the reference date
 * 
 * @author Stewart Bissett
 */
public class IsSameDatePart extends TypeSafeDiagnosingMatcher<Date> {

	/**
	 * Creates a matcher that matches when the examined date matches the date part on the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameDatePart(new Date(), Calendar.MONTH))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 * @param datePart
	 *            the part of the reference date to check
	 */
	@Factory
	public static Matcher<Date> sameDatePart(final Date date, final int datePart) {
		return new IsSameDatePart(date, datePart);
	}

	/**
	 * Creates a matcher that matches when the examined date matches the date part on the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameDatePart(11, Calendar.MONTH))
	 * </pre>
	 * 
	 * @param expectedValue
	 *            the reference date part value against which the examined date is checked
	 * @param datePart
	 *            the part of the reference date to check
	 */
	@Factory
	public static Matcher<Date> sameDatePart(final int expectedValue, final int datePart) {
		return new IsSameDatePart(expectedValue, datePart);
	}

	private final int datePart;
	private final int expected;
	private final String datePartLabel;

	public IsSameDatePart(final int expectedValue, final int datePart, final String datePartLabel) {
		this.datePart = datePart;
		this.expected = expectedValue;
		this.datePartLabel = datePartLabel;
	}

	public IsSameDatePart(final Date date, final int datePart, final String datePartLabel) {
		this(extractDatePart(date, datePart), datePart, datePartLabel);
	}

	public IsSameDatePart(final Date date, final int datePart) {
		this(extractDatePart(date, datePart), datePart);
	}

	public IsSameDatePart(final int expectedValue, final int datePart) {
		this(expectedValue, datePart, "date part " + datePart);
	}

	@Override
	protected boolean matchesSafely(final Date actual, final Description mismatchDesc) {
		int actualDatePart = extractDatePart(actual, datePart);
		if (expected != actualDatePart) {
			mismatchDesc.appendText(String.valueOf(datePartLabel)).appendText(" is ").appendValue(actualDatePart);
			return false;
		} else {
			return true;
		}
	}

	public void describeTo(final Description description) {
		description.appendText("a ").appendText(datePartLabel).appendText(" of ").appendValue(expected);
	}

	private static int extractDatePart(final Date date, final int part) {
		return convertDateToCalendar(date).get(part);
	}

	private static Calendar convertDateToCalendar(final Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

}