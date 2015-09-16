
package org.exparity.hamcrest.date;

import org.exparity.hamcrest.date.Weekdays;
import org.junit.Test;
import static org.exparity.hamcrest.date.DateMatchers.*;
import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit Tests for the {@link IsSameMonthOfYear} class
 * 
 * @author Stewart Bissett
 */
public class IsSameDayOfWeekTest {

	@Test
	public void canMatchTheSameDayOfTheWeekVsDate() {
		assertThat(JAN_1_2012_11AM_UTC_AS_DATE, sameDayOfWeek(JAN_8TH_2012_11_AM));
	}

	@Test(expected = AssertionError.class)
	public void canMatchDifferentDayOfTheWeekVsDate() {
		assertThat(JAN_1_2012_11AM_UTC_AS_DATE, sameDayOfWeek(JAN_2ND_2012_11_AM));
	}

	@Test
	public void canMatchTheSameWeekday() {
		assertThat(JAN_1_2012_11AM_UTC_AS_DATE, sameDayOfWeek(Weekdays.SUNDAY));
	}

	@Test(expected = AssertionError.class)
	public void canMatchDifferentWeekday() {
		assertThat(JAN_1_2012_11AM_UTC_AS_DATE, sameDayOfWeek(Weekdays.SATURDAY));
	}

	@Test
	public void canMatchSaturday() {
		assertThat(JAN_7TH_2012_11_AM, isSaturday());
	}

	@Test(expected = AssertionError.class)
	public void canMatchNotSaturday() {
		assertThat(JAN_1_2012_11AM_UTC_AS_DATE, isSaturday());
	}

	@Test
	public void canMatchSunday() {
		assertThat(JAN_1_2012_11AM_UTC_AS_DATE, isSunday());
	}

	@Test(expected = AssertionError.class)
	public void canMatchNotSunday() {
		assertThat(JAN_2ND_2012_11_AM, isSunday());
	}

	@Test
	public void canMatchWeekend() {
		assertThat(JAN_1_2012_11AM_UTC_AS_DATE, isWeekend());
		assertThat(JAN_7TH_2012_11_AM, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canMatchMondayIsNotWeekend() {
		assertThat(JAN_2ND_2012_11_AM, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canMatchTuesdayIsNotWeekend() {
		assertThat(JAN_3RD_2012_11_AM, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canMatchWednesdayIsNotWeekend() {
		assertThat(JAN_4TH_2012_11_AM, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canMatchThursdayIsNotWeekend() {
		assertThat(JAN_5TH_2012_11_AM, isWeekend());
	}

	@Test(expected = AssertionError.class)
	public void canMatchFridayIsNotWeekend() {
		assertThat(JAN_6TH_2012_11_AM, isWeekend());
	}

	@Test
	public void canMatchWeekday() {
		assertThat(JAN_2ND_2012_11_AM, isWeekday());
		assertThat(JAN_3RD_2012_11_AM, isWeekday());
		assertThat(JAN_4TH_2012_11_AM, isWeekday());
		assertThat(JAN_5TH_2012_11_AM, isWeekday());
		assertThat(JAN_6TH_2012_11_AM, isWeekday());
	}

	@Test(expected = AssertionError.class)
	public void canMatchSaturdayIsNotWeekday() {
		assertThat(JAN_7TH_2012_11_AM, isWeekday());
	}

	@Test(expected = AssertionError.class)
	public void canMatchSundayIsNotWeekday() {
		assertThat(JAN_1_2012_11AM_UTC_AS_DATE, isWeekday());
	}

	@Test
	public void canMatchMonday() {
		assertThat(JAN_2ND_2012_11_AM, isMonday());
	}

	@Test(expected = AssertionError.class)
	public void canMatchNotMonday() {
		assertThat(JAN_3RD_2012_11_AM, isMonday());
	}

	@Test
	public void canMatchTuesday() {
		assertThat(JAN_3RD_2012_11_AM, isTuesday());
	}

	@Test(expected = AssertionError.class)
	public void canMatchNotTuesday() {
		assertThat(JAN_4TH_2012_11_AM, isTuesday());
	}

	@Test
	public void canMatchWednesday() {
		assertThat(JAN_4TH_2012_11_AM, isWednesday());
	}

	@Test(expected = AssertionError.class)
	public void canMatchNotWednesday() {
		assertThat(JAN_5TH_2012_11_AM, isWednesday());
	}

	@Test
	public void canMatchThursday() {
		assertThat(JAN_5TH_2012_11_AM, isThursday());
	}

	@Test(expected = AssertionError.class)
	public void canMatchNotThursday() {
		assertThat(JAN_6TH_2012_11_AM, isThursday());
	}

	@Test
	public void canMatchFriday() {
		assertThat(JAN_6TH_2012_11_AM, isFriday());
	}

	@Test(expected = AssertionError.class)
	public void canMatchNotFriday() {
		assertThat(JAN_7TH_2012_11_AM, isFriday());
	}
}
