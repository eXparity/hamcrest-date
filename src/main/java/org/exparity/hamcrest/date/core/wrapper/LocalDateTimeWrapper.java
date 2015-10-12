package org.exparity.hamcrest.date.core.wrapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

import org.exparity.hamcrest.date.core.TemporalWrapper;

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
		wrapped = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		accuracy = ChronoUnit.MILLIS;
	}

	public LocalDateTimeWrapper(final LocalDateTime date) {
		wrapped = date;
		accuracy = ChronoUnit.NANOS;
	}

	public LocalDateTimeWrapper(final int year, final Month month, final int dayOfMonth) {
		wrapped = LocalDateTime.of(LocalDate.of(year, month, dayOfMonth), LocalTime.NOON);
		accuracy = ChronoUnit.DAYS;
	}

	public LocalDateTimeWrapper(final int year, final Month month, final int dayOfMonth, final int hour, final int minute, final int second) {
		wrapped = LocalDateTime.of(year, month, dayOfMonth, hour, minute, second);
		accuracy = ChronoUnit.SECONDS;
	}

	public LocalDateTimeWrapper(final int year, final Month month, final int dayOfMonth, final int hour, final int minute, final int second, final int nanos) {
		wrapped = LocalDateTime.of(year, month, dayOfMonth, hour, minute, second, nanos);
		accuracy = ChronoUnit.NANOS;
	}


	@Override
	public long difference(final LocalDateTime other, final ChronoUnit unit) {
		return Math.abs(wrapped.truncatedTo(accuracy).until(other, unit));
	}

	@Override
	public boolean isAfter(final LocalDateTime other) {
		return wrapped.truncatedTo(accuracy).isAfter(other.truncatedTo(accuracy));
	}

	@Override
	public boolean isBefore(final LocalDateTime other) {
		return wrapped.truncatedTo(accuracy).isBefore(other.truncatedTo(accuracy));
	}

	@Override
	public boolean isSame(final LocalDateTime other) {
		return wrapped.truncatedTo(accuracy).isEqual(other.truncatedTo(accuracy));
	}

	@Override
	public boolean isSameDay(final LocalDateTime other) {
		return wrapped.truncatedTo(ChronoUnit.DAYS).isEqual(other.truncatedTo(ChronoUnit.DAYS));
	}

	@Override
	public LocalDateTime unwrap() {
		return wrapped;
	}

}
