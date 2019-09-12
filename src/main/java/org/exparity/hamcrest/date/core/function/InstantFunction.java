package org.exparity.hamcrest.date.core.function;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import org.exparity.hamcrest.date.core.TemporalFunction;
import org.exparity.hamcrest.date.core.types.Interval;

/**
 * Implementation of {@link TemporalFunction} for {@link Instant}
 */
public final class InstantFunction implements TemporalFunction<Instant> {

	@Override
	public boolean isSame(Instant temporal, Instant other) {
		return temporal.equals(other);
	}

	@Override
	public boolean isAfter(Instant temporal, Instant other) {
		return temporal.isAfter(other);
	}

	@Override
	public boolean isBefore(Instant temporal, Instant other) {
		return temporal.isBefore(other);
	}
	
	@Override
	public Interval interval(Instant expected, Instant other, ChronoUnit unit) {
		return Interval.of(expected.until(other, unit), unit);
	}
	
	@Override
	public String describe(Instant temporal, Locale locale) {
		return DateTimeFormatter.ISO_INSTANT.format(temporal);
	}
}