
package org.exparity.hamcrest.date.core;

import static org.exparity.hamcrest.date.testutils.DateMatcherTestUtils.addDateField;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

import org.exparity.hamcrest.date.DateMatchers;
import org.exparity.hamcrest.date.LocalDateMatchers;
import org.exparity.hamcrest.date.LocalDateTimeMatchers;
import org.exparity.hamcrest.date.ZonedDateTimeMatchers;
import org.testng.annotations.Test;

/**
 * @author Stewart Bissett
 */
public class IsDayTest {

    private static final String ASSERTION_PATTERN = "\\s*Expected: the same day as [A-Za-z0-9:,.+ ]*\\s*but: the day is [A-Za-z0-9:,.+ ]*";

	// Date Matchers
	@Test
	public void isDateToday() {
		assertThat(new Date(), DateMatchers.isToday());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotToday() {
		assertThat(addDateField(new Date(), Calendar.DATE, 1), DateMatchers.isToday());
	}

	@Test
	public void isDateYesterday() {
		assertThat(addDateField(new Date(), Calendar.DATE, -1), DateMatchers.isYesterday());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotYesterday() {
		assertThat(new Date(), DateMatchers.isYesterday());
	}

	@Test
	public void isDateTomorrow() {
		assertThat(addDateField(new Date(), Calendar.DATE, 1), DateMatchers.isTomorrow());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isDateNotTomorrow() {
		assertThat(new Date(), DateMatchers.isTomorrow());
	}

	// LocalDate Matchers
	@Test
	public void isLocalDateToday() {
		assertThat(LocalDate.now(), LocalDateMatchers.isToday());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotToday() {
		assertThat(LocalDate.now().plusDays(1), LocalDateMatchers.isToday());
	}

	@Test
	public void isLocalDateYesterday() {
		assertThat(LocalDate.now().minusDays(1), LocalDateMatchers.isYesterday());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotYesterday() {
		assertThat(LocalDate.now(), LocalDateMatchers.isYesterday());
	}

	@Test
	public void isLocalDateTomorrow() {
		assertThat(LocalDate.now().plusDays(1), LocalDateMatchers.isTomorrow());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotTomorrow() {
		assertThat(LocalDate.now(), LocalDateMatchers.isTomorrow());
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeToday() {
		assertThat(LocalDateTime.now(), LocalDateTimeMatchers.isToday());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotToday() {
		assertThat(LocalDateTime.now().plusDays(1), LocalDateTimeMatchers.isToday());
	}

	@Test
	public void isLocalDateTimeYesterday() {
		assertThat(LocalDateTime.now().minusDays(1), LocalDateTimeMatchers.isYesterday());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotYesterday() {
		assertThat(LocalDateTime.now(), LocalDateTimeMatchers.isYesterday());
	}

	@Test
	public void isLocalDateTimeTomorrow() {
		assertThat(LocalDateTime.now().plusDays(1), LocalDateTimeMatchers.isTomorrow());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotTomorrow() {
		assertThat(LocalDateTime.now(), LocalDateTimeMatchers.isTomorrow());
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeToday() {
		assertThat(ZonedDateTime.now(), ZonedDateTimeMatchers.isToday());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotToday() {
		assertThat(ZonedDateTime.now().plusDays(1), ZonedDateTimeMatchers.isToday());
	}

	@Test
	public void isZonedDateTimeYesterday() {
		assertThat(ZonedDateTime.now().minusDays(1), ZonedDateTimeMatchers.isYesterday());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotYesterday() {
		assertThat(ZonedDateTime.now(), ZonedDateTimeMatchers.isYesterday());
	}

	@Test
	public void isZonedDateTimeTomorrow() {
		assertThat(ZonedDateTime.now().plusDays(1), ZonedDateTimeMatchers.isTomorrow());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotTomorrow() {
		assertThat(ZonedDateTime.now(), ZonedDateTimeMatchers.isTomorrow());
	}

}
