package org.exparity.hamcrest.date;

import static java.time.DayOfWeek.MONDAY;
import static java.time.Month.*;
import static org.exparity.hamcrest.date.LocalDateMatchers.*;
import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.UnsupportedTemporalTypeException;

import org.junit.Test;

/**
 * Unit Test for {@link LocalDateMatchers}
 * 
 * @author Stewart Bissett
 */
public class LocalDateMatchersTest {

	@Test
	public void canTestAfterWithEarlierLocalDate() {
		assertThat(AUG_04_2015, after(AUG_03_2015));
	}

	@Test(expected = AssertionError.class)
	public void canTestAfterWithSameLocalDate() {
		assertThat(AUG_04_2015, after(AUG_04_2015));
	}

	@Test(expected = AssertionError.class)
	public void canTestAfterWithLaterLocalDate() {
		assertThat(AUG_04_2015, after(AUG_05_2015));
	}

	@Test
	public void canTestAfterWithEarlierDate() {
		assertThat(AUG_04_2015, after(AUG_03_2015_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestAfterWithSameDate() {
		assertThat(AUG_04_2015, after(AUG_04_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestAfterWithLaterDate() {
		assertThat(AUG_04_2015, after(AUG_05_2015_AS_DATE));
	}

	@Test
	public void canTestAfterWithEarlierDMY() {
		assertThat(AUG_04_2015, after(2015, AUGUST, 3));
	}

	@Test(expected = AssertionError.class)
	public void canTestAfterWithSameDMY() {
		assertThat(AUG_04_2015, after(2015, AUGUST, 4));
	}

	@Test(expected = AssertionError.class)
	public void canTestAfterWithLaterDDMY() {
		assertThat(AUG_04_2015, after(2015, AUGUST, 5));
	}

	@Test(expected = AssertionError.class)
	public void canTestBeforeWithEarlierLocalDate() {
		assertThat(AUG_04_2015, before(AUG_03_2015));
	}

	@Test(expected = AssertionError.class)
	public void canTestBeforeWithSameLocalDate() {
		assertThat(AUG_04_2015, before(AUG_04_2015));
	}

	@Test
	public void canTestBeforeWithLaterLocalDate() {
		assertThat(AUG_04_2015, before(AUG_05_2015));
	}

	@Test(expected = AssertionError.class)
	public void canTestBeforeWithEarlierDate() {
		assertThat(AUG_04_2015, before(AUG_03_2015_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestBeforeWithSameDate() {
		assertThat(AUG_04_2015, before(AUG_04_2015_NOON_AS_DATE));
	}

	@Test
	public void canTestBeforeWithLaterDate() {
		assertThat(AUG_04_2015, before(AUG_05_2015_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestBeforeWithEarlierDMY() {
		assertThat(AUG_04_2015, before(2015, AUGUST, 3));
	}

	@Test(expected = AssertionError.class)
	public void canTestBeforeWithSameDMY() {
		assertThat(AUG_04_2015, before(2015, AUGUST, 4));
	}

	@Test
	public void canTestBeforeWithLaterDDMY() {
		assertThat(AUG_04_2015, before(2015, AUGUST, 5));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameDayWithEarlierLocalDate() {
		assertThat(AUG_04_2015, sameDay(AUG_03_2015));
	}

	@Test
	public void canTestSameDayWithSameLocalDate() {
		assertThat(AUG_04_2015, sameDay(AUG_04_2015));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameDayWithLaterLocalDate() {
		assertThat(AUG_04_2015, sameDay(AUG_05_2015));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameDayWithEarlierDate() {
		assertThat(AUG_04_2015, sameDay(AUG_03_2015_AS_DATE));
	}

	@Test
	public void canTestSameDayWithSameDate() {
		assertThat(AUG_04_2015, sameDay(AUG_04_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameDayWithLaterDate() {
		assertThat(AUG_04_2015, sameDay(AUG_05_2015_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameDayWithEarlierDMY() {
		assertThat(AUG_04_2015, sameDay(2015, AUGUST, 3));
	}

	@Test
	public void canTestSameDayWithSameDMY() {
		assertThat(AUG_04_2015, sameDay(2015, AUGUST, 4));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameDayWithLaterDDMY() {
		assertThat(AUG_04_2015, sameDay(2015, AUGUST, 5));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameOrBeforeWithEarlierLocalDate() {
		assertThat(AUG_04_2015, sameOrBefore(AUG_03_2015));
	}

	@Test
	public void canTestSameOrBeforeWithSameLocalDate() {
		assertThat(AUG_04_2015, sameOrBefore(AUG_04_2015));
	}

	@Test
	public void canTestSameOrBeforeWithLaterLocalDate() {
		assertThat(AUG_04_2015, sameOrBefore(AUG_05_2015));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameOrBeforeWithEarlierDate() {
		assertThat(AUG_04_2015, sameOrBefore(AUG_03_2015_AS_DATE));
	}

	@Test
	public void canTestSameOrBeforeWithSameDate() {
		assertThat(AUG_04_2015, sameOrBefore(AUG_04_2015_NOON_AS_DATE));
	}

	@Test
	public void canTestSameOrBeforeWithLaterDate() {
		assertThat(AUG_04_2015, sameOrBefore(AUG_05_2015_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameOrBeforeWithEarlierDMY() {
		assertThat(AUG_04_2015, sameOrBefore(2015, AUGUST, 3));
	}

	@Test
	public void canTestSameOrBeforeWithSameDMY() {
		assertThat(AUG_04_2015, sameOrBefore(2015, AUGUST, 4));
	}

	@Test
	public void canTestSameOrBeforeWithLaterDDMY() {
		assertThat(AUG_04_2015, sameOrBefore(2015, AUGUST, 5));
	}

	@Test
	public void canTestSameOrAfterWithEarlierLocalDate() {
		assertThat(AUG_04_2015, sameOrAfter(AUG_03_2015));
	}

	@Test
	public void canTestSameOrAfterWithSameLocalDate() {
		assertThat(AUG_04_2015, sameOrAfter(AUG_04_2015));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameOrAfterWithLaterLocalDate() {
		assertThat(AUG_04_2015, sameOrAfter(AUG_05_2015));
	}

	@Test
	public void canTestSameOrAfterWithEarlierDate() {
		assertThat(AUG_04_2015, sameOrAfter(AUG_03_2015_AS_DATE));
	}

	@Test
	public void canTestSameOrAfterWithSameDate() {
		assertThat(AUG_04_2015, sameOrAfter(AUG_04_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameOrAfterWithLaterDate() {
		assertThat(AUG_04_2015, sameOrAfter(AUG_05_2015_AS_DATE));
	}

	@Test
	public void canTestSameOrAfterWithEarlierDMY() {
		assertThat(AUG_04_2015, sameOrAfter(2015, AUGUST, 3));
	}

	@Test
	public void canTestSameOrAfterWithSameDMY() {
		assertThat(AUG_04_2015, sameOrAfter(2015, AUGUST, 4));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameOrAfterWithLaterDDMY() {
		assertThat(AUG_04_2015, sameOrAfter(2015, AUGUST, 5));
	}

	@Test
	public void canTestSameMonthOfYearWithSameLocalDate() {
		assertThat(AUG_04_2015, sameMonthOfYear(AUG_04_2015));
	}

	@Test
	public void canTestSameMonthOfYearWithDifferentLocalDateSameMonth() {
		assertThat(AUG_04_2015, sameMonthOfYear(AUG_03_2015));
	}

	@Test
	public void canTestSameMonthOfYearWithDifferentLocalDateSameMonthDifferentYear() {
		assertThat(AUG_04_2015, sameMonthOfYear(AUG_04_2016));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameMonthOfYearWithDifferentLocalDateMonth() {
		assertThat(AUG_04_2015, sameMonthOfYear(SEP_04_2015));
	}

	@Test
	public void canTestSameMonthOfYearWithSameDate() {
		assertThat(AUG_04_2015, sameMonthOfYear(AUG_04_2015_NOON_AS_DATE));
	}

	@Test
	public void canTestSameMonthOfYearWithDifferentDateSameMonth() {
		assertThat(AUG_04_2015, sameMonthOfYear(AUG_03_2015_AS_DATE));
	}

	@Test
	public void canTestSameMonthOfYearWithDifferentDateSameMonthDifferentYear() {
		assertThat(AUG_04_2015, sameMonthOfYear(AUG_04_2016_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameMonthOfYearWithDifferentDateMonth() {
		assertThat(AUG_04_2015, sameMonthOfYear(SEP_04_2015_AS_DATE));
	}

	@Test
	public void canTestIsSameMonth() {
		assertThat(AUG_04_2015, isMonth(AUGUST));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsDifferentMonth() {
		assertThat(AUG_04_2015, isMonth(SEPTEMBER));
	}

	@Test
	public void canTestSameYearWithSameLocalDate() {
		assertThat(AUG_04_2015, sameYear(AUG_04_2015));
	}

	@Test
	public void canTestSameYearWithDifferentLocalDateSameYear() {
		assertThat(AUG_04_2015, sameYear(AUG_03_2015));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameYearWithDifferentLocalDateDifferentYear() {
		assertThat(AUG_04_2015, sameYear(AUG_04_2016));
	}

	@Test
	public void canTestSameYearWithSameDate() {
		assertThat(AUG_04_2015, sameYear(AUG_04_2015_NOON_AS_DATE));
	}

	@Test
	public void canTestSameYearWithDifferentDateSameYear() {
		assertThat(AUG_04_2015, sameYear(AUG_03_2015_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameYearWithDifferentDateSameDifferentYear() {
		assertThat(AUG_04_2015, sameYear(AUG_04_2016_AS_DATE));
	}

	@Test
	public void canTestIsSameYear() {
		assertThat(AUG_04_2015, isYear(2015));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsDifferentYear() {
		assertThat(AUG_04_2016, isYear(2015));
	}

	@Test
	public void canTestWithinIntervalLocalDate() {
		assertThat(AUG_03_2015, within(1, ChronoUnit.DAYS, AUG_04_2015));
	}

	@Test(expected = AssertionError.class)
	public void canTestWithinOutsideIntervalLocalDate() {
		assertThat(AUG_03_2015, within(1, ChronoUnit.DAYS, AUG_05_2015));
	}

	@Test
	public void canTestWithinIntervalDate() {
		assertThat(AUG_03_2015, within(1, ChronoUnit.DAYS, AUG_04_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestWithinOutsideIntervalDate() {
		assertThat(AUG_03_2015, within(1, ChronoUnit.DAYS, AUG_05_2015_AS_DATE));
	}

	@Test
	public void canTestWithinIntervalDMY() {
		assertThat(AUG_03_2015, within(1, ChronoUnit.DAYS, 2015, AUGUST, 4));
	}

	@Test(expected = AssertionError.class)
	public void canTestWithinOutsideIntervalDMY() {
		assertThat(AUG_03_2015, within(1, ChronoUnit.DAYS, 2015, AUGUST, 5));
	}

	@Test(expected = UnsupportedTemporalTypeException.class)
	public void canTestWithinTimeIntervalLocalDateTime() {
		assertThat(AUG_04_2015, within(1, ChronoUnit.SECONDS, AUG_04_2015));
	}

	@Test(expected = UnsupportedTemporalTypeException.class)
	public void canTestWithinTimeIntervalDate() {
		assertThat(AUG_04_2015, within(1, ChronoUnit.SECONDS, AUG_04_2015_NOON_AS_DATE));
	}

	@Test(expected = UnsupportedTemporalTypeException.class)
	public void canTestWithinTimeIntervalDMY() {
		assertThat(AUG_04_2015, within(1, ChronoUnit.SECONDS, 2015, AUGUST, 4));
	}

	@Test
	public void canTestIsYesterday() {
		assertThat(yesterday(), isYesterday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotYesterday() {
		assertThat(today(), isYesterday());
	}

	@Test
	public void canTestIsToday() {
		assertThat(today(), isToday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotToday() {
		assertThat(tomorrow(), isToday());
	}

	@Test
	public void canTestIsTomorrow() {
		assertThat(tomorrow(), isTomorrow());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotTomorrow() {
		assertThat(today(), isTomorrow());
	}

	@Test
	public void canTestIsDayOfWeek() {
		assertThat(AUG_03_2015, isDayOfWeek(MONDAY));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotDayOfWeek() {
		assertThat(AUG_04_2015, isDayOfWeek(DayOfWeek.MONDAY));
	}

	@Test
	public void canTestIsMonday() {
		assertThat(AUG_03_2015, isMonday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotMonday() {
		assertThat(AUG_04_2015, isMonday());
	}

	@Test
	public void canTestIsTuesday() {
		assertThat(AUG_04_2015, isTuesday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotTuesday() {
		assertThat(AUG_05_2015, isTuesday());
	}

	@Test
	public void canTestIsWednesday() {
		assertThat(AUG_05_2015, isWednesday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWednesday() {
		assertThat(AUG_06_2015, isWednesday());
	}

	@Test
	public void canTestIsThursday() {
		assertThat(AUG_06_2015, isThursday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotThursday() {
		assertThat(AUG_07_2015, isThursday());
	}

	@Test
	public void canTestIsFriday() {
		assertThat(AUG_07_2015, isFriday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotFriday() {
		assertThat(AUG_08_2015, isFriday());
	}

	@Test
	public void canTestIsSaturday() {
		assertThat(AUG_08_2015, isSaturday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotSaturday() {
		assertThat(AUG_09_2015, isSaturday());
	}

	@Test
	public void canTestIsSunday() {
		assertThat(AUG_09_2015, isSunday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotSunday() {
		assertThat(AUG_03_2015, isSunday());
	}

	@Test
	public void canTestIsWeekday() {
		assertThat(AUG_03_2015, isWeekday());
		assertThat(AUG_04_2015, isWeekday());
		assertThat(AUG_05_2015, isWeekday());
		assertThat(AUG_06_2015, isWeekday());
		assertThat(AUG_07_2015, isWeekday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWeekdayOnSaturday() {
		assertThat(AUG_08_2015, isWeekday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWeekdayOnSunday() {
		assertThat(AUG_09_2015, isWeekday());
	}

	@Test
	public void canTestIsWeekend() {
		assertThat(AUG_08_2015, isWeekend());
		assertThat(AUG_09_2015, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWeekendOnMonday() {
		assertThat(AUG_03_2015, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWeekendOnTuesday() {
		assertThat(AUG_04_2015, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWeekendOnWednesday() {
		assertThat(AUG_05_2015, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWeekendOnThursday() {
		assertThat(AUG_06_2015, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWeekendOnFriday() {
		assertThat(AUG_07_2015, isWeekend());
	}

	@Test
	public void canTestIsFirstDayOfMonth() {
		assertThat(AUG_01_2015, isFirstDayOfMonth());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotFirstDayOfMonth() {
		assertThat(AUG_03_2015, isFirstDayOfMonth());
	}

	@Test
	public void canTestIsMinimum() {
		assertThat(AUG_01_2015, isMinimum(ChronoField.DAY_OF_MONTH));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotMinimum() {
		assertThat(AUG_03_2015, isMinimum(ChronoField.DAY_OF_MONTH));
	}

	@Test
	public void canTestIsLastDayOfMonthAugust() {
		assertThat(AUG_31_2015, isLastDayOfMonth());
	}

	@Test
	public void canTestIsLastDayOfMonthSeptember() {
		assertThat(SEP_30_2015, isLastDayOfMonth());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotLastDayOfMonth() {
		assertThat(AUG_01_2015, isLastDayOfMonth());
	}

	@Test
	public void canTestIsMaximum() {
		assertThat(AUG_31_2015, isMaximum(ChronoField.DAY_OF_MONTH));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotMaximum() {
		assertThat(AUG_01_2015, isMaximum(ChronoField.DAY_OF_MONTH));
	}

	@Test
	public void canTestIsMonth() {
		assertThat(AUG_04_2015, isMonth(AUGUST));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotMonth() {
		assertThat(AUG_04_2015, isMonth(SEPTEMBER));
	}

	@Test
	public void canTestIsJanuary() {
		assertThat(JAN_01_2015, isJanuary());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotJanuary() {
		assertThat(AUG_04_2015, isJanuary());
	}

	@Test
	public void canTestIsFebruary() {
		assertThat(FEB_01_2015, isFebruary());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotFebruary() {
		assertThat(AUG_04_2015, isFebruary());
	}

	@Test
	public void canTestIsMarch() {
		assertThat(MAR_01_2015, isMarch());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotMarch() {
		assertThat(AUG_04_2015, isMarch());
	}

	@Test
	public void canTestIsApril() {
		assertThat(APR_01_2015, isApril());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotApril() {
		assertThat(AUG_04_2015, isApril());
	}

	@Test
	public void canTestIsMay() {
		assertThat(MAY_01_2015, isMay());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotMay() {
		assertThat(AUG_04_2015, isMay());
	}

	@Test
	public void canTestIsJune() {
		assertThat(JUN_01_2015, isJune());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotJune() {
		assertThat(AUG_04_2015, isJune());
	}

	@Test
	public void canTestIsJuly() {
		assertThat(JUL_01_2015, isJuly());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotJuly() {
		assertThat(AUG_04_2015, isJuly());
	}

	@Test
	public void canTestIsAugust() {
		assertThat(AUG_01_2015, isAugust());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotAugust() {
		assertThat(SEP_04_2015, isAugust());
	}

	@Test
	public void canTestIsSeptember() {
		assertThat(SEP_04_2015, isSeptember());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotSeptember() {
		assertThat(AUG_04_2015, isSeptember());
	}

	@Test
	public void canTestIsOctober() {
		assertThat(OCT_01_2015, isOctober());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotOctober() {
		assertThat(AUG_04_2015, isOctober());
	}

	@Test
	public void canTestIsNovember() {
		assertThat(NOV_01_2015, isNovember());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotNovember() {
		assertThat(AUG_04_2015, isNovember());
	}

	@Test
	public void canTestIsDecember() {
		assertThat(DEC_01_2015, isDecember());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotDecember() {
		assertThat(AUG_04_2015, isDecember());
	}

	@Test
	public void canTestIsLeapYear() {
		assertThat(AUG_04_2016, isLeapYear());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotLeapYear() {
		assertThat(AUG_04_2015, isLeapYear());
	}

	@Test
	public void canTestIsDayOfMonth() {
		assertThat(AUG_04_2015, isDayOfMonth(4));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotDayOfMonth() {
		assertThat(AUG_04_2015, isDayOfMonth(5));
	}

	@Test
	public void canTestSameDayOfMonth() {
		assertThat(AUG_04_2015, sameDayOfMonth(AUG_04_2015));
	}

	@Test(expected = AssertionError.class)
	public void canTestNotSameDayOfMonth() {
		assertThat(AUG_04_2015, sameDayOfMonth(AUG_05_2015));
	}

	@Test
	public void canTestSameDayOfMonthAsDate() {
		assertThat(AUG_04_2015, sameDayOfMonth(AUG_04_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestNotSameDayOfMonthAsDate() {
		assertThat(AUG_04_2015, sameDayOfMonth(AUG_05_2015_AS_DATE));
	}

	private LocalDate yesterday() {
		return LocalDate.now().minusDays(1);
	}

	private LocalDate today() {
		return LocalDate.now();
	}

	private LocalDate tomorrow() {
		return LocalDate.now().plusDays(1);
	}

}
