
package org.exparity.hamcrest.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is a leap year
 * 
 * @author Stewart Bissett
 */
public class IsLeapYear extends TypeSafeDiagnosingMatcher<Date> {

	/**
	 * Creates a matcher that matches when the examined date is a leap year
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isLeapYear());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isLeapYear() {
		return new IsLeapYear();
	}

	@Override
	protected boolean matchesSafely(final Date actual, final Description mismatchDesc) {
		if (isLeapYear(actual)) {
			return true;
		} else {
			mismatchDesc.appendText("a leap year");
			return false;
		}
	}

	public void describeTo(final Description description) {
		description.appendText("a leap year");
	}

	private boolean isLeapYear(final Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if (calendar instanceof GregorianCalendar) {
			return ((GregorianCalendar) calendar).isLeapYear(calendar.get(Calendar.YEAR));
		} else {
			return false;
		}
	}
}