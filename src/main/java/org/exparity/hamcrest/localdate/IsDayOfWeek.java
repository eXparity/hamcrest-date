package org.exparity.hamcrest.localdate;

import static java.util.stream.Collectors.joining;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is on the same day of the week as
 * the reference date
 * 
 * @author Stewart Bissett
 */
public class IsDayOfWeek extends AbstractLocalDateMatcher {

	private final Set<DayOfWeek> daysOfWeeks = new HashSet<>();
	private final String description;

	public IsDayOfWeek(final DayOfWeek... daysOfWeek) {
		this.daysOfWeeks.addAll(Arrays.asList(daysOfWeek));
		this.description = Stream.of(daysOfWeek).map((d) -> d.name().toLowerCase()).collect(joining(", "));
	}

	@Override
	protected boolean matchesSafely(LocalDate actual, Description mismatchDesc) {
		if (daysOfWeeks.contains(actual.getDayOfWeek())) {
			return true;
		} else {
			mismatchDesc.appendText("the date is on " + actual.getDayOfWeek().name().toLowerCase());
			return false;
		}
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("the date is on on the days of the week " + this.description);
	}
}