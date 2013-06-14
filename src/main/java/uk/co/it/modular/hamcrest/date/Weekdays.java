/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date;

import java.util.Calendar;

/**
 * Enumeration of days in a week
 * 
 * @author Stewart Bissett
 */
public enum Weekdays {

	MONDAY(Calendar.MONDAY),
	TUESDAY(Calendar.TUESDAY),
	WEDNESDAY(Calendar.WEDNESDAY),
	THURSDAY(Calendar.THURSDAY),
	FRIDAY(Calendar.FRIDAY),
	SATURDAY(Calendar.SATURDAY),
	SUNDAY(Calendar.SUNDAY);

	private final int calendarDay;

	private Weekdays(final int calendarDay) {
		this.calendarDay = calendarDay;
	}

	public int getAsCalendarConstant() {
		return calendarDay;
	}

	public String describe() {
		return name().toLowerCase();
	}
}
