
package org.exparity.hamcrest.date;

import java.util.Calendar;
import java.util.Date;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/**
 * A matcher that tests that the examined date is on the same year as the reference date
 * 
 * @author Stewart Bissett
 */
public class IsSameYear extends IsSameDateField {

	public IsSameYear(final Date date) {
		super(date, Calendar.YEAR, "year", "yyyy");
	}

	public IsSameYear(final int year) {
		super(year, String.valueOf(year), Calendar.YEAR, "year", "yyyy");
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same year as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameYear(new Date()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	@Factory
	public static Matcher<Date> sameYear(final Date date) {
		return new IsSameYear(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same year as the reference year
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameYear(2013))
	 * </pre>
	 * 
	 * @param year
	 *            the reference year against which the examined date is checked
	 */
	@Factory
	public static Matcher<Date> sameYear(final int year) {
		return new IsSameYear(year);
	}

}