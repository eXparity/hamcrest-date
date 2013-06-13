/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static uk.co.it.modular.hamcrest.date.DateMatchers.*;
import static uk.co.it.modular.hamcrest.date.testutils.DateMatcherTestUtils.addDateField;
import static uk.co.it.modular.hamcrest.date.testutils.Dates.*;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

/**
 * @author <a href="mailto:stewart@modular-it.co.uk">Stewart Bissett</a>
 */
public class DayMatchersTest {

	@Test
	public void canMatchFirstDayOfMonth() {
		assertThat(JAN_1ST_2012_11_AM_GMT, isFirstDayOfMonth());
	}

	@Test
	public void canNotMatchFirstDayOfMonth() {
		assertThat(JAN_31ST_2012_11_AM_GMT, not(isFirstDayOfMonth()));
	}

	@Test
	public void canMatchLastDayOfMonth() {
		assertThat(JAN_31ST_2012_11_AM_GMT, isLastDayOfMonth());
	}

	@Test
	public void canNotMatchLastDayOfMonth() {
		assertThat(JAN_1ST_2012_11_AM_GMT, not(isLastDayOfMonth()));
	}

	@Test
	public void canMatchSaturday() {
		assertThat(JAN_7TH_2012_11_AM_GMT, isSaturday());
	}

	@Test
	public void canNotMatchSaturday() {
		assertThat(JAN_1ST_2012_11_AM_GMT, not(isSaturday()));
	}

	@Test
	public void canMatchSunday() {
		assertThat(JAN_1ST_2012_11_AM_GMT, isSunday());
	}

	@Test
	public void canNotMatchSunday() {
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
	public void canNotMatchMonday() {
		assertThat(JAN_3RD_2012_11_AM_GMT, not(isMonday()));
	}

	@Test
	public void canMatchTuesday() {
		assertThat(JAN_3RD_2012_11_AM_GMT, isTuesday());
	}

	@Test
	public void canNotMatchTuesday() {
		assertThat(JAN_4TH_2012_11_AM_GMT, not(isTuesday()));
	}

	@Test
	public void canMatchWednesday() {
		assertThat(JAN_4TH_2012_11_AM_GMT, isWednesday());
	}

	@Test
	public void canNotMatchWednesday() {
		assertThat(JAN_5TH_2012_11_AM_GMT, not(isWednesday()));
	}

	@Test
	public void canMatchThursday() {
		assertThat(JAN_5TH_2012_11_AM_GMT, isThursday());
	}

	@Test
	public void canNotMatchThursday() {
		assertThat(JAN_6TH_2012_11_AM_GMT, not(isThursday()));
	}

	@Test
	public void canMatchFriday() {
		assertThat(JAN_6TH_2012_11_AM_GMT, isFriday());
	}

	@Test
	public void canNotMatchFriday() {
		assertThat(JAN_7TH_2012_11_AM_GMT, not(isFriday()));
	}

	@Test
	public void canMatchYesterday() {
		Date today = new Date(), yesterday = addDateField(today, Calendar.DATE, -1), tomorrow = addDateField(today, Calendar.DATE, 1);
		assertThat(yesterday, isYesterday());
		assertThat(today, not(isYesterday()));
		assertThat(tomorrow, not(isYesterday()));
	}

	@Test
	public void canMatchToday() {
		Date today = new Date(), yesterday = addDateField(today, Calendar.DATE, -1), tomorrow = addDateField(today, Calendar.DATE, 1);
		assertThat(yesterday, not(isToday()));
		assertThat(today, isToday());
		assertThat(tomorrow, not(isToday()));
	}

	@Test
	public void canMatchTomorrow() {
		Date today = new Date(), yesterday = addDateField(today, Calendar.DATE, -1), tomorrow = addDateField(today, Calendar.DATE, 1);
		assertThat(yesterday, not(isTomorrow()));
		assertThat(today, not(isTomorrow()));
		assertThat(tomorrow, isTomorrow());
	}
}
