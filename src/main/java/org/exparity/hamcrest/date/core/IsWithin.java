package org.exparity.hamcrest.date.core;

import java.time.ZoneId;
import java.util.Locale;

import org.exparity.hamcrest.date.core.types.Interval;
import org.hamcrest.Description;

/**
 * A matcher that tests that the examined date is within a defined period of the reference date
 *
 * @author Stewart Bissett
 */
public class IsWithin<T, E> extends TemporalMatcher<T> {

	private final Interval expectedInterval;
	private final TemporalProvider<E> reference;
	private final TemporalConverter<T, E> converter;
	private final TemporalFunction<E> functions;
	private final Locale locale;
	private final ZoneId zone;

	public IsWithin(Interval interval,
	        TemporalConverter<T, E> converter,
	        TemporalProvider<E> reference,
	        TemporalFunction<E> functions,
	        ZoneId zone,
	        Locale locale) {
		this.expectedInterval = interval;
		this.converter = converter;
		this.reference = reference;
		this.functions = functions;
		this.locale = locale;
		this.zone = zone;
	}

	public IsWithin(Interval interval,
	        TemporalConverter<T, E> converter,
	        TemporalProvider<E> reference,
	        TemporalFunction<E> functions) {
		this(interval,
		        converter,
		        reference,
		        functions,
		        ZoneId.systemDefault(),
		        Locale.getDefault(Locale.Category.FORMAT));
	}

	@Override
	protected boolean matchesSafely(final T actual, final Description mismatchDescription) {
		E referenceValue = reference.apply(zone), actualValue = converter.apply(actual, zone);
		Interval actualInterval = functions.interval(referenceValue, actualValue, expectedInterval.getUnit());
		if (actualInterval.longerThan(expectedInterval)) {
			mismatchDescription.appendText("the date is " + functions.describe(actualValue, locale) + " and "
			        + actualInterval.describe(locale) + " different");
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void describeTo(final Description description) {
		description.appendText("the date is within " + expectedInterval.describe(locale) + " of "
		        + functions.describe(reference.apply(zone), locale));
	}

	@Override
	public TemporalMatcher<T> atZone(ZoneId zone) {
		return new IsWithin<>(expectedInterval, converter, reference, functions, zone, locale);
	}

}