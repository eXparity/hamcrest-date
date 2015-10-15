package org.exparity.hamcrest.date;

import static org.exparity.hamcrest.date.Weekdays.*;
import static org.junit.Assert.assertThat;

import java.time.DayOfWeek;
import java.util.Calendar;

import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * @author Stewart Bissett
 */
public class WeekDaysTest {

	@Test
	public void canDefineMonday() {
		assertThat(MONDAY.getAsCalendarConstant(), Matchers.equalTo(Calendar.MONDAY));
		assertThat(MONDAY.getAsDayOfWeek(), Matchers.equalTo(DayOfWeek.MONDAY));
		assertThat(MONDAY.describe(), Matchers.equalTo("Monday"));
	}

	@Test
	public void canDefineTuesday() {
		assertThat(TUESDAY.getAsCalendarConstant(), Matchers.equalTo(Calendar.TUESDAY));
		assertThat(TUESDAY.getAsDayOfWeek(), Matchers.equalTo(DayOfWeek.TUESDAY));
		assertThat(TUESDAY.describe(), Matchers.equalTo("Tuesday"));
	}

	@Test
	public void canDefineWednesday() {
		assertThat(WEDNESDAY.getAsCalendarConstant(), Matchers.equalTo(Calendar.WEDNESDAY));
		assertThat(WEDNESDAY.getAsDayOfWeek(), Matchers.equalTo(DayOfWeek.WEDNESDAY));
		assertThat(WEDNESDAY.describe(), Matchers.equalTo("Wednesday"));
	}

	@Test
	public void canDefineThursday() {
		assertThat(THURSDAY.getAsCalendarConstant(), Matchers.equalTo(Calendar.THURSDAY));
		assertThat(THURSDAY.getAsDayOfWeek(), Matchers.equalTo(DayOfWeek.THURSDAY));
		assertThat(THURSDAY.describe(), Matchers.equalTo("Thursday"));
	}

	@Test
	public void canDefineFriday() {
		assertThat(FRIDAY.getAsCalendarConstant(), Matchers.equalTo(Calendar.FRIDAY));
		assertThat(FRIDAY.getAsDayOfWeek(), Matchers.equalTo(DayOfWeek.FRIDAY));
		assertThat(FRIDAY.describe(), Matchers.equalTo("Friday"));
	}

	@Test
	public void canDefineSaturday() {
		assertThat(SATURDAY.getAsCalendarConstant(), Matchers.equalTo(Calendar.SATURDAY));
		assertThat(SATURDAY.getAsDayOfWeek(), Matchers.equalTo(DayOfWeek.SATURDAY));
		assertThat(SATURDAY.describe(), Matchers.equalTo("Saturday"));
	}

	@Test
	public void canDefineSunday() {
		assertThat(SUNDAY.getAsCalendarConstant(), Matchers.equalTo(Calendar.SUNDAY));
		assertThat(SUNDAY.getAsDayOfWeek(), Matchers.equalTo(DayOfWeek.SUNDAY));
		assertThat(SUNDAY.describe(), Matchers.equalTo("Sunday"));
	}

}
