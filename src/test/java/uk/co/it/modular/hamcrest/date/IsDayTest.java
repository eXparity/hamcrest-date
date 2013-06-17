/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date;

import java.util.Calendar;
import java.util.Date;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static uk.co.it.modular.hamcrest.date.DateMatchers.isToday;
import static uk.co.it.modular.hamcrest.date.DateMatchers.isTomorrow;
import static uk.co.it.modular.hamcrest.date.DateMatchers.isYesterday;
import static uk.co.it.modular.hamcrest.date.testutils.DateMatcherTestUtils.addDateField;

/**
 * @author <a href="mailto:stewart@modular-it.co.uk">Stewart Bissett</a>
 */
public class IsDayTest {

	@Test
	public void canMatchYesterday() {
		Date today = new Date(), yesterday = addDateField(today, Calendar.DATE, -1), tomorrow = addDateField(today, Calendar.DATE, 1);
		assertThat(yesterday, isYesterday());
		assertThat(today, not(isYesterday()));
		assertThat(tomorrow, not(isYesterday()));
	}

	@Test
	public void canMatchToday() {
		Date today = new Date(), yesterday = addDateField(today, Calendar.DATE, -1), tomorrow = addDateField(today, Calendar.DATE, 1);
		assertThat(yesterday, not(isToday()));
		assertThat(today, isToday());
		assertThat(tomorrow, not(isToday()));
	}

	@Test
	public void canMatchTomorrow() {
		Date today = new Date(), yesterday = addDateField(today, Calendar.DATE, -1), tomorrow = addDateField(today, Calendar.DATE, 1);
		assertThat(yesterday, not(isTomorrow()));
		assertThat(today, not(isTomorrow()));
		assertThat(tomorrow, isTomorrow());
	}
}
