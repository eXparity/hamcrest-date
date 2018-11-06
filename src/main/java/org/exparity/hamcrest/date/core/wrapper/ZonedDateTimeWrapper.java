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
 * Implementation of a {@link TemporalWrapper} which wraps a
 * {@link ZonedDateTime} instance
 *
 * @author Stewart Bissett
 */
public class ZonedDateTimeWrapper implements TemporalWrapper<ZonedDateTime, TemporalUnit, ZoneId> {

	private final Function<ZoneId, ZonedDateTime> wrapped;
	private final TemporalUnit accuracy;
	private final ZoneId zone;

	private ZonedDateTimeWrapper(final Function<ZoneId, ZonedDateTime> wrapped, final TemporalUnit accuracy, final ZoneId zone) {
		this.wrapped = wrapped;
		this.accuracy = accuracy;
		this.zone = zone;
	}

	private ZonedDateTimeWrapper(final Function<ZoneId, ZonedDateTime> wrapped, final TemporalUnit accuracy) {
 		this(wrapped, accuracy, null);
 	}

	public ZonedDateTimeWrapper(final ZonedDateTime date, final TemporalUnit accuracy) {
 		this(date::withZoneSameInstant, accuracy);
 	}

	public ZonedDateTimeWrapper(final Date date, final TemporalUnit accuracy, final ZoneId zone) {
		this(date.toInstant().atZone(zone), accuracy);
	}

	public ZonedDateTimeWrapper(final Date date, final ZoneId zone) {
 		this(date, ChronoUnit.MILLIS, zone);
 	}

	public ZonedDateTimeWrapper(final ZonedDateTime date) {
		this(date, ChronoUnit.NANOS);
	}

	public ZonedDateTimeWrapper(final LocalDateTime date, final ZoneId zone) {
		this(date.atZone(zone), ChronoUnit.NANOS);
	}

	public ZonedDateTimeWrapper(final LocalDateTime date, final TemporalUnit accuracy, final ZoneId zone) {
		this(date.atZone(zone), accuracy);
	}

	public ZonedDateTimeWrapper(final int year, final Month month, final int dayOfMonth, final int hour,
 	        final int minute, final int second) {
 		this(z -> LocalDateTime.of(year, month, dayOfMonth, hour, minute, second).atZone(z), ChronoUnit.SECONDS);
 	}

	public ZonedDateTimeWrapper(final int year, final Month month, final int dayOfMonth, final int hour,
	        final int minute, final int second, final ZoneId zone) {
		this(LocalDateTime.of(year, month, dayOfMonth, hour, minute, second).atZone(zone), ChronoUnit.SECONDS);
	}

	public ZonedDateTimeWrapper(final int year, final Month month, final int dayOfMonth, final int hour,
 	        final int minute, final int second, final int nanos) {
 		this(z -> LocalDateTime.of(year, month, dayOfMonth, hour, minute, second, nanos).atZone(z), ChronoUnit.NANOS);
 	}

	public ZonedDateTimeWrapper(final int year, final Month month, final int dayOfMonth, final int hour,
	        final int minute, final int second, final int nanos, final ZoneId zone) {
		this(LocalDateTime.of(year, month, dayOfMonth, hour, minute, second, nanos).atZone(zone), ChronoUnit.NANOS);
	}

	public ZonedDateTimeWrapper(final int year, final Month month, final int dayOfMonth) {
 		this(z -> LocalDate.of(year, month, dayOfMonth).atStartOfDay(z), ChronoUnit.DAYS);
 	}

	public ZonedDateTimeWrapper(final int year, final Month month, final int dayOfMonth, final ZoneId zone) {
		this(LocalDate.of(year, month, dayOfMonth).atStartOfDay(zone), ChronoUnit.DAYS);
	}

	private ZoneId getReferenceZone() {
 	  return zone != null ? zone : ZoneId.systemDefault();
 	}

	@Override
	public long difference(final ZonedDateTime other, final TemporalUnit unit) {
		ZoneId referenceZone = getReferenceZone();
		return Math.abs(wrapped.apply(referenceZone).truncatedTo(accuracy).toInstant().until(other.withZoneSameInstant(referenceZone).truncatedTo(accuracy).toInstant(), unit));
	}

	@Override
	public boolean isAfter(final ZonedDateTime other) {
		ZoneId referenceZone = getReferenceZone();
		return wrapped.apply(referenceZone).truncatedTo(accuracy).toInstant().isAfter(other.withZoneSameInstant(referenceZone).truncatedTo(accuracy).toInstant());
	}

	@Override
	public boolean isBefore(final ZonedDateTime other) {
		ZoneId referenceZone = getReferenceZone();
		return wrapped.apply(referenceZone).truncatedTo(accuracy).toInstant().isBefore(other.withZoneSameInstant(referenceZone).truncatedTo(accuracy).toInstant());
	}

	@Override
	public boolean isSame(final ZonedDateTime other) {
		ZoneId referenceZone = getReferenceZone();
		return wrapped.apply(referenceZone).truncatedTo(accuracy).toInstant().equals(other.withZoneSameInstant(referenceZone).truncatedTo(accuracy).toInstant());
	}

	@Override
	public ZonedDateTime unwrap() {
		return wrapped.apply(getReferenceZone());
	}

	@Override
	public TemporalWrapper<ZonedDateTime, TemporalUnit, ZoneId> withZone(final ZoneId zone) {
		return new ZonedDateTimeWrapper(wrapped, accuracy, zone);
	}

}
