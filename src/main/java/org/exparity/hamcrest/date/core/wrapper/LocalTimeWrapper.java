package org.exparity.hamcrest.date.core.wrapper;

import java.time.LocalTime;
import java.time.temporal.TemporalUnit;

import org.exparity.hamcrest.date.core.TemporalWrapper;

/**
 * Implementation of a {@link TemporalWrapper} which wraps a {@link LocalTime}
 * instance
 *
 * @author Stewart Bissett
 */
public class LocalTimeWrapper implements TemporalWrapper<LocalTime, TemporalUnit, Void> {

	private final LocalTime wrapped;

	public LocalTimeWrapper(final LocalTime date) {
		this.wrapped = date;
	}

	public LocalTimeWrapper(final int hour, final int minute, final int second) {
		this(LocalTime.of(hour, minute, second));
	}

	@Override
	public long difference(final LocalTime other, final TemporalUnit unit) {
		return Math.abs(wrapped.until(other, unit));
	}

	@Override
	public boolean isAfter(final LocalTime other) {
		return wrapped.isAfter(other);
	}

	@Override
	public boolean isBefore(final LocalTime other) {
		return wrapped.isBefore(other);
	}

	@Override
	public boolean isSame(final LocalTime other) {
		return wrapped.equals(other);
	}

	@Override
	public LocalTime unwrap() {
		return wrapped;
	}

	@Override
	public TemporalWrapper<LocalTime, TemporalUnit, Void> withZone(final Void zone) {
		return this;
	}

}
