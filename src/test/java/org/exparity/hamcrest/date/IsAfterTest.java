package org.exparity.hamcrest.date;

import org.exparity.hamcrest.date.testutils.Dates;
import org.junit.Test;
import static org.exparity.hamcrest.date.DateMatchers.after;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_01_2012_11AM_GMT_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.JUN_15_2012_11AM_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.JUN_15_2012_11PM_AS_DATE;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit Tests for the {@link IsSameYear} class
 * 
 * @author Stewart Bissett
 */
public class IsAfterTest {

	@Test
	public void canCompareIsAfter() {
		assertThat(JUN_15_2012_11PM_AS_DATE, after(JUN_15_2012_11AM_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsNotAfter() {
		assertThat(JUN_15_2012_11AM_AS_DATE, after(JUN_15_2012_11PM_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsSame() {
		assertThat(JUN_15_2012_11PM_AS_DATE, after(JUN_15_2012_11PM_AS_DATE));
	}

	@Test
	public void canCompareIsAfterAcrossTimeZones() {
		assertThat(Dates.JAN_01_2012_11AM_PST_AS_DATE, after(JAN_01_2012_11AM_GMT_AS_DATE));
	}

	@Test
	public void canCompareIsAfterDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, after(2012, Months.JUNE, 14));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsNotAfterDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, after(2012, Months.JUNE, 16));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsSameDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, after(2012, Months.JUNE, 15));
	}

	@Test
	public void canCompareIsAfterDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, after(new DayMonthYear(14, Months.JUNE, 2012)));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsNotAfterDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, after(new DayMonthYear(16, Months.JUNE, 2012)));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsSameDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, after(new DayMonthYear(15, Months.JUNE, 2012)));
	}

	@Test
	public void canCompareIsAfterDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, after(2012, Months.JUNE, 15, 10, 59, 59));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsNotAfterHour() {
		assertThat(JUN_15_2012_11AM_AS_DATE, after(2012, Months.JUNE, 15, 11, 00, 01));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsSameHour() {
		assertThat(JUN_15_2012_11AM_AS_DATE, after(2012, Months.JUNE, 15, 11, 00, 00));
	}

}
