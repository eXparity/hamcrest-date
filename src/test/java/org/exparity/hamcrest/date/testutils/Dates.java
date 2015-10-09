
package org.exparity.hamcrest.date.testutils;

import static java.time.LocalTime.NOON;
import static org.exparity.dates.en.FluentDateTime.*;
import static org.exparity.hamcrest.date.testutils.TimeZones.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZonedDateTime;
import java.util.Date;

import org.exparity.dates.en.FluentDate;

/**
 * Static repository of dates used for testing
 *
 * @author Stewart Bissett
 */
public abstract class Dates {

	// Date
	public static final Date JAN_01_2000_11AM_AS_DATE = JAN(1, 2000).at(11);
	public static final Date JAN_01_2012_11AM_AS_DATE = JAN(1, 2012).at(11);
	public static final Date JAN_01_2012_11PM_AS_DATE = JAN(1, 2012).at(23);
	public static final Date JAN_02_2012_11AM_AS_DATE = JAN(2, 2012).at(11);
	public static final Date JAN_03_2012_11AM_AS_DATE = JAN(3, 2012).at(11);
	public static final Date JAN_04_2012_11AM_AS_DATE = JAN(4, 2012).at(11);
	public static final Date JAN_05_2012_11AM_AS_DATE = JAN(5, 2012).at(11);
	public static final Date JAN_06_2012_11AM_AS_DATE = JAN(6, 2012).at(11);
	public static final Date JAN_07_2012_11AM_AS_DATE = JAN(7, 2012).at(11);
	public static final Date JAN_08_2012_11AM_AS_DATE = JAN(8, 2012).at(11);
	public static final Date JAN_31_2012_11AM_AS_DATE = JAN(31, 2012).at(11);
	public static final Date FEB_01_2012_11AM_AS_DATE = FEB(1, 2012).at(11);
	public static final Date MAR_01_2012_11AM_AS_DATE = MAR(1, 2012).at(11);
	public static final Date APR_01_2012_11AM_AS_DATE = APR(1, 2012).at(11);
	public static final Date MAY_01_2012_11AM_AS_DATE = MAY(1, 2012).at(11);
	public static final Date JUN_01_2012_11AM_AS_DATE = JUN(1, 2012).at(11);
	public static final Date JUN_15_2012_11AM_AS_DATE = JUN(15, 2012).at(11);
	public static final Date JUN_15_2012_11PM_AS_DATE = JUN(15, 2012).at(23);
	public static final Date JUL_01_2012_11AM_AS_DATE = JUL(1, 2012).at(11);
	public static final Date AUG_01_2012_11AM_AS_DATE = AUG(1, 2012).at(11);
	public static final Date SEP_01_2012_11AM_AS_DATE = SEP(1, 2012).at(11);
	public static final Date OCT_01_2012_11AM_AS_DATE = OCT(1, 2012).at(11);
	public static final Date NOV_01_2012_11AM_AS_DATE = NOV(1, 2012).at(11);
	public static final Date DEC_01_2012_11AM_AS_DATE = DEC(1, 2012).at(11);
	public static final Date JAN_01_2013_11AM_AS_DATE = JAN(1, 2013).at(11);
	public static final Date JAN_01_2100_11AM_AS_DATE = JAN(1, 2100).at(11);
	public static final Date JAN_01_2015_NOON_AS_DATE = JAN(1, 2015).at(12);
	public static final Date FEB_01_2015_NOON_AS_DATE = FEB(1, 2015).at(12);
	public static final Date MAR_01_2015_NOON_AS_DATE = MAR(1, 2015).at(12);
	public static final Date APR_01_2015_NOON_AS_DATE = APR(1, 2015).at(12);
	public static final Date MAY_01_2015_NOON_AS_DATE = MAY(1, 2015).at(12);
	public static final Date JUN_01_2015_NOON_AS_DATE = JUN(1, 2015).at(12);
	public static final Date JUL_01_2015_NOON_AS_DATE = JUL(1, 2015).at(12);
	public static final Date AUG_01_2015_NOON_AS_DATE = AUG(1, 2015).at(12);
	public static final Date AUG_03_2015_NOON_AS_DATE = AUG(3, 2015).at(12);
	public static final Date AUG_04_2015_1159_AS_DATE = AUG(4, 2015).at(11, 59);
	public static final Date AUG_04_2015_NOON_AS_DATE = AUG(4, 2015).at(12);
	public static final Date AUG_04_2015_1201_AS_DATE = AUG(4, 2015).at(12, 1);
	public static final Date AUG_05_2015_NOON_AS_DATE = AUG(5, 2015).at(12);
	public static final Date AUG_31_2015_NOON_AS_DATE = AUG(31, 2015).at(12);
	public static final Date SEP_04_2015_NOON_AS_DATE = SEP(4, 2015).at(12);
	public static final Date SEP_01_2015_NOON_AS_DATE = SEP(1, 2015).at(12);
	public static final Date OCT_01_2015_NOON_AS_DATE = OCT(1, 2015).at(12);
	public static final Date NOV_01_2015_NOON_AS_DATE = NOV(1, 2015).at(12);
	public static final Date DEC_01_2015_NOON_AS_DATE = DEC(1, 2015).at(12);
	public static final Date AUG_04_2016_NOON_AS_DATE = AUG(4, 2016).at(12);
	public static final Date AUG_03_2015_AS_DATE = FluentDate.AUG(3, 2015);
	public static final Date AUG_05_2015_AS_DATE = FluentDate.AUG(5, 2015);
	public static final Date SEP_04_2015_AS_DATE = FluentDate.SEP(4, 2015);
	public static final Date AUG_04_2016_AS_DATE = FluentDate.AUG(4, 2016);

	public static final Date JAN_01_2012_11AM_GMT_AS_DATE = JAN(1, 2012).at(11, GMT_AS_TZ);
	public static final Date JAN_01_2012_11AM_PST_AS_DATE = JAN(1, 2012).at(11, PST_AS_TZ);
	public static final Date AUG_03_2015_NOON_UTC_AS_DATE = AUG(3, 2015).at(12, UTC_AS_TZ);
	public static final Date AUG_04_2015_1159_UTC_AS_DATE = AUG(4, 2015).at(11, 59, UTC_AS_TZ);
	public static final Date AUG_04_2015_NOON_CET_AS_DATE = AUG(4, 2015).at(12, CET_AS_TZ);
	public static final Date AUG_04_2015_NOON_UTC_AS_DATE = AUG(4, 2015).at(12, UTC_AS_TZ);
	public static final Date AUG_04_2015_NOON_EST_AS_DATE = AUG(4, 2015).at(12, EST_AS_TZ);
	public static final Date AUG_04_2015_1201_UTC_AS_DATE = AUG(4, 2015).at(12, 1, UTC_AS_TZ);
	public static final Date AUG_04_2016_NOON_UTC_AS_DATE = AUG(4, 2016).at(12, UTC_AS_TZ);
	public static final Date SEP_04_2015_NOON_UTC_AS_DATE = SEP(4, 2015).at(12, UTC_AS_TZ);
	public static final Date AUG_05_2015_NOON_UTC_AS_DATE = AUG(5, 2015).at(12, UTC_AS_TZ);

	// LocalDate
	public static final LocalDate JUN_14_2012 = LocalDate.of(2012, Month.JUNE, 14);
	public static final LocalDate JUN_15_2012 = LocalDate.of(2012, Month.JUNE, 15);
	public static final LocalDate JUN_16_2012 = LocalDate.of(2012, Month.JUNE, 16);
	public static final LocalDate JAN_01_2015 = LocalDate.of(2015, Month.JANUARY, 1);
	public static final LocalDate FEB_01_2015 = LocalDate.of(2015, Month.FEBRUARY, 1);
	public static final LocalDate MAR_01_2015 = LocalDate.of(2015, Month.MARCH, 1);
	public static final LocalDate APR_01_2015 = LocalDate.of(2015, Month.APRIL, 1);
	public static final LocalDate MAY_01_2015 = LocalDate.of(2015, Month.MAY, 1);
	public static final LocalDate JUN_01_2015 = LocalDate.of(2015, Month.JUNE, 1);
	public static final LocalDate JUL_01_2015 = LocalDate.of(2015, Month.JULY, 1);
	public static final LocalDate AUG_01_2015 = LocalDate.of(2015, Month.AUGUST, 1);
	public static final LocalDate AUG_03_2015 = LocalDate.of(2015, Month.AUGUST, 3);
	public static final LocalDate AUG_04_2015 = LocalDate.of(2015, Month.AUGUST, 4);
	public static final LocalDate AUG_05_2015 = LocalDate.of(2015, Month.AUGUST, 5);
	public static final LocalDate AUG_06_2015 = LocalDate.of(2015, Month.AUGUST, 6);
	public static final LocalDate AUG_07_2015 = LocalDate.of(2015, Month.AUGUST, 7);
	public static final LocalDate AUG_08_2015 = LocalDate.of(2015, Month.AUGUST, 8);
	public static final LocalDate AUG_09_2015 = LocalDate.of(2015, Month.AUGUST, 9);
	public static final LocalDate AUG_31_2015 = LocalDate.of(2015, Month.AUGUST, 31);
	public static final LocalDate SEP_04_2015 = LocalDate.of(2015, Month.SEPTEMBER, 4);
	public static final LocalDate SEP_30_2015 = LocalDate.of(2015, Month.SEPTEMBER, 30);
	public static final LocalDate OCT_01_2015 = LocalDate.of(2015, Month.OCTOBER, 1);
	public static final LocalDate NOV_01_2015 = LocalDate.of(2015, Month.NOVEMBER, 1);
	public static final LocalDate DEC_01_2015 = LocalDate.of(2015, Month.DECEMBER, 1);
	public static final LocalDate AUG_04_2016 = LocalDate.of(2016, Month.AUGUST, 4);

	// LocalDateTime
	public static final LocalDateTime JUN_14_2012_NOON = LocalDateTime.of(JUN_14_2012, NOON);
	public static final LocalDateTime JUN_15_2012_11AM = LocalDateTime.of(JUN_15_2012, LocalTime.of(11, 0));
	public static final LocalDateTime JUN_15_2012_NOON = LocalDateTime.of(JUN_15_2012, NOON);
	public static final LocalDateTime JAN_01_2015_NOON = LocalDateTime.of(JAN_01_2015, NOON);
	public static final LocalDateTime FEB_01_2015_NOON = LocalDateTime.of(FEB_01_2015, NOON);
	public static final LocalDateTime MAR_01_2015_NOON = LocalDateTime.of(MAR_01_2015, NOON);
	public static final LocalDateTime APR_01_2015_NOON = LocalDateTime.of(APR_01_2015, NOON);
	public static final LocalDateTime MAY_01_2015_NOON = LocalDateTime.of(MAY_01_2015, NOON);
	public static final LocalDateTime JUN_01_2015_NOON = LocalDateTime.of(JUN_01_2015, NOON);
	public static final LocalDateTime JUL_01_2015_NOON = LocalDateTime.of(JUL_01_2015, NOON);
	public static final LocalDateTime AUG_01_2015_NOON = LocalDateTime.of(AUG_01_2015, NOON);
	public static final LocalDateTime AUG_03_2015_NOON = LocalDateTime.of(AUG_03_2015, NOON);
	public static final LocalDateTime AUG_03_2015_11PM = LocalDateTime.of(AUG_03_2015, LocalTime.of(23, 0, 0));
	public static final LocalDateTime AUG_04_2015_1159 = LocalDateTime.of(AUG_04_2015, LocalTime.of(11, 59, 0));
	public static final LocalDateTime AUG_04_2015_NOON = LocalDateTime.of(AUG_04_2015, NOON);
	public static final LocalDateTime AUG_04_2015_1201 = LocalDateTime.of(AUG_04_2015, LocalTime.of(12, 1, 0));
	public static final LocalDateTime AUG_05_2015_01AM = LocalDateTime.of(AUG_05_2015, LocalTime.of(1, 0, 0));
	public static final LocalDateTime AUG_05_2015_NOON = LocalDateTime.of(AUG_05_2015, NOON);
	public static final LocalDateTime AUG_06_2015_NOON = LocalDateTime.of(AUG_06_2015, NOON);
	public static final LocalDateTime AUG_07_2015_NOON = LocalDateTime.of(AUG_07_2015, NOON);
	public static final LocalDateTime AUG_08_2015_NOON = LocalDateTime.of(AUG_08_2015, NOON);
	public static final LocalDateTime AUG_09_2015_NOON = LocalDateTime.of(AUG_09_2015, NOON);
	public static final LocalDateTime AUG_31_2015_NOON = LocalDateTime.of(AUG_31_2015, NOON);
	public static final LocalDateTime SEP_04_2015_NOON = LocalDateTime.of(SEP_04_2015, NOON);
	public static final LocalDateTime SEP_30_2015_NOON = LocalDateTime.of(SEP_30_2015, NOON);
	public static final LocalDateTime OCT_01_2015_NOON = LocalDateTime.of(OCT_01_2015, NOON);
	public static final LocalDateTime NOV_01_2015_NOON = LocalDateTime.of(NOV_01_2015, NOON);
	public static final LocalDateTime DEC_01_2015_NOON = LocalDateTime.of(DEC_01_2015, NOON);
	public static final LocalDateTime AUG_04_2016_NOON = LocalDateTime.of(AUG_04_2016, NOON);

	public static final ZonedDateTime JUN_14_2012_NOON_UTC = ZonedDateTime.of(JUN_14_2012_NOON, ZoneIds.UTC);
	public static final ZonedDateTime JUN_15_2012_11AM_UTC = ZonedDateTime.of(JUN_15_2012_11AM, ZoneIds.UTC);
	public static final ZonedDateTime JUN_15_2012_NOON_UTC = ZonedDateTime.of(JUN_15_2012_NOON, ZoneIds.UTC);
	public static final ZonedDateTime JAN_01_2015_NOON_UTC = ZonedDateTime.of(JAN_01_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime FEB_01_2015_NOON_UTC = ZonedDateTime.of(FEB_01_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime MAR_01_2015_NOON_UTC = ZonedDateTime.of(MAR_01_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime APR_01_2015_NOON_UTC = ZonedDateTime.of(APR_01_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime MAY_01_2015_NOON_UTC = ZonedDateTime.of(MAY_01_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime JUN_01_2015_NOON_UTC = ZonedDateTime.of(JUN_01_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime JUL_01_2015_NOON_UTC = ZonedDateTime.of(JUL_01_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime AUG_01_2015_NOON_UTC = ZonedDateTime.of(AUG_01_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime AUG_03_2015_NOON_UTC = ZonedDateTime.of(AUG_03_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime AUG_04_2015_11AM_UTC = ZonedDateTime.of(AUG_04_2015_1159, ZoneIds.UTC);
	public static final ZonedDateTime AUG_04_2015_NOON_UTC = ZonedDateTime.of(AUG_04_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime AUG_04_2015_01PM_UTC = ZonedDateTime.of(AUG_04_2015_1201, ZoneIds.UTC);
	public static final ZonedDateTime AUG_05_2015_NOON_UTC = ZonedDateTime.of(AUG_05_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime AUG_06_2015_NOON_UTC = ZonedDateTime.of(AUG_06_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime AUG_07_2015_NOON_UTC = ZonedDateTime.of(AUG_07_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime AUG_08_2015_NOON_UTC = ZonedDateTime.of(AUG_08_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime AUG_09_2015_NOON_UTC = ZonedDateTime.of(AUG_09_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime AUG_31_2015_NOON_UTC = ZonedDateTime.of(AUG_31_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime SEP_04_2015_NOON_UTC = ZonedDateTime.of(SEP_04_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime SEP_30_2015_NOON_UTC = ZonedDateTime.of(SEP_30_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime OCT_01_2015_NOON_UTC = ZonedDateTime.of(OCT_01_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime NOV_01_2015_NOON_UTC = ZonedDateTime.of(NOV_01_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime DEC_01_2015_NOON_UTC = ZonedDateTime.of(DEC_01_2015_NOON, ZoneIds.UTC);
	public static final ZonedDateTime AUG_04_2016_NOON_UTC = ZonedDateTime.of(AUG_04_2016_NOON, ZoneIds.UTC);

	public static final ZonedDateTime AUG_03_2015_11PM_EST = ZonedDateTime.of(AUG_03_2015_11PM, ZoneIds.EST);
	public static final ZonedDateTime AUG_04_2015_NOON_EST = ZonedDateTime.of(AUG_04_2015_NOON, ZoneIds.EST);
	public static final ZonedDateTime AUG_04_2015_01PM_EST = ZonedDateTime.of(AUG_04_2015_NOON, ZoneIds.EST);
	public static final ZonedDateTime AUG_04_2015_NOON_CET = ZonedDateTime.of(AUG_04_2015_NOON, ZoneIds.CET);
	public static final ZonedDateTime AUG_05_2015_01AM_CET = ZonedDateTime.of(AUG_05_2015_01AM, ZoneIds.CET);
}
