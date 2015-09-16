package org.exparity.hamcrest.date;

import static java.util.Calendar.SECOND;
import static org.exparity.hamcrest.date.DateMatchers.within;
import static org.exparity.hamcrest.date.testutils.DateMatcherTestUtils.addDateField;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_1_2012_11AM_UTC_AS_DATE;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.exparity.hamcrest.date.DayMonthYear;
import org.exparity.hamcrest.date.Months;
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

	@Test(expected = AssertionError.class)
	public void doesNotMatchesEarlierDatesOutsideLimit() {
		Date date = new Date(), other = addDateField(date, SECOND, -2);
		assertThat(other, within(1, TimeUnit.SECONDS, date));
	}

	@Test(expected = AssertionError.class)
	public void doesNotMatchesLaterDatesOutsideLimit() {
		Date date = new Date(), other = addDateField(date, SECOND, 2);
		assertThat(other, within(1, TimeUnit.SECONDS, date));
	}

	@Test
	public void canCompareDatesWithinLimitDay() {
		assertThat(JAN_1_2012_11AM_UTC_AS_DATE, within(2, TimeUnit.DAYS, 2012, Months.JAN, 2));
	}

	@Test(expected = AssertionError.class)
	public void canCompareDatesNotWithinLimitDay() {
		assertThat(JAN_1_2012_11AM_UTC_AS_DATE, within(2, TimeUnit.DAYS, 2012, Months.JAN, 6));
	}

	@Test
	public void canCompareDatesWithinLimitDayMonthYear() {
		assertThat(JAN_1_2012_11AM_UTC_AS_DATE, within(2, TimeUnit.DAYS, new DayMonthYear(2, Months.JAN, 2012)));
	}

	@Test(expected = AssertionError.class)
	public void canCompareDatesNotWithinLimitDayMonthYear() {
		assertThat(JAN_1_2012_11AM_UTC_AS_DATE, within(2, TimeUnit.DAYS, new DayMonthYear(6, Months.JAN, 2012)));
	}

	@Test
	public void canCompareDatesWithinLimitTime() {
		assertThat(JAN_1_2012_11AM_UTC_AS_DATE, within(10, TimeUnit.SECONDS, 2012, Months.JAN, 1, 11, 00, 00, 000));
	}

	@Test(expected = AssertionError.class)
	public void canCompareDatesNotWithinLimitTime() {
		assertThat(JAN_1_2012_11AM_UTC_AS_DATE, within(10, TimeUnit.SECONDS, 2012, Months.JAN, 1, 11, 00, 11, 000));
	}

}
