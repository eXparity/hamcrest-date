/*
 * Copyright (c) Modular IT Limited.
 */

package org.exparity.hamcrest.date;

import java.util.Calendar;

/**
 * Enumeration of months in a year
 * 
 * @author Stewart Bissett
 */
public enum Months {

	JAN(Calendar.JANUARY, "January"),
	JANUARY(Calendar.JANUARY, "January"),
	FEB(Calendar.FEBRUARY, "February"),
	FEBRUARY(Calendar.FEBRUARY, "February"),
	MAR(Calendar.MARCH, "March"),
	MARCH(Calendar.MARCH, "March"),
	APR(Calendar.APRIL, "April"),
	APRIL(Calendar.APRIL, "April"),
	MAY(Calendar.MAY, "May"),
	JUN(Calendar.JUNE, "June"),
	JUNE(Calendar.JUNE, "June"),
	JUL(Calendar.JULY, "July"),
	JULY(Calendar.JULY, "July"),
	AUG(Calendar.AUGUST, "August"),
	AUGUST(Calendar.AUGUST, "August"),
	SEP(Calendar.SEPTEMBER, "September"),
	SEPTEMBER(Calendar.SEPTEMBER, "September"),
	OCT(Calendar.OCTOBER, "October"),
	OCTOBER(Calendar.OCTOBER, "October"),
	NOV(Calendar.NOVEMBER, "November"),
	NOVEMBER(Calendar.NOVEMBER, "November"),
	DEC(Calendar.DECEMBER, "December"),
	DECEMBER(Calendar.DECEMBER, "December");

	/**
	 * Factory method to create a Months instance from a java calendar month value
	 */
	public static Months fromCalendar(final int calendarMonth) {
		for (Months month : values()) {
			if (calendarMonth == month.calendarMonth) {
				return month;
			}
		}
		throw new IllegalArgumentException("Unknown calendar month value '" + calendarMonth + "'");
	}

	private final int calendarMonth;;
	private final String description;

	private Months(final int calendarMonth, final String description) {
		this.calendarMonth = calendarMonth;
		this.description = description;
	}

	public int calendarConstant() {
		return calendarMonth;
	}

	public String describe() {
		return description;
	}
}
