package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.DateMatcherTestUtils.addDateField;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Calendar;
import java.util.Date;

import org.exparity.hamcrest.date.DateMatchers;
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link DateMatchers} class
 *
 * @author Stewart Bissett
 */
@SuppressWarnings("deprecation")
public class IsSameMillisecondOfSecondTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the millisecond [0-9]+?\\s     but: the date has the millisecond [0-9]+";

	// Date Matchers
	@Test
	public void isDateSameMillisecond() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, DateMatchers.sameMillisecond(date));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotSameMillisecond() {
		Date date = new Date(), other = addDateField(date, Calendar.MILLISECOND, 1);
		assertThat(other, DateMatchers.sameMillisecond(date));
	}

	@Test
	public void isDateSameMillisecondDifferentSecond() {
		Date date = new Date(), other = addDateField(date, Calendar.SECOND, 1);
		assertThat(other, DateMatchers.sameMillisecond(date));
	}
	
	@Test(expectedExceptions = TemporalConversionException.class, expectedExceptionsMessageRegExp = TemporalConverters.UNSUPPORTED_SQL_DATE_UNIT)
	public void isSqlDateSameMillisecond() {
		Date date = new Date(), other = new java.sql.Date(date.getTime());
		assertThat(other, DateMatchers.sameMillisecond(date));
	}
	
	@Test(expectedExceptions = TemporalConversionException.class, expectedExceptionsMessageRegExp = TemporalConverters.UNSUPPORTED_SQL_DATE_UNIT)
	public void isDateSameMillisecondSqlDate() {
		Date date = new Date();
		java.sql.Date other = new java.sql.Date(date.getTime());
		assertThat(date, DateMatchers.sameMillisecond(other));
	}
	
	@Test
	public void isDateSameMillisecondOfSecond() {
		Date date = new Date(), other = new Date(date.getTime());
		assertThat(other, DateMatchers.sameMillisecondOfSecond(date));
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotSameMillisecondOfSecond() {
		Date date = new Date(), other = addDateField(date, Calendar.MILLISECOND, 1);
		assertThat(other, DateMatchers.sameMillisecondOfSecond(date));
	}

	@Test
	public void isDateSameMillisecondOfSecondDifferentSecond() {
		Date date = new Date(), other = addDateField(date, Calendar.SECOND, 1);
		assertThat(other, DateMatchers.sameMillisecondOfSecond(date));
	}
	
	@Test(expectedExceptions = TemporalConversionException.class, expectedExceptionsMessageRegExp = TemporalConverters.UNSUPPORTED_SQL_DATE_UNIT)
	public void isSqlDateSameMillisecondOfSecond() {
		Date date = new Date(), other = new java.sql.Date(date.getTime());
		assertThat(other, DateMatchers.sameMillisecondOfSecond(date));
	}

	@Test(expectedExceptions = TemporalConversionException.class, expectedExceptionsMessageRegExp = TemporalConverters.UNSUPPORTED_SQL_DATE_UNIT)
	public void isDateSameMillisecondOfSecondSqlDate() {
		Date date = new Date();
		java.sql.Date other = new java.sql.Date(date.getTime());
		assertThat(date, DateMatchers.sameMillisecondOfSecond(other));
	}
}
