
package org.exparity.hamcrest.date;

import java.util.Calendar;
import java.util.Date;
import org.junit.Test;
import static org.exparity.hamcrest.date.DateMatchers.isToday;
import static org.exparity.hamcrest.date.DateMatchers.isTomorrow;
import static org.exparity.hamcrest.date.DateMatchers.isYesterday;
import static org.exparity.hamcrest.date.testutils.DateMatcherTestUtils.addDateField;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author <a href="mailto:stewart@modular-it.co.uk">Stewart Bissett</a>
 */
public class IsDayTest {

	@Test
	public void canMatchYesterday() {
		Date yesterday = addDateField(new Date(), Calendar.DATE, -1);
		assertThat(yesterday, isYesterday());
	}

	@Test(expected = AssertionError.class)
	public void canMatchTodayIsNotYesterday() {
		Date today = new Date();
		assertThat(today, isYesterday());
	}

	@Test(expected = AssertionError.class)
	public void canMatchTomorrowIsNotYesterday() {
		Date tomorrow = addDateField(new Date(), Calendar.DATE, 1);
		assertThat(tomorrow, isYesterday());
	}

	@Test
	public void canMatchToday() {
		Date today = new Date();
		assertThat(today, isToday());
	}

	@Test(expected = AssertionError.class)
	public void canMatchYesterdayIsNotToday() {
		Date yesterday = addDateField(new Date(), Calendar.DATE, -1);
		assertThat(yesterday, isToday());
	}

	@Test(expected = AssertionError.class)
	public void canMatchTomorrowIsNotToday() {
		Date today = new Date(), tomorrow = addDateField(today, Calendar.DATE, 1);
		assertThat(tomorrow, isToday());
	}

	@Test
	public void canMatchTomorrow() {
		Date tomorrow = addDateField(new Date(), Calendar.DATE, 1);
		assertThat(tomorrow, isTomorrow());
	}

	@Test(expected = AssertionError.class)
	public void canMatchYesterdayIsNotTomorrow() {
		Date yesterday = addDateField(new Date(), Calendar.DATE, -1);
		assertThat(yesterday, isTomorrow());
	}

	@Test(expected = AssertionError.class)
	public void canMatchTodayIsNotTomorrow() {
		Date today = new Date();
		assertThat(today, isTomorrow());
	}
}
