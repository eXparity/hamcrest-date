package org.exparity.hamcrest.date.core;

import static java.util.stream.Collectors.joining;

import java.time.DayOfWeek;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is on the same day of the week as the reference date
 *
 * @author Stewart Bissett
 */
public class IsDayOfWeek<T> extends TemporalMatcher<T> {

	private final TemporalConverter<T, DayOfWeek> converter;
	private final TemporalProvider<List<DayOfWeek>> expected;
	private final Locale locale;
	private final ZoneId zone;

	public IsDayOfWeek(TemporalConverter<T, DayOfWeek> converter,
	        TemporalProvider<List<DayOfWeek>> expected,
	        ZoneId zone,
	        Locale locale) {
		this.expected = expected;
		this.converter = converter;
		this.locale = locale;
		this.zone = zone;
	}

	public IsDayOfWeek(TemporalConverter<T, DayOfWeek> converter, TemporalProvider<List<DayOfWeek>> expected) {
		this(converter, expected, ZoneId.systemDefault(), Locale.getDefault(Locale.Category.FORMAT));
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
		List<DayOfWeek> expectedValues = expected.apply(zone);
		DayOfWeek actualValue = converter.apply(actual, zone);
		if (!expectedValues.contains(actualValue)) {
			mismatchDescription.appendText("the date is on a " + describe(actualValue));
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void describeTo(final Description description) {
		List<DayOfWeek> expectedValues = expected.apply(zone);
		if ( expectedValues.size() > 1 ) {
			List<DayOfWeek> headValues = expectedValues.subList(0, expectedValues.size() - 1);
			DayOfWeek tailValue = expectedValues.get(expectedValues.size()-1);
			description.appendText(
			        "the date is on a " + headValues.stream().map(this::describe).collect(joining(", ")) + " or " + describe(tailValue));
		} else {
			description.appendText(
			        "the date is on a " + describe(expectedValues.get(0)));
		}
	}

	@Override
	public TemporalMatcher<T> atZone(ZoneId zone) {
		return new IsDayOfWeek<>(converter, expected, zone, locale);
	}

	private String describe(DayOfWeek actualValue) {
		return actualValue.getDisplayName(TextStyle.FULL, locale);
	}

}