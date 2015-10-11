/**
 *
 */
package org.exparity.hamcrest.date.core;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.Weekdays;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.junit.Test;

/**
 * @author Stewart Bissett
 */
public class IsDayOfWeekTest {

	// Date Matchers
	@Test
	public void isDateWeekdays() {
		assertThat(JAN_01_2012_11AM_AS_DATE, DateMatchers.isDayOfWeek(Weekdays.SUNDAY));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotWeekdays() {
		assertThat(JAN_01_2012_11AM_AS_DATE, DateMatchers.isDayOfWeek(Weekdays.SATURDAY));
	}

	@Test
	public void isDateDayOfWeek() {
		assertThat(JAN_01_2012_11AM_AS_DATE, DateMatchers.isDayOfWeek(SUNDAY));
	}

	@Test(expected = AssertionError.class)
	public void isDateNotDayOfWeek() {
		assertThat(JAN_01_2012_11AM_AS_DATE, DateMatchers.isDayOfWeek(SATURDAY));
	}

	@Test
	public void isDateSaturday() {
		assertThat(JAN_07_2012_11AM_AS_DATE, DateMatchers.isSaturday());
	}

	@Test(expected = AssertionError.class)
	public void isDateNotSaturday() {
		assertThat(JAN_01_2012_11AM_AS_DATE, DateMatchers.isSaturday());
	}

	@Test
	public void isDateSunday() {
		assertThat(JAN_01_2012_11AM_AS_DATE, DateMatchers.isSunday());
	}

	@Test(expected = AssertionError.class)
	public void isDateNotSunday() {
		assertThat(JAN_02_2012_11AM_AS_DATE, DateMatchers.isSunday());
	}

	@Test
	public void isDateWeekend() {
		assertThat(JAN_01_2012_11AM_AS_DATE, DateMatchers.isWeekend());
		assertThat(JAN_07_2012_11AM_AS_DATE, DateMatchers.isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void isDateMondayIsNotWeekend() {
		assertThat(JAN_02_2012_11AM_AS_DATE, DateMatchers.isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void isDateTuesdayIsNotWeekend() {
		assertThat(JAN_03_2012_11AM_AS_DATE, DateMatchers.isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void isDateWednesdayIsNotWeekend() {
		assertThat(JAN_04_2012_11AM_AS_DATE, DateMatchers.isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void isDateThursdayIsNotWeekend() {
		assertThat(JAN_05_2012_11AM_AS_DATE, DateMatchers.isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void isDateFridayIsNotWeekend() {
		assertThat(JAN_06_2012_11AM_AS_DATE, DateMatchers.isWeekend());
	}

	@Test
	public void isDateWeekday() {
		assertThat(JAN_02_2012_11AM_AS_DATE, DateMatchers.isWeekday());
		assertThat(JAN_03_2012_11AM_AS_DATE, DateMatchers.isWeekday());
		assertThat(JAN_04_2012_11AM_AS_DATE, DateMatchers.isWeekday());
		assertThat(JAN_05_2012_11AM_AS_DATE, DateMatchers.isWeekday());
		assertThat(JAN_06_2012_11AM_AS_DATE, DateMatchers.isWeekday());
	}

	@Test(expected = AssertionError.class)
	public void isDateSaturdayIsNotWeekday() {
		assertThat(JAN_07_2012_11AM_AS_DATE, DateMatchers.isWeekday());
	}

	@Test(expected = AssertionError.class)
	public void isDateSundayIsNotWeekday() {
		assertThat(JAN_01_2012_11AM_AS_DATE, DateMatchers.isWeekday());
	}

	@Test
	public void isDateMonday() {
		assertThat(JAN_02_2012_11AM_AS_DATE, DateMatchers.isMonday());
	}

	@Test(expected = AssertionError.class)
	public void isDateNotMonday() {
		assertThat(JAN_03_2012_11AM_AS_DATE, DateMatchers.isMonday());
	}

	@Test
	public void isDateTuesday() {
		assertThat(JAN_03_2012_11AM_AS_DATE, DateMatchers.isTuesday());
	}

	@Test(expected = AssertionError.class)
	public void isDateNotTuesday() {
		assertThat(JAN_04_2012_11AM_AS_DATE, DateMatchers.isTuesday());
	}

	@Test
	public void isDateWednesday() {
		assertThat(JAN_04_2012_11AM_AS_DATE, DateMatchers.isWednesday());
	}

	@Test(expected = AssertionError.class)
	public void isDateNotWednesday() {
		assertThat(JAN_05_2012_11AM_AS_DATE, DateMatchers.isWednesday());
	}

	@Test
	public void isDateThursday() {
		assertThat(JAN_05_2012_11AM_AS_DATE, DateMatchers.isThursday());
	}

	@Test(expected = AssertionError.class)
	public void isDateNotThursday() {
		assertThat(JAN_06_2012_11AM_AS_DATE, DateMatchers.isThursday());
	}

	@Test
	public void isDateFriday() {
		assertThat(JAN_06_2012_11AM_AS_DATE, DateMatchers.isFriday());
	}

	@Test(expected = AssertionError.class)
	public void isDateNotFriday() {
		assertThat(JAN_07_2012_11AM_AS_DATE, DateMatchers.isFriday());
	}

	// Local Date Matchers
	@Test
	public void isLocalDateDayOfWeek() {
		assertThat(AUG_03_2015, LocalDateMatchers.isDayOfWeek(MONDAY));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotDayOfWeek() {
		assertThat(AUG_04_2015, LocalDateMatchers.isDayOfWeek(MONDAY));
	}

	@Test
	public void isLocalDateMonday() {
		assertThat(AUG_03_2015, LocalDateMatchers.isMonday());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotMonday() {
		assertThat(AUG_04_2015, LocalDateMatchers.isMonday());
	}

	@Test
	public void isLocalDateTuesday() {
		assertThat(AUG_04_2015, LocalDateMatchers.isTuesday());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotTuesday() {
		assertThat(AUG_05_2015, LocalDateMatchers.isTuesday());
	}

	@Test
	public void isLocalDateWednesday() {
		assertThat(AUG_05_2015, LocalDateMatchers.isWednesday());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotWednesday() {
		assertThat(AUG_06_2015, LocalDateMatchers.isWednesday());
	}

	@Test
	public void isLocalDateThursday() {
		assertThat(AUG_06_2015, LocalDateMatchers.isThursday());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotThursday() {
		assertThat(AUG_07_2015, LocalDateMatchers.isThursday());
	}

	@Test
	public void isLocalDateFriday() {
		assertThat(AUG_07_2015, LocalDateMatchers.isFriday());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotFriday() {
		assertThat(AUG_08_2015, LocalDateMatchers.isFriday());
	}

	@Test
	public void isLocalDateSaturday() {
		assertThat(AUG_08_2015, LocalDateMatchers.isSaturday());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotSaturday() {
		assertThat(AUG_09_2015, LocalDateMatchers.isSaturday());
	}

	@Test
	public void isLocalDateSunday() {
		assertThat(AUG_09_2015, LocalDateMatchers.isSunday());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotSunday() {
		assertThat(AUG_03_2015, LocalDateMatchers.isSunday());
	}

	@Test
	public void isLocalDateWeekday() {
		assertThat(AUG_03_2015, LocalDateMatchers.isWeekday());
		assertThat(AUG_04_2015, LocalDateMatchers.isWeekday());
		assertThat(AUG_05_2015, LocalDateMatchers.isWeekday());
		assertThat(AUG_06_2015, LocalDateMatchers.isWeekday());
		assertThat(AUG_07_2015, LocalDateMatchers.isWeekday());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotWeekdayOnSaturday() {
		assertThat(AUG_08_2015, LocalDateMatchers.isWeekday());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotWeekdayOnSunday() {
		assertThat(AUG_09_2015, LocalDateMatchers.isWeekday());
	}

	@Test
	public void isLocalDateWeekend() {
		assertThat(AUG_08_2015, LocalDateMatchers.isWeekend());
		assertThat(AUG_09_2015, LocalDateMatchers.isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotWeekendOnMonday() {
		assertThat(AUG_03_2015, LocalDateMatchers.isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotWeekendOnTuesday() {
		assertThat(AUG_04_2015, LocalDateMatchers.isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotWeekendOnWednesday() {
		assertThat(AUG_05_2015, LocalDateMatchers.isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotWeekendOnThursday() {
		assertThat(AUG_06_2015, LocalDateMatchers.isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateNotWeekendOnFriday() {
		assertThat(AUG_07_2015, LocalDateMatchers.isWeekend());
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeDayOfWeek() {
		assertThat(AUG_03_2015_NOON, LocalDateTimeMatchers.isDayOfWeek(MONDAY));
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotDayOfWeek() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isDayOfWeek(MONDAY));
	}

	@Test
	public void isLocalDateTimeMonday() {
		assertThat(AUG_03_2015_NOON, LocalDateTimeMatchers.isMonday());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotMonday() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isMonday());
	}

	@Test
	public void isLocalDateTimeTuesday() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isTuesday());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotTuesday() {
		assertThat(AUG_05_2015_NOON, LocalDateTimeMatchers.isTuesday());
	}

	@Test
	public void isLocalDateTimeWednesday() {
		assertThat(AUG_05_2015_NOON, LocalDateTimeMatchers.isWednesday());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotWednesday() {
		assertThat(AUG_06_2015_NOON, LocalDateTimeMatchers.isWednesday());
	}

	@Test
	public void isLocalDateTimeThursday() {
		assertThat(AUG_06_2015_NOON, LocalDateTimeMatchers.isThursday());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotThursday() {
		assertThat(AUG_07_2015_NOON, LocalDateTimeMatchers.isThursday());
	}

	@Test
	public void isLocalDateTimeFriday() {
		assertThat(AUG_07_2015_NOON, LocalDateTimeMatchers.isFriday());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotFriday() {
		assertThat(AUG_08_2015_NOON, LocalDateTimeMatchers.isFriday());
	}

	@Test
	public void isLocalDateTimeSaturday() {
		assertThat(AUG_08_2015_NOON, LocalDateTimeMatchers.isSaturday());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotSaturday() {
		assertThat(AUG_09_2015_NOON, LocalDateTimeMatchers.isSaturday());
	}

	@Test
	public void isLocalDateTimeSunday() {
		assertThat(AUG_09_2015_NOON, LocalDateTimeMatchers.isSunday());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotSunday() {
		assertThat(AUG_03_2015_NOON, LocalDateTimeMatchers.isSunday());
	}

	@Test
	public void isLocalDateTimeWeekday() {
		assertThat(AUG_03_2015_NOON, LocalDateTimeMatchers.isWeekday());
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isWeekday());
		assertThat(AUG_05_2015_NOON, LocalDateTimeMatchers.isWeekday());
		assertThat(AUG_06_2015_NOON, LocalDateTimeMatchers.isWeekday());
		assertThat(AUG_07_2015_NOON, LocalDateTimeMatchers.isWeekday());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotWeekdayOnSaturday() {
		assertThat(AUG_08_2015_NOON, LocalDateTimeMatchers.isWeekday());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotWeekdayOnSunday() {
		assertThat(AUG_09_2015_NOON, LocalDateTimeMatchers.isWeekday());
	}

	@Test
	public void isLocalDateTimeWeekend() {
		assertThat(AUG_08_2015_NOON, LocalDateTimeMatchers.isWeekend());
		assertThat(AUG_09_2015_NOON, LocalDateTimeMatchers.isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotWeekendOnMonday() {
		assertThat(AUG_03_2015_NOON, LocalDateTimeMatchers.isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotWeekendOnTuesday() {
		assertThat(AUG_04_2015_NOON, LocalDateTimeMatchers.isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotWeekendOnWednesday() {
		assertThat(AUG_05_2015_NOON, LocalDateTimeMatchers.isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotWeekendOnThursday() {
		assertThat(AUG_06_2015_NOON, LocalDateTimeMatchers.isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void isLocalDateTimeNotWeekendOnFriday() {
		assertThat(AUG_07_2015_NOON, LocalDateTimeMatchers.isWeekend());
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeDayOfWeek() {
		assertThat(AUG_03_2015_NOON_UTC, ZonedDateTimeMatchers.isDayOfWeek(MONDAY));
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotDayOfWeek() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isDayOfWeek(MONDAY));
	}

	@Test
	public void isZonedDateTimeMonday() {
		assertThat(AUG_03_2015_NOON_UTC, ZonedDateTimeMatchers.isMonday());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotMonday() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isMonday());
	}

	@Test
	public void isZonedDateTimeTuesday() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isTuesday());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotTuesday() {
		assertThat(AUG_05_2015_NOON_UTC, ZonedDateTimeMatchers.isTuesday());
	}

	@Test
	public void isZonedDateTimeWednesday() {
		assertThat(AUG_05_2015_NOON_UTC, ZonedDateTimeMatchers.isWednesday());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotWednesday() {
		assertThat(AUG_06_2015_NOON_UTC, ZonedDateTimeMatchers.isWednesday());
	}

	@Test
	public void isZonedDateTimeThursday() {
		assertThat(AUG_06_2015_NOON_UTC, ZonedDateTimeMatchers.isThursday());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotThursday() {
		assertThat(AUG_07_2015_NOON_UTC, ZonedDateTimeMatchers.isThursday());
	}

	@Test
	public void isZonedDateTimeFriday() {
		assertThat(AUG_07_2015_NOON_UTC, ZonedDateTimeMatchers.isFriday());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotFriday() {
		assertThat(AUG_08_2015_NOON_UTC, ZonedDateTimeMatchers.isFriday());
	}

	@Test
	public void isZonedDateTimeSaturday() {
		assertThat(AUG_08_2015_NOON_UTC, ZonedDateTimeMatchers.isSaturday());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotSaturday() {
		assertThat(AUG_09_2015_NOON_UTC, ZonedDateTimeMatchers.isSaturday());
	}

	@Test
	public void isZonedDateTimeSunday() {
		assertThat(AUG_09_2015_NOON_UTC, ZonedDateTimeMatchers.isSunday());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotSunday() {
		assertThat(AUG_03_2015_NOON_UTC, ZonedDateTimeMatchers.isSunday());
	}

	@Test
	public void isZonedDateTimeWeekday() {
		assertThat(AUG_03_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekday());
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekday());
		assertThat(AUG_05_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekday());
		assertThat(AUG_06_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekday());
		assertThat(AUG_07_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekday());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotWeekdayOnSaturday() {
		assertThat(AUG_08_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekday());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotWeekdayOnSunday() {
		assertThat(AUG_09_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekday());
	}

	@Test
	public void isZonedDateTimeWeekend() {
		assertThat(AUG_08_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekend());
		assertThat(AUG_09_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotWeekendOnMonday() {
		assertThat(AUG_03_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotWeekendOnTuesday() {
		assertThat(AUG_04_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotWeekendOnWednesday() {
		assertThat(AUG_05_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotWeekendOnThursday() {
		assertThat(AUG_06_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void isZonedDateTimeNotWeekendOnFriday() {
		assertThat(AUG_07_2015_NOON_UTC, ZonedDateTimeMatchers.isWeekend());
	}
}
