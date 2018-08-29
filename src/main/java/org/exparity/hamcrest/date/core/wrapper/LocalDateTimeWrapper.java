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

	private LocalDateTimeWrapper(Supplier<LocalDateTime> wrapped, ZoneId zone, TemporalUnit accuracy) {
		this.wrapped = wrapped;
		this.zone = zone;
		this.accuracy = accuracy;
	}

	public LocalDateTimeWrapper(final Date date) {
		zone = ZoneId.systemDefault();
		wrapped = () -> date.toInstant().atZone(zone).toLocalDateTime();
		accuracy = ChronoUnit.MILLIS;
	}

	public LocalDateTimeWrapper(final LocalDateTime date) {
		zone = ZoneId.systemDefault();
		wrapped = () -> date;
		accuracy = ChronoUnit.NANOS;
	}

	public LocalDateTimeWrapper(final int year, final Month month, final int dayOfMonth) {
		zone = ZoneId.systemDefault();
		wrapped = () -> LocalDate.of(year, month, dayOfMonth).atStartOfDay();
		accuracy = ChronoUnit.DAYS;
	}

	public LocalDateTimeWrapper(final int year, final Month month, final int dayOfMonth, final int hour, final int minute, final int second) {
		zone = ZoneId.systemDefault();
		wrapped = () -> LocalDateTime.of(year, month, dayOfMonth, hour, minute, second);
		accuracy = ChronoUnit.SECONDS;
	}

	public LocalDateTimeWrapper(final int year, final Month month, final int dayOfMonth, final int hour, final int minute, final int second, final int nanos) {
		zone = ZoneId.systemDefault();
		wrapped = () -> LocalDateTime.of(year, month, dayOfMonth, hour, minute, second, nanos);
		accuracy = ChronoUnit.NANOS;
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
	public boolean isSameDay(final LocalDateTime other) {
		return wrapped.get().truncatedTo(ChronoUnit.DAYS).isEqual(other.truncatedTo(ChronoUnit.DAYS));
	}

	@Override
	public LocalDateTime unwrap() {
		return wrapped.get();
	}

	@Override
	public LocalDateTimeWrapper withZone(ZoneId zone) {
		return new LocalDateTimeWrapper(wrapped, zone, accuracy);
	}

}
