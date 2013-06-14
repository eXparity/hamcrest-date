
package uk.co.it.modular.hamcrest.date;

import java.util.Calendar;
import java.util.Date;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/**
 * A matcher that tests that the examined date is on the same month as the reference date
 * 
 * @author Stewart Bissett
 */
public class IsSameMonth extends IsSameDatePart {

	/**
	 * Creates a matcher that matches when the examined date is on the same month as the reference date
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameMonth(new Date()))
	 * </pre>
	 * 
	 * @param date
	 *            the reference date against which the examined date is checked
	 */
	@Factory
	public static Matcher<Date> sameMonth(final Date date) {
		return new IsSameMonth(date);
	}

	/**
	 * Creates a matcher that matches when the examined date is on the same month as the reference month
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, sameMonth(Months.DECEMBER))
	 * </pre>
	 * 
	 * @param month
	 *            the reference month against which the examined date is checked
	 */
	@Factory
	public static Matcher<Date> sameMonth(final Months month) {
		return new IsSameMonth(month);
	}

	/**
	 * Creates a matcher that matches when the examined date is in January
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isJanuary());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isJanuary() {
		return sameMonth(Months.JANUARY);
	}

	/**
	 * Creates a matcher that matches when the examined date is in February
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isFebruary());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isFebruary() {
		return sameMonth(Months.FEBRUARY);
	}

	/**
	 * Creates a matcher that matches when the examined date is in March
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isMarch());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isMarch() {
		return sameMonth(Months.MARCH);
	}

	/**
	 * Creates a matcher that matches when the examined date is in April
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isApril());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isApril() {
		return sameMonth(Months.APRIL);
	}

	/**
	 * Creates a matcher that matches when the examined date is in May
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isMay());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isMay() {
		return sameMonth(Months.MAY);
	}

	/**
	 * Creates a matcher that matches when the examined date is in June
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isJune());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isJune() {
		return sameMonth(Months.JUNE);
	}

	/**
	 * Creates a matcher that matches when the examined date is in July
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isJuly());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isJuly() {
		return sameMonth(Months.JULY);
	}

	/**
	 * Creates a matcher that matches when the examined date is in August
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isAugust());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isAugust() {
		return sameMonth(Months.AUGUST);
	}

	/**
	 * Creates a matcher that matches when the examined date is in September
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isSeptember());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isSeptember() {
		return sameMonth(Months.SEPTEMBER);
	}

	/**
	 * Creates a matcher that matches when the examined date is in October
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isOctober());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isOctober() {
		return sameMonth(Months.OCTOBER);
	}

	/**
	 * Creates a matcher that matches when the examined date is in November
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isNovember());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isNovember() {
		return sameMonth(Months.NOVEMBER);
	}

	/**
	 * Creates a matcher that matches when the examined date is in December
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isDecember());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isDecember() {
		return sameMonth(Months.DECEMBER);
	}

	public IsSameMonth(final Date date) {
		super(date, Calendar.MONTH, "month", "MMMMM");
	}

	public IsSameMonth(final Months month) {
		super(month.calendarConstant(), month.describe(), Calendar.MONTH, "month", "MMMMM");
	}

}