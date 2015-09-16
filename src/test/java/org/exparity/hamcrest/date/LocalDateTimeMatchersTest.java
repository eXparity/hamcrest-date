package org.exparity.hamcrest.date;

import static java.time.DayOfWeek.MONDAY;
import static java.time.Month.*;
import static org.exparity.hamcrest.date.LocalDateTimeMatchers.*;
import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

/**
 * Unit Test for {@link LocalDateTimeMatchers}
 * 
 * @author Stewart Bissett
 */
public class LocalDateTimeMatchersTest {

	@Test
	public void canTestAfterWithEarlierLocalDateTime() {
		assertThat(AUG_4_2015_NOON, after(AUG_4_2015_1159));
	}

	@Test(expected = AssertionError.class)
	public void canTestAfterWithSameLocalDateTime() {
		assertThat(AUG_4_2015_NOON, after(AUG_4_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void canTestAfterWithLaterLocalDateTime() {
		assertThat(AUG_4_2015_NOON, after(AUG_4_2015_1201));
	}

	@Test
	public void canTestAfterWithEarlierDate() {
		assertThat(AUG_4_2015_NOON, after(AUG_4_2015_AT_11_59_59_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestAfterWithSameDate() {
		assertThat(AUG_4_2015_NOON, after(AUG_4_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestAfterWithLaterDate() {
		assertThat(AUG_4_2015_NOON, after(AUG_4_2015_AT_12_00_01_AS_DATE));
	}

	@Test
	public void canTestAfterWithEarlierDMY() {
		assertThat(AUG_4_2015_NOON, after(2015, AUGUST, 4, 11, 59, 59));
	}

	@Test(expected = AssertionError.class)
	public void canTestAfterWithSameDMY() {
		assertThat(AUG_4_2015_NOON, after(2015, AUGUST, 4, 12, 0, 0));
	}

	@Test(expected = AssertionError.class)
	public void canTestAfterWithLaterDDMY() {
		assertThat(AUG_4_2015_NOON, after(2015, AUGUST, 4, 12, 0, 1));
	}

	@Test(expected = AssertionError.class)
	public void canTestBeforeWithEarlierLocalDateTime() {
		assertThat(AUG_4_2015_NOON, before(AUG_4_2015_1159));
	}

	@Test(expected = AssertionError.class)
	public void canTestBeforeWithSameLocalDateTime() {
		assertThat(AUG_4_2015_NOON, before(AUG_4_2015_NOON));
	}

	@Test
	public void canTestBeforeWithLaterLocalDateTime() {
		assertThat(AUG_4_2015_NOON, before(AUG_4_2015_1201));
	}

	@Test(expected = AssertionError.class)
	public void canTestBeforeWithEarlierDate() {
		assertThat(AUG_4_2015_NOON, before(AUG_4_2015_AT_11_59_59_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestBeforeWithSameDate() {
		assertThat(AUG_4_2015_NOON, before(AUG_4_2015_NOON_AS_DATE));
	}

	@Test
	public void canTestBeforeWithLaterDate() {
		assertThat(AUG_4_2015_NOON, before(AUG_4_2015_AT_12_00_01_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestBeforeWithEarlierDMY() {
		assertThat(AUG_4_2015_NOON, before(2015, AUGUST, 4, 11, 59, 59));
	}

	@Test(expected = AssertionError.class)
	public void canTestBeforeWithSameDMY() {
		assertThat(AUG_4_2015_NOON, before(2015, AUGUST, 4, 12, 0, 0));
	}

	@Test
	public void canTestBeforeWithLaterDDMY() {
		assertThat(AUG_4_2015_NOON, before(2015, AUGUST, 4, 12, 0, 1));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameDayWithEarlierLocalDateTime() {
		assertThat(AUG_4_2015_NOON, sameDay(AUG_3_2015_NOON));
	}

	@Test
	public void canTestSameDayWithSameLocalDateTime() {
		assertThat(AUG_4_2015_NOON, sameDay(AUG_4_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameDayWithLaterLocalDateTime() {
		assertThat(AUG_4_2015_NOON, sameDay(AUG_5_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameDayWithEarlierDate() {
		assertThat(AUG_4_2015_NOON, sameDay(AUG_3_2015_NOON_AS_DATE));
	}

	@Test
	public void canTestSameDayWithSameDate() {
		assertThat(AUG_4_2015_NOON, sameDay(AUG_4_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameDayWithLaterDate() {
		assertThat(AUG_4_2015_NOON, sameDay(AUG_5_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameDayWithEarlierDMY() {
		assertThat(AUG_4_2015_NOON, sameDay(2015, AUGUST, 3));
	}

	@Test
	public void canTestSameDayWithSameDMY() {
		assertThat(AUG_4_2015_NOON, sameDay(2015, AUGUST, 4));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameDayWithLaterDDMY() {
		assertThat(AUG_4_2015_NOON, sameDay(2015, AUGUST, 5));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameInstantWithEarlierLocalDateTime() {
		assertThat(AUG_4_2015_NOON, sameInstant(AUG_3_2015_NOON));
	}

	@Test
	public void canTestSameInstantWithSameLocalDateTime() {
		assertThat(AUG_4_2015_NOON, sameInstant(AUG_4_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameInstantWithLaterLocalDateTime() {
		assertThat(AUG_4_2015_NOON, sameInstant(AUG_5_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameInstantWithEarlierDate() {
		assertThat(AUG_4_2015_NOON, sameInstant(AUG_3_2015_NOON_AS_DATE));
	}

	@Test
	public void canTestSameInstantWithSameDate() {
		assertThat(AUG_4_2015_NOON, sameInstant(AUG_4_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameInstantWithLaterDate() {
		assertThat(AUG_4_2015_NOON, sameInstant(AUG_5_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameOrBeforeWithEarlierLocalDateTime() {
		assertThat(AUG_4_2015_NOON, sameOrBefore(AUG_4_2015_1159));
	}

	@Test
	public void canTestSameOrBeforeWithSameLocalDateTime() {
		assertThat(AUG_4_2015_NOON, sameOrBefore(AUG_4_2015_NOON));
	}

	@Test
	public void canTestSameOrBeforeWithLaterLocalDateTime() {
		assertThat(AUG_4_2015_NOON, sameOrBefore(AUG_4_2015_1201));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameOrBeforeWithEarlierDate() {
		assertThat(AUG_4_2015_NOON, sameOrBefore(AUG_4_2015_AT_11_59_59_AS_DATE));
	}

	@Test
	public void canTestSameOrBeforeWithSameDate() {
		assertThat(AUG_4_2015_NOON, sameOrBefore(AUG_4_2015_NOON_AS_DATE));
	}

	@Test
	public void canTestSameOrBeforeWithLaterDate() {
		assertThat(AUG_4_2015_NOON, sameOrBefore(AUG_4_2015_AT_12_00_01_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameOrBeforeWithEarlierDMY() {
		assertThat(AUG_4_2015_NOON, sameOrBefore(2015, AUGUST, 3, 12, 0, 0));
	}

	@Test
	public void canTestSameOrBeforeWithSameDMY() {
		assertThat(AUG_4_2015_NOON, sameOrBefore(2015, AUGUST, 4, 12, 0, 0));
	}

	@Test
	public void canTestSameOrBeforeWithLaterDDMY() {
		assertThat(AUG_4_2015_NOON, sameOrBefore(2015, AUGUST, 5, 12, 0, 0));
	}

	@Test
	public void canTestSameOrAfterWithEarlierLocalDateTime() {
		assertThat(AUG_4_2015_NOON, sameOrAfter(AUG_4_2015_1159));
	}

	@Test
	public void canTestSameOrAfterWithSameLocalDateTime() {
		assertThat(AUG_4_2015_NOON, sameOrAfter(AUG_4_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameOrAfterWithLaterLocalDateTime() {
		assertThat(AUG_4_2015_NOON, sameOrAfter(AUG_4_2015_1201));
	}

	@Test
	public void canTestSameOrAfterWithEarlierDate() {
		assertThat(AUG_4_2015_NOON, sameOrAfter(AUG_4_2015_AT_11_59_59_AS_DATE));
	}

	@Test
	public void canTestSameOrAfterWithSameDate() {
		assertThat(AUG_4_2015_NOON, sameOrAfter(AUG_4_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameOrAfterWithLaterDate() {
		assertThat(AUG_4_2015_NOON, sameOrAfter(AUG_4_2015_AT_12_00_01_AS_DATE));
	}

	@Test
	public void canTestSameOrAfterWithEarlierDMY() {
		assertThat(AUG_4_2015_NOON, sameOrAfter(2015, AUGUST, 4, 11, 59, 59));
	}

	@Test
	public void canTestSameOrAfterWithSameDMY() {
		assertThat(AUG_4_2015_NOON, sameOrAfter(2015, AUGUST, 4, 12, 0, 0));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameOrAfterWithLaterDDMY() {
		assertThat(AUG_4_2015_NOON, sameOrAfter(2015, AUGUST, 4, 12, 0, 1));
	}

	@Test
	public void canTestSameMonthOfYearWithSameLocalDateTime() {
		assertThat(AUG_4_2015_NOON, sameMonthOfYear(AUG_4_2015_NOON));
	}

	@Test
	public void canTestSameMonthOfYearWithDifferentLocalDateTimeSameMonth() {
		assertThat(AUG_4_2015_NOON, sameMonthOfYear(AUG_3_2015_NOON));
	}

	@Test
	public void canTestSameMonthOfYearWithDifferentLocalDateTimeSameMonthDifferentYear() {
		assertThat(AUG_4_2015_NOON, sameMonthOfYear(AUG_4_2016_NOON));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameMonthOfYearWithDifferentLocalDateTimeMonth() {
		assertThat(AUG_4_2015_NOON, sameMonthOfYear(SEP_4_2015_NOON));
	}

	@Test
	public void canTestSameMonthOfYearWithSameDate() {
		assertThat(AUG_4_2015_NOON, sameMonthOfYear(AUG_4_2015_NOON_AS_DATE));
	}

	@Test
	public void canTestSameMonthOfYearWithDifferentDateSameMonth() {
		assertThat(AUG_4_2015_NOON, sameMonthOfYear(AUG_5_2015_NOON_AS_DATE));
	}

	@Test
	public void canTestSameMonthOfYearWithDifferentDateSameMonthDifferentYear() {
		assertThat(AUG_4_2015_NOON, sameMonthOfYear(AUG_4_2016_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameMonthOfYearWithDifferentDateMonth() {
		assertThat(AUG_4_2015_NOON, sameMonthOfYear(SEP_4_2015_NOON_AS_DATE));
	}

	@Test
	public void canTestIsSameMonth() {
		assertThat(AUG_4_2015_NOON, isMonth(AUGUST));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsDifferentMonth() {
		assertThat(AUG_4_2015_NOON, isMonth(SEPTEMBER));
	}

	@Test
	public void canTestSameYearWithSameLocalDateTime() {
		assertThat(AUG_4_2015_NOON, sameYear(AUG_4_2015_NOON));
	}

	@Test
	public void canTestSameYearWithDifferentLocalDateTimeSameYear() {
		assertThat(AUG_4_2015_NOON, sameYear(AUG_3_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameYearWithDifferentLocalDateTimeDifferentYear() {
		assertThat(AUG_4_2015_NOON, sameYear(AUG_4_2016_NOON));
	}

	@Test
	public void canTestSameYearWithSameDate() {
		assertThat(AUG_4_2015_NOON, sameYear(AUG_4_2015_NOON_AS_DATE));
	}

	@Test
	public void canTestSameYearWithDifferentDateSameYear() {
		assertThat(AUG_4_2015_NOON, sameYear(AUG_5_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameYearWithDifferentDateSameDifferentYear() {
		assertThat(AUG_4_2015_NOON, sameYear(AUG_4_2016_NOON_AS_DATE));
	}

	@Test
	public void canTestIsSameYear() {
		assertThat(AUG_4_2015_NOON, isYear(2015));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsDifferentYear() {
		assertThat(AUG_4_2016_NOON, isYear(2015));
	}

	@Test
	public void canTestWithinIntervalLocalDateTime() {
		assertThat(AUG_3_2015_NOON, within(1, ChronoUnit.DAYS, AUG_4_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void canTestWithinOutsideIntervalLocalDateTime() {
		assertThat(AUG_3_2015_NOON, within(1, ChronoUnit.DAYS, AUG_5_2015_NOON));
	}

	@Test
	public void canTestWithinIntervalDate() {
		assertThat(AUG_3_2015_NOON, within(1, ChronoUnit.DAYS, AUG_4_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestWithinOutsideIntervalDate() {
		assertThat(AUG_3_2015_NOON, within(1, ChronoUnit.DAYS, AUG_5_2015_NOON_AS_DATE));
	}

	@Test
	public void canTestWithinIntervalDMY() {
		assertThat(AUG_3_2015_NOON, within(1, ChronoUnit.DAYS, 2015, AUGUST, 4, 12, 0, 0));
	}

	@Test(expected = AssertionError.class)
	public void canTestWithinOutsideIntervalDMY() {
		assertThat(AUG_3_2015_NOON, within(1, ChronoUnit.DAYS, 2015, AUGUST, 5, 12, 0, 0));
	}

	@Test
	public void canTestWithinTimeIntervalLocalDateTime() {
		assertThat(AUG_4_2015_NOON, within(1, ChronoUnit.SECONDS, AUG_4_2015_1201));
	}

	@Test(expected = AssertionError.class)
	public void canTestWithinOutsideTimeIntervalLocalDateTime() {
		assertThat(AUG_4_2015_1159, within(1, ChronoUnit.SECONDS, AUG_4_2015_1201));
	}

	@Test
	public void canTestWithinTimeIntervalDate() {
		assertThat(AUG_4_2015_NOON, within(1, ChronoUnit.SECONDS, AUG_4_2015_AT_12_00_01_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestWithinOutsideTimeIntervalDate() {
		assertThat(AUG_4_2015_1159, within(1, ChronoUnit.SECONDS, AUG_4_2015_AT_12_00_01_AS_DATE));
	}

	@Test
	public void canTestWithinTimeIntervalDMY() {
		assertThat(AUG_4_2015_NOON, within(1, ChronoUnit.SECONDS, 2015, AUGUST, 4, 12, 0, 1));
	}

	@Test(expected = AssertionError.class)
	public void canTestWithinOutsideTimeIntervalDMY() {
		assertThat(AUG_4_2015_NOON, within(1, ChronoUnit.SECONDS, 2015, AUGUST, 4, 12, 0, 2));
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
		assertThat(AUG_3_2015_NOON, isDayOfWeek(MONDAY));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotDayOfWeek() {
		assertThat(AUG_4_2015_NOON, isDayOfWeek(DayOfWeek.MONDAY));
	}

	@Test
	public void canTestIsMonday() {
		assertThat(AUG_3_2015_NOON, isMonday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotMonday() {
		assertThat(AUG_4_2015_NOON, isMonday());
	}

	@Test
	public void canTestIsTuesday() {
		assertThat(AUG_4_2015_NOON, isTuesday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotTuesday() {
		assertThat(AUG_5_2015_NOON, isTuesday());
	}

	@Test
	public void canTestIsWednesday() {
		assertThat(AUG_5_2015_NOON, isWednesday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWednesday() {
		assertThat(AUG_6_2015_NOON, isWednesday());
	}

	@Test
	public void canTestIsThursday() {
		assertThat(AUG_6_2015_NOON, isThursday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotThursday() {
		assertThat(AUG_7_2015_NOON, isThursday());
	}

	@Test
	public void canTestIsFriday() {
		assertThat(AUG_7_2015_NOON, isFriday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotFriday() {
		assertThat(AUG_8_2015_NOON, isFriday());
	}

	@Test
	public void canTestIsSaturday() {
		assertThat(AUG_8_2015_NOON, isSaturday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotSaturday() {
		assertThat(AUG_9_2015_NOON, isSaturday());
	}

	@Test
	public void canTestIsSunday() {
		assertThat(AUG_9_2015_NOON, isSunday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotSunday() {
		assertThat(AUG_3_2015_NOON, isSunday());
	}

	@Test
	public void canTestIsWeekday() {
		assertThat(AUG_3_2015_NOON, isWeekday());
		assertThat(AUG_4_2015_NOON, isWeekday());
		assertThat(AUG_5_2015_NOON, isWeekday());
		assertThat(AUG_6_2015_NOON, isWeekday());
		assertThat(AUG_7_2015_NOON, isWeekday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWeekdayOnSaturday() {
		assertThat(AUG_8_2015_NOON, isWeekday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWeekdayOnSunday() {
		assertThat(AUG_9_2015_NOON, isWeekday());
	}

	@Test
	public void canTestIsWeekend() {
		assertThat(AUG_8_2015_NOON, isWeekend());
		assertThat(AUG_9_2015_NOON, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWeekendOnMonday() {
		assertThat(AUG_3_2015_NOON, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWeekendOnTuesday() {
		assertThat(AUG_4_2015_NOON, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWeekendOnWednesday() {
		assertThat(AUG_5_2015_NOON, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWeekendOnThursday() {
		assertThat(AUG_6_2015_NOON, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWeekendOnFriday() {
		assertThat(AUG_7_2015_NOON, isWeekend());
	}

	@Test
	public void canTestIsFirstDayOfMonth() {
		assertThat(AUG_1_2015_NOON, isFirstDayOfMonth());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotFirstDayOfMonth() {
		assertThat(AUG_3_2015_NOON, isFirstDayOfMonth());
	}

	@Test
	public void canTestIsMinimum() {
		assertThat(AUG_1_2015_NOON, isMinimum(ChronoField.DAY_OF_MONTH));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotMinimum() {
		assertThat(AUG_3_2015_NOON, isMinimum(ChronoField.DAY_OF_MONTH));
	}

	@Test
	public void canTestIsLastDayOfMonthAugust() {
		assertThat(AUG_31_2015_NOON, isLastDayOfMonth());
	}

	@Test
	public void canTestIsLastDayOfMonthSeptember() {
		assertThat(SEP_30_2015_NOON, isLastDayOfMonth());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotLastDayOfMonth() {
		assertThat(AUG_1_2015_NOON, isLastDayOfMonth());
	}

	@Test
	public void canTestIsMaximum() {
		assertThat(AUG_31_2015_NOON, isMaximum(ChronoField.DAY_OF_MONTH));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotMaximum() {
		assertThat(AUG_1_2015_NOON, isMaximum(ChronoField.DAY_OF_MONTH));
	}

	@Test
	public void canTestIsMonth() {
		assertThat(AUG_4_2015_NOON, isMonth(AUGUST));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotMonth() {
		assertThat(AUG_4_2015_NOON, isMonth(SEPTEMBER));
	}

	@Test
	public void canTestIsJanuary() {
		assertThat(JAN_1_2015_NOON, isJanuary());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotJanuary() {
		assertThat(AUG_4_2015_NOON, isJanuary());
	}

	@Test
	public void canTestIsFebruary() {
		assertThat(FEB_1_2015_NOON, isFebruary());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotFebruary() {
		assertThat(AUG_4_2015_NOON, isFebruary());
	}

	@Test
	public void canTestIsMarch() {
		assertThat(MAR_1_2015_NOON, isMarch());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotMarch() {
		assertThat(AUG_4_2015_NOON, isMarch());
	}

	@Test
	public void canTestIsApril() {
		assertThat(APR_1_2015_NOON, isApril());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotApril() {
		assertThat(AUG_4_2015_NOON, isApril());
	}

	@Test
	public void canTestIsMay() {
		assertThat(MAY_1_2015_NOON, isMay());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotMay() {
		assertThat(AUG_4_2015_NOON, isMay());
	}

	@Test
	public void canTestIsJune() {
		assertThat(JUN_1_2015_NOON, isJune());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotJune() {
		assertThat(AUG_4_2015_NOON, isJune());
	}

	@Test
	public void canTestIsJuly() {
		assertThat(JUL_1_2015_NOON, isJuly());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotJuly() {
		assertThat(AUG_4_2015_NOON, isJuly());
	}

	@Test
	public void canTestIsAugust() {
		assertThat(AUG_1_2015_NOON, isAugust());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotAugust() {
		assertThat(SEP_4_2015_NOON, isAugust());
	}

	@Test
	public void canTestIsSeptember() {
		assertThat(SEP_4_2015_NOON, isSeptember());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotSeptember() {
		assertThat(AUG_4_2015_NOON, isSeptember());
	}

	@Test
	public void canTestIsOctober() {
		assertThat(OCT_1_2015_NOON, isOctober());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotOctober() {
		assertThat(AUG_4_2015_NOON, isOctober());
	}

	@Test
	public void canTestIsNovember() {
		assertThat(NOV_1_2015_NOON, isNovember());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotNovember() {
		assertThat(AUG_4_2015_NOON, isNovember());
	}

	@Test
	public void canTestIsDecember() {
		assertThat(DEC_1_2015_NOON, isDecember());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotDecember() {
		assertThat(AUG_4_2015_NOON, isDecember());
	}

	@Test
	public void canTestIsLeapYear() {
		assertThat(AUG_4_2016_NOON, isLeapYear());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotLeapYear() {
		assertThat(AUG_4_2015_NOON, isLeapYear());
	}

	@Test
	public void canTestIsYear() {
		assertThat(AUG_4_2015_NOON, isYear(2015));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotYear() {
		assertThat(AUG_4_2015_NOON, isYear(2014));
	}

	@Test
	public void canTestIsDayOfMonth() {
		assertThat(AUG_4_2015_NOON, isDayOfMonth(4));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotDayOfMonth() {
		assertThat(AUG_4_2015_NOON, isDayOfMonth(5));
	}

	@Test
	public void canTestSameDayOfMonth() {
		assertThat(AUG_4_2015_NOON, sameDayOfMonth(AUG_4_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void canTestNotSameDayOfMonth() {
		assertThat(AUG_4_2015_NOON, sameDayOfMonth(AUG_5_2015_NOON));
	}

	@Test
	public void canTestSameDayOfMonthAsDate() {
		assertThat(AUG_4_2015_NOON, sameDayOfMonth(AUG_4_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestNotSameDayOfMonthAsDate() {
		assertThat(AUG_4_2015_NOON, sameDayOfMonth(AUG_5_2015_NOON_AS_DATE));
	}

	@Test
	public void canTestIsHour() {
		assertThat(AUG_4_2015_NOON, isHour(12));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotHour() {
		assertThat(AUG_4_2015_NOON, isHour(13));
	}

	@Test
	public void canTestSameHourOfDay() {
		assertThat(AUG_4_2015_NOON, sameHourOfDay(AUG_4_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void canTestNotSameHourOfDay() {
		assertThat(AUG_4_2015_NOON, sameHourOfDay(AUG_4_2015_1159));
	}

	@Test
	public void canTestSameHourOfDayAsDate() {
		assertThat(AUG_4_2015_NOON, sameHourOfDay(AUG_4_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestNotSameHourOfDayAsDate() {
		assertThat(AUG_4_2015_NOON, sameHourOfDay(AUG_4_2015_AT_11_59_59_AS_DATE));
	}

	@Test
	public void canTestIsMinute() {
		assertThat(AUG_4_2015_1159, isMinute(59));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotMinute() {
		assertThat(AUG_4_2015_1159, isMinute(58));
	}

	@Test
	public void canTestSameMinuteOfHour() {
		assertThat(AUG_4_2015_1159, sameMinuteOfHour(AUG_4_2015_1159));
	}

	@Test(expected = AssertionError.class)
	public void canTestNotSameMinuteOfHour() {
		assertThat(AUG_4_2015_1159, sameMinuteOfHour(AUG_4_2015_NOON));
	}

	@Test
	public void canTestSameMinuteOfHourAsDate() {
		assertThat(AUG_4_2015_1159, sameMinuteOfHour(AUG_4_2015_AT_11_59_59_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestNotSameMinuteOfHourAsDate() {
		assertThat(AUG_4_2015_1159, sameMinuteOfHour(AUG_4_2015_NOON_AS_DATE));
	}

	@Test
	public void canTestIsSecond() {
		assertThat(AUG_4_2015_1159, isSecond(59));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotSecond() {
		assertThat(AUG_4_2015_1159, isSecond(58));
	}

	@Test
	public void canTestSameSecondOfMinute() {
		assertThat(AUG_4_2015_1159, sameSecondOfMinute(AUG_4_2015_1159));
	}

	@Test(expected = AssertionError.class)
	public void canTestNotSameSecondOfMinute() {
		assertThat(AUG_4_2015_1159, sameSecondOfMinute(AUG_4_2015_NOON));
	}

	@Test
	public void canTestSameSecondOfMinuteAsDate() {
		assertThat(AUG_4_2015_1159, sameSecondOfMinute(AUG_4_2015_AT_11_59_59_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestNotSameSecondOfMinuteAsDate() {
		assertThat(AUG_4_2015_1159, sameSecondOfMinute(AUG_4_2015_NOON_AS_DATE));
	}

	private LocalDateTime yesterday() {
		return LocalDateTime.now().minusDays(1);
	}

	private LocalDateTime today() {
		return LocalDateTime.now();
	}

	private LocalDateTime tomorrow() {
		return LocalDateTime.now().plusDays(1);
	}

}
