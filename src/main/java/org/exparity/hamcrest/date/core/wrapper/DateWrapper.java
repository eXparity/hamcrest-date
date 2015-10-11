/**
 *
 */
package org.exparity.hamcrest.date.core.wrapper;

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

import org.exparity.hamcrest.date.core.TemporalWrapper;

/**
 * Implementation of {@link TemporalWrapper} to wrap {@link Date} objects.
 *
 * @author Stewart Bissett
 */
public class DateWrapper implements TemporalWrapper<Date> {

	private final Instant wrapped;
	private final TemporalUnit accuracy;

	public DateWrapper(final Date date) {
		wrapped = date.toInstant();
		accuracy = ChronoUnit.MILLIS;
	}

	public DateWrapper(final LocalDate date) {
		wrapped = ZonedDateTime.of(date, LocalTime.NOON, ZoneId.systemDefault()).toInstant();
		accuracy = ChronoUnit.DAYS;
	}

	public DateWrapper(final int year, final Month month, final int dayOfMonth) {
		this(LocalDate.of(year, month, dayOfMonth));
	}

	public DateWrapper(final int year, final Month month, final int dayOfMonth, final int hour, final int minute,
			final int second) {
		wrapped = ZonedDateTime
				.of(LocalDateTime.of(year, month, dayOfMonth, hour, minute, second), ZoneId.systemDefault())
					.toInstant();
		accuracy = ChronoUnit.SECONDS;
	}

	public DateWrapper(final int year, final Month month, final int dayOfMonth, final int hour, final int minute,
			final int second, final int millis) {
		wrapped = ZonedDateTime
				.of(
						LocalDateTime.of(year, month, dayOfMonth, hour, minute, second, millis * 1000000),
							ZoneId.systemDefault())
					.toInstant();
		accuracy = ChronoUnit.MILLIS;
	}

	@Override
	public long difference(final Date other, final ChronoUnit unit) {
		return Math.abs(wrapped.truncatedTo(accuracy).until(other.toInstant(), unit));
	}

	@Override
	public boolean isAfter(final Date other) {
		return wrapped.truncatedTo(accuracy).isAfter(other.toInstant().truncatedTo(accuracy));
	}

	@Override
	public boolean isBefore(final Date other) {
		return wrapped.truncatedTo(accuracy).isBefore(other.toInstant().truncatedTo(accuracy));
	}

	@Override
	public boolean isSame(final Date other) {
		return wrapped.truncatedTo(accuracy).equals(other.toInstant().truncatedTo(accuracy));
	}

	@Override
	public boolean isSameDay(final Date other) {
		return wrapped.truncatedTo(ChronoUnit.DAYS).equals(other.toInstant().truncatedTo(ChronoUnit.DAYS));
	}

	@Override
	public Date unwrap() {
		return new Date(wrapped.toEpochMilli());
	}
}
