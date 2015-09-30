package org.exparity.hamcrest.date;

import static org.exparity.hamcrest.date.Months.fromCalendar;

import java.util.Calendar;
import java.util.Date;

/**
 * Static factory to create moments in time such as now, today, tomorrow, etc
 *
 * @author Stewart Bissett
 */
public abstract class Moments {

	/**
	 * Return a {@link Date} instance representing now down to millisecond
	 * accuracy
	 */
	public static Date now() {
		return new Date();
	}

	/**
	 * Return a {@link DayMonthYear} instance representing yesterday
	 */
	public static DayMonthYear yesterday() {
		return aRelativeDayMonthYear(-1, Calendar.DAY_OF_MONTH);
	}

	/**
	 * Return a {@link DayMonthYear} instance representing today
	 */
	public static DayMonthYear today() {
		return aRelativeDayMonthYear(0, Calendar.DAY_OF_MONTH);
	}

	/**
	 * Return a {@link DayMonthYear} instance representing tomorrow
	 */
	public static DayMonthYear tomorrow() {
		return aRelativeDayMonthYear(1, Calendar.DAY_OF_MONTH);
	}

	private static DayMonthYear aRelativeDayMonthYear(final int adjustment, final int datePart) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(datePart, adjustment);
		return new DayMonthYear(
		        calendar.get(datePart),
		            fromCalendar(calendar.get(Calendar.MONTH)),
		            calendar.get(Calendar.YEAR));
	}

}
