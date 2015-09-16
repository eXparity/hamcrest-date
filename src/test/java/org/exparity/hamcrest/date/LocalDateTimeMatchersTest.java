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
		assertThat(AUG_04_2015_NOON, after(AUG_04_2015_1159));
	}

	@Test(expected = AssertionError.class)
	public void canTestAfterWithSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, after(AUG_04_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void canTestAfterWithLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON, after(AUG_04_2015_1201));
	}

	@Test
	public void canTestAfterWithEarlierDate() {
		assertThat(AUG_04_2015_NOON, after(AUG_04_2015_115959_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestAfterWithSameDate() {
		assertThat(AUG_04_2015_NOON, after(AUG_04_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestAfterWithLaterDate() {
		assertThat(AUG_04_2015_NOON, after(AUG_04_2015_120001_AS_DATE));
	}

	@Test
	public void canTestAfterWithEarlierDMY() {
		assertThat(AUG_04_2015_NOON, after(2015, AUGUST, 4, 11, 59, 59));
	}

	@Test(expected = AssertionError.class)
	public void canTestAfterWithSameDMY() {
		assertThat(AUG_04_2015_NOON, after(2015, AUGUST, 4, 12, 0, 0));
	}

	@Test(expected = AssertionError.class)
	public void canTestAfterWithLaterDDMY() {
		assertThat(AUG_04_2015_NOON, after(2015, AUGUST, 4, 12, 0, 1));
	}

	@Test(expected = AssertionError.class)
	public void canTestBeforeWithEarlierLocalDateTime() {
		assertThat(AUG_04_2015_NOON, before(AUG_04_2015_1159));
	}

	@Test(expected = AssertionError.class)
	public void canTestBeforeWithSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, before(AUG_04_2015_NOON));
	}

	@Test
	public void canTestBeforeWithLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON, before(AUG_04_2015_1201));
	}

	@Test(expected = AssertionError.class)
	public void canTestBeforeWithEarlierDate() {
		assertThat(AUG_04_2015_NOON, before(AUG_04_2015_115959_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestBeforeWithSameDate() {
		assertThat(AUG_04_2015_NOON, before(AUG_04_2015_NOON_AS_DATE));
	}

	@Test
	public void canTestBeforeWithLaterDate() {
		assertThat(AUG_04_2015_NOON, before(AUG_04_2015_120001_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestBeforeWithEarlierDMY() {
		assertThat(AUG_04_2015_NOON, before(2015, AUGUST, 4, 11, 59, 59));
	}

	@Test(expected = AssertionError.class)
	public void canTestBeforeWithSameDMY() {
		assertThat(AUG_04_2015_NOON, before(2015, AUGUST, 4, 12, 0, 0));
	}

	@Test
	public void canTestBeforeWithLaterDDMY() {
		assertThat(AUG_04_2015_NOON, before(2015, AUGUST, 4, 12, 0, 1));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameDayWithEarlierLocalDateTime() {
		assertThat(AUG_04_2015_NOON, sameDay(AUG_03_2015_NOON));
	}

	@Test
	public void canTestSameDayWithSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, sameDay(AUG_04_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameDayWithLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON, sameDay(AUG_05_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameDayWithEarlierDate() {
		assertThat(AUG_04_2015_NOON, sameDay(AUG_03_2015_NOON_AS_DATE));
	}

	@Test
	public void canTestSameDayWithSameDate() {
		assertThat(AUG_04_2015_NOON, sameDay(AUG_04_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameDayWithLaterDate() {
		assertThat(AUG_04_2015_NOON, sameDay(AUG_05_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameDayWithEarlierDMY() {
		assertThat(AUG_04_2015_NOON, sameDay(2015, AUGUST, 3));
	}

	@Test
	public void canTestSameDayWithSameDMY() {
		assertThat(AUG_04_2015_NOON, sameDay(2015, AUGUST, 4));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameDayWithLaterDDMY() {
		assertThat(AUG_04_2015_NOON, sameDay(2015, AUGUST, 5));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameInstantWithEarlierLocalDateTime() {
		assertThat(AUG_04_2015_NOON, sameInstant(AUG_03_2015_NOON));
	}

	@Test
	public void canTestSameInstantWithSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, sameInstant(AUG_04_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameInstantWithLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON, sameInstant(AUG_05_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameInstantWithEarlierDate() {
		assertThat(AUG_04_2015_NOON, sameInstant(AUG_03_2015_NOON_AS_DATE));
	}

	@Test
	public void canTestSameInstantWithSameDate() {
		assertThat(AUG_04_2015_NOON, sameInstant(AUG_04_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameInstantWithLaterDate() {
		assertThat(AUG_04_2015_NOON, sameInstant(AUG_05_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameOrBeforeWithEarlierLocalDateTime() {
		assertThat(AUG_04_2015_NOON, sameOrBefore(AUG_04_2015_1159));
	}

	@Test
	public void canTestSameOrBeforeWithSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, sameOrBefore(AUG_04_2015_NOON));
	}

	@Test
	public void canTestSameOrBeforeWithLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON, sameOrBefore(AUG_04_2015_1201));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameOrBeforeWithEarlierDate() {
		assertThat(AUG_04_2015_NOON, sameOrBefore(AUG_04_2015_115959_AS_DATE));
	}

	@Test
	public void canTestSameOrBeforeWithSameDate() {
		assertThat(AUG_04_2015_NOON, sameOrBefore(AUG_04_2015_NOON_AS_DATE));
	}

	@Test
	public void canTestSameOrBeforeWithLaterDate() {
		assertThat(AUG_04_2015_NOON, sameOrBefore(AUG_04_2015_120001_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameOrBeforeWithEarlierDMY() {
		assertThat(AUG_04_2015_NOON, sameOrBefore(2015, AUGUST, 3, 12, 0, 0));
	}

	@Test
	public void canTestSameOrBeforeWithSameDMY() {
		assertThat(AUG_04_2015_NOON, sameOrBefore(2015, AUGUST, 4, 12, 0, 0));
	}

	@Test
	public void canTestSameOrBeforeWithLaterDDMY() {
		assertThat(AUG_04_2015_NOON, sameOrBefore(2015, AUGUST, 5, 12, 0, 0));
	}

	@Test
	public void canTestSameOrAfterWithEarlierLocalDateTime() {
		assertThat(AUG_04_2015_NOON, sameOrAfter(AUG_04_2015_1159));
	}

	@Test
	public void canTestSameOrAfterWithSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, sameOrAfter(AUG_04_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameOrAfterWithLaterLocalDateTime() {
		assertThat(AUG_04_2015_NOON, sameOrAfter(AUG_04_2015_1201));
	}

	@Test
	public void canTestSameOrAfterWithEarlierDate() {
		assertThat(AUG_04_2015_NOON, sameOrAfter(AUG_04_2015_115959_AS_DATE));
	}

	@Test
	public void canTestSameOrAfterWithSameDate() {
		assertThat(AUG_04_2015_NOON, sameOrAfter(AUG_04_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameOrAfterWithLaterDate() {
		assertThat(AUG_04_2015_NOON, sameOrAfter(AUG_04_2015_120001_AS_DATE));
	}

	@Test
	public void canTestSameOrAfterWithEarlierDMY() {
		assertThat(AUG_04_2015_NOON, sameOrAfter(2015, AUGUST, 4, 11, 59, 59));
	}

	@Test
	public void canTestSameOrAfterWithSameDMY() {
		assertThat(AUG_04_2015_NOON, sameOrAfter(2015, AUGUST, 4, 12, 0, 0));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameOrAfterWithLaterDDMY() {
		assertThat(AUG_04_2015_NOON, sameOrAfter(2015, AUGUST, 4, 12, 0, 1));
	}

	@Test
	public void canTestSameMonthOfYearWithSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, sameMonthOfYear(AUG_04_2015_NOON));
	}

	@Test
	public void canTestSameMonthOfYearWithDifferentLocalDateTimeSameMonth() {
		assertThat(AUG_04_2015_NOON, sameMonthOfYear(AUG_03_2015_NOON));
	}

	@Test
	public void canTestSameMonthOfYearWithDifferentLocalDateTimeSameMonthDifferentYear() {
		assertThat(AUG_04_2015_NOON, sameMonthOfYear(AUG_04_2016_NOON));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameMonthOfYearWithDifferentLocalDateTimeMonth() {
		assertThat(AUG_04_2015_NOON, sameMonthOfYear(SEP_04_2015_NOON));
	}

	@Test
	public void canTestSameMonthOfYearWithSameDate() {
		assertThat(AUG_04_2015_NOON, sameMonthOfYear(AUG_04_2015_NOON_AS_DATE));
	}

	@Test
	public void canTestSameMonthOfYearWithDifferentDateSameMonth() {
		assertThat(AUG_04_2015_NOON, sameMonthOfYear(AUG_05_2015_NOON_AS_DATE));
	}

	@Test
	public void canTestSameMonthOfYearWithDifferentDateSameMonthDifferentYear() {
		assertThat(AUG_04_2015_NOON, sameMonthOfYear(AUG_04_2016_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameMonthOfYearWithDifferentDateMonth() {
		assertThat(AUG_04_2015_NOON, sameMonthOfYear(SEP_04_2015_NOON_AS_DATE));
	}

	@Test
	public void canTestIsSameMonth() {
		assertThat(AUG_04_2015_NOON, isMonth(AUGUST));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsDifferentMonth() {
		assertThat(AUG_04_2015_NOON, isMonth(SEPTEMBER));
	}

	@Test
	public void canTestSameYearWithSameLocalDateTime() {
		assertThat(AUG_04_2015_NOON, sameYear(AUG_04_2015_NOON));
	}

	@Test
	public void canTestSameYearWithDifferentLocalDateTimeSameYear() {
		assertThat(AUG_04_2015_NOON, sameYear(AUG_03_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameYearWithDifferentLocalDateTimeDifferentYear() {
		assertThat(AUG_04_2015_NOON, sameYear(AUG_04_2016_NOON));
	}

	@Test
	public void canTestSameYearWithSameDate() {
		assertThat(AUG_04_2015_NOON, sameYear(AUG_04_2015_NOON_AS_DATE));
	}

	@Test
	public void canTestSameYearWithDifferentDateSameYear() {
		assertThat(AUG_04_2015_NOON, sameYear(AUG_05_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestSameYearWithDifferentDateSameDifferentYear() {
		assertThat(AUG_04_2015_NOON, sameYear(AUG_04_2016_NOON_AS_DATE));
	}

	@Test
	public void canTestIsSameYear() {
		assertThat(AUG_04_2015_NOON, isYear(2015));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsDifferentYear() {
		assertThat(AUG_04_2016_NOON, isYear(2015));
	}

	@Test
	public void canTestWithinIntervalLocalDateTime() {
		assertThat(AUG_03_2015_NOON, within(1, ChronoUnit.DAYS, AUG_04_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void canTestWithinOutsideIntervalLocalDateTime() {
		assertThat(AUG_03_2015_NOON, within(1, ChronoUnit.DAYS, AUG_05_2015_NOON));
	}

	@Test
	public void canTestWithinIntervalDate() {
		assertThat(AUG_03_2015_NOON, within(1, ChronoUnit.DAYS, AUG_04_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestWithinOutsideIntervalDate() {
		assertThat(AUG_03_2015_NOON, within(1, ChronoUnit.DAYS, AUG_05_2015_NOON_AS_DATE));
	}

	@Test
	public void canTestWithinIntervalDMY() {
		assertThat(AUG_03_2015_NOON, within(1, ChronoUnit.DAYS, 2015, AUGUST, 4, 12, 0, 0));
	}

	@Test(expected = AssertionError.class)
	public void canTestWithinOutsideIntervalDMY() {
		assertThat(AUG_03_2015_NOON, within(1, ChronoUnit.DAYS, 2015, AUGUST, 5, 12, 0, 0));
	}

	@Test
	public void canTestWithinTimeIntervalLocalDateTime() {
		assertThat(AUG_04_2015_NOON, within(1, ChronoUnit.SECONDS, AUG_04_2015_1201));
	}

	@Test(expected = AssertionError.class)
	public void canTestWithinOutsideTimeIntervalLocalDateTime() {
		assertThat(AUG_04_2015_1159, within(1, ChronoUnit.SECONDS, AUG_04_2015_1201));
	}

	@Test
	public void canTestWithinTimeIntervalDate() {
		assertThat(AUG_04_2015_NOON, within(1, ChronoUnit.SECONDS, AUG_04_2015_120001_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestWithinOutsideTimeIntervalDate() {
		assertThat(AUG_04_2015_1159, within(1, ChronoUnit.SECONDS, AUG_04_2015_120001_AS_DATE));
	}

	@Test
	public void canTestWithinTimeIntervalDMY() {
		assertThat(AUG_04_2015_NOON, within(1, ChronoUnit.SECONDS, 2015, AUGUST, 4, 12, 0, 1));
	}

	@Test(expected = AssertionError.class)
	public void canTestWithinOutsideTimeIntervalDMY() {
		assertThat(AUG_04_2015_NOON, within(1, ChronoUnit.SECONDS, 2015, AUGUST, 4, 12, 0, 2));
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
		assertThat(AUG_03_2015_NOON, isDayOfWeek(MONDAY));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotDayOfWeek() {
		assertThat(AUG_04_2015_NOON, isDayOfWeek(DayOfWeek.MONDAY));
	}

	@Test
	public void canTestIsMonday() {
		assertThat(AUG_03_2015_NOON, isMonday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotMonday() {
		assertThat(AUG_04_2015_NOON, isMonday());
	}

	@Test
	public void canTestIsTuesday() {
		assertThat(AUG_04_2015_NOON, isTuesday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotTuesday() {
		assertThat(AUG_05_2015_NOON, isTuesday());
	}

	@Test
	public void canTestIsWednesday() {
		assertThat(AUG_05_2015_NOON, isWednesday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWednesday() {
		assertThat(AUG_06_2015_NOON, isWednesday());
	}

	@Test
	public void canTestIsThursday() {
		assertThat(AUG_06_2015_NOON, isThursday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotThursday() {
		assertThat(AUG_07_2015_NOON, isThursday());
	}

	@Test
	public void canTestIsFriday() {
		assertThat(AUG_07_2015_NOON, isFriday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotFriday() {
		assertThat(AUG_08_2015_NOON, isFriday());
	}

	@Test
	public void canTestIsSaturday() {
		assertThat(AUG_08_2015_NOON, isSaturday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotSaturday() {
		assertThat(AUG_09_2015_NOON, isSaturday());
	}

	@Test
	public void canTestIsSunday() {
		assertThat(AUG_09_2015_NOON, isSunday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotSunday() {
		assertThat(AUG_03_2015_NOON, isSunday());
	}

	@Test
	public void canTestIsWeekday() {
		assertThat(AUG_03_2015_NOON, isWeekday());
		assertThat(AUG_04_2015_NOON, isWeekday());
		assertThat(AUG_05_2015_NOON, isWeekday());
		assertThat(AUG_06_2015_NOON, isWeekday());
		assertThat(AUG_07_2015_NOON, isWeekday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWeekdayOnSaturday() {
		assertThat(AUG_08_2015_NOON, isWeekday());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWeekdayOnSunday() {
		assertThat(AUG_09_2015_NOON, isWeekday());
	}

	@Test
	public void canTestIsWeekend() {
		assertThat(AUG_08_2015_NOON, isWeekend());
		assertThat(AUG_09_2015_NOON, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWeekendOnMonday() {
		assertThat(AUG_03_2015_NOON, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWeekendOnTuesday() {
		assertThat(AUG_04_2015_NOON, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWeekendOnWednesday() {
		assertThat(AUG_05_2015_NOON, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWeekendOnThursday() {
		assertThat(AUG_06_2015_NOON, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotWeekendOnFriday() {
		assertThat(AUG_07_2015_NOON, isWeekend());
	}

	@Test
	public void canTestIsFirstDayOfMonth() {
		assertThat(AUG_01_2015_NOON, isFirstDayOfMonth());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotFirstDayOfMonth() {
		assertThat(AUG_03_2015_NOON, isFirstDayOfMonth());
	}

	@Test
	public void canTestIsMinimum() {
		assertThat(AUG_01_2015_NOON, isMinimum(ChronoField.DAY_OF_MONTH));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotMinimum() {
		assertThat(AUG_03_2015_NOON, isMinimum(ChronoField.DAY_OF_MONTH));
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
		assertThat(AUG_01_2015_NOON, isLastDayOfMonth());
	}

	@Test
	public void canTestIsMaximum() {
		assertThat(AUG_31_2015_NOON, isMaximum(ChronoField.DAY_OF_MONTH));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotMaximum() {
		assertThat(AUG_01_2015_NOON, isMaximum(ChronoField.DAY_OF_MONTH));
	}

	@Test
	public void canTestIsMonth() {
		assertThat(AUG_04_2015_NOON, isMonth(AUGUST));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotMonth() {
		assertThat(AUG_04_2015_NOON, isMonth(SEPTEMBER));
	}

	@Test
	public void canTestIsJanuary() {
		assertThat(JAN_01_2015_NOON, isJanuary());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotJanuary() {
		assertThat(AUG_04_2015_NOON, isJanuary());
	}

	@Test
	public void canTestIsFebruary() {
		assertThat(FEB_01_2015_NOON, isFebruary());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotFebruary() {
		assertThat(AUG_04_2015_NOON, isFebruary());
	}

	@Test
	public void canTestIsMarch() {
		assertThat(MAR_01_2015_NOON, isMarch());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotMarch() {
		assertThat(AUG_04_2015_NOON, isMarch());
	}

	@Test
	public void canTestIsApril() {
		assertThat(APR_01_2015_NOON, isApril());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotApril() {
		assertThat(AUG_04_2015_NOON, isApril());
	}

	@Test
	public void canTestIsMay() {
		assertThat(MAY_01_2015_NOON, isMay());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotMay() {
		assertThat(AUG_04_2015_NOON, isMay());
	}

	@Test
	public void canTestIsJune() {
		assertThat(JUN_01_2015_NOON, isJune());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotJune() {
		assertThat(AUG_04_2015_NOON, isJune());
	}

	@Test
	public void canTestIsJuly() {
		assertThat(JUL_01_2015_NOON, isJuly());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotJuly() {
		assertThat(AUG_04_2015_NOON, isJuly());
	}

	@Test
	public void canTestIsAugust() {
		assertThat(AUG_01_2015_NOON, isAugust());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotAugust() {
		assertThat(SEP_04_2015_NOON, isAugust());
	}

	@Test
	public void canTestIsSeptember() {
		assertThat(SEP_04_2015_NOON, isSeptember());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotSeptember() {
		assertThat(AUG_04_2015_NOON, isSeptember());
	}

	@Test
	public void canTestIsOctober() {
		assertThat(OCT_01_2015_NOON, isOctober());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotOctober() {
		assertThat(AUG_04_2015_NOON, isOctober());
	}

	@Test
	public void canTestIsNovember() {
		assertThat(NOV_01_2015_NOON, isNovember());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotNovember() {
		assertThat(AUG_04_2015_NOON, isNovember());
	}

	@Test
	public void canTestIsDecember() {
		assertThat(DEC_01_2015_NOON, isDecember());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotDecember() {
		assertThat(AUG_04_2015_NOON, isDecember());
	}

	@Test
	public void canTestIsLeapYear() {
		assertThat(AUG_04_2016_NOON, isLeapYear());
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotLeapYear() {
		assertThat(AUG_04_2015_NOON, isLeapYear());
	}

	@Test
	public void canTestIsYear() {
		assertThat(AUG_04_2015_NOON, isYear(2015));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotYear() {
		assertThat(AUG_04_2015_NOON, isYear(2014));
	}

	@Test
	public void canTestIsDayOfMonth() {
		assertThat(AUG_04_2015_NOON, isDayOfMonth(4));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotDayOfMonth() {
		assertThat(AUG_04_2015_NOON, isDayOfMonth(5));
	}

	@Test
	public void canTestSameDayOfMonth() {
		assertThat(AUG_04_2015_NOON, sameDayOfMonth(AUG_04_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void canTestNotSameDayOfMonth() {
		assertThat(AUG_04_2015_NOON, sameDayOfMonth(AUG_05_2015_NOON));
	}

	@Test
	public void canTestSameDayOfMonthAsDate() {
		assertThat(AUG_04_2015_NOON, sameDayOfMonth(AUG_04_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestNotSameDayOfMonthAsDate() {
		assertThat(AUG_04_2015_NOON, sameDayOfMonth(AUG_05_2015_NOON_AS_DATE));
	}

	@Test
	public void canTestIsHour() {
		assertThat(AUG_04_2015_NOON, isHour(12));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotHour() {
		assertThat(AUG_04_2015_NOON, isHour(13));
	}

	@Test
	public void canTestSameHourOfDay() {
		assertThat(AUG_04_2015_NOON, sameHourOfDay(AUG_04_2015_NOON));
	}

	@Test(expected = AssertionError.class)
	public void canTestNotSameHourOfDay() {
		assertThat(AUG_04_2015_NOON, sameHourOfDay(AUG_04_2015_1159));
	}

	@Test
	public void canTestSameHourOfDayAsDate() {
		assertThat(AUG_04_2015_NOON, sameHourOfDay(AUG_04_2015_NOON_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestNotSameHourOfDayAsDate() {
		assertThat(AUG_04_2015_NOON, sameHourOfDay(AUG_04_2015_115959_AS_DATE));
	}

	@Test
	public void canTestIsMinute() {
		assertThat(AUG_04_2015_1159, isMinute(59));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotMinute() {
		assertThat(AUG_04_2015_1159, isMinute(58));
	}

	@Test
	public void canTestSameMinuteOfHour() {
		assertThat(AUG_04_2015_1159, sameMinuteOfHour(AUG_04_2015_1159));
	}

	@Test(expected = AssertionError.class)
	public void canTestNotSameMinuteOfHour() {
		assertThat(AUG_04_2015_1159, sameMinuteOfHour(AUG_04_2015_NOON));
	}

	@Test
	public void canTestSameMinuteOfHourAsDate() {
		assertThat(AUG_04_2015_1159, sameMinuteOfHour(AUG_04_2015_115959_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestNotSameMinuteOfHourAsDate() {
		assertThat(AUG_04_2015_1159, sameMinuteOfHour(AUG_04_2015_NOON_AS_DATE));
	}

	@Test
	public void canTestIsSecond() {
		assertThat(AUG_04_2015_1159, isSecond(59));
	}

	@Test(expected = AssertionError.class)
	public void canTestIsNotSecond() {
		assertThat(AUG_04_2015_1159, isSecond(58));
	}

	@Test
	public void canTestSameSecondOfMinute() {
		assertThat(AUG_04_2015_1159, sameSecondOfMinute(AUG_04_2015_1159));
	}

	@Test(expected = AssertionError.class)
	public void canTestNotSameSecondOfMinute() {
		assertThat(AUG_04_2015_1159, sameSecondOfMinute(AUG_04_2015_NOON));
	}

	@Test
	public void canTestSameSecondOfMinuteAsDate() {
		assertThat(AUG_04_2015_1159, sameSecondOfMinute(AUG_04_2015_115959_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canTestNotSameSecondOfMinuteAsDate() {
		assertThat(AUG_04_2015_1159, sameSecondOfMinute(AUG_04_2015_NOON_AS_DATE));
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
