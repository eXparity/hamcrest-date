package org.exparity.hamcrest.date;

import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

/**
 * Unit Tests for the {@link IsSameMonthOfYear} class
 *
 * @author Stewart Bissett
 */
public class IsMonthTest {

	// Date Matchers
	@Test
	public void isDateJanuary() {
		assertThat(JAN_01_2015_NOON_AS_DATE, DateMatchers.isJanuary());
	}

	@Test(expected = AssertionError.class)
	public void isDateNotJanuary() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.isJanuary());
	}

	@Test
	public void isDateFebruary() {
		assertThat(FEB_01_2015_NOON_AS_DATE, DateMatchers.isFebruary());
	}

	@Test(expected = AssertionError.class)
	public void isDateNotFebruary() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.isFebruary());
	}

	@Test
	public void isDateMarch() {
		assertThat(MAR_01_2015_NOON_AS_DATE, DateMatchers.isMarch());
	}

	@Test(expected = AssertionError.class)
	public void isDateNotMarch() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.isMarch());
	}

	@Test
	public void isDateApril() {
		assertThat(APR_01_2015_NOON_AS_DATE, DateMatchers.isApril());
	}

	@Test(expected = AssertionError.class)
	public void isDateNotApril() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.isApril());
	}

	@Test
	public void isDateMay() {
		assertThat(MAY_01_2015_NOON_AS_DATE, DateMatchers.isMay());
	}

	@Test(expected = AssertionError.class)
	public void isDateNotMay() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.isMay());
	}

	@Test
	public void isDateJune() {
		assertThat(JUN_01_2015_NOON_AS_DATE, DateMatchers.isJune());
	}

	@Test(expected = AssertionError.class)
	public void isDateNotJune() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.isJune());
	}

	@Test
	public void isDateJuly() {
		assertThat(JUL_01_2015_NOON_AS_DATE, DateMatchers.isJuly());
	}

	@Test(expected = AssertionError.class)
	public void isDateNotJuly() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.isJuly());
	}

	@Test
	public void isDateAugust() {
		assertThat(AUG_01_2015_NOON_AS_DATE, DateMatchers.isAugust());
	}

	@Test(expected = AssertionError.class)
	public void isDateNotAugust() {
		assertThat(SEP_04_2015_AS_DATE, DateMatchers.isAugust());
	}

	@Test
	public void isDateSeptember() {
		assertThat(SEP_04_2015_AS_DATE, DateMatchers.isSeptember());
	}

	@Test(expected = AssertionError.class)
	public void isDateNotSeptember() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.isSeptember());
	}

	@Test
	public void isDateOctober() {
		assertThat(OCT_01_2015_NOON_AS_DATE, DateMatchers.isOctober());
	}

	@Test(expected = AssertionError.class)
	public void isDateNotOctober() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.isOctober());
	}

	@Test
	public void isDateNovember() {
		assertThat(NOV_01_2015_NOON_AS_DATE, DateMatchers.isNovember());
	}

	@Test(expected = AssertionError.class)
	public void isDateNotNovember() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.isNovember());
	}

	@Test
	public void isDateDecember() {
		assertThat(DEC_01_2015_NOON_AS_DATE, DateMatchers.isDecember());
	}

	@Test(expected = AssertionError.class)
	public void isDateNotDecember() {
		assertThat(AUG_04_2015_NOON_AS_DATE, DateMatchers.isDecember());
	}

	// LocalDate Matchers
	@Test
	public void isLocalDateJanuary() {
		assertThat(JAN_01_2015, LocalDateMatchers.isJanuary());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotJanuary() {
		assertThat(AUG_04_2015, LocalDateMatchers.isJanuary());
	}

	@Test
	public void isLocalDateFebruary() {
		assertThat(FEB_01_2015, LocalDateMatchers.isFebruary());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotFebruary() {
		assertThat(AUG_04_2015, LocalDateMatchers.isFebruary());
	}

	@Test
	public void isLocalDateMarch() {
		assertThat(MAR_01_2015, LocalDateMatchers.isMarch());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotMarch() {
		assertThat(AUG_04_2015, LocalDateMatchers.isMarch());
	}

	@Test
	public void isLocalDateApril() {
		assertThat(APR_01_2015, LocalDateMatchers.isApril());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotApril() {
		assertThat(AUG_04_2015, LocalDateMatchers.isApril());
	}

	@Test
	public void isLocalDateMay() {
		assertThat(MAY_01_2015, LocalDateMatchers.isMay());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotMay() {
		assertThat(AUG_04_2015, LocalDateMatchers.isMay());
	}

	@Test
	public void isLocalDateJune() {
		assertThat(JUN_01_2015, LocalDateMatchers.isJune());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotJune() {
		assertThat(AUG_04_2015, LocalDateMatchers.isJune());
	}

	@Test
	public void isLocalDateJuly() {
		assertThat(JUL_01_2015, LocalDateMatchers.isJuly());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotJuly() {
		assertThat(AUG_04_2015, LocalDateMatchers.isJuly());
	}

	@Test
	public void isLocalDateAugust() {
		assertThat(AUG_01_2015, LocalDateMatchers.isAugust());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotAugust() {
		assertThat(SEP_04_2015, LocalDateMatchers.isAugust());
	}

	@Test
	public void isLocalDateSeptember() {
		assertThat(SEP_04_2015, LocalDateMatchers.isSeptember());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotSeptember() {
		assertThat(AUG_04_2015, LocalDateMatchers.isSeptember());
	}

	@Test
	public void isLocalDateOctober() {
		assertThat(OCT_01_2015, LocalDateMatchers.isOctober());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotOctober() {
		assertThat(AUG_04_2015, LocalDateMatchers.isOctober());
	}

	@Test
	public void isLocalDateNovember() {
		assertThat(NOV_01_2015, LocalDateMatchers.isNovember());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotNovember() {
		assertThat(AUG_04_2015, LocalDateMatchers.isNovember());
	}

	@Test
	public void isLocalDateDecember() {
		assertThat(DEC_01_2015, LocalDateMatchers.isDecember());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotDecember() {
		assertThat(AUG_04_2015, LocalDateMatchers.isDecember());
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeJanuary() {
		assertThat(JAN_01_2015_NOON, LocalDateTimeMatchers.isJanuary());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotJanuary() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isJanuary());
	}

	@Test
	public void isLocalDateTimeFebruary() {
		assertThat(FEB_01_2015_NOON, LocalDateTimeMatchers.isFebruary());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotFebruary() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isFebruary());
	}

	@Test
	public void isLocalDateTimeMarch() {
		assertThat(MAR_01_2015_NOON, LocalDateTimeMatchers.isMarch());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotMarch() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isMarch());
	}

	@Test
	public void isLocalDateTimeApril() {
		assertThat(APR_01_2015_NOON, LocalDateTimeMatchers.isApril());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotApril() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isApril());
	}

	@Test
	public void isLocalDateTimeMay() {
		assertThat(MAY_01_2015_NOON, LocalDateTimeMatchers.isMay());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotMay() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isMay());
	}

	@Test
	public void isLocalDateTimeJune() {
		assertThat(JUN_01_2015_NOON, LocalDateTimeMatchers.isJune());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotJune() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isJune());
	}

	@Test
	public void isLocalDateTimeJuly() {
		assertThat(JUL_01_2015_NOON, LocalDateTimeMatchers.isJuly());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotJuly() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isJuly());
	}

	@Test
	public void isLocalDateTimeAugust() {
		assertThat(AUG_01_2015_NOON, LocalDateTimeMatchers.isAugust());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotAugust() {
		assertThat(SEP_04_2015_NOON, LocalDateTimeMatchers.isAugust());
	}

	@Test
	public void isLocalDateTimeSeptember() {
		assertThat(SEP_04_2015_NOON, LocalDateTimeMatchers.isSeptember());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotSeptember() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isSeptember());
	}

	@Test
	public void isLocalDateTimeOctober() {
		assertThat(OCT_01_2015_NOON, LocalDateTimeMatchers.isOctober());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotOctober() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isOctober());
	}

	@Test
	public void isLocalDateTimeNovember() {
		assertThat(NOV_01_2015_NOON, LocalDateTimeMatchers.isNovember());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotNovember() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isNovember());
	}

	@Test
	public void isLocalDateTimeDecember() {
		assertThat(DEC_01_2015_NOON, LocalDateTimeMatchers.isDecember());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotDecember() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isDecember());
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeJanuary() {
		assertThat(JAN_01_2015_NOON_UTC, ZonedDateTimeMatchers.isJanuary());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotJanuary() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isJanuary());
	}

	@Test
	public void isZonedDateTimeFebruary() {
		assertThat(FEB_01_2015_NOON_UTC, ZonedDateTimeMatchers.isFebruary());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotFebruary() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isFebruary());
	}

	@Test
	public void isZonedDateTimeMarch() {
		assertThat(MAR_01_2015_NOON_UTC, ZonedDateTimeMatchers.isMarch());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotMarch() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isMarch());
	}

	@Test
	public void isZonedDateTimeApril() {
		assertThat(APR_01_2015_NOON_UTC, ZonedDateTimeMatchers.isApril());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotApril() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isApril());
	}

	@Test
	public void isZonedDateTimeMay() {
		assertThat(MAY_01_2015_NOON_UTC, ZonedDateTimeMatchers.isMay());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotMay() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isMay());
	}

	@Test
	public void isZonedDateTimeJune() {
		assertThat(JUN_01_2015_NOON_UTC, ZonedDateTimeMatchers.isJune());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotJune() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isJune());
	}

	@Test
	public void isZonedDateTimeJuly() {
		assertThat(JUL_01_2015_NOON_UTC, ZonedDateTimeMatchers.isJuly());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotJuly() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isJuly());
	}

	@Test
	public void isZonedDateTimeAugust() {
		assertThat(AUG_01_2015_NOON_UTC, ZonedDateTimeMatchers.isAugust());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotAugust() {
		assertThat(SEP_04_2015_NOON_UTC, ZonedDateTimeMatchers.isAugust());
	}

	@Test
	public void isZonedDateTimeSeptember() {
		assertThat(SEP_04_2015_NOON_UTC, ZonedDateTimeMatchers.isSeptember());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotSeptember() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isSeptember());
	}

	@Test
	public void isZonedDateTimeOctober() {
		assertThat(OCT_01_2015_NOON_UTC, ZonedDateTimeMatchers.isOctober());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotOctober() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isOctober());
	}

	@Test
	public void isZonedDateTimeNovember() {
		assertThat(NOV_01_2015_NOON_UTC, ZonedDateTimeMatchers.isNovember());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotNovember() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isNovember());
	}

	@Test
	public void isZonedDateTimeDecember() {
		assertThat(DEC_01_2015_NOON_UTC, ZonedDateTimeMatchers.isDecember());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotDecember() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isDecember());
	}

}
