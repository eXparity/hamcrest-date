package org.exparity.hamcrest.date.core.wrapper;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.function.Function;

import org.exparity.hamcrest.date.core.TemporalWrapper;

/**
 * Implementation of a {@link TemporalWrapper} which wraps a
 * {@link ZonedDateTime} instance
 *
 * @author Stewart Bissett
 */
public class ZonedDateTimeWrapper implements TemporalWrapper<ZonedDateTime> {

	private final Function<ZoneId, ZonedDateTime> wrapped;
	private final ZoneId zone;
	private final TemporalUnit accuracy;

	private ZonedDateTimeWrapper(final Function<ZoneId, ZonedDateTime> wrapped, final ZoneId zone, final TemporalUnit accuracy) {
		this.wrapped = wrapped;
		this.zone = zone;
		this.accuracy = accuracy;
	}

	public ZonedDateTimeWrapper(final Date date) {
		this(date, ChronoUnit.MILLIS);
	}

	public ZonedDateTimeWrapper(final Date date, final TemporalUnit accuracy) {
		this.zone = ZoneId.systemDefault();
		this.wrapped = z -> date.toInstant().atZone(z);
		this.accuracy = accuracy;
	}

	public ZonedDateTimeWrapper(final ZonedDateTime date) {
		this(date, ChronoUnit.NANOS);
	}

	public ZonedDateTimeWrapper(final ZonedDateTime date, final TemporalUnit accuracy) {
		this.zone = ZoneId.systemDefault();
		this.wrapped = date::withZoneSameInstant;
		this.accuracy = accuracy;
	}

	public ZonedDateTimeWrapper(final LocalDateTime date, final ZoneId zone) {
		this(date, zone, ChronoUnit.NANOS);
	}

	public ZonedDateTimeWrapper(final LocalDateTime date, final ZoneId zone, final TemporalUnit accuracy) {
		this.zone = zone;
		this.wrapped = date::atZone;
		this.accuracy = accuracy;
	}

	public ZonedDateTimeWrapper(final int year, final Month month, final int dayOfMonth, final int hour,
	        final int minute, final int second, final ZoneId zone) {
		this.zone = zone;
		this.wrapped = z -> LocalDateTime.of(year, month, dayOfMonth, hour, minute, second).atZone(zone);
		this.accuracy = ChronoUnit.SECONDS;
	}

	public ZonedDateTimeWrapper(final int year, final Month month, final int dayOfMonth, final int hour,
	        final int minute, final int second, final int nanos, final ZoneId zone) {
		this.zone = zone;
		this.wrapped = z -> LocalDateTime.of(year, month, dayOfMonth, hour, minute, second, nanos).atZone(zone);
		this.accuracy = ChronoUnit.NANOS;
	}

	public ZonedDateTimeWrapper(final int year, final Month month, final int dayOfMonth, final ZoneId zone) {
		this.zone = zone;
		this.wrapped = z -> LocalDate.of(year, month, dayOfMonth).atStartOfDay().atZone(zone);
		this.accuracy = ChronoUnit.DAYS;
	}

	@Override
	public long difference(final ZonedDateTime other, final ChronoUnit unit) {
		return Math.abs(wrapped.apply(zone).truncatedTo(accuracy).toInstant().until(other.toInstant(), unit));
	}

	@Override
	public boolean isAfter(final ZonedDateTime other) {
		return wrapped.apply(zone).truncatedTo(accuracy).toInstant().isAfter(other.truncatedTo(accuracy).toInstant());
	}

	@Override
	public boolean isBefore(final ZonedDateTime other) {
		return wrapped.apply(zone).truncatedTo(accuracy).toInstant().isBefore(other.truncatedTo(accuracy).toInstant());
	}

	@Override
	public boolean isSame(final ZonedDateTime other) {
		return wrapped.apply(zone).truncatedTo(accuracy).toInstant().equals(other.truncatedTo(accuracy).toInstant());
	}

	@Override
	public ZonedDateTime unwrap() {
		return wrapped.apply(zone);
	}

	@Override
	public TemporalWrapper<ZonedDateTime> withZone(final ZoneId zone) {
		return new ZonedDateTimeWrapper(wrapped, zone, accuracy);
	}

}
