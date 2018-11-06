package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.Dates.APR_01_2015;
import static org.exparity.hamcrest.date.testutils.Dates.APR_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.Dates.APR_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.Dates.APR_01_2015_NOON_UTC_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_01_2015;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_01_2015_NOON_UTC_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_04_2015;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_04_2015_NOON;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_04_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.Dates.AUG_04_2015_NOON_UTC_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.DEC_01_2015;
import static org.exparity.hamcrest.date.testutils.Dates.DEC_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.Dates.DEC_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.Dates.DEC_01_2015_NOON_UTC_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.FEB_01_2015;
import static org.exparity.hamcrest.date.testutils.Dates.FEB_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.Dates.FEB_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.Dates.FEB_01_2015_NOON_UTC_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_01_2015;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_01_2015_NOON_UTC_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.JUL_01_2015;
import static org.exparity.hamcrest.date.testutils.Dates.JUL_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.Dates.JUL_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.Dates.JUL_01_2015_NOON_UTC_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.JUN_01_2015;
import static org.exparity.hamcrest.date.testutils.Dates.JUN_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.Dates.JUN_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.Dates.JUN_01_2015_NOON_UTC_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.MAR_01_2015;
import static org.exparity.hamcrest.date.testutils.Dates.MAR_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.Dates.MAR_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.Dates.MAR_01_2015_NOON_UTC_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.MAY_01_2015;
import static org.exparity.hamcrest.date.testutils.Dates.MAY_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.Dates.MAY_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.Dates.MAY_01_2015_NOON_UTC_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.NOV_01_2015;
import static org.exparity.hamcrest.date.testutils.Dates.NOV_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.Dates.NOV_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.Dates.NOV_01_2015_NOON_UTC_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.OCT_01_2015;
import static org.exparity.hamcrest.date.testutils.Dates.OCT_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.Dates.OCT_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.Dates.OCT_01_2015_NOON_UTC_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.SEP_04_2015;
import static org.exparity.hamcrest.date.testutils.Dates.SEP_04_2015_MIDNIGHT_UTC_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.SEP_04_2015_NOON;
import static org.exparity.hamcrest.date.testutils.Dates.SEP_04_2015_NOON_UTC;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.Month;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.Months;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link IsMonth} class
 *
 * @author Stewart Bissett
 */
@SuppressWarnings("deprecation")
public class IsMonthTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the month [0-9]+?\\s     but: the date has the month [0-9]+?";

	// Date Matchers
	@Test
	public void isDateMonth() {
		assertThat(JAN_01_2015_NOON_UTC_AS_DATE, DateMatchers.isMonth(Month.JANUARY));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotMonth() {
		assertThat(JAN_01_2015_NOON_UTC_AS_DATE, DateMatchers.isMonth(Month.FEBRUARY));
	}

	@Test
	public void isDateSameMonth() {
		assertThat(JAN_01_2015_NOON_UTC_AS_DATE, DateMatchers.sameMonth(Months.JANUARY));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotSameMonth() {
		assertThat(JAN_01_2015_NOON_UTC_AS_DATE, DateMatchers.sameMonth(Months.FEBRUARY));
	}

	@Test
	public void isDateJanuary() {
		assertThat(JAN_01_2015_NOON_UTC_AS_DATE, DateMatchers.isJanuary());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotJanuary() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.isJanuary());
	}

	@Test
	public void isDateFebruary() {
		assertThat(FEB_01_2015_NOON_UTC_AS_DATE, DateMatchers.isFebruary());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotFebruary() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.isFebruary());
	}

	@Test
	public void isDateMarch() {
		assertThat(MAR_01_2015_NOON_UTC_AS_DATE, DateMatchers.isMarch());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotMarch() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.isMarch());
	}

	@Test
	public void isDateApril() {
		assertThat(APR_01_2015_NOON_UTC_AS_DATE, DateMatchers.isApril());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotApril() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.isApril());
	}

	@Test
	public void isDateMay() {
		assertThat(MAY_01_2015_NOON_UTC_AS_DATE, DateMatchers.isMay());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotMay() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.isMay());
	}

	@Test
	public void isDateJune() {
		assertThat(JUN_01_2015_NOON_UTC_AS_DATE, DateMatchers.isJune());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotJune() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.isJune());
	}

	@Test
	public void isDateJuly() {
		assertThat(JUL_01_2015_NOON_UTC_AS_DATE, DateMatchers.isJuly());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotJuly() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.isJuly());
	}

	@Test
	public void isDateAugust() {
		assertThat(AUG_01_2015_NOON_UTC_AS_DATE, DateMatchers.isAugust());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotAugust() {
		assertThat(SEP_04_2015_MIDNIGHT_UTC_AS_DATE, DateMatchers.isAugust());
	}

	@Test
	public void isDateSeptember() {
		assertThat(SEP_04_2015_MIDNIGHT_UTC_AS_DATE, DateMatchers.isSeptember());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotSeptember() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.isSeptember());
	}

	@Test
	public void isDateOctober() {
		assertThat(OCT_01_2015_NOON_UTC_AS_DATE, DateMatchers.isOctober());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotOctober() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.isOctober());
	}

	@Test
	public void isDateNovember() {
		assertThat(NOV_01_2015_NOON_UTC_AS_DATE, DateMatchers.isNovember());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotNovember() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.isNovember());
	}

	@Test
	public void isDateDecember() {
		assertThat(DEC_01_2015_NOON_UTC_AS_DATE, DateMatchers.isDecember());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotDecember() {
		assertThat(AUG_04_2015_NOON_UTC_AS_DATE, DateMatchers.isDecember());
	}

	// LocalDate Matchers
	@Test
	public void isLocalDateJanuary() {
		assertThat(JAN_01_2015, LocalDateMatchers.isJanuary());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotJanuary() {
		assertThat(AUG_04_2015, LocalDateMatchers.isJanuary());
	}

	@Test
	public void isLocalDateFebruary() {
		assertThat(FEB_01_2015, LocalDateMatchers.isFebruary());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotFebruary() {
		assertThat(AUG_04_2015, LocalDateMatchers.isFebruary());
	}

	@Test
	public void isLocalDateMarch() {
		assertThat(MAR_01_2015, LocalDateMatchers.isMarch());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotMarch() {
		assertThat(AUG_04_2015, LocalDateMatchers.isMarch());
	}

	@Test
	public void isLocalDateApril() {
		assertThat(APR_01_2015, LocalDateMatchers.isApril());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotApril() {
		assertThat(AUG_04_2015, LocalDateMatchers.isApril());
	}

	@Test
	public void isLocalDateMay() {
		assertThat(MAY_01_2015, LocalDateMatchers.isMay());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotMay() {
		assertThat(AUG_04_2015, LocalDateMatchers.isMay());
	}

	@Test
	public void isLocalDateJune() {
		assertThat(JUN_01_2015, LocalDateMatchers.isJune());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotJune() {
		assertThat(AUG_04_2015, LocalDateMatchers.isJune());
	}

	@Test
	public void isLocalDateJuly() {
		assertThat(JUL_01_2015, LocalDateMatchers.isJuly());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotJuly() {
		assertThat(AUG_04_2015, LocalDateMatchers.isJuly());
	}

	@Test
	public void isLocalDateAugust() {
		assertThat(AUG_01_2015, LocalDateMatchers.isAugust());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotAugust() {
		assertThat(SEP_04_2015, LocalDateMatchers.isAugust());
	}

	@Test
	public void isLocalDateSeptember() {
		assertThat(SEP_04_2015, LocalDateMatchers.isSeptember());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotSeptember() {
		assertThat(AUG_04_2015, LocalDateMatchers.isSeptember());
	}

	@Test
	public void isLocalDateOctober() {
		assertThat(OCT_01_2015, LocalDateMatchers.isOctober());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotOctober() {
		assertThat(AUG_04_2015, LocalDateMatchers.isOctober());
	}

	@Test
	public void isLocalDateNovember() {
		assertThat(NOV_01_2015, LocalDateMatchers.isNovember());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotNovember() {
		assertThat(AUG_04_2015, LocalDateMatchers.isNovember());
	}

	@Test
	public void isLocalDateDecember() {
		assertThat(DEC_01_2015, LocalDateMatchers.isDecember());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotDecember() {
		assertThat(AUG_04_2015, LocalDateMatchers.isDecember());
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeJanuary() {
		assertThat(JAN_01_2015_NOON, LocalDateTimeMatchers.isJanuary());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotJanuary() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isJanuary());
	}

	@Test
	public void isLocalDateTimeFebruary() {
		assertThat(FEB_01_2015_NOON, LocalDateTimeMatchers.isFebruary());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotFebruary() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isFebruary());
	}

	@Test
	public void isLocalDateTimeMarch() {
		assertThat(MAR_01_2015_NOON, LocalDateTimeMatchers.isMarch());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotMarch() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isMarch());
	}

	@Test
	public void isLocalDateTimeApril() {
		assertThat(APR_01_2015_NOON, LocalDateTimeMatchers.isApril());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotApril() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isApril());
	}

	@Test
	public void isLocalDateTimeMay() {
		assertThat(MAY_01_2015_NOON, LocalDateTimeMatchers.isMay());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotMay() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isMay());
	}

	@Test
	public void isLocalDateTimeJune() {
		assertThat(JUN_01_2015_NOON, LocalDateTimeMatchers.isJune());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotJune() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isJune());
	}

	@Test
	public void isLocalDateTimeJuly() {
		assertThat(JUL_01_2015_NOON, LocalDateTimeMatchers.isJuly());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotJuly() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isJuly());
	}

	@Test
	public void isLocalDateTimeAugust() {
		assertThat(AUG_01_2015_NOON, LocalDateTimeMatchers.isAugust());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotAugust() {
		assertThat(SEP_04_2015_NOON, LocalDateTimeMatchers.isAugust());
	}

	@Test
	public void isLocalDateTimeSeptember() {
		assertThat(SEP_04_2015_NOON, LocalDateTimeMatchers.isSeptember());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotSeptember() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isSeptember());
	}

	@Test
	public void isLocalDateTimeOctober() {
		assertThat(OCT_01_2015_NOON, LocalDateTimeMatchers.isOctober());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotOctober() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isOctober());
	}

	@Test
	public void isLocalDateTimeNovember() {
		assertThat(NOV_01_2015_NOON, LocalDateTimeMatchers.isNovember());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotNovember() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isNovember());
	}

	@Test
	public void isLocalDateTimeDecember() {
		assertThat(DEC_01_2015_NOON, LocalDateTimeMatchers.isDecember());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotDecember() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isDecember());
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeJanuary() {
		assertThat(JAN_01_2015_NOON_UTC, ZonedDateTimeMatchers.isJanuary());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotJanuary() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isJanuary());
	}

	@Test
	public void isZonedDateTimeFebruary() {
		assertThat(FEB_01_2015_NOON_UTC, ZonedDateTimeMatchers.isFebruary());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotFebruary() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isFebruary());
	}

	@Test
	public void isZonedDateTimeMarch() {
		assertThat(MAR_01_2015_NOON_UTC, ZonedDateTimeMatchers.isMarch());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotMarch() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isMarch());
	}

	@Test
	public void isZonedDateTimeApril() {
		assertThat(APR_01_2015_NOON_UTC, ZonedDateTimeMatchers.isApril());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotApril() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isApril());
	}

	@Test
	public void isZonedDateTimeMay() {
		assertThat(MAY_01_2015_NOON_UTC, ZonedDateTimeMatchers.isMay());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotMay() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isMay());
	}

	@Test
	public void isZonedDateTimeJune() {
		assertThat(JUN_01_2015_NOON_UTC, ZonedDateTimeMatchers.isJune());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotJune() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isJune());
	}

	@Test
	public void isZonedDateTimeJuly() {
		assertThat(JUL_01_2015_NOON_UTC, ZonedDateTimeMatchers.isJuly());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotJuly() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isJuly());
	}

	@Test
	public void isZonedDateTimeAugust() {
		assertThat(AUG_01_2015_NOON_UTC, ZonedDateTimeMatchers.isAugust());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotAugust() {
		assertThat(SEP_04_2015_NOON_UTC, ZonedDateTimeMatchers.isAugust());
	}

	@Test
	public void isZonedDateTimeSeptember() {
		assertThat(SEP_04_2015_NOON_UTC, ZonedDateTimeMatchers.isSeptember());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotSeptember() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isSeptember());
	}

	@Test
	public void isZonedDateTimeOctober() {
		assertThat(OCT_01_2015_NOON_UTC, ZonedDateTimeMatchers.isOctober());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotOctober() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isOctober());
	}

	@Test
	public void isZonedDateTimeNovember() {
		assertThat(NOV_01_2015_NOON_UTC, ZonedDateTimeMatchers.isNovember());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotNovember() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isNovember());
	}

	@Test
	public void isZonedDateTimeDecember() {
		assertThat(DEC_01_2015_NOON_UTC, ZonedDateTimeMatchers.isDecember());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotDecember() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isDecember());
	}

}
