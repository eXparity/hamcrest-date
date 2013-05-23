
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

	private final Date expectedDate;
	private final int datePart;
	private final int expected;
	private final String datePartLabel;

	public IsSameDatePart(final Date date, final int datePart, final String datePartLabel) {
		this.expectedDate = date;
		this.datePart = datePart;
		this.expected = extractDatePart(date, datePart);
		this.datePartLabel = datePartLabel;
	}

	public IsSameDatePart(final Date date, final int datePart) {
		this(date, datePart, "date part " + datePart);
	}

	@Override
	protected boolean matchesSafely(final Date actual, final Description mismatchDesc) {
		int actualDatePart = extractDatePart(actual, datePart);
		if (expected != actualDatePart) {
			mismatchDesc.appendText(String.valueOf(datePartLabel)).appendText(" is ").appendValue(describeDate(actual));
			return false;
		} else {
			return true;
		}
	}

	public void describeTo(final Description description) {
		description.appendText("the same ").appendText(datePartLabel).appendText(" value as ").appendValue(describeDate(expectedDate));
	}

	private String describeDate(final Date date) {
		return date.toString();
	}

	private int extractDatePart(final Date date, final int part) {
		return convertDateToCalendar(date).get(part);
	}

	private Calendar convertDateToCalendar(final Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

}