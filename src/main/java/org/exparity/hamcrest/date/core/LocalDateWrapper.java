package org.exparity.hamcrest.date.core;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * Implementation of a {@link TemporalWrapper} which wraps a {@link LocalDate}
 * instance
 * 
 * @author Stewart Bissett
 */
public class LocalDateWrapper implements TemporalWrapper<LocalDate> {

	private final LocalDate wrapped;

	public LocalDateWrapper(final Date date) {
		this.wrapped = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public LocalDateWrapper(final LocalDate date) {
		this.wrapped = date;
	}

	@Override
	public long difference(LocalDate other, ChronoUnit unit) {
		return Math.abs(wrapped.until(other, unit));
	}

	@Override
	public boolean isAfter(LocalDate other) {
		return wrapped.isAfter(other);
	}

	@Override
	public boolean isBefore(LocalDate other) {
		return wrapped.isBefore(other);
	}

	@Override
	public boolean isSame(LocalDate other) {
		return wrapped.isEqual(other);
	}

	@Override
	public boolean isSameDay(LocalDate other) {
		return wrapped.isEqual(other);
	}

	@Override
	public LocalDate unwrap() {
		return wrapped;
	}

	@Override
	public String toString() {
		return wrapped.toString();
	}

}
