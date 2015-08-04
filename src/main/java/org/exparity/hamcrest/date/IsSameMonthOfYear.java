
package org.exparity.hamcrest.date;

import java.util.Calendar;
import java.util.Date;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

/**
 * A matcher that tests that the examined date is on the same month as the reference date
 * 
 * @author Stewart Bissett
 */
public class IsSameMonthOfYear extends IsSameDateField {

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
	public static Matcher<Date> sameMonthOfYear(final Date date) {
		return new IsSameMonthOfYear(date);
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
	public static Matcher<Date> sameMonthOfYear(final Months month) {
		return new IsSameMonthOfYear(month);
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
		return sameMonthOfYear(Months.JANUARY);
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
		return sameMonthOfYear(Months.FEBRUARY);
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
		return sameMonthOfYear(Months.MARCH);
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
		return sameMonthOfYear(Months.APRIL);
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
		return sameMonthOfYear(Months.MAY);
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
		return sameMonthOfYear(Months.JUNE);
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
		return sameMonthOfYear(Months.JULY);
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
		return sameMonthOfYear(Months.AUGUST);
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
		return sameMonthOfYear(Months.SEPTEMBER);
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
		return sameMonthOfYear(Months.OCTOBER);
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
		return sameMonthOfYear(Months.NOVEMBER);
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
		return sameMonthOfYear(Months.DECEMBER);
	}

	public IsSameMonthOfYear(final Date date) {
		super(date, Calendar.MONTH, "month", "MMMMM");
	}

	public IsSameMonthOfYear(final Months month) {
		super(month.calendarConstant(), month.describe(), Calendar.MONTH, "month", "MMMMM");
	}

}