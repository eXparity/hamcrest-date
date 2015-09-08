package org.exparity.hamcrest.date.core;

import static java.util.stream.Collectors.joining;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is on the same day of the week as
 * the reference date
 * 
 * @author Stewart Bissett
 */
public class IsDayOfWeek<T extends Temporal> extends TypeSafeDiagnosingMatcher<T> {

	private final Set<DayOfWeek> daysOfWeeks = new HashSet<>();
	private final String description;

	public IsDayOfWeek(final DayOfWeek... daysOfWeek) {
		this.daysOfWeeks.addAll(Arrays.asList(daysOfWeek));
		this.description = Stream.of(daysOfWeek).map((d) -> d.name().toLowerCase()).collect(joining(", "));
	}

	@Override
	protected boolean matchesSafely(final T actual, Description mismatchDesc) {
		DayOfWeek actualValue = DayOfWeek.of(actual.get(ChronoField.DAY_OF_WEEK));
		if (daysOfWeeks.contains(actualValue)) {
			return true;
		} else {
			mismatchDesc.appendText("the date is on " + actualValue.name().toLowerCase());
			return false;
		}
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("the date is on on the days of the week " + this.description);
	}
}