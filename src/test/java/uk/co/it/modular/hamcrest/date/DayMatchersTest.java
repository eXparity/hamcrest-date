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
