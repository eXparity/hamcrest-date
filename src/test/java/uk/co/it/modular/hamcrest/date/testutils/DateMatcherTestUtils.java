/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date.testutils;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import uk.co.it.modular.hamcrest.date.Month;

/**
 * Utility class for manipulating dates
 * 
 * @author Stewart Bissett
 */
public abstract class DateMatcherTestUtils {

	public static final TimeZone PST = TimeZone.getTimeZone("PST");
	public static final TimeZone GMT = TimeZone.getTimeZone("GMT");

	public static final Date JAN_1ST_2012_11_AM_GMT = createDate(2012, Month.JAN, 1, 11, 00, 00, GMT);
	public static final Date JAN_1ST_2012_11_PM_GMT = createDate(2012, Month.JAN, 1, 23, 00, 00, GMT);
	public static final Date JAN_2ND_2012_11_AM_GMT = createDate(2012, Month.JAN, 2, 23, 00, 00, GMT);

	public static final Date JAN_1ST_2012_11_AM_PST = createDate(2012, Month.JAN, 1, 11, 00, 00, PST);
	public static final Date JAN_1ST_2012_11_PM_PST = createDate(2012, Month.JAN, 1, 23, 00, 00, PST);

	public static Date addDateField(final Date date, final int field, final int duration) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(field, duration);
		return cal.getTime();
	}

	public static Date createDate(final int year, final Month month, final int day, final int hour, final int minute, final int second) {
		return createDate(year, month, day, hour, minute, second, TimeZone.getDefault());
	}

	public static Date createDate(final int year, final Month month, final int date, final int hour, final int minute, final int second, final TimeZone tz) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeZone(tz);
		cal.set(year, month.getAsCalendarConstant(), date, hour, minute, second);
		return cal.getTime();
	}
}
