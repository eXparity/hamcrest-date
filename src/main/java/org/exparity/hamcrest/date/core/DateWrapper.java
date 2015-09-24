/**
 * 
 */
package org.exparity.hamcrest.date.core;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

import org.exparity.hamcrest.date.DayMonthYear;

/**
 * Implementation of {@link TemporalWrapper} to wrap {@link Date} objects.
 * 
 * @author Stewart Bissett
 */
public class DateWrapper implements TemporalWrapper<Date> {

	private final Instant wrapped;
	private final TemporalUnit accuracy;

	public DateWrapper(final Date date) {
		this.wrapped = date.toInstant();
		this.accuracy = ChronoUnit.MILLIS;
	}

	public DateWrapper(final LocalDate date) {
		this.wrapped = ZonedDateTime.of(date, LocalTime.NOON, ZoneId.systemDefault()).toInstant();
		this.accuracy = ChronoUnit.DAYS;
	}

	public DateWrapper(final int year, final Month month, final int dayOfMonth) {
		this(LocalDate.of(year, month, dayOfMonth));
	}

	public DateWrapper(final int year, final Month month, final int dayOfMonth, final int hour, final int minute,
			final int second) {
		this.wrapped = ZonedDateTime
				.of(LocalDateTime.of(year, month, dayOfMonth, hour, minute, second), ZoneId.systemDefault())
					.toInstant();
		this.accuracy = ChronoUnit.SECONDS;
	}

	public DateWrapper(final int year, final Month month, final int dayOfMonth, final int hour, final int minute,
			final int second, final int millis) {
		this.wrapped = ZonedDateTime
				.of(
						LocalDateTime.of(year, month, dayOfMonth, hour, minute, second, millis * 1000000),
							ZoneId.systemDefault())
					.toInstant();
		this.accuracy = ChronoUnit.MILLIS;
	}

	@Override
	public long difference(final Date other, ChronoUnit unit) {
		return Math.abs(wrapped.truncatedTo(accuracy).until(other.toInstant(), unit));
	}

	@Override
	public boolean isAfter(final Date other) {
		return wrapped.truncatedTo(accuracy).isAfter(other.toInstant().truncatedTo(accuracy));
	}

	@Override
	public boolean isBefore(Date other) {
		return wrapped.truncatedTo(accuracy).isBefore(other.toInstant().truncatedTo(accuracy));
	}

	@Override
	public boolean isSame(Date other) {
		return wrapped.truncatedTo(accuracy).equals(other.toInstant().truncatedTo(accuracy));
	}

	@Override
	public boolean isSameDay(Date other) {
		return wrapped.truncatedTo(accuracy).equals(other.toInstant().truncatedTo(ChronoUnit.DAYS));
	}

	@Override
	public Date unwrap() {
		return new Date(wrapped.toEpochMilli());
	}
}
