package org.exparity.hamcrest.date;

import static java.util.Calendar.YEAR;
import static org.exparity.hamcrest.date.DateMatchers.*;
import static org.exparity.hamcrest.date.testutils.DateMatcherTestUtils.addDateField;
import static org.exparity.hamcrest.date.testutils.Dates.JAN_01_2012_11AM_AS_DATE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;

import java.util.Date;

import org.junit.Test;

/**
 * Unit Tests for the {@link IsSameYear} class
 *
 * @author Stewart Bissett
 */
public class IsSameYearTest {

	@Test
	public void canCompareTheSameYear() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, sameYear(date));
	}

	@Test
	public void canDetectDifferentYears() {
		Date date = new Date(), other = addDateField(date, YEAR, 1);
		assertThat(other, not(sameYear(date)));
	}

	@Test
	public void canCompareTheSameYearInt() {
		assertThat(JAN_01_2012_11AM_AS_DATE, isYear(2012));
	}

	@Test
	public void canDetectDifferentYearInt() {
		assertThat(JAN_01_2012_11AM_AS_DATE, not(isYear(2013)));
	}

}
