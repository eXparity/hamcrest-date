/*
 * Copyright (c) Modular IT Limited.
 */

package org.exparity.hamcrest.date;

import org.exparity.hamcrest.date.Weekdays;
import org.junit.Test;
import static org.exparity.hamcrest.date.DateMatchers.*;
import static org.exparity.hamcrest.date.testutils.Dates.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

/**
 * Unit Tests for the {@link IsSameMonth} class
 * 
 * @author Stewart Bissett
 */
public class IsSameDayOfWeekTest {

	@Test
	public void canMatchTheSameDayOfTheWeekVsDate() {
		assertThat(JAN_1ST_2012_11_AM_GMT, sameDayOfWeek(JAN_8TH_2012_11_AM_GMT));
	}

	@Test
	public void canMatchDifferentDayOfTheWeekVsDate() {
		assertThat(JAN_1ST_2012_11_AM_GMT, not(sameDayOfWeek(JAN_2ND_2012_11_AM_GMT)));
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
		assertThat(JAN_7TH_2012_11_AM_GMT, isSaturday());
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
		assertThat(JAN_2ND_2012_11_AM_GMT, not(isSunday()));
	}

	@Test
	public void canMatchWeekend() {
		assertThat(JAN_1ST_2012_11_AM_GMT, isWeekend());
		assertThat(JAN_2ND_2012_11_AM_GMT, not(isWeekend()));
		assertThat(JAN_3RD_2012_11_AM_GMT, not(isWeekend()));
		assertThat(JAN_4TH_2012_11_AM_GMT, not(isWeekend()));
		assertThat(JAN_5TH_2012_11_AM_GMT, not(isWeekend()));
		assertThat(JAN_6TH_2012_11_AM_GMT, not(isWeekend()));
		assertThat(JAN_7TH_2012_11_AM_GMT, isWeekend());
	}

	@Test
	public void canMatchWeekday() {
		assertThat(JAN_1ST_2012_11_AM_GMT, not(isWeekday()));
		assertThat(JAN_2ND_2012_11_AM_GMT, isWeekday());
		assertThat(JAN_3RD_2012_11_AM_GMT, isWeekday());
		assertThat(JAN_4TH_2012_11_AM_GMT, isWeekday());
		assertThat(JAN_5TH_2012_11_AM_GMT, isWeekday());
		assertThat(JAN_6TH_2012_11_AM_GMT, isWeekday());
		assertThat(JAN_7TH_2012_11_AM_GMT, not(isWeekday()));
	}

	@Test
	public void canMatchMonday() {
		assertThat(JAN_2ND_2012_11_AM_GMT, isMonday());
	}

	@Test
	public void canMatchNotMonday() {
		assertThat(JAN_3RD_2012_11_AM_GMT, not(isMonday()));
	}

	@Test
	public void canMatchTuesday() {
		assertThat(JAN_3RD_2012_11_AM_GMT, isTuesday());
	}

	@Test
	public void canMatchNotTuesday() {
		assertThat(JAN_4TH_2012_11_AM_GMT, not(isTuesday()));
	}

	@Test
	public void canMatchWednesday() {
		assertThat(JAN_4TH_2012_11_AM_GMT, isWednesday());
	}

	@Test
	public void canMatchNotWednesday() {
		assertThat(JAN_5TH_2012_11_AM_GMT, not(isWednesday()));
	}

	@Test
	public void canMatchThursday() {
		assertThat(JAN_5TH_2012_11_AM_GMT, isThursday());
	}

	@Test
	public void canMatchNotThursday() {
		assertThat(JAN_6TH_2012_11_AM_GMT, not(isThursday()));
	}

	@Test
	public void canMatchFriday() {
		assertThat(JAN_6TH_2012_11_AM_GMT, isFriday());
	}

	@Test
	public void canMatchNotFriday() {
		assertThat(JAN_7TH_2012_11_AM_GMT, not(isFriday()));
	}
}
