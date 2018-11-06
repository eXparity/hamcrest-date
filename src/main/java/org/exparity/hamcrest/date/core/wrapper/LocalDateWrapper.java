package org.exparity.hamcrest.date.core.wrapper;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.function.Supplier;

import org.exparity.hamcrest.date.core.TemporalWrapper;

/**
 * Implementation of a {@link TemporalWrapper} which wraps a {@link LocalDate}
 * instance
 * 
 * @author Stewart Bissett
 */
public class LocalDateWrapper implements TemporalWrapper<LocalDate, TemporalUnit, Void> {

	private final Supplier<LocalDate> wrapped;
	private final TemporalUnit accuracy;

	public LocalDateWrapper(final Supplier<LocalDate> wrapped, final TemporalUnit accuracy) {
		this.wrapped = wrapped;
		this.accuracy = accuracy;
	}

	public LocalDateWrapper(final LocalDate date) {
		this(() -> date, ChronoUnit.DAYS);
	}

	@Override
	public long difference(final LocalDate other, TemporalUnit unit) {
		return Math.abs(wrapped.get().until(other, unit));
	}

	@Override
	public boolean isAfter(final LocalDate other) {
		return wrapped.get().isAfter(other);
	}

	@Override
	public boolean isBefore(final LocalDate other) {
		return wrapped.get().isBefore(other);
	}

	@Override
	public boolean isSame(final LocalDate other) {
		return wrapped.get().isEqual(other);
	}

	@Override
	public LocalDate unwrap() {
		return wrapped.get();
	}

	@Override
	public String toString() {
		return wrapped.get().toString();
	}

	@Override
	public TemporalWrapper<LocalDate, TemporalUnit, Void> withZone(final Void ignored) {
		return this;
	}

}
