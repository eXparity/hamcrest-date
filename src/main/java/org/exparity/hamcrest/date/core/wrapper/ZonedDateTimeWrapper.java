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
 * Implementation of a {@link TemporalWrapper} which wraps a
 * {@link ZonedDateTime} instance
 *
 * @author Stewart Bissett
 */
public class ZonedDateTimeWrapper implements TemporalWrapper<ZonedDateTime> {

	private final Supplier<ZonedDateTime> wrapped;
	private final ZoneId zone;
	private final TemporalUnit accuracy;

	public ZonedDateTimeWrapper(final Date date) {
		zone = ZoneId.systemDefault();
		wrapped = () -> date.toInstant().atZone(zone);
		accuracy = ChronoUnit.MILLIS;
	}

	public ZonedDateTimeWrapper(final ZonedDateTime date) {
		zone = ZoneId.systemDefault();
		wrapped = () -> date;
		accuracy = ChronoUnit.NANOS;
	}

	public ZonedDateTimeWrapper(final LocalDateTime date, final ZoneId zone) {
		this.zone = ZoneId.systemDefault();
		wrapped = () -> date.atZone(zone);
		accuracy = ChronoUnit.NANOS;
	}

	public ZonedDateTimeWrapper(final int year, final Month month, final int dayOfMonth, final int hour,
	        final int minute, final int second, final ZoneId zone) {
		this.zone = ZoneId.systemDefault();
		wrapped = () -> LocalDateTime.of(year, month, dayOfMonth, hour, minute, second).atZone(zone);
		accuracy = ChronoUnit.SECONDS;
	}

	public ZonedDateTimeWrapper(final int year, final Month month, final int dayOfMonth, final int hour,
	        final int minute, final int second, final int nanos, final ZoneId zone) {
		this.zone = ZoneId.systemDefault();
		wrapped = () -> LocalDateTime.of(year, month, dayOfMonth, hour, minute, second, nanos).atZone(zone);
		accuracy = ChronoUnit.NANOS;
	}

	public ZonedDateTimeWrapper(final int year, final Month month, final int dayOfMonth, final ZoneId zone) {
		this.zone = ZoneId.systemDefault();
		wrapped = () -> LocalDate.of(year, month, dayOfMonth).atStartOfDay().atZone(zone);
		accuracy = ChronoUnit.DAYS;
	}

	private ZonedDateTimeWrapper(Supplier<ZonedDateTime> wrapped, ZoneId zone, TemporalUnit accuracy) {
		this.wrapped = wrapped;
		this.zone = zone;
		this.accuracy = accuracy;
	}

	@Override
	public long difference(final ZonedDateTime other, final ChronoUnit unit) {
		return Math.abs(wrapped.get().truncatedTo(accuracy).until(other, unit));
	}

	@Override
	public boolean isAfter(final ZonedDateTime other) {
		return wrapped.get().truncatedTo(accuracy).isAfter(other.truncatedTo(accuracy));
	}

	@Override
	public boolean isBefore(final ZonedDateTime other) {
		return wrapped.get().truncatedTo(accuracy).isBefore(other.truncatedTo(accuracy));
	}

	@Override
	public boolean isSame(final ZonedDateTime other) {
		return wrapped.get().truncatedTo(accuracy).isEqual(other.truncatedTo(accuracy));
	}

	@Override
	public boolean isSameDay(final ZonedDateTime other) {
		return wrapped.get().toLocalDate().isEqual(other.toLocalDate());
	}

	@Override
	public ZonedDateTime unwrap() {
		return wrapped.get();
	}

	@Override
	public TemporalWrapper<ZonedDateTime> withZone(ZoneId zone) {
		return new ZonedDateTimeWrapper(wrapped, zone, accuracy);
	}

}
