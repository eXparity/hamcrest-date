package org.exparity.hamcrest.date.core.wrapper;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import org.exparity.hamcrest.date.core.TemporalWrapper;

/**
 * Implementation of a {@link TemporalWrapper} which wraps a {@link LocalTime}
 * instance
 *
 * @author Stewart Bissett
 */
public class LocalTimeWrapper implements TemporalWrapper<LocalTime> {

	private final LocalTime wrapped;

	public LocalTimeWrapper(final LocalTime date) {
		this.wrapped = date;
	}

	public LocalTimeWrapper(final int hour, final int minute, final int second) {
		this(LocalTime.of(hour, minute, second));
	}

	@Override
	public long difference(final LocalTime other, final ChronoUnit unit) {
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
	public TemporalWrapper<LocalTime> withZone(final ZoneId zone) {
		return this;
	}

}
