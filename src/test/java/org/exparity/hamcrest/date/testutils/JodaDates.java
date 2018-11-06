package org.exparity.hamcrest.date.testutils;

import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;

public class JodaDates {

	public static final LocalTime NOON = new org.joda.time.LocalTime(12, 0);
	public static final LocalTime MIDN = new org.joda.time.LocalTime(0, 0);

	// Joda LocalDate
	public static final LocalDate JAN_01_2012 = new LocalDate(2012, DateTimeConstants.JANUARY, 1);
	public static final LocalDate JUN_14_2012 = new LocalDate(2012, DateTimeConstants.JUNE, 14);
	public static final LocalDate JUN_15_2012 = new LocalDate(2012, DateTimeConstants.JUNE, 15);
	public static final LocalDate JUN_16_2012 = new LocalDate(2012, DateTimeConstants.JUNE, 16);
	public static final LocalDate JAN_01_2015 = new LocalDate(2015, DateTimeConstants.JANUARY, 1);
	public static final LocalDate FEB_01_2015 = new LocalDate(2015, DateTimeConstants.FEBRUARY, 1);
	public static final LocalDate MAR_01_2015 = new LocalDate(2015, DateTimeConstants.MARCH, 1);
	public static final LocalDate APR_01_2015 = new LocalDate(2015, DateTimeConstants.APRIL, 1);
	public static final LocalDate MAY_01_2015 = new LocalDate(2015, DateTimeConstants.MAY, 1);
	public static final LocalDate JUN_01_2015 = new LocalDate(2015, DateTimeConstants.JUNE, 1);
	public static final LocalDate JUL_01_2015 = new LocalDate(2015, DateTimeConstants.JULY, 1);
	public static final LocalDate AUG_01_2015 = new LocalDate(2015, DateTimeConstants.AUGUST, 1);
	public static final LocalDate AUG_03_2015 = new LocalDate(2015, DateTimeConstants.AUGUST, 3);
	public static final LocalDate AUG_04_2015 = new LocalDate(2015, DateTimeConstants.AUGUST, 4);
	public static final LocalDate AUG_05_2015 = new LocalDate(2015, DateTimeConstants.AUGUST, 5);
	public static final LocalDate AUG_06_2015 = new LocalDate(2015, DateTimeConstants.AUGUST, 6);
	public static final LocalDate AUG_07_2015 = new LocalDate(2015, DateTimeConstants.AUGUST, 7);
	public static final LocalDate AUG_08_2015 = new LocalDate(2015, DateTimeConstants.AUGUST, 8);
	public static final LocalDate AUG_09_2015 = new LocalDate(2015, DateTimeConstants.AUGUST, 9);
	public static final LocalDate AUG_31_2015 = new LocalDate(2015, DateTimeConstants.AUGUST, 31);
	public static final LocalDate SEP_04_2015 = new LocalDate(2015, DateTimeConstants.SEPTEMBER, 4);
	public static final LocalDate SEP_30_2015 = new LocalDate(2015, DateTimeConstants.SEPTEMBER, 30);
	public static final LocalDate OCT_01_2015 = new LocalDate(2015, DateTimeConstants.OCTOBER, 1);
	public static final LocalDate NOV_01_2015 = new LocalDate(2015, DateTimeConstants.NOVEMBER, 1);
	public static final LocalDate DEC_01_2015 = new LocalDate(2015, DateTimeConstants.DECEMBER, 1);
	public static final LocalDate AUG_04_2016 = new LocalDate(2016, DateTimeConstants.AUGUST, 4);

	// Joda LocalDateTime
	public static final LocalDateTime JAN_01_2012_11AM = JAN_01_2012.toLocalDateTime(new LocalTime(11, 0));
	public static final LocalDateTime JAN_01_2012_MIDN = JAN_01_2012.toLocalDateTime(MIDN);
	public static final LocalDateTime JUN_14_2012_NOON = JUN_14_2012.toLocalDateTime(NOON);
	public static final LocalDateTime JUN_15_2012_11AM = JUN_15_2012.toLocalDateTime(new LocalTime(11, 0));
	public static final LocalDateTime JUN_15_2012_NOON = JUN_15_2012.toLocalDateTime(new LocalTime(12, 0));
	public static final LocalDateTime JUN_15_2012_11PM = JUN_15_2012.toLocalDateTime(new LocalTime(23, 0));
	public static final LocalDateTime JAN_01_2015_NOON = JAN_01_2015.toLocalDateTime(new LocalTime(12, 0));
	public static final LocalDateTime FEB_01_2015_NOON = FEB_01_2015.toLocalDateTime(new LocalTime(12, 0));
	public static final LocalDateTime MAR_01_2015_NOON = MAR_01_2015.toLocalDateTime(new LocalTime(12, 0));
	public static final LocalDateTime APR_01_2015_NOON = APR_01_2015.toLocalDateTime(new LocalTime(12, 0));
	public static final LocalDateTime MAY_01_2015_NOON = MAY_01_2015.toLocalDateTime(new LocalTime(12, 0));
	public static final LocalDateTime JUN_01_2015_NOON = JUN_01_2015.toLocalDateTime(new LocalTime(12, 0));
	public static final LocalDateTime JUL_01_2015_NOON = JUL_01_2015.toLocalDateTime(new LocalTime(12, 0));
	public static final LocalDateTime AUG_01_2015_NOON = AUG_01_2015.toLocalDateTime(new LocalTime(12, 0));
	public static final LocalDateTime AUG_03_2015_NOON = AUG_03_2015.toLocalDateTime(new LocalTime(12, 0));
	public static final LocalDateTime AUG_03_2015_11PM = AUG_03_2015.toLocalDateTime(new LocalTime(23, 0));
	public static final LocalDateTime AUG_04_2015_1159 = AUG_04_2015.toLocalDateTime(new LocalTime(11, 59));
	public static final LocalDateTime AUG_04_2015_NOON = AUG_04_2015.toLocalDateTime(new LocalTime(12, 0));
	public static final LocalDateTime AUG_04_2015_1201 = AUG_04_2015.toLocalDateTime(new LocalTime(12, 1));
	public static final LocalDateTime AUG_05_2015_01AM = AUG_05_2015.toLocalDateTime(new LocalTime(1, 0));
	public static final LocalDateTime AUG_05_2015_NOON = AUG_05_2015.toLocalDateTime(new LocalTime(12, 0));
	public static final LocalDateTime AUG_06_2015_NOON = AUG_06_2015.toLocalDateTime(new LocalTime(12, 0));
	public static final LocalDateTime AUG_07_2015_NOON = AUG_07_2015.toLocalDateTime(new LocalTime(12, 0));
	public static final LocalDateTime AUG_08_2015_NOON = AUG_08_2015.toLocalDateTime(new LocalTime(12, 0));
	public static final LocalDateTime AUG_09_2015_NOON = AUG_09_2015.toLocalDateTime(new LocalTime(12, 0));
	public static final LocalDateTime AUG_31_2015_NOON = AUG_31_2015.toLocalDateTime(new LocalTime(12, 0));
	public static final LocalDateTime SEP_04_2015_NOON = SEP_04_2015.toLocalDateTime(new LocalTime(12, 0));
	public static final LocalDateTime SEP_30_2015_NOON = SEP_30_2015.toLocalDateTime(new LocalTime(12, 0));
	public static final LocalDateTime OCT_01_2015_NOON = OCT_01_2015.toLocalDateTime(new LocalTime(12, 0));
	public static final LocalDateTime NOV_01_2015_NOON = NOV_01_2015.toLocalDateTime(new LocalTime(12, 0));
	public static final LocalDateTime DEC_01_2015_NOON = DEC_01_2015.toLocalDateTime(new LocalTime(12, 0));
	public static final LocalDateTime AUG_04_2016_NOON = AUG_04_2016.toLocalDateTime(new LocalTime(12, 0));

 	public static final DateTime JAN_01_2012_11AM_UTC = JAN_01_2012_11AM.toDateTime(DateTimeZone.UTC);
 	public static final DateTime JAN_01_2012_MIDN_UTC = JAN_01_2012_MIDN.toDateTime(DateTimeZone.UTC);
	public static final DateTime JUN_14_2012_NOON_UTC = JUN_14_2012_NOON.toDateTime(DateTimeZone.UTC);
	public static final DateTime JUN_15_2012_11AM_UTC = JUN_15_2012_11AM.toDateTime(DateTimeZone.UTC);
	public static final DateTime JUN_15_2012_NOON_UTC = JUN_15_2012_NOON.toDateTime(DateTimeZone.UTC);
	public static final DateTime JUN_15_2012_11PM_UTC = JUN_15_2012_11PM.toDateTime(DateTimeZone.UTC);
	public static final DateTime JAN_01_2015_NOON_UTC = JAN_01_2015_NOON.toDateTime(DateTimeZone.UTC);
	public static final DateTime FEB_01_2015_NOON_UTC = FEB_01_2015_NOON.toDateTime(DateTimeZone.UTC);
	public static final DateTime MAR_01_2015_NOON_UTC = MAR_01_2015_NOON.toDateTime(DateTimeZone.UTC);
	public static final DateTime APR_01_2015_NOON_UTC = APR_01_2015_NOON.toDateTime(DateTimeZone.UTC);
	public static final DateTime MAY_01_2015_NOON_UTC = MAY_01_2015_NOON.toDateTime(DateTimeZone.UTC);
	public static final DateTime JUN_01_2015_NOON_UTC = JUN_01_2015_NOON.toDateTime(DateTimeZone.UTC);
	public static final DateTime JUL_01_2015_NOON_UTC = JUL_01_2015_NOON.toDateTime(DateTimeZone.UTC);
	public static final DateTime AUG_01_2015_NOON_UTC = AUG_01_2015_NOON.toDateTime(DateTimeZone.UTC);
	public static final DateTime AUG_03_2015_NOON_UTC = AUG_03_2015_NOON.toDateTime(DateTimeZone.UTC);
	public static final DateTime AUG_04_2015_11AM_UTC = AUG_04_2015_1159.toDateTime(DateTimeZone.UTC);
	public static final DateTime AUG_04_2015_NOON_UTC = AUG_04_2015_NOON.toDateTime(DateTimeZone.UTC);
	public static final DateTime AUG_04_2015_01PM_UTC = AUG_04_2015_1201.toDateTime(DateTimeZone.UTC);
	public static final DateTime AUG_05_2015_NOON_UTC = AUG_05_2015_NOON.toDateTime(DateTimeZone.UTC);
	public static final DateTime AUG_06_2015_NOON_UTC = AUG_06_2015_NOON.toDateTime(DateTimeZone.UTC);
	public static final DateTime AUG_07_2015_NOON_UTC = AUG_07_2015_NOON.toDateTime(DateTimeZone.UTC);
	public static final DateTime AUG_08_2015_NOON_UTC = AUG_08_2015_NOON.toDateTime(DateTimeZone.UTC);
	public static final DateTime AUG_09_2015_NOON_UTC = AUG_09_2015_NOON.toDateTime(DateTimeZone.UTC);
	public static final DateTime AUG_31_2015_NOON_UTC = AUG_31_2015_NOON.toDateTime(DateTimeZone.UTC);
	public static final DateTime SEP_04_2015_NOON_UTC = SEP_04_2015_NOON.toDateTime(DateTimeZone.UTC);
	public static final DateTime SEP_30_2015_NOON_UTC = SEP_30_2015_NOON.toDateTime(DateTimeZone.UTC);
	public static final DateTime OCT_01_2015_NOON_UTC = OCT_01_2015_NOON.toDateTime(DateTimeZone.UTC);
	public static final DateTime NOV_01_2015_NOON_UTC = NOV_01_2015_NOON.toDateTime(DateTimeZone.UTC);
	public static final DateTime DEC_01_2015_NOON_UTC = DEC_01_2015_NOON.toDateTime(DateTimeZone.UTC);
	public static final DateTime AUG_04_2016_NOON_UTC = AUG_04_2016_NOON.toDateTime(DateTimeZone.UTC);

	public static final DateTime AUG_03_2015_11PM_EST = AUG_03_2015_11PM.toDateTime(DateTimeZone.forTimeZone(TimeZone.getTimeZone(ZoneIds.EST)));
	public static final DateTime AUG_04_2015_NOON_EST = AUG_04_2015_NOON.toDateTime(DateTimeZone.forTimeZone(TimeZone.getTimeZone(ZoneIds.EST)));
	public static final DateTime AUG_04_2015_01PM_EST = AUG_04_2015_NOON.toDateTime(DateTimeZone.forTimeZone(TimeZone.getTimeZone(ZoneIds.EST)));

	public static final DateTime JAN_01_2012_11AM_PST = JAN_01_2012_11AM.toDateTime(DateTimeZone.forTimeZone(TimeZone.getTimeZone("PST")));

	public static final DateTime JAN_01_2012_11AM_CET = JAN_01_2012_11AM.toDateTime(DateTimeZone.forTimeZone(TimeZone.getTimeZone(ZoneIds.CET)));
	public static final DateTime JAN_01_2012_MIDN_CET = JAN_01_2012_MIDN.toDateTime(DateTimeZone.forTimeZone(TimeZone.getTimeZone(ZoneIds.CET)));
	public static final DateTime AUG_04_2015_NOON_CET = AUG_04_2015_NOON.toDateTime(DateTimeZone.forTimeZone(TimeZone.getTimeZone(ZoneIds.CET)));
	public static final DateTime AUG_05_2015_01AM_CET = AUG_05_2015_01AM.toDateTime(DateTimeZone.forTimeZone(TimeZone.getTimeZone(ZoneIds.CET)));

}
