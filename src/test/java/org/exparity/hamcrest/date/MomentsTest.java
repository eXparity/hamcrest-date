package org.exparity.hamcrest.date;

import static org.exparity.hamcrest.date.DateMatchers.isToday;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.time.LocalDate;

import org.junit.Test;

/**
 * @author Stewart Bissett
 */
public class MomentsTest {

	@Test
	public void canDefineNow() {
		assertThat(Moments.now(), isToday());
	}

	@Test
	public void canDefineToday() {
		LocalDate today = LocalDate.now();
		assertThat(
		        Moments.today(),
		            equalTo(
		                    new DayMonthYear(
		                            today.getDayOfMonth(),
		                                Months.fromCalendar(today.getMonthValue()-1),
		                                today.getYear())));
	}

	@Test
	public void canDefineTomorrow() {
		LocalDate tomorrow = LocalDate.now().plusDays(1);
		assertThat(
		        Moments.tomorrow(),
		            equalTo(
		                    new DayMonthYear(
		                            tomorrow.getDayOfMonth(),
		                                Months.fromCalendar(tomorrow.getMonthValue()-1),
		                                tomorrow.getYear())));
	}

	@Test
	public void canDefineYesterday() {
		LocalDate yesterday = LocalDate.now().minusDays(1);
		assertThat(
		        Moments.yesterday(),
		            equalTo(
		                    new DayMonthYear(
		                            yesterday.getDayOfMonth(),
		                                Months.fromCalendar(yesterday.getMonthValue()-1),
		                                yesterday.getYear())));
	}

}
