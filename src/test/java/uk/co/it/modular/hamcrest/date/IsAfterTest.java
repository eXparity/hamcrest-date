/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static uk.co.it.modular.hamcrest.date.IsAfter.after;
import static uk.co.it.modular.hamcrest.date.testutils.Dates.JAN_1ST_2012_11_AM_GMT;
import static uk.co.it.modular.hamcrest.date.testutils.Dates.JAN_1ST_2012_11_AM_PST;
import static uk.co.it.modular.hamcrest.date.testutils.Dates.JUN_15TH_2012_11_AM;
import static uk.co.it.modular.hamcrest.date.testutils.Dates.JUN_15TH_2012_11_PM;
import org.junit.Test;

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

	@Test
	public void canCompareIsNotAfter() {
		assertThat(JUN_15TH_2012_11_AM, not(after(JUN_15TH_2012_11_PM)));
	}

	@Test
	public void canCompareIsSame() {
		assertThat(JUN_15TH_2012_11_PM, not(after(JUN_15TH_2012_11_PM)));
	}

	@Test
	public void canCompareIsAfterAcrossTimeZones() {
		assertThat(JAN_1ST_2012_11_AM_PST, after(JAN_1ST_2012_11_AM_GMT));
	}

	@Test
	public void canCompareIsAfterDay() {
		assertThat(JUN_15TH_2012_11_PM, after(2012, Month.JUNE, 14));
	}

	@Test
	public void canCompareIsNotAfterDay() {
		assertThat(JUN_15TH_2012_11_PM, not(after(2012, Month.JUNE, 16)));
	}

	@Test
	public void canCompareIsSameDay() {
		assertThat(JUN_15TH_2012_11_PM, not(after(2012, Month.JUNE, 15)));
	}

	@Test
	public void canCompareIsAfterDateTime() {
		assertThat(JUN_15TH_2012_11_AM, after(2012, Month.JUNE, 15, 10, 59, 59));
	}

	@Test
	public void canCompareIsNotAfterHour() {
		assertThat(JUN_15TH_2012_11_AM, not(after(2012, Month.JUNE, 15, 11, 00, 01)));
	}

	@Test
	public void canCompareIsSameHour() {
		assertThat(JUN_15TH_2012_11_AM, not(after(2012, Month.JUNE, 15, 11, 00, 00)));
	}

}
