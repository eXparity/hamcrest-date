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
public class DateWrapper implements TemporalWrapper<Date, TemporalUnit, ZoneId> {

	private final Function<ZoneId, ZonedDateTime> wrapped;
	private final TemporalUnit accuracy;
	private final ZoneId zone;

	private DateWrapper(final Function<ZoneId, ZonedDateTime> wrapped, final TemporalUnit accuracy, final ZoneId zone) {
		this.wrapped = wrapped;
		this.accuracy = accuracy;
		this.zone = zone;
	}

	private DateWrapper(final Function<ZoneId, ZonedDateTime> wrapped, final TemporalUnit accuracy) {
		this(wrapped, accuracy, null);
	}

	private DateWrapper(final ZonedDateTime date, final TemporalUnit accuracy) {
  		this(date::withZoneSameInstant, accuracy);
  	}

	private DateWrapper(final ZonedDateTime date) {
 		this(date::withZoneSameInstant, ChronoUnit.MILLIS);
 	}

	public DateWrapper(final Date date, final TemporalUnit accuracy) {
		this(z -> date.toInstant().atZone(z), accuracy);
	}

	public DateWrapper(final Date date) {
 		this(date, ChronoUnit.MILLIS);
 	}

	public DateWrapper(final Date date, final ZoneId zone, final TemporalUnit accuracy) {
 		this(date.toInstant().atZone(zone), accuracy);
 	}

	public DateWrapper(final Date date, final ZoneId zone) {
		this(date, zone, ChronoUnit.MILLIS);
	}

	public DateWrapper(final LocalDate date, final TemporalUnit accuracy) {
  		this(date::atStartOfDay, accuracy);
  	}

	public DateWrapper(final LocalDate date) {
 		this(date, ChronoUnit.DAYS);
 	}

	public DateWrapper(final LocalDate date, final ZoneId zone) {
		this(date.atStartOfDay(zone), ChronoUnit.DAYS);
	}

	public DateWrapper(final int year, final Month month, final int dayOfMonth) {
 		this(LocalDate.of(year, month, dayOfMonth));
 	}

	public DateWrapper(final int year, final Month month, final int dayOfMonth, final ZoneId zone) {
		this(LocalDate.of(year, month, dayOfMonth), zone);
	}

	public DateWrapper(final LocalDateTime date, final TemporalUnit accuracy) {
   		this(date::atZone, accuracy);
   	}

 	public DateWrapper(final LocalDateTime date) {
  		this(date, ChronoUnit.MILLIS);
  	}

	public DateWrapper(final int year, final Month month, final int dayOfMonth, final int hour, final int minute,
 			final int second) {
 		this(LocalDateTime.of(year, month, dayOfMonth, hour, minute, second), ChronoUnit.SECONDS);
 	}

	public DateWrapper(final int year, final Month month, final int dayOfMonth, final int hour, final int minute,
			final int second, final ZoneId zone) {
		this(LocalDateTime.of(year, month, dayOfMonth, hour, minute, second).atZone(zone), ChronoUnit.SECONDS);
	}

	public DateWrapper(final int year, final Month month, final int dayOfMonth, final int hour, final int minute,
 			final int second, final int millis) {
 		this(LocalDateTime.of(year, month, dayOfMonth, hour, minute, second, millis * 1000000));
 	}

	public DateWrapper(final int year, final Month month, final int dayOfMonth, final int hour, final int minute,
			final int second, final int millis, final ZoneId zone) {
		this(LocalDateTime.of(year, month, dayOfMonth, hour, minute, second, millis * 1000000).atZone(zone));
	}

	private ZoneId getReferenceZone() {
	  return zone != null ? zone : ZoneId.systemDefault();
	}

	@Override
	public long difference(final Date other, final TemporalUnit unit) {
		ZoneId referenceZone = getReferenceZone();
		return Math.abs(wrapped.apply(referenceZone).truncatedTo(accuracy).toInstant().until(other.toInstant().atZone(referenceZone).truncatedTo(accuracy).toInstant(), unit));
	}

	@Override
	public boolean isAfter(final Date other) {
		ZoneId referenceZone = getReferenceZone();
		return wrapped.apply(referenceZone).truncatedTo(accuracy).toInstant().isAfter(other.toInstant().atZone(referenceZone).truncatedTo(accuracy).toInstant());
	}

	@Override
	public boolean isBefore(final Date other) {
		ZoneId referenceZone = getReferenceZone();
		return wrapped.apply(referenceZone).truncatedTo(accuracy).toInstant().isBefore(other.toInstant().atZone(referenceZone).truncatedTo(accuracy).toInstant());
	}

	@Override
	public boolean isSame(final Date other) {
		ZoneId referenceZone = getReferenceZone();
		return wrapped.apply(referenceZone).truncatedTo(accuracy).toInstant().equals(other.toInstant().atZone(referenceZone).truncatedTo(accuracy).toInstant());
	}

  	@Override
	public Date unwrap() {
		return new Date(wrapped.apply(getReferenceZone()).toInstant().toEpochMilli());
	}

	@Override
	public TemporalWrapper<Date, TemporalUnit, ZoneId> withZone(final ZoneId zone) {
		return new DateWrapper(wrapped, accuracy, zone);
	}

}
