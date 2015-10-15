package org.exparity.hamcrest.date;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;

/**
 * Enumeration of days in a week
 *
 * @author Stewart Bissett
 *
 * @deprecated Use {@link DayOfWeek}
 */
public enum Weekdays {

	MONDAY(Calendar.MONDAY, DayOfWeek.MONDAY),
	TUESDAY(Calendar.TUESDAY, DayOfWeek.TUESDAY),
	WEDNESDAY(Calendar.WEDNESDAY, DayOfWeek.WEDNESDAY),
	THURSDAY(Calendar.THURSDAY, DayOfWeek.THURSDAY),
	FRIDAY(Calendar.FRIDAY, DayOfWeek.FRIDAY),
	SATURDAY(Calendar.SATURDAY, DayOfWeek.SATURDAY),
	SUNDAY(Calendar.SUNDAY, DayOfWeek.SUNDAY);

	private final int calendarDay;
	private final DayOfWeek dayOfWeek;

	private Weekdays(final int calendarDay, final DayOfWeek dayOfWeek) {
		this.calendarDay = calendarDay;
		this.dayOfWeek = dayOfWeek;
	}

	public int getAsCalendarConstant() {
		return calendarDay;
	}

	public String describe() {
		return dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
	}

	public DayOfWeek getAsDayOfWeek() {
		return dayOfWeek;
	}
}
