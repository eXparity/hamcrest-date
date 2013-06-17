/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date;

import java.util.Calendar;
import java.util.Date;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import static uk.co.it.modular.hamcrest.date.IsMinimumDatePart.minimumDatePart;

/**
 * @author Stewart Bissett
 */
public class IsDayOfMonth {

	/**
	 * Creates a matcher that matches when the examined date is on the first day of the month
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isFirstDayOfMonth());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isFirstDayOfMonth() {
		return minimumDatePart(Calendar.DAY_OF_MONTH, "day of month");
	}

	/**
	 * Creates a matcher that matches when the examined date is on the first day of the month
	 * <p/>
	 * For example:
	 * 
	 * <pre>
	 * assertThat(myDate, isLastDayOfMonth());
	 * </pre>
	 */
	@Factory
	public static Matcher<Date> isLastDayOfMonth() {
		return IsMaximumDatePart.maximumDatePart(Calendar.DAY_OF_MONTH, "day of month");
	}

}
