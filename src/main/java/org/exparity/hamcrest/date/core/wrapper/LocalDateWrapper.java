package org.exparity.hamcrest.date.core.wrapper;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.function.Supplier;

import org.exparity.hamcrest.date.core.TemporalWrapper;

/**
 * Implementation of a {@link TemporalWrapper} which wraps a {@link LocalDate}
 * instance
 * 
 * @author Stewart Bissett
 */
public class LocalDateWrapper implements TemporalWrapper<LocalDate> {

	private final Supplier<LocalDate> wrapped;
	private final ZoneId zone;

	private LocalDateWrapper(Supplier<LocalDate> wrapped, ZoneId zone) {
		this.wrapped = wrapped;
		this.zone = zone;
	}

	public LocalDateWrapper(final Date date) {
		this.zone = ZoneId.systemDefault();
		this.wrapped = () -> date.toInstant().atZone(zone).toLocalDate();
	}

	public LocalDateWrapper(final LocalDate date) {
		this.zone = ZoneId.systemDefault();
		this.wrapped = () -> date;
	}

	@Override
	public long difference(LocalDate other, ChronoUnit unit) {
		return Math.abs(wrapped.get().until(other, unit));
	}

	@Override
	public boolean isAfter(LocalDate other) {
		return wrapped.get().isAfter(other);
	}

	@Override
	public boolean isBefore(LocalDate other) {
		return wrapped.get().isBefore(other);
	}

	@Override
	public boolean isSame(LocalDate other) {
		return wrapped.get().isEqual(other);
	}

	@Override
	public boolean isSameDay(LocalDate other) {
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
	public TemporalWrapper<LocalDate> withZone(ZoneId zone) {
		return new LocalDateWrapper(this.wrapped, zone);
	}

}
