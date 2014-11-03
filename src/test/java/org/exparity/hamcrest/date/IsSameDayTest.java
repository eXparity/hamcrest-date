package org.exparity.hamcrest.date;

import static org.exparity.hamcrest.date.DateMatchers.*;
import static org.exparity.hamcrest.date.Months.JANUARY;
import static org.hamcrest.MatcherAssert.assertThat;
import org.exparity.hamcrest.date.DayMonthYear;
import org.exparity.hamcrest.date.testutils.Dates;
import org.junit.Test;

/**
 * Unit Tests for the {@link IsSameDay} class
 * 
 * @author Stewart Bissett
 */
public class IsSameDayTest {

	@Test
	public void canCompareTheSameExactDay() {
		assertThat(Dates.JAN_1ST_2012_11_AM, sameDay(Dates.JAN_1ST_2012_11_AM));
	}

	@Test
	public void canCompareTheSameDay() {
		assertThat(Dates.JAN_1ST_2012_11_AM, sameDay(Dates.JAN_1ST_2012_11_PM));
	}

	@Test(expected = AssertionError.class)
	public void canCompareADifferentDay() {
		assertThat(Dates.JAN_1ST_2012_11_AM, sameDay(Dates.JAN_2ND_2012_11_AM));
	}

	@Test
	public void canCompareTheSameDayWithFields() {
		assertThat(Dates.JAN_1ST_2012_11_AM, sameDay(2012, JANUARY, 1));
	}

	@Test(expected = AssertionError.class)
	public void canCompareADifferentDayWithFields() {
		assertThat(Dates.JAN_1ST_2012_11_AM, sameDay(2012, JANUARY, 2));
	}

	@Test
	public void canCompareTheSameDayMonthYear() {
		assertThat(Dates.JAN_1ST_2012_11_AM, sameDay(new DayMonthYear(1, JANUARY, 2012)));
	}

	@Test(expected = AssertionError.class)
	public void canCompareADifferentDayMonthYear() {
		assertThat(Dates.JAN_1ST_2012_11_AM, sameDay(new DayMonthYear(2, JANUARY, 2012)));
	}

}
