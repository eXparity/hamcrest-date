package org.exparity.hamcrest.date;

import java.time.LocalDate;

/**
 * Value object to store a day, month, and year tuple
 *
 * @author Stewart Bissett
 *
 * @deprecated Use {@link LocalDate}
 */
@Deprecated
public class DayMonthYear {

	private final int day, year;
	private final Months month;

	public DayMonthYear(final int day, final Months month, final int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public Months getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public LocalDate toLocalDate() {
		return LocalDate.of(year, month.month(), day);
	}
}
