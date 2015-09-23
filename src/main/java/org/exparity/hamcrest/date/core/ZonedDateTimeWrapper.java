package org.exparity.hamcrest.date.core;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Implementation of a {@link TemporalWrapper} which wraps a
 * {@link ZonedDateTime} instance
 * 
 * @author Stewart Bissett
 */
public class ZonedDateTimeWrapper implements TemporalWrapper<ZonedDateTime> {

	private final ZonedDateTime wrapped;

	public ZonedDateTimeWrapper(final Date date) {
		this.wrapped = date.toInstant().atZone(ZoneId.systemDefault());
	}

	public ZonedDateTimeWrapper(final ZonedDateTime date) {
		this.wrapped = date;
	}

	public ZonedDateTimeWrapper(final LocalDateTime date, final ZoneId zone) {
		this.wrapped = ZonedDateTime.of(date, zone);
	}

	public ZonedDateTimeWrapper(int year, Month month, int dayOfMonth, int hour, int minute, int second,
			final ZoneId zone) {
		this(LocalDateTime.of(year, month, dayOfMonth, hour, minute, second), zone);
	}

	@Override
	public boolean isAfter(ZonedDateTime other) {
		return wrapped.isAfter(other);
	}

	@Override
	public boolean isBefore(ZonedDateTime other) {
		return wrapped.isBefore(other);
	}

	@Override
	public boolean isSame(ZonedDateTime other) {
		return wrapped.isEqual(other);
	}

	@Override
	public boolean isSameDay(ZonedDateTime other) {
		return wrapped.isEqual(other);
	}

	@Override
	public ZonedDateTime unwrap() {
		return wrapped;
	}

}
