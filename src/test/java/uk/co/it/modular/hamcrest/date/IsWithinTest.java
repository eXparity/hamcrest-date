/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date;

import static java.util.Calendar.SECOND;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static uk.co.it.modular.hamcrest.date.DateMatchers.within;
import static uk.co.it.modular.hamcrest.date.testutils.DateMatcherTestUtils.addDateField;
import static uk.co.it.modular.hamcrest.date.testutils.Dates.JAN_1ST_2012_11_AM_GMT;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

/**
 * Unit Tests for the {@link IsSameYear} class
 * 
 * @author Stewart Bissett
 */
public class IsWithinTest {

	@Test
	public void matchesEarlierDatesWithinLimit() {
		Date date = new Date(), other = addDateField(date, SECOND, -1);
		assertThat(other, within(2, TimeUnit.SECONDS, date));
	}

	@Test
	public void matchesLaterDatesWithinLimit() {
		Date date = new Date(), other = addDateField(date, SECOND, 1);
		assertThat(other, within(2, TimeUnit.SECONDS, date));
	}

	@Test
	public void doesNotMatchesEarlierDatesOutsideLimit() {
		Date date = new Date(), other = addDateField(date, SECOND, -2);
		assertThat(other, not(within(1, TimeUnit.SECONDS, date)));
	}

	@Test
	public void doesNotMatchesLaterDatesOutsideLimit() {
		Date date = new Date(), other = addDateField(date, SECOND, 2);
		assertThat(other, not(within(1, TimeUnit.SECONDS, date)));
	}

	@Test
	public void canCompareDatesWithinLimitDay() {
		assertThat(JAN_1ST_2012_11_AM_GMT, within(2, TimeUnit.DAYS, 2012, Months.JAN, 2));
	}

	@Test
	public void canCompareDatesNotWithinLimitDay() {
		assertThat(JAN_1ST_2012_11_AM_GMT, not(within(2, TimeUnit.DAYS, 2012, Months.JAN, 6)));
	}

	@Test
	public void canCompareDatesWithinLimitDayMonthYear() {
		assertThat(JAN_1ST_2012_11_AM_GMT, within(2, TimeUnit.DAYS, new DayMonthYear(2, Months.JAN, 2012)));
	}

	@Test
	public void canCompareDatesNotWithinLimitDayMonthYear() {
		assertThat(JAN_1ST_2012_11_AM_GMT, not(within(2, TimeUnit.DAYS, new DayMonthYear(6, Months.JAN, 2012))));
	}

	@Test
	public void canCompareDatesWithinLimitTime() {
		assertThat(JAN_1ST_2012_11_AM_GMT, within(10, TimeUnit.SECONDS, 2012, Months.JAN, 1, 11, 00, 00, 000));
	}

	@Test
	public void canCompareDatesNotWithinLimitTime() {
		assertThat(JAN_1ST_2012_11_AM_GMT, not(within(10, TimeUnit.SECONDS, 2012, Months.JAN, 1, 11, 00, 11, 000)));
	}

}
