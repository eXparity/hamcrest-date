package org.exparity.hamcrest.date.core;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A matcher that tests that the examined date is on the same day of the week as
 * the reference date
 *
 * @author Stewart Bissett
 */
public class IsDayOfWeek<T> extends TypeSafeDiagnosingMatcher<T> {

	private final Set<DayOfWeek> daysOfWeeks = new HashSet<>();
	private final String description;
	private final TemporalAdapter<T> accessor;

	public IsDayOfWeek(final List<DayOfWeek> daysOfWeek, final TemporalAdapter<T> accessor) {
		this.daysOfWeeks.addAll(daysOfWeek);
		this.description = daysOfWeek.stream().map((d) -> d.name().toLowerCase()).collect(joining(", "));
		this.accessor = accessor;
	}

	public IsDayOfWeek(final DayOfWeek dayOfWeek, final TemporalAdapter<T> accessor) {
		this(asList(dayOfWeek), accessor);
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDesc) {
		DayOfWeek actualValue = DayOfWeek.of(accessor.asTemporal(actual).get(ChronoField.DAY_OF_WEEK));
		if (daysOfWeeks.contains(actualValue)) {
			return true;
		} else {
			mismatchDesc.appendText("the date is on " + actualValue.name().toLowerCase());
			return false;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the date is on on the days of the week " + this.description);
	}
}