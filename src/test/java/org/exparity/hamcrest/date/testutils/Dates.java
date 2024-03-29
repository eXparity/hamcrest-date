
package org.exparity.hamcrest.date.testutils;

import static java.time.LocalTime.MIDNIGHT;
import static java.time.LocalTime.NOON;
import static org.exparity.dates.en.FluentDateTime.*;
import static org.exparity.hamcrest.date.testutils.TimeZones.CET_AS_TZ;
import static org.exparity.hamcrest.date.testutils.TimeZones.EST_AS_TZ;
import static org.exparity.hamcrest.date.testutils.TimeZones.GMT_AS_TZ;
import static org.exparity.hamcrest.date.testutils.TimeZones.PST_AS_TZ;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.TimeZone;

/**
 * Static repository of dates used for testing
 *
 * @author Stewart Bissett
 */
public abstract class Dates {

	// Date
	public static final Date JAN_01_2000_11AM_UTC_AS_DATE = JAN(1, 2000).at(11, TimeZones.UTC_AS_TZ);
	public static final Date JAN_01_2012_11AM_UTC_AS_DATE = JAN(1, 2012).at(11, TimeZones.UTC_AS_TZ);
	public static final Date JAN_01_2012_11PM_UTC_AS_DATE = JAN(1, 2012).at(23, TimeZones.UTC_AS_TZ);
	public static final Date JAN_02_2012_11AM_UTC_AS_DATE = JAN(2, 2012).at(11, TimeZones.UTC_AS_TZ);
	public static final Date JAN_03_2012_11AM_UTC_AS_DATE = JAN(3, 2012).at(11, TimeZones.UTC_AS_TZ);
	public static final Date JAN_04_2012_11AM_UTC_AS_DATE = JAN(4, 2012).at(11, TimeZones.UTC_AS_TZ);
	public static final Date JAN_05_2012_11AM_UTC_AS_DATE = JAN(5, 2012).at(11, TimeZones.UTC_AS_TZ);
	public static final Date JAN_06_2012_11AM_UTC_AS_DATE = JAN(6, 2012).at(11, TimeZones.UTC_AS_TZ);
	public static final Date JAN_07_2012_11AM_UTC_AS_DATE = JAN(7, 2012).at(11, TimeZones.UTC_AS_TZ);
	public static final Date JAN_08_2012_11AM_UTC_AS_DATE = JAN(8, 2012).at(11, TimeZones.UTC_AS_TZ);
	public static final Date JAN_31_2012_11AM_UTC_AS_DATE = JAN(31, 2012).at(11, TimeZones.UTC_AS_TZ);
	public static final Date FEB_01_2012_11AM_UTC_AS_DATE = FEB(1, 2012).at(11, TimeZones.UTC_AS_TZ);
	public static final Date MAR_01_2012_11AM_UTC_AS_DATE = MAR(1, 2012).at(11, TimeZones.UTC_AS_TZ);
	public static final Date APR_01_2012_11AM_UTC_AS_DATE = APR(1, 2012).at(11, TimeZones.UTC_AS_TZ);
	public static final Date MAY_01_2012_11AM_UTC_AS_DATE = MAY(1, 2012).at(11, TimeZones.UTC_AS_TZ);
	public static final Date JUN_01_2012_11AM_UTC_AS_DATE = JUN(1, 2012).at(11, TimeZones.UTC_AS_TZ);
	public static final Date JUN_15_2012_11AM_UTC_AS_DATE = JUN(15, 2012).at(11, TimeZones.UTC_AS_TZ);
	public static final Date JUN_15_2012_11PM_UTC_AS_DATE = JUN(15, 2012).at(23, TimeZones.UTC_AS_TZ);
	public static final Date JUN_16_2012_11PM_UTC_AS_DATE = JUN(16, 2012).at(23, TimeZones.UTC_AS_TZ);
	public static final Date JUL_01_2012_11AM_UTC_AS_DATE = JUL(1, 2012).at(11, TimeZones.UTC_AS_TZ);
	public static final Date AUG_01_2012_11AM_UTC_AS_DATE = AUG(1, 2012).at(11, TimeZones.UTC_AS_TZ);
	public static final Date SEP_01_2012_11AM_UTC_AS_DATE = SEP(1, 2012).at(11, TimeZones.UTC_AS_TZ);
	public static final Date OCT_01_2012_11AM_UTC_AS_DATE = OCT(1, 2012).at(11, TimeZones.UTC_AS_TZ);
	public static final Date NOV_01_2012_11AM_UTC_AS_DATE = NOV(1, 2012).at(11, TimeZones.UTC_AS_TZ);
	public static final Date DEC_01_2012_11AM_UTC_AS_DATE = DEC(1, 2012).at(11, TimeZones.UTC_AS_TZ);
	public static final Date JAN_01_2013_11AM_UTC_AS_DATE = JAN(1, 2013).at(11, TimeZones.UTC_AS_TZ);
	public static final Date JAN_01_2100_11AM_UTC_AS_DATE = JAN(1, 2100).at(11, TimeZones.UTC_AS_TZ);
	public static final Date JAN_01_2015_NOON_UTC_AS_DATE = JAN(1, 2015).at(12, TimeZones.UTC_AS_TZ);
	public static final Date FEB_01_2015_NOON_UTC_AS_DATE = FEB(1, 2015).at(12, TimeZones.UTC_AS_TZ);
	public static final Date MAR_01_2015_NOON_UTC_AS_DATE = MAR(1, 2015).at(12, TimeZones.UTC_AS_TZ);
	public static final Date APR_01_2015_NOON_UTC_AS_DATE = APR(1, 2015).at(12, TimeZones.UTC_AS_TZ);
	public static final Date MAY_01_2015_NOON_UTC_AS_DATE = MAY(1, 2015).at(12, TimeZones.UTC_AS_TZ);
	public static final Date JUN_01_2015_NOON_UTC_AS_DATE = JUN(1, 2015).at(12, TimeZones.UTC_AS_TZ);
	public static final Date JUL_01_2015_NOON_UTC_AS_DATE = JUL(1, 2015).at(12, TimeZones.UTC_AS_TZ);
	public static final Date AUG_01_2015_NOON_UTC_AS_DATE = AUG(1, 2015).at(12, TimeZones.UTC_AS_TZ);
	public static final Date AUG_03_2015_NOON_UTC_AS_DATE = AUG(3, 2015).at(12, TimeZones.UTC_AS_TZ);
	public static final Date AUG_04_2015_1159_UTC_AS_DATE = AUG(4, 2015).at(11, 59, TimeZones.UTC_AS_TZ);
	public static final Date AUG_04_2015_NOON_UTC_AS_DATE = AUG(4, 2015).at(12, TimeZones.UTC_AS_TZ);
	public static final Date AUG_04_2015_1201_UTC_AS_DATE = AUG(4, 2015).at(12, 1, TimeZones.UTC_AS_TZ);
	public static final Date AUG_05_2015_NOON_UTC_AS_DATE = AUG(5, 2015).at(12, TimeZones.UTC_AS_TZ);
	public static final Date AUG_06_2015_NOON_UTC_AS_DATE = AUG(6, 2015).at(12, TimeZones.UTC_AS_TZ);
	public static final Date AUG_07_2015_NOON_UTC_AS_DATE = AUG(7, 2015).at(12, TimeZones.UTC_AS_TZ);
	public static final Date AUG_31_2015_NOON_UTC_AS_DATE = AUG(31, 2015).at(12, TimeZones.UTC_AS_TZ);
	public static final Date SEP_04_2015_NOON_UTC_AS_DATE = SEP(4, 2015).at(12, TimeZones.UTC_AS_TZ);
	public static final Date SEP_01_2015_NOON_UTC_AS_DATE = SEP(1, 2015).at(12, TimeZones.UTC_AS_TZ);
	public static final Date OCT_01_2015_NOON_UTC_AS_DATE = OCT(1, 2015).at(12, TimeZones.UTC_AS_TZ);
	public static final Date NOV_01_2015_NOON_UTC_AS_DATE = NOV(1, 2015).at(12, TimeZones.UTC_AS_TZ);
	public static final Date DEC_01_2015_NOON_UTC_AS_DATE = DEC(1, 2015).at(12, TimeZones.UTC_AS_TZ);
	public static final Date AUG_04_2016_NOON_UTC_AS_DATE = AUG(4, 2016).at(12, TimeZones.UTC_AS_TZ);
	public static final Date AUG_03_2015_MIDNIGHT_UTC_AS_DATE = AUG(3, 2015).at(0, TimeZones.UTC_AS_TZ);
	public static final Date AUG_05_2015_MIDNIGHT_UTC_AS_DATE = AUG(5, 2015).at(0, TimeZones.UTC_AS_TZ);
	public static final Date SEP_04_2015_MIDNIGHT_UTC_AS_DATE = SEP(4, 2015).at(0, TimeZones.UTC_AS_TZ);
	public static final Date AUG_04_2016_MIDNIGHT_UTC_AS_DATE = AUG(4, 2016).at(0, TimeZones.UTC_AS_TZ);

	public static final Date JAN_01_2012_MIDNIGHT_GMT_AS_DATE = JAN(1, 2012).at(0, GMT_AS_TZ);
	public static final Date JAN_01_2012_MIDNIGHT_PST_AS_DATE = JAN(1, 2012).at(0, PST_AS_TZ);
	public static final Date JAN_01_2012_MIDNIGHT_CET_AS_DATE = JAN(1, 2012).at(0, CET_AS_TZ);
	public static final Date JAN_01_2012_11AM_GMT_AS_DATE = JAN(1, 2012).at(11, GMT_AS_TZ);
	public static final Date JAN_01_2012_11AM_PST_AS_DATE = JAN(1, 2012).at(11, PST_AS_TZ);
	public static final Date JAN_01_2012_11AM_CET_AS_DATE = JAN(1, 2012).at(11, CET_AS_TZ);
	public static final Date AUG_04_2015_NOON_CET_AS_DATE = AUG(4, 2015).at(12, CET_AS_TZ);
	public static final Date AUG_04_2015_NOON_EST_AS_DATE = AUG(4, 2015).at(12, EST_AS_TZ);

	public static final Date AUG_04_2015_1159_DEFAULT_AS_DATE = AUG(4, 2015).at(11, 59, TimeZone.getDefault());
	
	// LocalDate
	public static final LocalDate JAN_01_2012 = LocalDate.of(2012, Month.JANUARY, 1);
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
	public static final LocalDateTime JAN_01_2012_MIDNIGHT = LocalDateTime.of(JAN_01_2012, MIDNIGHT);
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
    public static final LocalDateTime AUG_04_2015_MIDNIGHT = LocalDateTime.of(AUG_04_2015, MIDNIGHT);
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

	public static final ZonedDateTime JAN_01_2012_MIDNIGHT_CET = ZonedDateTime.of(JAN_01_2012_MIDNIGHT, ZoneIds.CET);
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

    public static final OffsetDateTime JAN_01_2012_MIDNIGHT_OFFSET_CET = OffsetDateTime.of(JAN_01_2012_MIDNIGHT, ZoneOffsets.CET);
    public static final OffsetDateTime JUN_14_2012_NOON_OFFSET_UTC = OffsetDateTime.of(JUN_14_2012_NOON, ZoneOffsets.UTC);
    public static final OffsetDateTime JUN_15_2012_11AM_OFFSET_UTC = OffsetDateTime.of(JUN_15_2012_11AM, ZoneOffsets.UTC);
    public static final OffsetDateTime JUN_15_2012_NOON_OFFSET_UTC = OffsetDateTime.of(JUN_15_2012_NOON, ZoneOffsets.UTC);
    public static final OffsetDateTime JAN_01_2015_NOON_OFFSET_UTC = OffsetDateTime.of(JAN_01_2015_NOON, ZoneOffsets.UTC);
    public static final OffsetDateTime FEB_01_2015_NOON_OFFSET_UTC = OffsetDateTime.of(FEB_01_2015_NOON, ZoneOffsets.UTC);
    public static final OffsetDateTime MAR_01_2015_NOON_OFFSET_UTC = OffsetDateTime.of(MAR_01_2015_NOON, ZoneOffsets.UTC);
    public static final OffsetDateTime APR_01_2015_NOON_OFFSET_UTC = OffsetDateTime.of(APR_01_2015_NOON, ZoneOffsets.UTC);
    public static final OffsetDateTime MAY_01_2015_NOON_OFFSET_UTC = OffsetDateTime.of(MAY_01_2015_NOON, ZoneOffsets.UTC);
    public static final OffsetDateTime JUN_01_2015_NOON_OFFSET_UTC = OffsetDateTime.of(JUN_01_2015_NOON, ZoneOffsets.UTC);
    public static final OffsetDateTime JUL_01_2015_NOON_OFFSET_UTC = OffsetDateTime.of(JUL_01_2015_NOON, ZoneOffsets.UTC);
    public static final OffsetDateTime AUG_01_2015_NOON_OFFSET_UTC = OffsetDateTime.of(AUG_01_2015_NOON, ZoneOffsets.UTC);
    public static final OffsetDateTime AUG_03_2015_NOON_OFFSET_UTC = OffsetDateTime.of(AUG_03_2015_NOON, ZoneOffsets.UTC);
    public static final OffsetDateTime AUG_04_2015_11AM_OFFSET_UTC = OffsetDateTime.of(AUG_04_2015_1159, ZoneOffsets.UTC);
    public static final OffsetDateTime AUG_04_2015_NOON_OFFSET_UTC = OffsetDateTime.of(AUG_04_2015_NOON, ZoneOffsets.UTC);
    public static final OffsetDateTime AUG_04_2015_MIDNIGHT_OFFSET_UTC = OffsetDateTime.of(AUG_04_2015_MIDNIGHT, ZoneOffsets.UTC);
    public static final OffsetDateTime AUG_04_2015_01PM_OFFSET_UTC = OffsetDateTime.of(AUG_04_2015_1201, ZoneOffsets.UTC);
    public static final OffsetDateTime AUG_05_2015_NOON_OFFSET_UTC = OffsetDateTime.of(AUG_05_2015_NOON, ZoneOffsets.UTC);
    public static final OffsetDateTime AUG_06_2015_NOON_OFFSET_UTC = OffsetDateTime.of(AUG_06_2015_NOON, ZoneOffsets.UTC);
    public static final OffsetDateTime AUG_07_2015_NOON_OFFSET_UTC = OffsetDateTime.of(AUG_07_2015_NOON, ZoneOffsets.UTC);
    public static final OffsetDateTime AUG_08_2015_NOON_OFFSET_UTC = OffsetDateTime.of(AUG_08_2015_NOON, ZoneOffsets.UTC);
    public static final OffsetDateTime AUG_09_2015_NOON_OFFSET_UTC = OffsetDateTime.of(AUG_09_2015_NOON, ZoneOffsets.UTC);
    public static final OffsetDateTime AUG_31_2015_NOON_OFFSET_UTC = OffsetDateTime.of(AUG_31_2015_NOON, ZoneOffsets.UTC);
    public static final OffsetDateTime SEP_04_2015_NOON_OFFSET_UTC = OffsetDateTime.of(SEP_04_2015_NOON, ZoneOffsets.UTC);
    public static final OffsetDateTime SEP_30_2015_NOON_OFFSET_UTC = OffsetDateTime.of(SEP_30_2015_NOON, ZoneOffsets.UTC);
    public static final OffsetDateTime OCT_01_2015_NOON_OFFSET_UTC = OffsetDateTime.of(OCT_01_2015_NOON, ZoneOffsets.UTC);
    public static final OffsetDateTime NOV_01_2015_NOON_OFFSET_UTC = OffsetDateTime.of(NOV_01_2015_NOON, ZoneOffsets.UTC);
    public static final OffsetDateTime DEC_01_2015_NOON_OFFSET_UTC = OffsetDateTime.of(DEC_01_2015_NOON, ZoneOffsets.UTC);
    public static final OffsetDateTime AUG_04_2016_NOON_OFFSET_UTC = OffsetDateTime.of(AUG_04_2016_NOON, ZoneOffsets.UTC);
    public static final OffsetDateTime AUG_03_2015_11PM_OFFSET_EST = OffsetDateTime.of(AUG_03_2015_11PM, ZoneOffsets.EST);
    public static final OffsetDateTime AUG_04_2015_NOON_OFFSET_EST = OffsetDateTime.of(AUG_04_2015_NOON, ZoneOffsets.EST);
    public static final OffsetDateTime AUG_04_2015_01PM_OFFSET_EST = OffsetDateTime.of(AUG_04_2015_NOON, ZoneOffsets.EST);
    public static final OffsetDateTime AUG_04_2015_NOON_OFFSET_CET = OffsetDateTime.of(AUG_04_2015_NOON, ZoneOffsets.CET);
    public static final OffsetDateTime AUG_05_2015_01AM_OFFSET_CET = OffsetDateTime.of(AUG_05_2015_01AM, ZoneOffsets.CET);

    public static final Instant JAN_01_2012_MIDNIGHT_INSTANT_CET = JAN_01_2012_MIDNIGHT.toInstant(ZoneOffsets.CET);
    public static final Instant JUN_14_2012_NOON_INSTANT_UTC = JUN_14_2012_NOON.toInstant(ZoneOffsets.UTC);
    public static final Instant JUN_15_2012_11AM_INSTANT_UTC = JUN_15_2012_11AM.toInstant(ZoneOffsets.UTC);
    public static final Instant JUN_15_2012_NOON_INSTANT_UTC = JUN_15_2012_NOON.toInstant(ZoneOffsets.UTC);
    public static final Instant JAN_01_2015_NOON_INSTANT_UTC = JAN_01_2015_NOON.toInstant(ZoneOffsets.UTC);
    public static final Instant FEB_01_2015_NOON_INSTANT_UTC = FEB_01_2015_NOON.toInstant(ZoneOffsets.UTC);
    public static final Instant MAR_01_2015_NOON_INSTANT_UTC = MAR_01_2015_NOON.toInstant(ZoneOffsets.UTC);
    public static final Instant APR_01_2015_NOON_INSTANT_UTC = APR_01_2015_NOON.toInstant(ZoneOffsets.UTC);
    public static final Instant MAY_01_2015_NOON_INSTANT_UTC = MAY_01_2015_NOON.toInstant(ZoneOffsets.UTC);
    public static final Instant JUN_01_2015_NOON_INSTANT_UTC = JUN_01_2015_NOON.toInstant(ZoneOffsets.UTC);
    public static final Instant JUL_01_2015_NOON_INSTANT_UTC = JUL_01_2015_NOON.toInstant(ZoneOffsets.UTC);
    public static final Instant AUG_01_2015_NOON_INSTANT_UTC = AUG_01_2015_NOON.toInstant(ZoneOffsets.UTC);
    public static final Instant AUG_03_2015_NOON_INSTANT_UTC = AUG_03_2015_NOON.toInstant(ZoneOffsets.UTC);
    public static final Instant AUG_04_2015_11AM_INSTANT_UTC = AUG_04_2015_1159.toInstant(ZoneOffsets.UTC);
    public static final Instant AUG_04_2015_NOON_INSTANT_UTC = AUG_04_2015_NOON.toInstant(ZoneOffsets.UTC);
    public static final Instant AUG_04_2015_MIDNIGHT_INSTANT_UTC = AUG_04_2015_MIDNIGHT.toInstant(ZoneOffsets.UTC);
    public static final Instant AUG_04_2015_01PM_INSTANT_UTC = AUG_04_2015_1201.toInstant(ZoneOffsets.UTC);
    public static final Instant AUG_05_2015_NOON_INSTANT_UTC = AUG_05_2015_NOON.toInstant(ZoneOffsets.UTC);
    public static final Instant AUG_06_2015_NOON_INSTANT_UTC = AUG_06_2015_NOON.toInstant(ZoneOffsets.UTC);
    public static final Instant AUG_07_2015_NOON_INSTANT_UTC = AUG_07_2015_NOON.toInstant(ZoneOffsets.UTC);
    public static final Instant AUG_08_2015_NOON_INSTANT_UTC = AUG_08_2015_NOON.toInstant(ZoneOffsets.UTC);
    public static final Instant AUG_09_2015_NOON_INSTANT_UTC = AUG_09_2015_NOON.toInstant(ZoneOffsets.UTC);
    public static final Instant AUG_31_2015_NOON_INSTANT_UTC = AUG_31_2015_NOON.toInstant(ZoneOffsets.UTC);
    public static final Instant SEP_04_2015_NOON_INSTANT_UTC = SEP_04_2015_NOON.toInstant(ZoneOffsets.UTC);
    public static final Instant SEP_30_2015_NOON_INSTANT_UTC = SEP_30_2015_NOON.toInstant(ZoneOffsets.UTC);
    public static final Instant OCT_01_2015_NOON_INSTANT_UTC = OCT_01_2015_NOON.toInstant(ZoneOffsets.UTC);
    public static final Instant NOV_01_2015_NOON_INSTANT_UTC = NOV_01_2015_NOON.toInstant(ZoneOffsets.UTC);
    public static final Instant DEC_01_2015_NOON_INSTANT_UTC = DEC_01_2015_NOON.toInstant(ZoneOffsets.UTC);
    public static final Instant AUG_04_2016_NOON_INSTANT_UTC = AUG_04_2016_NOON.toInstant(ZoneOffsets.UTC);
    public static final Instant AUG_03_2015_11PM_INSTANT_EST = AUG_03_2015_11PM.toInstant(ZoneOffsets.EST);
    public static final Instant AUG_04_2015_NOON_INSTANT_EST = AUG_04_2015_NOON.toInstant(ZoneOffsets.EST);
    public static final Instant AUG_04_2015_01PM_INSTANT_EST = AUG_04_2015_NOON.toInstant(ZoneOffsets.EST);
    public static final Instant AUG_04_2015_NOON_INSTANT_CET = AUG_04_2015_NOON.toInstant(ZoneOffsets.CET);
    public static final Instant AUG_05_2015_01AM_INSTANT_CET = AUG_05_2015_01AM.toInstant(ZoneOffsets.CET);
    
	// SQL Date
	public static final java.sql.Date JAN_01_2012_AS_SQL = java.sql.Date.valueOf(LocalDate.of(2012, 1, 1));
	public static final java.sql.Date JAN_02_2012_AS_SQL = java.sql.Date.valueOf(LocalDate.of(2012, 1, 2));
	public static final java.sql.Date JAN_03_2012_AS_SQL = java.sql.Date.valueOf(LocalDate.of(2012, 1, 3));
	public static final java.sql.Date JAN_04_2012_AS_SQL = java.sql.Date.valueOf(LocalDate.of(2012, 1, 4));
	public static final java.sql.Date JAN_05_2012_AS_SQL = java.sql.Date.valueOf(LocalDate.of(2012, 1, 5));
	public static final java.sql.Date JAN_06_2012_AS_SQL = java.sql.Date.valueOf(LocalDate.of(2012, 1, 6));
	public static final java.sql.Date JAN_07_2012_AS_SQL = java.sql.Date.valueOf(LocalDate.of(2012, 1, 7));
	public static final java.sql.Date JUN_14_2012_AS_SQL = java.sql.Date.valueOf(LocalDate.of(2012, 6, 14));	
	public static final java.sql.Date JUN_15_2012_AS_SQL = java.sql.Date.valueOf(LocalDate.of(2012, 6, 15));	
	public static final java.sql.Date JUN_16_2012_AS_SQL = java.sql.Date.valueOf(LocalDate.of(2012, 6, 16));	
	public static final java.sql.Date JAN_01_2015_AS_SQL = java.sql.Date.valueOf(LocalDate.of(2015, 1, 1));
	public static final java.sql.Date FEB_01_2015_AS_SQL = java.sql.Date.valueOf(LocalDate.of(2015, 2, 1));
	public static final java.sql.Date MAR_01_2015_AS_SQL = java.sql.Date.valueOf(LocalDate.of(2015, 3, 1));
	public static final java.sql.Date APR_01_2015_AS_SQL = java.sql.Date.valueOf(LocalDate.of(2015, 4, 1));
	public static final java.sql.Date MAY_01_2015_AS_SQL = java.sql.Date.valueOf(LocalDate.of(2015, 5, 1));
	public static final java.sql.Date JUN_01_2015_AS_SQL = java.sql.Date.valueOf(LocalDate.of(2015, 6, 1));
	public static final java.sql.Date JUL_01_2015_AS_SQL = java.sql.Date.valueOf(LocalDate.of(2015, 7, 1));
	public static final java.sql.Date AUG_01_2015_AS_SQL = java.sql.Date.valueOf(LocalDate.of(2015, 8, 1));
	public static final java.sql.Date AUG_03_2015_AS_SQL = java.sql.Date.valueOf(LocalDate.of(2015, 8, 3));
	public static final java.sql.Date AUG_04_2015_AS_SQL = java.sql.Date.valueOf(LocalDate.of(2015, 8, 4));
	public static final java.sql.Date AUG_05_2015_AS_SQL = java.sql.Date.valueOf(LocalDate.of(2015, 8, 5));
	public static final java.sql.Date AUG_06_2015_AS_SQL = java.sql.Date.valueOf(LocalDate.of(2015, 8, 6));
	public static final java.sql.Date AUG_07_2015_AS_SQL = java.sql.Date.valueOf(LocalDate.of(2015, 8, 7));
	public static final java.sql.Date SEP_01_2015_AS_SQL = java.sql.Date.valueOf(LocalDate.of(2015, 9, 1));
	public static final java.sql.Date SEP_04_2015_AS_SQL = java.sql.Date.valueOf(LocalDate.of(2015, 9, 4));
	public static final java.sql.Date OCT_01_2015_AS_SQL = java.sql.Date.valueOf(OCT_01_2015);
	public static final java.sql.Date NOV_01_2015_AS_SQL = java.sql.Date.valueOf(NOV_01_2015);
	public static final java.sql.Date DEC_01_2015_AS_SQL = java.sql.Date.valueOf(DEC_01_2015);
	public static final java.sql.Date AUG_04_2016_AS_SQL = java.sql.Date.valueOf(AUG_04_2016);
	public static final java.sql.Date AUG_31_2015_AS_SQL = java.sql.Date.valueOf(AUG_31_2015);
}
