/**
 * 
 */
package org.exparity.hamcrest.date.core;

import static java.time.ZoneId.systemDefault;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

import org.exparity.hamcrest.date.DayMonthYear;
import org.exparity.hamcrest.date.Months;

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
		this.wrapped = ZonedDateTime.of(date, LocalTime.MIN, ZoneId.systemDefault()).toInstant();
		this.accuracy = ChronoUnit.DAYS;
	}

	public DateWrapper(final LocalDate date, final LocalTime time) {
		this.wrapped = ZonedDateTime.of(date, time, ZoneId.systemDefault()).toInstant();
		this.accuracy = ChronoUnit.SECONDS;
	}

	public DateWrapper(final DayMonthYear date) {
		this(LocalDate.of(date.getYear(), date.getMonth().month(), date.getDay()));
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
