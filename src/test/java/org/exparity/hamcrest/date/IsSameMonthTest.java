package org.exparity.hamcrest.date;

import org.exparity.hamcrest.date.Months;
import org.exparity.hamcrest.date.testutils.Dates;
import org.junit.Test;
import static org.exparity.hamcrest.date.DateMatchers.*;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_1_2012_11AM_UTC_AS_DATE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;

/**
 * Unit Tests for the {@link IsSameMonthOfYear} class
 * 
 * @author Stewart Bissett
 */
public class IsSameMonthTest {

	@Test
	public void canMatchTheSameMonthOnDates() {
		assertThat(Dates.JAN_1_2012_11AM_UTC_AS_DATE, sameMonthOfYear(Dates.JAN_2ND_2012_11_AM));
	}

	@Test
	public void canMatchDifferentMonthsOnDates() {
		assertThat(Dates.JAN_1_2012_11AM_UTC_AS_DATE, not(sameMonthOfYear(Dates.JUN_15TH_2012_11_AM)));
	}

	@Test
	public void canMatchTheSameMonth() {
		assertThat(Dates.JAN_1_2012_11AM_UTC_AS_DATE, sameMonthOfYear(Months.JANUARY));
	}

	@Test
	public void canMatchDifferentMonth() {
		assertThat(JAN_1_2012_11AM_UTC_AS_DATE, not(sameMonthOfYear(Months.FEBRUARY)));
	}

	@Test
	public void canMatchJanuary() {
		assertThat(Dates.JAN_1_2012_11AM_UTC_AS_DATE, isJanuary());
	}

	@Test
	public void canMatchFebruary() {
		assertThat(Dates.FEB_1ST_2012_11_AM, isFebruary());
	}

	@Test
	public void canMatchMarch() {
		assertThat(Dates.MAR_1ST_2012_11_AM, isMarch());
	}

	@Test
	public void canMatchApril() {
		assertThat(Dates.APR_1ST_2012_11_AM, isApril());
	}

	@Test
	public void canMatchMay() {
		assertThat(Dates.MAY_1ST_2012_11_AM, isMay());
	}

	@Test
	public void canMatchJune() {
		assertThat(Dates.JUN_1ST_2012_11_AM, isJune());
	}

	@Test
	public void canMatchJuly() {
		assertThat(Dates.JUL_1ST_2012_11_AM, isJuly());
	}

	@Test
	public void canMatchAugust() {
		assertThat(Dates.AUG_1ST_2012_11_AM, isAugust());
	}

	@Test
	public void canMatchSeptember() {
		assertThat(Dates.SEP_1ST_2012_11_AM, isSeptember());
	}

	@Test
	public void canMatchOctober() {
		assertThat(Dates.OCT_1ST_2012_11_AM, isOctober());
	}

	@Test
	public void canMatchNovember() {
		assertThat(Dates.NOV_1ST_2012_11_AM, isNovember());
	}

	@Test
	public void canMatchDecember() {
		assertThat(Dates.DEC_1ST_2012_11_AM, isDecember());
	}

}
