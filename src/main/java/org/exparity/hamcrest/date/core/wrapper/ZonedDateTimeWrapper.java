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
		wrapped = date.toInstant().atZone(zone);
		accuracy = ChronoUnit.MILLIS;
	}

	public ZonedDateTimeWrapper(final ZonedDateTime date) {
		accuracy = ChronoUnit.NANOS;
		wrapped = date;
	}

	public ZonedDateTimeWrapper(final LocalDateTime date, final ZoneId zone) {
		wrapped = ZonedDateTime.of(date, zone);
		accuracy = ChronoUnit.NANOS;
	}

	public ZonedDateTimeWrapper(final int year, final Month month, final int dayOfMonth, final int hour,
	        final int minute, final int second, final ZoneId zone) {
		wrapped = ZonedDateTime.of(LocalDateTime.of(year, month, dayOfMonth, hour, minute, second), zone);
		accuracy = ChronoUnit.SECONDS;
	}

	public ZonedDateTimeWrapper(final int year, final Month month, final int dayOfMonth, final int hour,
	        final int minute, final int second, final int nanos, final ZoneId zone) {
		wrapped = ZonedDateTime.of(LocalDateTime.of(year, month, dayOfMonth, hour, minute, second, nanos), zone);
		accuracy = ChronoUnit.NANOS;
	}

	public ZonedDateTimeWrapper(final int year, final Month month, final int dayOfMonth, final ZoneId zone) {
		wrapped = ZonedDateTime.of(LocalDate.of(year, month, dayOfMonth), LocalTime.NOON, zone);
		accuracy = ChronoUnit.DAYS;
	}

	@Override
	public long difference(final ZonedDateTime other, final ChronoUnit unit) {
		return Math.abs(wrapped.truncatedTo(accuracy).until(other, unit));
	}

	@Override
	public boolean isAfter(final ZonedDateTime other) {
		return wrapped.truncatedTo(accuracy).isAfter(other.truncatedTo(accuracy));
	}

	@Override
	public boolean isBefore(final ZonedDateTime other) {
		return wrapped.truncatedTo(accuracy).isBefore(other.truncatedTo(accuracy));
	}

	@Override
	public boolean isSame(final ZonedDateTime other) {
		return wrapped.truncatedTo(accuracy).isEqual(other.truncatedTo(accuracy));
	}

	@Override
	public boolean isSameDay(final ZonedDateTime other) {
		return wrapped.toLocalDate().isEqual(other.toLocalDate());
	}

	@Override
	public ZonedDateTime unwrap() {
		return wrapped;
	}

}
