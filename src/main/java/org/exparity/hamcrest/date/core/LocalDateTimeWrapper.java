package org.exparity.hamcrest.date.core;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/**
 * Implementation of a {@link TemporalWrapper} which wraps a
 * {@link LocalDateTime} instance
 * 
 * @author Stewart Bissett
 */
public class LocalDateTimeWrapper implements TemporalWrapper<LocalDateTime> {

	private final LocalDateTime wrapped;
	private final TemporalUnit accuracy;

	public LocalDateTimeWrapper(final Date date) {
		this.wrapped = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		this.accuracy = ChronoUnit.MILLIS;
	}

	public LocalDateTimeWrapper(final LocalDateTime date) {
		this.wrapped = date;
		this.accuracy = ChronoUnit.NANOS;
	}

	public LocalDateTimeWrapper(int year, Month month, int dayOfMonth, int hour, int minute, int second) {
		this.wrapped = LocalDateTime.of(year, month, dayOfMonth, hour, minute, second);
		this.accuracy = ChronoUnit.SECONDS;
	}

	@Override
	public long difference(LocalDateTime other, ChronoUnit unit) {
		return Math.abs(wrapped.truncatedTo(accuracy).until(other, unit));
	}

	@Override
	public boolean isAfter(LocalDateTime other) {
		return wrapped.truncatedTo(accuracy).isAfter(other.truncatedTo(accuracy));
	}

	@Override
	public boolean isBefore(LocalDateTime other) {
		return wrapped.truncatedTo(accuracy).isBefore(other.truncatedTo(accuracy));
	}

	@Override
	public boolean isSame(LocalDateTime other) {
		return wrapped.truncatedTo(accuracy).isEqual(other.truncatedTo(accuracy));
	}

	@Override
	public boolean isSameDay(LocalDateTime other) {
		return wrapped.truncatedTo(accuracy).isEqual(other.truncatedTo(accuracy));
	}

	@Override
	public LocalDateTime unwrap() {
		return wrapped;
	}

}
