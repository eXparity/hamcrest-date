package org.exparity.hamcrest.date.joda;

import static org.exparity.hamcrest.date.testutils.JodaDates.APR_01_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.APR_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.APR_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_01_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.DEC_01_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.DEC_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.DEC_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.FEB_01_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.FEB_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.FEB_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.JAN_01_2012;
import static org.exparity.hamcrest.date.testutils.JodaDates.JAN_01_2012_11AM;
import static org.exparity.hamcrest.date.testutils.JodaDates.JAN_01_2012_11AM_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.JAN_01_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.JAN_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.JAN_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.JUL_01_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.JUL_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.JUL_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.JUN_01_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.JUN_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.JUN_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.MAR_01_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.MAR_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.MAR_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.MAY_01_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.MAY_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.MAY_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.NOV_01_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.NOV_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.NOV_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.OCT_01_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.OCT_01_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.OCT_01_2015_NOON_UTC;
import static org.exparity.hamcrest.date.testutils.JodaDates.SEP_04_2015;
import static org.exparity.hamcrest.date.testutils.JodaDates.SEP_04_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.SEP_04_2015_NOON_UTC;
import static org.hamcrest.MatcherAssert.assertThat;

import org.exparity.hamcrest.date.core.IsMonth;
import org.joda.time.DateTimeConstants;
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link IsMonth} class
 *
 * @author Thomas Naskali
 */
public class IsMonthTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the month [0-9]+?\\s     but: the date has the month [0-9]+?";

	// LocalDate Matchers
	@Test
	public void isLocalDateMonth() {
		assertThat(JAN_01_2015, JodaLocalDateMatchers.isMonth(DateTimeConstants.JANUARY));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotMonth() {
		assertThat(JAN_01_2015, JodaLocalDateMatchers.isMonth(DateTimeConstants.FEBRUARY));
	}

	@Test
	public void isLocalDateSameMonth() {
		assertThat(JAN_01_2015, JodaLocalDateMatchers.sameMonthOfYear(JAN_01_2012));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotSameMonth() {
		assertThat(JAN_01_2015, JodaLocalDateMatchers.sameMonthOfYear(JAN_01_2015.withMonthOfYear(DateTimeConstants.FEBRUARY)));
	}

	@Test
	public void isLocalDateJanuary() {
		assertThat(JAN_01_2015, JodaLocalDateMatchers.isJanuary());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotJanuary() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.isJanuary());
	}

	@Test
	public void isLocalDateFebruary() {
		assertThat(FEB_01_2015, JodaLocalDateMatchers.isFebruary());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotFebruary() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.isFebruary());
	}

	@Test
	public void isLocalDateMarch() {
		assertThat(MAR_01_2015, JodaLocalDateMatchers.isMarch());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotMarch() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.isMarch());
	}

	@Test
	public void isLocalDateApril() {
		assertThat(APR_01_2015, JodaLocalDateMatchers.isApril());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotApril() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.isApril());
	}

	@Test
	public void isLocalDateMay() {
		assertThat(MAY_01_2015, JodaLocalDateMatchers.isMay());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotMay() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.isMay());
	}

	@Test
	public void isLocalDateJune() {
		assertThat(JUN_01_2015, JodaLocalDateMatchers.isJune());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotJune() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.isJune());
	}

	@Test
	public void isLocalDateJuly() {
		assertThat(JUL_01_2015, JodaLocalDateMatchers.isJuly());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotJuly() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.isJuly());
	}

	@Test
	public void isLocalDateAugust() {
		assertThat(AUG_01_2015, JodaLocalDateMatchers.isAugust());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotAugust() {
		assertThat(SEP_04_2015, JodaLocalDateMatchers.isAugust());
	}

	@Test
	public void isLocalDateSeptember() {
		assertThat(SEP_04_2015, JodaLocalDateMatchers.isSeptember());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotSeptember() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.isSeptember());
	}

	@Test
	public void isLocalDateOctober() {
		assertThat(OCT_01_2015, JodaLocalDateMatchers.isOctober());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotOctober() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.isOctober());
	}

	@Test
	public void isLocalDateNovember() {
		assertThat(NOV_01_2015, JodaLocalDateMatchers.isNovember());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotNovember() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.isNovember());
	}

	@Test
	public void isLocalDateDecember() {
		assertThat(DEC_01_2015, JodaLocalDateMatchers.isDecember());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotDecember() {
		assertThat(AUG_04_2015, JodaLocalDateMatchers.isDecember());
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeMonth() {
		assertThat(JAN_01_2015_NOON, JodaLocalDateTimeMatchers.isMonth(DateTimeConstants.JANUARY));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotMonth() {
		assertThat(JAN_01_2015_NOON, JodaLocalDateTimeMatchers.isMonth(DateTimeConstants.FEBRUARY));
	}

	@Test
	public void isLocalDateTimeSameMonth() {
		assertThat(JAN_01_2015_NOON, JodaLocalDateTimeMatchers.sameMonthOfYear(JAN_01_2012_11AM));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotSameMonth() {
		assertThat(JAN_01_2015_NOON, JodaLocalDateTimeMatchers.sameMonthOfYear(JAN_01_2015_NOON.withMonthOfYear(DateTimeConstants.FEBRUARY)));
	}

	@Test
	public void isLocalDateTimeJanuary() {
		assertThat(JAN_01_2015_NOON, JodaLocalDateTimeMatchers.isJanuary());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotJanuary() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isJanuary());
	}

	@Test
	public void isLocalDateTimeFebruary() {
		assertThat(FEB_01_2015_NOON, JodaLocalDateTimeMatchers.isFebruary());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotFebruary() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isFebruary());
	}

	@Test
	public void isLocalDateTimeMarch() {
		assertThat(MAR_01_2015_NOON, JodaLocalDateTimeMatchers.isMarch());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotMarch() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isMarch());
	}

	@Test
	public void isLocalDateTimeApril() {
		assertThat(APR_01_2015_NOON, JodaLocalDateTimeMatchers.isApril());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotApril() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isApril());
	}

	@Test
	public void isLocalDateTimeMay() {
		assertThat(MAY_01_2015_NOON, JodaLocalDateTimeMatchers.isMay());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotMay() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isMay());
	}

	@Test
	public void isLocalDateTimeJune() {
		assertThat(JUN_01_2015_NOON, JodaLocalDateTimeMatchers.isJune());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotJune() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isJune());
	}

	@Test
	public void isLocalDateTimeJuly() {
		assertThat(JUL_01_2015_NOON, JodaLocalDateTimeMatchers.isJuly());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotJuly() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isJuly());
	}

	@Test
	public void isLocalDateTimeAugust() {
		assertThat(AUG_01_2015_NOON, JodaLocalDateTimeMatchers.isAugust());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotAugust() {
		assertThat(SEP_04_2015_NOON, JodaLocalDateTimeMatchers.isAugust());
	}

	@Test
	public void isLocalDateTimeSeptember() {
		assertThat(SEP_04_2015_NOON, JodaLocalDateTimeMatchers.isSeptember());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotSeptember() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isSeptember());
	}

	@Test
	public void isLocalDateTimeOctober() {
		assertThat(OCT_01_2015_NOON, JodaLocalDateTimeMatchers.isOctober());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotOctober() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isOctober());
	}

	@Test
	public void isLocalDateTimeNovember() {
		assertThat(NOV_01_2015_NOON, JodaLocalDateTimeMatchers.isNovember());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotNovember() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isNovember());
	}

	@Test
	public void isLocalDateTimeDecember() {
		assertThat(DEC_01_2015_NOON, JodaLocalDateTimeMatchers.isDecember());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotDecember() {
		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.isDecember());
	}

	// DateTime Matchers
	@Test
	public void isDateTimeMonth() {
		assertThat(JAN_01_2015_NOON_UTC, JodaDateTimeMatchers.isMonth(DateTimeConstants.JANUARY));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeNotMonth() {
		assertThat(JAN_01_2015_NOON_UTC, JodaDateTimeMatchers.isMonth(DateTimeConstants.FEBRUARY));
	}

	@Test
	public void isDateTimeSameMonth() {
		assertThat(JAN_01_2015_NOON_UTC, JodaDateTimeMatchers.sameMonthOfYear(JAN_01_2012_11AM_UTC));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateTimeNotSameMonth() {
		assertThat(JAN_01_2015_NOON_UTC, JodaDateTimeMatchers.sameMonthOfYear(JAN_01_2015_NOON_UTC.withMonthOfYear(DateTimeConstants.FEBRUARY)));
	}

	@Test
	public void isZonedDateTimeJanuary() {
		assertThat(JAN_01_2015_NOON_UTC, JodaDateTimeMatchers.isJanuary());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotJanuary() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isJanuary());
	}

	@Test
	public void isZonedDateTimeFebruary() {
		assertThat(FEB_01_2015_NOON_UTC, JodaDateTimeMatchers.isFebruary());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotFebruary() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isFebruary());
	}

	@Test
	public void isZonedDateTimeMarch() {
		assertThat(MAR_01_2015_NOON_UTC, JodaDateTimeMatchers.isMarch());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotMarch() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isMarch());
	}

	@Test
	public void isZonedDateTimeApril() {
		assertThat(APR_01_2015_NOON_UTC, JodaDateTimeMatchers.isApril());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotApril() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isApril());
	}

	@Test
	public void isZonedDateTimeMay() {
		assertThat(MAY_01_2015_NOON_UTC, JodaDateTimeMatchers.isMay());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotMay() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isMay());
	}

	@Test
	public void isZonedDateTimeJune() {
		assertThat(JUN_01_2015_NOON_UTC, JodaDateTimeMatchers.isJune());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotJune() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isJune());
	}

	@Test
	public void isZonedDateTimeJuly() {
		assertThat(JUL_01_2015_NOON_UTC, JodaDateTimeMatchers.isJuly());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotJuly() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isJuly());
	}

	@Test
	public void isZonedDateTimeAugust() {
		assertThat(AUG_01_2015_NOON_UTC, JodaDateTimeMatchers.isAugust());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotAugust() {
		assertThat(SEP_04_2015_NOON_UTC, JodaDateTimeMatchers.isAugust());
	}

	@Test
	public void isZonedDateTimeSeptember() {
		assertThat(SEP_04_2015_NOON_UTC, JodaDateTimeMatchers.isSeptember());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotSeptember() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isSeptember());
	}

	@Test
	public void isZonedDateTimeOctober() {
		assertThat(OCT_01_2015_NOON_UTC, JodaDateTimeMatchers.isOctober());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotOctober() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isOctober());
	}

	@Test
	public void isZonedDateTimeNovember() {
		assertThat(NOV_01_2015_NOON_UTC, JodaDateTimeMatchers.isNovember());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotNovember() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isNovember());
	}

	@Test
	public void isZonedDateTimeDecember() {
		assertThat(DEC_01_2015_NOON_UTC, JodaDateTimeMatchers.isDecember());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotDecember() {
		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.isDecember());
	}

}
