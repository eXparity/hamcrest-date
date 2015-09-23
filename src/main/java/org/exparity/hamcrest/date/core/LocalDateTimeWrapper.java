package org.exparity.hamcrest.date.core;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.Date;

/**
 * Implementation of a {@link TemporalWrapper} which wraps a
 * {@link LocalDateTime} instance
 * 
 * @author Stewart Bissett
 */
public class LocalDateTimeWrapper implements TemporalWrapper<LocalDateTime> {

	private final LocalDateTime wrapped;

	public LocalDateTimeWrapper(final Date date) {
		this.wrapped = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public LocalDateTimeWrapper(final LocalDateTime date) {
		this.wrapped = date;
	}

	public LocalDateTimeWrapper(int year, Month month, int dayOfMonth, int hour, int minute, int second) {
		this.wrapped = LocalDateTime.of(year, month, dayOfMonth, hour, minute, second);
	}

	@Override
	public boolean isAfter(LocalDateTime other) {
		return wrapped.isAfter(other);
	}

	@Override
	public boolean isBefore(LocalDateTime other) {
		return wrapped.isBefore(other);
	}

	@Override
	public boolean isSame(LocalDateTime other) {
		return wrapped.isEqual(other);
	}

	@Override
	public boolean isSameDay(LocalDateTime other) {
		return wrapped.isEqual(other);
	}

	@Override
	public LocalDateTime unwrap() {
		return wrapped;
	}

}
