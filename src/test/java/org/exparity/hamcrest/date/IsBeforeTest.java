
package org.exparity.hamcrest.date;

import org.junit.Test;
import static org.exparity.hamcrest.date.DateMatchers.before;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_01_2012_11AM_GMT_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_01_2012_11AM_PST_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.JUN_15_2012_11AM_AS_DATE;
import static org.exparity.hamcrest.date.testutils.Dates.JUN_15_2012_11PM_AS_DATE;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit Tests for the {@link IsBefore} class
 * 
 * @author Stewart Bissett
 */
public class IsBeforeTest {

	@Test(expected = AssertionError.class)
	public void canCompareIsNotBefore() {
		assertThat(JUN_15_2012_11PM_AS_DATE, before(JUN_15_2012_11AM_AS_DATE));
	}

	@Test
	public void canCompareIsBefore() {
		assertThat(JUN_15_2012_11AM_AS_DATE, before(JUN_15_2012_11PM_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsSame() {
		assertThat(JUN_15_2012_11PM_AS_DATE, before(JUN_15_2012_11PM_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsNotBeforeAcrossTimeZones() {
		assertThat(JAN_01_2012_11AM_PST_AS_DATE, before(JAN_01_2012_11AM_GMT_AS_DATE));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsNotBeforeDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, before(2012, Months.JUNE, 14));
	}

	@Test
	public void canCompareisBeforeDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, before(2012, Months.JUNE, 16));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsSameDay() {
		assertThat(JUN_15_2012_11PM_AS_DATE, before(2012, Months.JUNE, 15));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsNotBeforeDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, before(new DayMonthYear(14, Months.JUNE, 2012)));
	}

	@Test
	public void canCompareisBeforeDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, before(new DayMonthYear(16, Months.JUNE, 2012)));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsSameDayMonthYear() {
		assertThat(JUN_15_2012_11PM_AS_DATE, before(new DayMonthYear(15, Months.JUNE, 2012)));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsNotBeforeDateTime() {
		assertThat(JUN_15_2012_11AM_AS_DATE, before(2012, Months.JUNE, 15, 10, 59, 59));
	}

	@Test
	public void canCompareIsBeforeHour() {
		assertThat(JUN_15_2012_11AM_AS_DATE, before(2012, Months.JUNE, 15, 11, 00, 01));
	}

	@Test(expected = AssertionError.class)
	public void canCompareIsSameHour() {
		assertThat(JUN_15_2012_11AM_AS_DATE, before(2012, Months.JUNE, 15, 11, 00, 00));
	}
}
