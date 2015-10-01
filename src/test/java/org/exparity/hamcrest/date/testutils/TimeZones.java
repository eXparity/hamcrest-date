package org.exparity.hamcrest.date.testutils;

import java.util.TimeZone;

/**
 * Static repository of timezone used for testing
 *
 * @author Stewart Bissett
 */
public abstract class TimeZones {

	public static final TimeZone PST_AS_TZ = TimeZone.getTimeZone("PST");
	public static final TimeZone EST_AS_TZ = TimeZone.getTimeZone("EST");
	public static final TimeZone CET_AS_TZ = TimeZone.getTimeZone("CET");
	public static final TimeZone GMT_AS_TZ = TimeZone.getTimeZone("GMT");
	public static final TimeZone UTC_AS_TZ = TimeZone.getTimeZone("UTC");

}
