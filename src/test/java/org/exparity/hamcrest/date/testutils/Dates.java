
package org.exparity.hamcrest.date.testutils;

import static java.time.LocalTime.NOON;
import static org.exparity.dates.en.FluentDateTime.*;
import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.exparity.hamcrest.date.testutils.TimeZones.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZonedDateTime;
import java.util.Date;

import org.exparity.dates.en.FluentDate;
import org.exparity.dates.en.FluentDateTime;

/**
 * Static repository of dates used for testing
 * 
 * @author Stewart Bissett
 */
public abstract class Dates {

	// Date
	public static final Date JAN_1_2000_11AM_UTC_AS_DATE = JAN(1, 2000).at(11, UTC_AS_TZ);
	public static final Date JAN_1_2012_11AM_UTC_AS_DATE = JAN(1, 2012).at(11, UTC_AS_TZ);
	public static final Date JAN_1_2012_11AM_GMT_AS_DATE = JAN(1, 2012).at(11, GMT);
	public static final Date JAN_T_2012_11PM_UTC_AS_DATE = JAN(1, 2012).at(23, UTC_AS_TZ);
	public static final Date JAN_1_2012_11AM_PST_AS_DATE = JAN(1, 2012).at(11, PST);
	public static final Date JAN_2ND_2012_11_AM = JAN(2, 2012).at(11, UTC_AS_TZ);
	public static final Date JAN_3RD_2012_11_AM = JAN(3, 2012).at(11, UTC_AS_TZ);
	public static final Date JAN_4TH_2012_11_AM = JAN(4, 2012).at(11, UTC_AS_TZ);
	public static final Date JAN_5TH_2012_11_AM = JAN(5, 2012).at(11, UTC_AS_TZ);
	public static final Date JAN_6TH_2012_11_AM = JAN(6, 2012).at(11, UTC_AS_TZ);
	public static final Date JAN_7TH_2012_11_AM = JAN(7, 2012).at(11, UTC_AS_TZ);
	public static final Date JAN_8TH_2012_11_AM = JAN(8, 2012).at(11, UTC_AS_TZ);
	public static final Date JAN_31ST_2012_11_AM = JAN(31, 2012).at(11, UTC_AS_TZ);
	public static final Date FEB_1ST_2012_11_AM = FEB(1, 2012).at(11, UTC_AS_TZ);
	public static final Date MAR_1ST_2012_11_AM = MAR(1, 2012).at(11, UTC_AS_TZ);
	public static final Date APR_1ST_2012_11_AM = APR(1, 2012).at(11, UTC_AS_TZ);
	public static final Date MAY_1ST_2012_11_AM = MAY(1, 2012).at(11, UTC_AS_TZ);
	public static final Date JUN_1ST_2012_11_AM = JUN(1, 2012).at(11, UTC_AS_TZ);
	public static final Date JUN_15TH_2012_11_AM = JUN(15, 2012).at(11, UTC_AS_TZ);
	public static final Date JUN_15TH_2012_11_PM = JUN(15, 2012).at(23, UTC_AS_TZ);
	public static final Date JUL_1ST_2012_11_AM = JUL(1, 2012).at(11, UTC_AS_TZ);
	public static final Date AUG_1ST_2012_11_AM = AUG(1, 2012).at(11, UTC_AS_TZ);
	public static final Date SEP_1ST_2012_11_AM = SEP(1, 2012).at(11, UTC_AS_TZ);
	public static final Date OCT_1ST_2012_11_AM = OCT(1, 2012).at(11, UTC_AS_TZ);
	public static final Date NOV_1ST_2012_11_AM = NOV(1, 2012).at(11, UTC_AS_TZ);
	public static final Date DEC_1ST_2012_11_AM = DEC(1, 2012).at(11, UTC_AS_TZ);
	public static final Date JAN_1ST_2013_11_AM = JAN(1, 2013).at(11, UTC_AS_TZ);
	public static final Date JAN_1ST_2100_11_AM = JAN(1, 2100).at(11, UTC_AS_TZ);
	public static final Date AUG_3_2015_NOON_AS_DATE = AUG(3, 2015).at(12, 0, 0, UTC_AS_TZ);
	public static final Date AUG_4_2015_AT_11_59_59_AS_DATE = AUG(4, 2015).at(11, 59, 59, UTC_AS_TZ);
	public static final Date AUG_4_2015_NOON_AS_DATE = AUG(4, 2015).at(12, UTC_AS_TZ);
	public static final Date AUG_4_2015_AT_12_00_01_AS_DATE = AUG(4, 2015).at(12, 0, 1, UTC_AS_TZ);
	public static final Date AUG_5_2015_NOON_AS_DATE = AUG(5, 2015).at(12, UTC_AS_TZ);
	public static final Date SEP_4_2015_NOON_AS_DATE = SEP(4, 2015).at(12, UTC_AS_TZ);
	public static final Date AUG_4_2016_NOON_AS_DATE = AUG(4, 2016).at(12, UTC_AS_TZ);
	public static final Date AUG_3_2015_AS_DATE = FluentDate.AUG(3, 2015);
	public static final Date AUG_4_2015_AS_DATE = FluentDate.AUG(4, 2015);
	public static final Date AUG_5_2015_AS_DATE = FluentDate.AUG(5, 2015);
	public static final Date SEP_4_2015_AS_DATE = FluentDate.SEP(4, 2015);
	public static final Date AUG_4_2016_AS_DATE = FluentDate.AUG(4, 2016);

	// LocalDate
	public static final LocalDate JAN_1_2015 = LocalDate.of(2015, Month.JANUARY, 1);
	public static final LocalDate FEB_1_2015 = LocalDate.of(2015, Month.FEBRUARY, 1);
	public static final LocalDate MAR_1_2015 = LocalDate.of(2015, Month.MARCH, 1);
	public static final LocalDate APR_1_2015 = LocalDate.of(2015, Month.APRIL, 1);
	public static final LocalDate MAY_1_2015 = LocalDate.of(2015, Month.MAY, 1);
	public static final LocalDate JUN_1_2015 = LocalDate.of(2015, Month.JUNE, 1);
	public static final LocalDate JUL_1_2015 = LocalDate.of(2015, Month.JULY, 1);
	public static final LocalDate AUG_1_2015 = LocalDate.of(2015, Month.AUGUST, 1);
	public static final LocalDate AUG_3_2015 = LocalDate.of(2015, Month.AUGUST, 3);
	public static final LocalDate AUG_4_2015 = LocalDate.of(2015, Month.AUGUST, 4);
	public static final LocalDate AUG_5_2015 = LocalDate.of(2015, Month.AUGUST, 5);
	public static final LocalDate AUG_6_2015 = LocalDate.of(2015, Month.AUGUST, 6);
	public static final LocalDate AUG_7_2015 = LocalDate.of(2015, Month.AUGUST, 7);
	public static final LocalDate AUG_8_2015 = LocalDate.of(2015, Month.AUGUST, 8);
	public static final LocalDate AUG_9_2015 = LocalDate.of(2015, Month.AUGUST, 9);
	public static final LocalDate AUG_31_2015 = LocalDate.of(2015, Month.AUGUST, 31);
	public static final LocalDate SEP_4_2015 = LocalDate.of(2015, Month.SEPTEMBER, 4);
	public static final LocalDate SEP_30_2015 = LocalDate.of(2015, Month.SEPTEMBER, 30);
	public static final LocalDate OCT_1_2015 = LocalDate.of(2015, Month.OCTOBER, 1);
	public static final LocalDate NOV_1_2015 = LocalDate.of(2015, Month.NOVEMBER, 1);
	public static final LocalDate DEC_1_2015 = LocalDate.of(2015, Month.DECEMBER, 1);
	public static final LocalDate AUG_4_2016 = LocalDate.of(2016, Month.AUGUST, 4);

	// LocalDateTime
	public static final LocalDateTime JAN_1_2015_NOON = LocalDateTime.of(JAN_1_2015, NOON);
	public static final LocalDateTime FEB_1_2015_NOON = LocalDateTime.of(FEB_1_2015, NOON);
	public static final LocalDateTime MAR_1_2015_NOON = LocalDateTime.of(MAR_1_2015, NOON);
	public static final LocalDateTime APR_1_2015_NOON = LocalDateTime.of(APR_1_2015, NOON);
	public static final LocalDateTime MAY_1_2015_NOON = LocalDateTime.of(MAY_1_2015, NOON);
	public static final LocalDateTime JUN_1_2015_NOON = LocalDateTime.of(JUN_1_2015, NOON);
	public static final LocalDateTime JUL_1_2015_NOON = LocalDateTime.of(JUL_1_2015, NOON);
	public static final LocalDateTime AUG_1_2015_NOON = LocalDateTime.of(AUG_1_2015, NOON);
	public static final LocalDateTime AUG_3_2015_NOON = LocalDateTime.of(AUG_3_2015, NOON);
	public static final LocalDateTime AUG_3_2015_11PM = LocalDateTime.of(AUG_3_2015, LocalTime.of(23, 0, 0));
	public static final LocalDateTime AUG_4_2015_1159 = LocalDateTime.of(AUG_4_2015, NOON.minusSeconds(1));
	public static final LocalDateTime AUG_4_2015_NOON = LocalDateTime.of(AUG_4_2015, NOON);
	public static final LocalDateTime AUG_4_2015_1201 = LocalDateTime.of(AUG_4_2015, NOON.plusSeconds(1));
	public static final LocalDateTime AUG_5_2015_01AM = LocalDateTime.of(AUG_5_2015, LocalTime.of(1, 0, 0));
	public static final LocalDateTime AUG_5_2015_NOON = LocalDateTime.of(AUG_5_2015, NOON);
	public static final LocalDateTime AUG_6_2015_NOON = LocalDateTime.of(AUG_6_2015, NOON);
	public static final LocalDateTime AUG_7_2015_NOON = LocalDateTime.of(AUG_7_2015, NOON);
	public static final LocalDateTime AUG_8_2015_NOON = LocalDateTime.of(AUG_8_2015, NOON);
	public static final LocalDateTime AUG_9_2015_NOON = LocalDateTime.of(AUG_9_2015, NOON);
	public static final LocalDateTime AUG_31_2015_NOON = LocalDateTime.of(AUG_31_2015, NOON);
	public static final LocalDateTime SEP_4_2015_NOON = LocalDateTime.of(SEP_4_2015, NOON);
	public static final LocalDateTime SEP_30_2015_NOON = LocalDateTime.of(SEP_30_2015, NOON);
	public static final LocalDateTime OCT_1_2015_NOON = LocalDateTime.of(OCT_1_2015, NOON);
	public static final LocalDateTime NOV_1_2015_NOON = LocalDateTime.of(NOV_1_2015, NOON);
	public static final LocalDateTime DEC_1_2015_NOON = LocalDateTime.of(DEC_1_2015, NOON);
	public static final LocalDateTime AUG_4_2016_NOON = LocalDateTime.of(AUG_4_2016, NOON);

	public static final ZonedDateTime JAN_1_2015_NOON_UTC = ZonedDateTime.of(JAN_1_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime FEB_1_2015_NOON_UTC = ZonedDateTime.of(FEB_1_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime MAR_1_2015_NOON_UTC = ZonedDateTime.of(MAR_1_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime APR_1_2015_NOON_UTC = ZonedDateTime.of(APR_1_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime MAY_1_2015_NOON_UTC = ZonedDateTime.of(MAY_1_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime JUN_1_2015_NOON_UTC = ZonedDateTime.of(JUN_1_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime JUL_1_2015_NOON_UTC = ZonedDateTime.of(JUL_1_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime AUG_1_2015_NOON_UTC = ZonedDateTime.of(AUG_1_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime AUG_3_2015_NOON_UTC = ZonedDateTime.of(AUG_3_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime AUG_4_2015_11AM_UTC = ZonedDateTime.of(AUG_4_2015_1159, ZoneIds.UTC);
	public static final ZonedDateTime AUG_4_2015_NOON_UTC = ZonedDateTime.of(AUG_4_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime AUG_4_2015_01PM_UTC = ZonedDateTime.of(AUG_4_2015_1201, ZoneIds.UTC);
	public static final ZonedDateTime AUG_5_2015_NOON_UTC = ZonedDateTime.of(AUG_5_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime AUG_6_2015_NOON_UTC = ZonedDateTime.of(AUG_6_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime AUG_7_2015_NOON_UTC = ZonedDateTime.of(AUG_7_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime AUG_8_2015_NOON_UTC = ZonedDateTime.of(AUG_8_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime AUG_9_2015_NOON_UTC = ZonedDateTime.of(AUG_9_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime AUG_31_2015_NOON_UTC = ZonedDateTime.of(AUG_31_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime SEP_4_2015_NOON_UTC = ZonedDateTime.of(SEP_4_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime SEP_30_2015_NOON_UTC = ZonedDateTime.of(SEP_30_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime OCT_1_2015_NOON_UTC = ZonedDateTime.of(OCT_1_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime NOV_1_2015_NOON_UTC = ZonedDateTime.of(NOV_1_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime DEC_1_2015_NOON_UTC = ZonedDateTime.of(DEC_1_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime AUG_4_2016_NOON_UTC = ZonedDateTime.of(AUG_4_2016_NOON, ZoneIds.UTC);

	public static final ZonedDateTime AUG_3_2015_11PM_MINUS_1 = ZonedDateTime.of(AUG_3_2015_11PM, ZoneIds.MINUS1);
	public static final ZonedDateTime AUG_4_2015_NOON_MINUS_1 = ZonedDateTime.of(AUG_4_2015_NOON, ZoneIds.MINUS1);
	public static final ZonedDateTime AUG_4_2015_01PM_MINUS_1 = ZonedDateTime.of(AUG_4_2015_NOON, ZoneIds.MINUS1);
	public static final ZonedDateTime AUG_4_2015_NOON_PLUS_1 = ZonedDateTime.of(AUG_4_2015_NOON, ZoneIds.PLUS1);
	public static final ZonedDateTime AUG_5_2015_01AM_PLUS_1 = ZonedDateTime.of(AUG_5_2015_01AM, ZoneIds.PLUS1);
}
