/*
 * Copyright (c) Modular IT Limited.
 */

package org.exparity.hamcrest.date.testutils;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.exparity.hamcrest.date.Months;

/**
 * Static repository of dates used for testing
 * 
 * @author Stewart Bissett
 */
public abstract class Dates {

	public static final Date JAN_1ST_2000_11_AM_GMT = createDate(2000, Months.JAN, 1, 11, 00, 00, TimeZones.GMT);
	public static final Date JAN_1ST_2012_11_AM_GMT = createDate(2012, Months.JAN, 1, 11, 00, 00, TimeZones.GMT);
	public static final Date JAN_1ST_2012_11_PM_GMT = createDate(2012, Months.JAN, 1, 23, 00, 00, TimeZones.GMT);
	public static final Date JAN_1ST_2012_11_AM_PST = createDate(2012, Months.JAN, 1, 11, 00, 00, TimeZones.PST);
	public static final Date JAN_1ST_2012_11_PM_PST = createDate(2012, Months.JAN, 1, 23, 00, 00, TimeZones.PST);
	public static final Date JAN_2ND_2012_11_AM_GMT = createDate(2012, Months.JAN, 2, 11, 00, 00, TimeZones.GMT);
	public static final Date JAN_3RD_2012_11_AM_GMT = createDate(2012, Months.JAN, 3, 11, 00, 00, TimeZones.GMT);
	public static final Date JAN_4TH_2012_11_AM_GMT = createDate(2012, Months.JAN, 4, 11, 00, 00, TimeZones.GMT);
	public static final Date JAN_5TH_2012_11_AM_GMT = createDate(2012, Months.JAN, 5, 11, 00, 00, TimeZones.GMT);
	public static final Date JAN_6TH_2012_11_AM_GMT = createDate(2012, Months.JAN, 6, 11, 00, 00, TimeZones.GMT);
	public static final Date JAN_7TH_2012_11_AM_GMT = createDate(2012, Months.JAN, 7, 11, 00, 00, TimeZones.GMT);
	public static final Date JAN_8TH_2012_11_AM_GMT = createDate(2012, Months.JAN, 8, 11, 00, 00, TimeZones.GMT);
	public static final Date JAN_31ST_2012_11_AM_GMT = createDate(2012, Months.JAN, 31, 11, 00, 00);
	public static final Date FEB_1ST_2012_11_AM_GMT = createDate(2012, Months.FEB, 1, 11, 00, 00, TimeZones.GMT);
	public static final Date MAR_1ST_2012_11_AM_GMT = createDate(2012, Months.MAR, 1, 11, 00, 00, TimeZones.GMT);
	public static final Date APR_1ST_2012_11_AM_GMT = createDate(2012, Months.APR, 1, 11, 00, 00, TimeZones.GMT);
	public static final Date MAY_1ST_2012_11_AM_GMT = createDate(2012, Months.MAY, 1, 11, 00, 00, TimeZones.GMT);
	public static final Date JUN_1ST_2012_11_AM_GMT = createDate(2012, Months.JUN, 1, 11, 00, 00, TimeZones.GMT);
	public static final Date JUN_15TH_2012_11_AM = Dates.createDate(2012, Months.JUN, 15, 11, 00, 00);
	public static final Date JUN_15TH_2012_11_PM = Dates.createDate(2012, Months.JUN, 15, 23, 00, 00);
	public static final Date JUL_1ST_2012_11_AM_GMT = createDate(2012, Months.JUL, 1, 11, 00, 00, TimeZones.GMT);
	public static final Date AUG_1ST_2012_11_AM_GMT = createDate(2012, Months.AUG, 1, 11, 00, 00, TimeZones.GMT);
	public static final Date SEP_1ST_2012_11_AM_GMT = createDate(2012, Months.SEP, 1, 11, 00, 00, TimeZones.GMT);
	public static final Date OCT_1ST_2012_11_AM_GMT = createDate(2012, Months.OCT, 1, 11, 00, 00, TimeZones.GMT);
	public static final Date NOV_1ST_2012_11_AM_GMT = createDate(2012, Months.NOV, 1, 11, 00, 00, TimeZones.GMT);
	public static final Date DEC_1ST_2012_11_AM_GMT = createDate(2012, Months.DEC, 1, 11, 00, 00, TimeZones.GMT);
	public static final Date JAN_1ST_2013_11_AM_GMT = createDate(2013, Months.JAN, 1, 11, 00, 00, TimeZones.GMT);
	public static final Date JAN_1ST_2100_11_AM_GMT = createDate(2100, Months.JAN, 1, 11, 00, 00, TimeZones.GMT);

	public static Date createDate(final int year, final Months month, final int day, final int hour, final int minute, final int second) {
		return Dates.createDate(year, month, day, hour, minute, second, TimeZone.getDefault());
	}

	public static Date createDate(final int year, final Months month, final int date, final int hour, final int minute, final int second, final TimeZone tz) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeZone(tz);
		cal.set(year, month.calendarConstant(), date, hour, minute, second);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

}
