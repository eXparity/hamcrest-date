package org.exparity.hamcrest.date.joda;

import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON;
import static org.exparity.hamcrest.date.testutils.JodaDates.AUG_04_2015_NOON_UTC;
import static org.hamcrest.MatcherAssert.assertThat;

import org.exparity.hamcrest.date.DateMatchers;
import org.testng.annotations.Test;

/**
 * Unit Tests for the {@link DateMatchers} class
 *
 * @author Thomas Naskali
 */
public class IsSameMillisecondOfSecondTest {

    private static final String ASSERTION_PATTERN = "\\sExpected: the date has the millisecond [0-9]+?\\s     but: the date has the millisecond [0-9]+";

	// LocalDateTime Matchers
	@Test
   	public void isLocalDateTimeSameMillisecondOfSecondSameDateTime() {
   		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.sameMillisecondOfSecond(AUG_04_2015_NOON));
   	}

 	@Test
  	public void isLocalDateTimeSameMillisecondOfSecondOtherSecondOfMinute() {
  		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.sameMillisecondOfSecond(AUG_04_2015_NOON.withSecondOfMinute(1)));
  	}

  	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
  	public void isLocalDateTimeNotSameMillisecondOfSecondOtherMillisecondOfSecond() {
  		assertThat(AUG_04_2015_NOON, JodaLocalDateTimeMatchers.sameMillisecondOfSecond(AUG_04_2015_NOON.withMillisOfSecond(1)));
  	}

	// DateTime Matchers
	@Test
  	public void isDateTimeSameMillisecondOfSecondSameDateTime() {
  		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameMillisecondOfSecond(AUG_04_2015_NOON_UTC));
  	}

	@Test
 	public void isDateTimeSameMillisecondOfSecondOtherSecondOfMinute() {
 		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameMillisecondOfSecond(AUG_04_2015_NOON_UTC.withSecondOfMinute(1)));
 	}

 	@Test(expectedExceptions = AssertionError.class, expectedExceptionsMessageRegExp = ASSERTION_PATTERN)
 	public void isDateTimeNotSameMillisecondOfSecondOtherMillisecondOfSecond() {
 		assertThat(AUG_04_2015_NOON_UTC, JodaDateTimeMatchers.sameMillisecondOfSecond(AUG_04_2015_NOON_UTC.withMillis(1)));
 	}

}
