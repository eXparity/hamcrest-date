package org.exparity.hamcrest.date;

import org.exparity.hamcrest.date.testutils.Dates;
import org.junit.Test;
import static org.exparity.hamcrest.date.DateMatchers.after;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_1_2012_11AM_GMT_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.JUN_15TH_2012_11_AM;
import static org.exparity.hamcrest.date.testutils.Dates.JUN_15TH_2012_11_PM;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit Tests for the {@link IsSameYear} class
 * 
 * @author Stewart Bissett
 */
public class IsAfterTest {

	@Test
	public void canCompareIsAfter() {
		assertThat(JUN_15TH_2012_11_PM, after(JUN_15TH_2012_11_AM));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsNotAfter() {
		assertThat(JUN_15TH_2012_11_AM, after(JUN_15TH_2012_11_PM));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsSame() {
		assertThat(JUN_15TH_2012_11_PM, after(JUN_15TH_2012_11_PM));
	}

	@Test
	public void canCompareIsAfterAcrossTimeZones() {
		assertThat(Dates.JAN_1_2012_11AM_PST_AS_DATE, after(JAN_1_2012_11AM_GMT_AS_DATE));
	}

	@Test
	public void canCompareIsAfterDay() {
		assertThat(JUN_15TH_2012_11_PM, after(2012, Months.JUNE, 14));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsNotAfterDay() {
		assertThat(JUN_15TH_2012_11_PM, after(2012, Months.JUNE, 16));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsSameDay() {
		assertThat(JUN_15TH_2012_11_PM, after(2012, Months.JUNE, 15));
	}

	@Test
	public void canCompareIsAfterDayMonthYear() {
		assertThat(JUN_15TH_2012_11_PM, after(new DayMonthYear(14, Months.JUNE, 2012)));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsNotAfterDayMonthYear() {
		assertThat(JUN_15TH_2012_11_PM, after(new DayMonthYear(16, Months.JUNE, 2012)));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsSameDayMonthYear() {
		assertThat(JUN_15TH_2012_11_PM, after(new DayMonthYear(15, Months.JUNE, 2012)));
	}

	@Test
	public void canCompareIsAfterDateTime() {
		assertThat(JUN_15TH_2012_11_AM, after(2012, Months.JUNE, 15, 10, 59, 59));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsNotAfterHour() {
		assertThat(JUN_15TH_2012_11_AM, after(2012, Months.JUNE, 15, 11, 00, 01));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsSameHour() {
		assertThat(JUN_15TH_2012_11_AM, after(2012, Months.JUNE, 15, 11, 00, 00));
	}

}
