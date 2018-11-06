
package org.exparity.hamcrest.date.joda;

import static org.hamcrest.MatcherAssert.assertThat;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.testng.annotations.Test;

/**
 * @author Thomas Naskali
 */
public class IsDayTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the same day as (?s:.)+?\\s     but: the day is (?s:.)+";

	// LocalDate Matchers
	@Test
	public void isLocalDateToday() {
		assertThat(new LocalDate(), JodaLocalDateMatchers.isToday());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotToday() {
		assertThat(new LocalDate().plusDays(1), JodaLocalDateMatchers.isToday());
	}

	@Test
	public void isLocalDateYesterday() {
		assertThat(new LocalDate().minusDays(1), JodaLocalDateMatchers.isYesterday());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotYesterday() {
		assertThat(new LocalDate(), JodaLocalDateMatchers.isYesterday());
	}

	@Test
	public void isLocalDateTomorrow() {
		assertThat(new LocalDate().plusDays(1), JodaLocalDateMatchers.isTomorrow());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateNotTomorrow() {
		assertThat(new LocalDate(), JodaLocalDateMatchers.isTomorrow());
	}

	// LocalDateTime Matchers
	@Test
	public void isLocalDateTimeToday() {
		assertThat(new LocalDateTime(), JodaLocalDateTimeMatchers.isToday());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotToday() {
		assertThat(new LocalDateTime().plusDays(1), JodaLocalDateTimeMatchers.isToday());
	}

	@Test
	public void isLocalDateTimeYesterday() {
		assertThat(new LocalDateTime().minusDays(1), JodaLocalDateTimeMatchers.isYesterday());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotYesterday() {
		assertThat(new LocalDateTime(), JodaLocalDateTimeMatchers.isYesterday());
	}

	@Test
	public void isLocalDateTimeTomorrow() {
		assertThat(new LocalDateTime().plusDays(1), JodaLocalDateTimeMatchers.isTomorrow());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isLocalDateTimeNotTomorrow() {
		assertThat(new LocalDateTime(), JodaLocalDateTimeMatchers.isTomorrow());
	}

	// ZonedDateTime Matchers
	@Test
	public void isZonedDateTimeToday() {
		assertThat(new DateTime(), JodaDateTimeMatchers.isToday());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotToday() {
		assertThat(new DateTime().plusDays(1), JodaDateTimeMatchers.isToday());
	}

	@Test
	public void isZonedDateTimeYesterday() {
		assertThat(new DateTime().minusDays(1), JodaDateTimeMatchers.isYesterday());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotYesterday() {
		assertThat(new DateTime(), JodaDateTimeMatchers.isYesterday());
	}

	@Test
	public void isZonedDateTimeTomorrow() {
		assertThat(new DateTime().plusDays(1), JodaDateTimeMatchers.isTomorrow());
	}

	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
	public void isZonedDateTimeNotTomorrow() {
		assertThat(new DateTime(), JodaDateTimeMatchers.isTomorrow());
	}

}
