package org.exparity.hamcrest.date.core;

import static java.util.stream.Collectors.joining;

import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.ValueRange;
import java.util.Locale;
import java.util.stream.Stream;

import org.hamcrest.Description;

/**
 * A base matcher that tests that the examined date has the maximum value for the given date part
 *
 * @author Stewart Bissett
 */
public class IsMaximum<T> extends TemporalMatcher<T> {

	private static final String SPLIT_ON_UPPERCASE_REGEX = "(?=[A-Z])";

	private final TemporalConverter<T, ? extends TemporalAccessor> converter;
	private final ChronoField field;
	private final Locale locale;
	private final ZoneId zone;

	public IsMaximum(TemporalConverter<T, ? extends TemporalAccessor> converter,
	        ChronoField field,
	        ZoneId zone,
	        Locale locale) {
		this.converter = converter;
		this.field = field;
		this.locale = locale;
		this.zone = zone;
	}

	public IsMaximum(TemporalConverter<T, ? extends TemporalAccessor> converter, ChronoField field) {
		this(converter, field, ZoneId.systemDefault(), Locale.getDefault(Locale.Category.FORMAT));
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDesc) {
		TemporalAccessor actualTemporal = converter.apply(actual, zone);
		ValueRange actualRange = field.rangeRefinedBy(actualTemporal);
		long actualValue = field.getFrom(actualTemporal), expectedValue = actualRange.getMaximum();
		if (expectedValue != actualValue) {
			mismatchDesc.appendText("date has the value " + actualValue + " instead of " + expectedValue);
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the date has the maximum value for "
		        + Stream.of(field.getDisplayName(locale).split(SPLIT_ON_UPPERCASE_REGEX))
		                .map(String::toLowerCase)
		                .collect(joining(" ")));
	}

	@Override
	public TemporalMatcher<T> atZone(ZoneId zone) {
		return new IsMaximum<>(converter, field, zone, locale);
	}
	
    @Override
    public TemporalMatcher<T> atLocale(Locale locale) {
        return new IsMaximum<>(converter, field, zone, locale);
    }
}