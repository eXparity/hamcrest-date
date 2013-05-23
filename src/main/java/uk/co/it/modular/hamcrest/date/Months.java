/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date;

import java.util.Calendar;

/**
 * Enumeration of months in a year
 * 
 * @author Stewart Bissett
 */
public enum Months {

	JAN(Calendar.JANUARY),
	JANUARY(Calendar.JANUARY),
	FEB(Calendar.FEBRUARY),
	FEBRUARY(Calendar.FEBRUARY),
	MAR(Calendar.MARCH),
	MARCH(Calendar.MARCH),
	APR(Calendar.APRIL),
	APRIL(Calendar.APRIL),
	MAY(Calendar.MAY),
	JUN(Calendar.JUNE),
	JUNE(Calendar.JUNE),
	JUL(Calendar.JULY),
	JULY(Calendar.JULY),
	AUG(Calendar.AUGUST),
	AUGUST(Calendar.AUGUST),
	SEP(Calendar.SEPTEMBER),
	SEPTEMBER(Calendar.SEPTEMBER),
	OCT(Calendar.OCTOBER),
	OCTOBER(Calendar.OCTOBER),
	NOV(Calendar.NOVEMBER),
	NOVEMBER(Calendar.NOVEMBER),
	DEC(Calendar.DECEMBER),
	DECEMBER(Calendar.DECEMBER);

	private final int calendarMonth;;

	private Months(final int calendarMonth) {
		this.calendarMonth = calendarMonth;
	}

	public int getAsCalendarConstant() {
		return calendarMonth;
	}
}
