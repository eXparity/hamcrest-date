package org.exparity.hamcrest.date.core.wrapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

import org.exparity.hamcrest.date.core.TemporalWrapper;

/**
 * Implementation of a {@link TemporalWrapper} which wraps a
 * {@link ZonedDateTime} instance
 * 
 * @author Stewart Bissett
 */
public class ZonedDateTimeWrapper implements TemporalWrapper<ZonedDateTime> {

	private final ZonedDateTime wrapped;
	private final TemporalUnit accuracy;

	public ZonedDateTimeWrapper(final Date date, final ZoneId zone) {
		this.wrapped = date.toInstant().atZone(zone);
		this.accuracy = ChronoUnit.MILLIS;
	}

	public ZonedDateTimeWrapper(final ZonedDateTime date) {
		this.accuracy = ChronoUnit.NANOS;
		this.wrapped = date;
	}

	public ZonedDateTimeWrapper(final LocalDateTime date, final ZoneId zone) {
		this.wrapped = ZonedDateTime.of(date, zone);
		this.accuracy = ChronoUnit.NANOS;
	}

	public ZonedDateTimeWrapper(int year, Month month, int dayOfMonth, int hour, int minute, int second,
			final ZoneId zone) {
		this.wrapped = ZonedDateTime.of(LocalDateTime.of(year, month, dayOfMonth, hour, minute, second), zone);
		this.accuracy = ChronoUnit.SECONDS;
	}

	public ZonedDateTimeWrapper(int year, Month month, int dayOfMonth, final ZoneId zone) {
		this.wrapped = ZonedDateTime.of(LocalDate.of(year, month, dayOfMonth), LocalTime.NOON, zone);
		this.accuracy = ChronoUnit.DAYS;
	}

	@Override
	public long difference(ZonedDateTime other, ChronoUnit unit) {
		return Math.abs(wrapped.truncatedTo(accuracy).until(other, unit));
	}

	@Override
	public boolean isAfter(ZonedDateTime other) {
		return wrapped.truncatedTo(accuracy).isAfter(other.truncatedTo(accuracy));
	}

	@Override
	public boolean isBefore(ZonedDateTime other) {
		return wrapped.truncatedTo(accuracy).isBefore(other.truncatedTo(accuracy));
	}

	@Override
	public boolean isSame(ZonedDateTime other) {
		return wrapped.truncatedTo(accuracy).isEqual(other.truncatedTo(accuracy));
	}

	@Override
	public boolean isSameDay(ZonedDateTime other) {
		return wrapped.toLocalDate().isEqual(other.toLocalDate());
	}

	@Override
	public ZonedDateTime unwrap() {
		return wrapped;
	}

}
