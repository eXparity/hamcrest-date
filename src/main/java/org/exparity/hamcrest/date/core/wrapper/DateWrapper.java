package org.exparity.hamcrest.date.core.wrapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.function.Function;

import org.exparity.hamcrest.date.core.TemporalWrapper;

/**
 * Implementation of {@link TemporalWrapper} to wrap {@link Date} objects.
 *
 * @author Stewart Bissett
 */
public class DateWrapper implements TemporalWrapper<Date> {

	private final Function<ZoneId, ZonedDateTime> wrapped;
	private final ZoneId zone;
	private final TemporalUnit accuracy;

	private DateWrapper(final Function<ZoneId, ZonedDateTime> wrapped, final ZoneId zone, final TemporalUnit accuracy) {
		this.wrapped = wrapped;
		this.zone = zone;
		this.accuracy = accuracy;
	}

	public DateWrapper(final Date date) {
		this(date, ChronoUnit.MILLIS);
	}

	public DateWrapper(final Date date, final TemporalUnit accuracy) {
		this.zone = ZoneId.systemDefault();
		this.wrapped = z -> date.toInstant().atZone(z);
		this.accuracy = accuracy;
	}

	public DateWrapper(final LocalDate date) {
		this(date, ChronoUnit.DAYS);
	}

	public DateWrapper(final LocalDate date, final TemporalUnit accuracy) {
		this.zone = ZoneId.systemDefault();
		this.wrapped = date::atStartOfDay;
		this.accuracy = accuracy;
	}

	public DateWrapper(final int year, final Month month, final int dayOfMonth) {
		this(LocalDate.of(year, month, dayOfMonth));
	}

	public DateWrapper(final int year, final Month month, final int dayOfMonth, final int hour, final int minute,
			final int second) {
		this.zone = ZoneId.systemDefault();
		this.wrapped = z -> LocalDateTime.of(year, month, dayOfMonth, hour, minute, second).atZone(z);
		this.accuracy = ChronoUnit.SECONDS;
	}

	public DateWrapper(final int year, final Month month, final int dayOfMonth, final int hour, final int minute,
			final int second, final int millis) {
		this.zone = ZoneId.systemDefault();
		this.wrapped = z -> LocalDateTime.of(year, month, dayOfMonth, hour, minute, second, millis * 1000000).atZone(z);
		this.accuracy = ChronoUnit.MILLIS;
	}

	@Override
	public long difference(final Date other, final ChronoUnit unit) {
		return Math.abs(wrapped.apply(zone).truncatedTo(accuracy).toInstant().until(other.toInstant().atZone(zone).truncatedTo(accuracy).toInstant(), unit));
	}

	@Override
	public boolean isAfter(final Date other) {
		return wrapped.apply(zone).truncatedTo(accuracy).toInstant().isAfter(other.toInstant().atZone(zone).truncatedTo(accuracy).toInstant());
	}

	@Override
	public boolean isBefore(final Date other) {
		return wrapped.apply(zone).truncatedTo(accuracy).toInstant().isBefore(other.toInstant().atZone(zone).truncatedTo(accuracy).toInstant());
	}

	@Override
	public boolean isSame(final Date other) {
		return wrapped.apply(zone).truncatedTo(accuracy).toInstant().equals(other.toInstant().atZone(zone).truncatedTo(accuracy).toInstant());
	}

	@Override
	public Date unwrap() {
		return new Date(wrapped.apply(zone).toInstant().toEpochMilli());
	}

	@Override
	public DateWrapper withZone(final ZoneId zone) {
		return new DateWrapper(wrapped, zone, accuracy);
	}

}
