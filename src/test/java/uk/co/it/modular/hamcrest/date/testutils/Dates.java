/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date.testutils;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import uk.co.it.modular.hamcrest.date.Months;

/**
 * Static repository of dates used for testing
 * 
 * @author Stewart Bissett
 */
public abstract class Dates {

	public static final Date JAN_1ST_2012_11_AM_GMT = Dates.createDate(2012, Months.JAN, 1, 11, 00, 00, TimeZones.GMT);
	public static final Date JAN_1ST_2012_11_PM_GMT = Dates.createDate(2012, Months.JAN, 1, 23, 00, 00, TimeZones.GMT);
	public static final Date JAN_2ND_2012_11_AM_GMT = Dates.createDate(2012, Months.JAN, 2, 23, 00, 00, TimeZones.GMT);
	public static final Date JAN_1ST_2012_11_AM_PST = Dates.createDate(2012, Months.JAN, 1, 11, 00, 00, TimeZones.PST);
	public static final Date JAN_1ST_2012_11_PM_PST = Dates.createDate(2012, Months.JAN, 1, 23, 00, 00, TimeZones.PST);

	public static final Date JUN_15TH_2012_11_AM = Dates.createDate(2012, Months.JUN, 15, 11, 00, 00);
	public static final Date JUN_15TH_2012_11_PM = Dates.createDate(2012, Months.JUN, 15, 23, 00, 00);

	public static Date createDate(final int year, final Months month, final int day, final int hour, final int minute, final int second) {
		return Dates.createDate(year, month, day, hour, minute, second, TimeZone.getDefault());
	}

	public static Date createDate(final int year, final Months month, final int date, final int hour, final int minute, final int second, final TimeZone tz) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeZone(tz);
		cal.set(year, month.getAsCalendarConstant(), date, hour, minute, second);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

}
