
package org.exparity.hamcrest.date;

import static org.exparity.hamcrest.date.DateMatchers.*;
import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

/**
 * Unit Tests for the {@link IsSameMonthOfYear} class
 *
 * @author Stewart Bissett
 */
public class IsSameDayOfWeekTest {

	@Test
	public void canMatchTheSameDayOfTheWeekVsDate() {
		assertThat(JAN_01_2012_11AM_AS_DATE, sameDayOfWeek(JAN_08_2012_11AM_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canMatchDifferentDayOfTheWeekVsDate() {
		assertThat(JAN_01_2012_11AM_AS_DATE, sameDayOfWeek(JAN_02_2012_11AM_AS_DATE));
	}

	@Test
	public void canMatchTheSameWeekday() {
		assertThat(JAN_01_2012_11AM_AS_DATE, isDayOfWeek(Weekdays.SUNDAY));
	}

	@Test(expected = AssertionError.class)
	public void canMatchDifferentWeekday() {
		assertThat(JAN_01_2012_11AM_AS_DATE, isDayOfWeek(Weekdays.SATURDAY));
	}

	@Test
	public void canMatchSaturday() {
		assertThat(JAN_07_2012_11AM_AS_DATE, isSaturday());
	}

	@Test(expected = AssertionError.class)
	public void canMatchNotSaturday() {
		assertThat(JAN_01_2012_11AM_AS_DATE, isSaturday());
	}

	@Test
	public void canMatchSunday() {
		assertThat(JAN_01_2012_11AM_AS_DATE, isSunday());
	}

	@Test(expected = AssertionError.class)
	public void canMatchNotSunday() {
		assertThat(JAN_02_2012_11AM_AS_DATE, isSunday());
	}

	@Test
	public void canMatchWeekend() {
		assertThat(JAN_01_2012_11AM_AS_DATE, isWeekend());
		assertThat(JAN_07_2012_11AM_AS_DATE, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canMatchMondayIsNotWeekend() {
		assertThat(JAN_02_2012_11AM_AS_DATE, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canMatchTuesdayIsNotWeekend() {
		assertThat(JAN_03_2012_11AM_AS_DATE, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canMatchWednesdayIsNotWeekend() {
		assertThat(JAN_04_2012_11AM_AS_DATE, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canMatchThursdayIsNotWeekend() {
		assertThat(JAN_05_2012_11AM_AS_DATE, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canMatchFridayIsNotWeekend() {
		assertThat(JAN_06_2012_11AM_AS_DATE, isWeekend());
	}

	@Test
	public void canMatchWeekday() {
		assertThat(JAN_02_2012_11AM_AS_DATE, isWeekday());
		assertThat(JAN_03_2012_11AM_AS_DATE, isWeekday());
		assertThat(JAN_04_2012_11AM_AS_DATE, isWeekday());
		assertThat(JAN_05_2012_11AM_AS_DATE, isWeekday());
		assertThat(JAN_06_2012_11AM_AS_DATE, isWeekday());
	}

	@Test(expected = AssertionError.class)
	public void canMatchSaturdayIsNotWeekday() {
		assertThat(JAN_07_2012_11AM_AS_DATE, isWeekday());
	}

	@Test(expected = AssertionError.class)
	public void canMatchSundayIsNotWeekday() {
		assertThat(JAN_01_2012_11AM_AS_DATE, isWeekday());
	}

	@Test
	public void canMatchMonday() {
		assertThat(JAN_02_2012_11AM_AS_DATE, isMonday());
	}

	@Test(expected = AssertionError.class)
	public void canMatchNotMonday() {
		assertThat(JAN_03_2012_11AM_AS_DATE, isMonday());
	}

	@Test
	public void canMatchTuesday() {
		assertThat(JAN_03_2012_11AM_AS_DATE, isTuesday());
	}

	@Test(expected = AssertionError.class)
	public void canMatchNotTuesday() {
		assertThat(JAN_04_2012_11AM_AS_DATE, isTuesday());
	}

	@Test
	public void canMatchWednesday() {
		assertThat(JAN_04_2012_11AM_AS_DATE, isWednesday());
	}

	@Test(expected = AssertionError.class)
	public void canMatchNotWednesday() {
		assertThat(JAN_05_2012_11AM_AS_DATE, isWednesday());
	}

	@Test
	public void canMatchThursday() {
		assertThat(JAN_05_2012_11AM_AS_DATE, isThursday());
	}

	@Test(expected = AssertionError.class)
	public void canMatchNotThursday() {
		assertThat(JAN_06_2012_11AM_AS_DATE, isThursday());
	}

	@Test
	public void canMatchFriday() {
		assertThat(JAN_06_2012_11AM_AS_DATE, isFriday());
	}

	@Test(expected = AssertionError.class)
	public void canMatchNotFriday() {
		assertThat(JAN_07_2012_11AM_AS_DATE, isFriday());
	}
}
