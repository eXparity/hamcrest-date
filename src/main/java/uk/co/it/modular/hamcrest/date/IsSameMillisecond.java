
package uk.co.it.modular.hamcrest.date;

import java.util.Calendar;
import java.util.Date;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/**
 * A matcher that tests that the examined date is on the same second as the reference date
 * 
 * @author Stewart Bissett
 */
public class IsSameMillisecond extends IsSameDatePart {

	public IsSameMillisecond(final Date date) {
		super(date, Calendar.MILLISECOND, "millisecond", "S");
	}

	public IsSameMillisecond(final int millisecond) {
		super(millisecond, String.valueOf(millisecond), Calendar.MILLISECOND, "millisecond", "S");
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same millisecond as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameMillisecond(new Date()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	@Factory
	public static Matcher<Date> sameMillisecond(final Date date) {
		return new IsSameMillisecond(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the reference second
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameMillisecond(123))
	 * </pre>
	 * 
	 * @param millisecond
	 *            the millisecond against which the examined date is checked
	 */
	@Factory
	public static Matcher<Date> sameMillisecond(final int millisecond) {
		return new IsSameMillisecond(millisecond);
	}
}