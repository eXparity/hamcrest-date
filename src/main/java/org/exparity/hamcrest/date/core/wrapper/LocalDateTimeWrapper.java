package org.exparity.hamcrest.date.core.wrapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.function.Supplier;

import org.exparity.hamcrest.date.core.TemporalWrapper;

/**
 * Implementation of a {@link TemporalWrapper} which wraps a
 * {@link LocalDateTime} instance
 *
 * @author Stewart Bissett
 */
public class LocalDateTimeWrapper implements TemporalWrapper<LocalDateTime, TemporalUnit, Void> {

	private final Supplier<LocalDateTime> wrapped;
	private final TemporalUnit accuracy;

	public LocalDateTimeWrapper(final Supplier<LocalDateTime> wrapped, final TemporalUnit accuracy) {
		this.wrapped = wrapped;
		this.accuracy = accuracy;
	}

	public LocalDateTimeWrapper(final Supplier<LocalDateTime> wrapped) {
 		this(wrapped, ChronoUnit.NANOS);
 	}

	public LocalDateTimeWrapper(final LocalDateTime date, final TemporalUnit accuracy) {
		this(() -> date, accuracy);
	}

	public LocalDateTimeWrapper(final LocalDateTime date) {
 		this(date, ChronoUnit.NANOS);
 	}

	public LocalDateTimeWrapper(final int year, final Month month, final int dayOfMonth) {
		this(() -> LocalDate.of(year, month, dayOfMonth).atStartOfDay(), ChronoUnit.DAYS);
	}

	public LocalDateTimeWrapper(final int year, final Month month, final int dayOfMonth, final int hour, final int minute, final int second) {
		this(() -> LocalDateTime.of(year, month, dayOfMonth, hour, minute, second), ChronoUnit.SECONDS);
	}

	public LocalDateTimeWrapper(final int year, final Month month, final int dayOfMonth, final int hour, final int minute, final int second, final int nanos) {
		this(() -> LocalDateTime.of(year, month, dayOfMonth, hour, minute, second, nanos), ChronoUnit.NANOS);
	}

	@Override
	public long difference(final LocalDateTime other, final TemporalUnit unit) {
		return Math.abs(wrapped.get().truncatedTo(accuracy).until(other, unit));
	}

	@Override
	public boolean isAfter(final LocalDateTime other) {
		return wrapped.get().truncatedTo(accuracy).isAfter(other.truncatedTo(accuracy));
	}

	@Override
	public boolean isBefore(final LocalDateTime other) {
		return wrapped.get().truncatedTo(accuracy).isBefore(other.truncatedTo(accuracy));
	}

	@Override
	public boolean isSame(final LocalDateTime other) {
		return wrapped.get().truncatedTo(accuracy).isEqual(other.truncatedTo(accuracy));
	}

	@Override
	public LocalDateTime unwrap() {
		return wrapped.get();
	}

	@Override
	public TemporalWrapper<LocalDateTime, TemporalUnit, Void> withZone(final Void ignored) {
		return this;
	}

}
