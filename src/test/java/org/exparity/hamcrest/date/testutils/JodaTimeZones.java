package org.exparity.hamcrest.date.testutils;

import java.util.TimeZone;

import org.joda.time.DateTimeZone;

public class JodaTimeZones {

	public static final DateTimeZone CET = DateTimeZone.forTimeZone(TimeZone.getTimeZone(ZoneIds.CET));
	public static final DateTimeZone EST = DateTimeZone.forTimeZone(TimeZone.getTimeZone(ZoneIds.EST));
	public static final DateTimeZone UTC = DateTimeZone.forTimeZone(TimeZone.getTimeZone(ZoneIds.UTC));

}
