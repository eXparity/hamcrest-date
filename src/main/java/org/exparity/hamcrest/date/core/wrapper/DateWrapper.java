package org.exparity.hamcrest.date.core.wrapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.function.Supplier;

import org.exparity.hamcrest.date.core.TemporalWrapper;

/**
 * Implementation of {@link TemporalWrapper} to wrap {@link Date} objects.
 *
 * @author Stewart Bissett
 */
public class DateWrapper implements TemporalWrapper<Date> {

	private final Supplier<ZonedDateTime> wrapped;
	private final ZoneId zone;
	private final TemporalUnit accuracy;

	private DateWrapper(Supplier<ZonedDateTime> wrapped, ZoneId zone, TemporalUnit accuracy) {
		this.wrapped = wrapped;
		this.zone = zone;
		this.accuracy = accuracy;
	}

	public DateWrapper(final Date date) {
		zone = ZoneId.systemDefault();
		wrapped = () -> date.toInstant().atZone(zone);
		accuracy = ChronoUnit.MILLIS;
	}

	public DateWrapper(final LocalDate date) {
		zone = ZoneId.systemDefault();
		wrapped = () -> date.atStartOfDay(zone);
		accuracy = ChronoUnit.DAYS;
	}

	public DateWrapper(final int year, final Month month, final int dayOfMonth) {
		this(LocalDate.of(year, month, dayOfMonth));
	}

	public DateWrapper(final int year, final Month month, final int dayOfMonth, final int hour, final int minute,
			final int second) {
		zone = ZoneId.systemDefault();
		wrapped = () -> LocalDateTime.of(year, month, dayOfMonth, hour, minute, second).atZone(zone);
		accuracy = ChronoUnit.SECONDS;
	}

	public DateWrapper(final int year, final Month month, final int dayOfMonth, final int hour, final int minute,
			final int second, final int millis) {
		zone = ZoneId.systemDefault();
		wrapped = () -> LocalDateTime.of(year, month, dayOfMonth, hour, minute, second, millis * 1000000).atZone(zone);
		accuracy = ChronoUnit.MILLIS;
	}

	@Override
	public long difference(final Date other, final ChronoUnit unit) {
		return Math.abs(wrapped.get().truncatedTo(accuracy).until(other.toInstant().atZone(zone).truncatedTo(accuracy), unit));
	}

	@Override
	public boolean isAfter(final Date other) {
		return wrapped.get().truncatedTo(accuracy).isAfter(other.toInstant().atZone(zone).truncatedTo(accuracy));
	}

	@Override
	public boolean isBefore(final Date other) {
		return wrapped.get().truncatedTo(accuracy).isBefore(other.toInstant().atZone(zone).truncatedTo(accuracy));
	}

	@Override
	public boolean isSame(final Date other) {
		return wrapped.get().truncatedTo(accuracy).equals(other.toInstant().atZone(zone).truncatedTo(accuracy));
	}

	@Override
	public boolean isSameDay(final Date other) {
		return wrapped.get().truncatedTo(ChronoUnit.DAYS).equals(other.toInstant().atZone(zone).truncatedTo(ChronoUnit.DAYS));
	}

	@Override
	public Date unwrap() {
		return new Date(wrapped.get().toInstant().toEpochMilli());
	}

	@Override
	public DateWrapper withZone(ZoneId zone) {
		return new DateWrapper(wrapped, zone, accuracy);
	}

}
