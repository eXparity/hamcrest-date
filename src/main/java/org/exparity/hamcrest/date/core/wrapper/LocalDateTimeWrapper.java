package org.exparity.hamcrest.date.core.wrapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.function.Supplier;

import org.exparity.hamcrest.date.core.TemporalWrapper;

/**
 * Implementation of a {@link TemporalWrapper} which wraps a
 * {@link LocalDateTime} instance
 *
 * @author Stewart Bissett
 */
public class LocalDateTimeWrapper implements TemporalWrapper<LocalDateTime> {

	private final Supplier<LocalDateTime> wrapped;
	private final ZoneId zone;
	private final TemporalUnit accuracy;

	private LocalDateTimeWrapper(final Supplier<LocalDateTime> wrapped, final ZoneId zone, final TemporalUnit accuracy) {
		this.wrapped = wrapped;
		this.zone = zone;
		this.accuracy = accuracy;
	}

	public LocalDateTimeWrapper(final Date date) {
		this(date, ChronoUnit.MILLIS);
	}

	public LocalDateTimeWrapper(final Date date, final TemporalUnit accuracy) {
		this.zone = ZoneId.systemDefault();
		this.wrapped = () -> date.toInstant().atZone(zone).toLocalDateTime();
		this.accuracy = accuracy;
	}

	public LocalDateTimeWrapper(final LocalDateTime date) {
		this(date, ChronoUnit.NANOS);
	}

	public LocalDateTimeWrapper(final LocalDateTime date, final TemporalUnit accuracy) {
		this.zone = ZoneId.systemDefault();
		this.wrapped = () -> date;
		this.accuracy = accuracy;
	}

	public LocalDateTimeWrapper(final int year, final Month month, final int dayOfMonth) {
		this.zone = ZoneId.systemDefault();
		this.wrapped = () -> LocalDate.of(year, month, dayOfMonth).atStartOfDay();
		this.accuracy = ChronoUnit.DAYS;
	}

	public LocalDateTimeWrapper(final int year, final Month month, final int dayOfMonth, final int hour, final int minute, final int second) {
		this.zone = ZoneId.systemDefault();
		this.wrapped = () -> LocalDateTime.of(year, month, dayOfMonth, hour, minute, second);
		this.accuracy = ChronoUnit.SECONDS;
	}

	public LocalDateTimeWrapper(final int year, final Month month, final int dayOfMonth, final int hour, final int minute, final int second, final int nanos) {
		this.zone = ZoneId.systemDefault();
		this.wrapped = () -> LocalDateTime.of(year, month, dayOfMonth, hour, minute, second, nanos);
		this.accuracy = ChronoUnit.NANOS;
	}

	@Override
	public long difference(final LocalDateTime other, final ChronoUnit unit) {
		return Math.abs(wrapped.get().truncatedTo(accuracy).until(other, unit));
	}

	@Override
	public boolean isAfter(final LocalDateTime other) {
		return wrapped.get().truncatedTo(accuracy).isAfter(other.truncatedTo(accuracy));
	}

	@Override
	public boolean isBefore(final LocalDateTime other) {
		return wrapped.get().truncatedTo(accuracy).isBefore(other.truncatedTo(accuracy));
	}

	@Override
	public boolean isSame(final LocalDateTime other) {
		return wrapped.get().truncatedTo(accuracy).isEqual(other.truncatedTo(accuracy));
	}

	@Override
	public LocalDateTime unwrap() {
		return wrapped.get();
	}

	@Override
	public LocalDateTimeWrapper withZone(final ZoneId zone) {
		return new LocalDateTimeWrapper(wrapped, zone, accuracy);
	}

}
