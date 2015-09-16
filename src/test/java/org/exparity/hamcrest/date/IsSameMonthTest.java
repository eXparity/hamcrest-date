package org.exparity.hamcrest.date;

import org.exparity.hamcrest.date.Months;
import org.exparity.hamcrest.date.testutils.Dates;
import org.junit.Test;
import static org.exparity.hamcrest.date.DateMatchers.*;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_01_2012_11AM_AS_DATE;
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
		assertThat(Dates.JAN_01_2012_11AM_AS_DATE, sameMonthOfYear(Dates.JAN_02_2012_11AM_AS_DATE));
	}

	@Test
	public void canMatchDifferentMonthsOnDates() {
		assertThat(Dates.JAN_01_2012_11AM_AS_DATE, not(sameMonthOfYear(Dates.JUN_15_2012_11AM_AS_DATE)));
	}

	@Test
	public void canMatchTheSameMonth() {
		assertThat(Dates.JAN_01_2012_11AM_AS_DATE, sameMonthOfYear(Months.JANUARY));
	}

	@Test
	public void canMatchDifferentMonth() {
		assertThat(JAN_01_2012_11AM_AS_DATE, not(sameMonthOfYear(Months.FEBRUARY)));
	}

	@Test
	public void canMatchJanuary() {
		assertThat(Dates.JAN_01_2012_11AM_AS_DATE, isJanuary());
	}

	@Test
	public void canMatchFebruary() {
		assertThat(Dates.FEB_01_2012_11AM_AS_DATE, isFebruary());
	}

	@Test
	public void canMatchMarch() {
		assertThat(Dates.MAR_01_2012_11AM_AS_DATE, isMarch());
	}

	@Test
	public void canMatchApril() {
		assertThat(Dates.APR_01_2012_11AM_AS_DATE, isApril());
	}

	@Test
	public void canMatchMay() {
		assertThat(Dates.MAY_01_2012_11AM_AS_DATE, isMay());
	}

	@Test
	public void canMatchJune() {
		assertThat(Dates.JUN_01_2012_11AM_AS_DATE, isJune());
	}

	@Test
	public void canMatchJuly() {
		assertThat(Dates.JUL_01_2012_11AM_AS_DATE, isJuly());
	}

	@Test
	public void canMatchAugust() {
		assertThat(Dates.AUG_01_2012_11AM_AS_DATE, isAugust());
	}

	@Test
	public void canMatchSeptember() {
		assertThat(Dates.SEP_01_2012_11AM_AS_DATE, isSeptember());
	}

	@Test
	public void canMatchOctober() {
		assertThat(Dates.OCT_01_2012_11AM_AS_DATE, isOctober());
	}

	@Test
	public void canMatchNovember() {
		assertThat(Dates.NOV_01_2012_11AM_AS_DATE, isNovember());
	}

	@Test
	public void canMatchDecember() {
		assertThat(Dates.DEC_01_2012_11AM_AS_DATE, isDecember());
	}

}
