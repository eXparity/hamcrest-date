/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date;

import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static uk.co.it.modular.hamcrest.date.DateMatchers.isFriday;
import static uk.co.it.modular.hamcrest.date.DateMatchers.isMonday;
import static uk.co.it.modular.hamcrest.date.DateMatchers.isSaturday;
import static uk.co.it.modular.hamcrest.date.DateMatchers.isSunday;
import static uk.co.it.modular.hamcrest.date.DateMatchers.isThursday;
import static uk.co.it.modular.hamcrest.date.DateMatchers.isTuesday;
import static uk.co.it.modular.hamcrest.date.DateMatchers.isWednesday;
import static uk.co.it.modular.hamcrest.date.DateMatchers.isWeekday;
import static uk.co.it.modular.hamcrest.date.DateMatchers.isWeekend;
import static uk.co.it.modular.hamcrest.date.DateMatchers.sameDayOfWeek;

import org.exparity.hamcrest.date.IsSameMonth;
import org.exparity.hamcrest.date.Weekdays;
import org.junit.Test;

/**
 * Unit Tests for the {@link IsSameMonth} class
 * 
 * @author Stewart Bissett
 */
public class IsSameDayOfWeekTest {

	@Test
	public void canMatchTheSameDayOfTheWeekVsDate() {
		assertThat(JAN_1ST_2012_11_AM_GMT, sameDayOfWeek(JAN_8TH_2012_11_AM));
	}

	@Test
	public void canMatchDifferentDayOfTheWeekVsDate() {
		assertThat(JAN_1ST_2012_11_AM_GMT, not(sameDayOfWeek(JAN_2ND_2012_11_AM)));
	}

	@Test
	public void canMatchTheSameWeekday() {
		assertThat(JAN_1ST_2012_11_AM_GMT, sameDayOfWeek(Weekdays.SUNDAY));
	}

	@Test
	public void canMatchDifferentWeekday() {
		assertThat(JAN_1ST_2012_11_AM_GMT, not(sameDayOfWeek(Weekdays.SATURDAY)));
	}

	@Test
	public void canMatchSaturday() {
		assertThat(JAN_7TH_2012_11_AM, isSaturday());
	}

	@Test
	public void canMatchNotSaturday() {
		assertThat(JAN_1ST_2012_11_AM_GMT, not(isSaturday()));
	}

	@Test
	public void canMatchSunday() {
		assertThat(JAN_1ST_2012_11_AM_GMT, isSunday());
	}

	@Test
	public void canMatchNotSunday() {
		assertThat(JAN_2ND_2012_11_AM, not(isSunday()));
	}

	@Test
	public void canMatchWeekend() {
		assertThat(JAN_1ST_2012_11_AM_GMT, isWeekend());
		assertThat(JAN_2ND_2012_11_AM, not(isWeekend()));
		assertThat(JAN_3RD_2012_11_AM, not(isWeekend()));
		assertThat(JAN_4TH_2012_11_AM, not(isWeekend()));
		assertThat(JAN_5TH_2012_11_AM, not(isWeekend()));
		assertThat(JAN_6TH_2012_11_AM, not(isWeekend()));
		assertThat(JAN_7TH_2012_11_AM, isWeekend());
	}

	@Test
	public void canMatchWeekday() {
		assertThat(JAN_1ST_2012_11_AM, not(isWeekday()));
		assertThat(JAN_2ND_2012_11_AM, isWeekday());
		assertThat(JAN_3RD_2012_11_AM, isWeekday());
		assertThat(JAN_4TH_2012_11_AM, isWeekday());
		assertThat(JAN_5TH_2012_11_AM, isWeekday());
		assertThat(JAN_6TH_2012_11_AM, isWeekday());
		assertThat(JAN_7TH_2012_11_AM, not(isWeekday()));
	}

	@Test
	public void canMatchMonday() {
		assertThat(JAN_2ND_2012_11_AM, isMonday());
	}

	@Test
	public void canMatchNotMonday() {
		assertThat(JAN_3RD_2012_11_AM, not(isMonday()));
	}

	@Test
	public void canMatchTuesday() {
		assertThat(JAN_3RD_2012_11_AM, isTuesday());
	}

	@Test
	public void canMatchNotTuesday() {
		assertThat(JAN_4TH_2012_11_AM, not(isTuesday()));
	}

	@Test
	public void canMatchWednesday() {
		assertThat(JAN_4TH_2012_11_AM, isWednesday());
	}

	@Test
	public void canMatchNotWednesday() {
		assertThat(JAN_5TH_2012_11_AM, not(isWednesday()));
	}

	@Test
	public void canMatchThursday() {
		assertThat(JAN_5TH_2012_11_AM, isThursday());
	}

	@Test
	public void canMatchNotThursday() {
		assertThat(JAN_6TH_2012_11_AM, not(isThursday()));
	}

	@Test
	public void canMatchFriday() {
		assertThat(JAN_6TH_2012_11_AM, isFriday());
	}

	@Test
	public void canMatchNotFriday() {
		assertThat(JAN_7TH_2012_11_AM, not(isFriday()));
	}
}
