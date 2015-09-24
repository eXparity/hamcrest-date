package org.exparity.hamcrest.date;

import java.time.Month;
import java.util.Calendar;

/**
 * Enumeration of months in a year
 * 
 * @author Stewart Bissett
 * @deprecated Use {@link Month} enumeration
 */
@Deprecated
public enum Months {

	JAN(Calendar.JANUARY, Month.JANUARY, "January"),
	JANUARY(Calendar.JANUARY, Month.JANUARY, "January"),
	FEB(Calendar.FEBRUARY, Month.FEBRUARY, "February"),
	FEBRUARY(Calendar.FEBRUARY, Month.FEBRUARY, "February"),
	MAR(Calendar.MARCH, Month.MARCH, "March"),
	MARCH(Calendar.MARCH, Month.MARCH, "March"),
	APR(Calendar.APRIL, Month.APRIL, "April"),
	APRIL(Calendar.APRIL, Month.APRIL, "April"),
	MAY(Calendar.MAY, Month.MAY, "May"),
	JUN(Calendar.JUNE, Month.JUNE, "June"),
	JUNE(Calendar.JUNE, Month.JUNE, "June"),
	JUL(Calendar.JULY, Month.JULY, "July"),
	JULY(Calendar.JULY, Month.JULY, "July"),
	AUG(Calendar.AUGUST, Month.AUGUST, "August"),
	AUGUST(Calendar.AUGUST, Month.AUGUST, "August"),
	SEP(Calendar.SEPTEMBER, Month.SEPTEMBER, "September"),
	SEPTEMBER(Calendar.SEPTEMBER, Month.SEPTEMBER, "September"),
	OCT(Calendar.OCTOBER, Month.OCTOBER, "October"),
	OCTOBER(Calendar.OCTOBER, Month.OCTOBER, "October"),
	NOV(Calendar.NOVEMBER, Month.NOVEMBER, "November"),
	NOVEMBER(Calendar.NOVEMBER, Month.NOVEMBER, "November"),
	DEC(Calendar.DECEMBER, Month.DECEMBER, "December"),
	DECEMBER(Calendar.DECEMBER, Month.DECEMBER, "December");

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
	private final Month month;
	private final String description;

	private Months(final int calendarMonth, final Month month, final String description) {
		this.calendarMonth = calendarMonth;
		this.month = month;
		this.description = description;
	}

	public int calendarConstant() {
		return calendarMonth;
	}

	public String describe() {
		return description;
	}
	
	public Month month() {
		return month;
	}
}
