
package org.exparity.hamcrest.date;

import org.junit.Test;
import static org.exparity.hamcrest.date.DateMatchers.before;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_1ST_2012_11_AM_GMT;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_1ST_2012_11_AM_PST;
import static org.exparity.hamcrest.date.testutils.Dates.JUN_15TH_2012_11_AM;
import static org.exparity.hamcrest.date.testutils.Dates.JUN_15TH_2012_11_PM;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit Tests for the {@link IsBefore} class
 * 
 * @author Stewart Bissett
 */
public class IsBeforeTest {

	@Test(expected = AssertionError.class)
	public void canCompareIsNotBefore() {
		assertThat(JUN_15TH_2012_11_PM, before(JUN_15TH_2012_11_AM));
	}

	@Test
	public void canCompareIsBefore() {
		assertThat(JUN_15TH_2012_11_AM, before(JUN_15TH_2012_11_PM));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsSame() {
		assertThat(JUN_15TH_2012_11_PM, before(JUN_15TH_2012_11_PM));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsNotBeforeAcrossTimeZones() {
		assertThat(JAN_1ST_2012_11_AM_PST, before(JAN_1ST_2012_11_AM_GMT));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsNotBeforeDay() {
		assertThat(JUN_15TH_2012_11_PM, before(2012, Months.JUNE, 14));
	}

	@Test
	public void canCompareisBeforeDay() {
		assertThat(JUN_15TH_2012_11_PM, before(2012, Months.JUNE, 16));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsSameDay() {
		assertThat(JUN_15TH_2012_11_PM, before(2012, Months.JUNE, 15));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsNotBeforeDayMonthYear() {
		assertThat(JUN_15TH_2012_11_PM, before(new DayMonthYear(14, Months.JUNE, 2012)));
	}

	@Test
	public void canCompareisBeforeDayMonthYear() {
		assertThat(JUN_15TH_2012_11_PM, before(new DayMonthYear(16, Months.JUNE, 2012)));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsSameDayMonthYear() {
		assertThat(JUN_15TH_2012_11_PM, before(new DayMonthYear(15, Months.JUNE, 2012)));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsNotBeforeDateTime() {
		assertThat(JUN_15TH_2012_11_AM, before(2012, Months.JUNE, 15, 10, 59, 59));
	}

	@Test
	public void canCompareIsBeforeHour() {
		assertThat(JUN_15TH_2012_11_AM, before(2012, Months.JUNE, 15, 11, 00, 01));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsSameHour() {
		assertThat(JUN_15TH_2012_11_AM, before(2012, Months.JUNE, 15, 11, 00, 00));
	}
}
