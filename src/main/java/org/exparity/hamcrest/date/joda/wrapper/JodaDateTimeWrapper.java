package org.exparity.hamcrest.date.joda.wrapper;

import java.util.Date;
import java.util.function.Function;

import org.exparity.hamcrest.date.core.TemporalWrapper;
import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationFieldType;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;

/**
 * Implementation of a {@link TemporalWrapper} which wraps a Joda {@link DateTime}
 * instance
 *
 * @author Thomas Naskali
 */
public class JodaDateTimeWrapper implements TemporalWrapper<DateTime, DurationFieldType, DateTimeZone> {

	private final Function<DateTimeZone, DateTime> wrapped;
 	private final DateTimeFieldType accuracy;
 	private final DateTimeZone zone;
 
 	private JodaDateTimeWrapper(final Function<DateTimeZone, DateTime> wrapped, final DateTimeFieldType accuracy, final DateTimeZone zone) {
 		this.wrapped = wrapped;
 		this.accuracy = accuracy;
 		this.zone = zone;
 	}
 
	private JodaDateTimeWrapper(final Function<DateTimeZone, DateTime> wrapped, final DateTimeFieldType accuracy) {
 		this(wrapped,  accuracy, null);
 	}

	public JodaDateTimeWrapper(final DateTime date, final DateTimeFieldType accuracy) {
  		this(date::withZone, accuracy);
  	}

  	public JodaDateTimeWrapper(final DateTime date) {
  		this(date, DateTimeFieldType.millisOfSecond());
  	}

 	public JodaDateTimeWrapper(final Date date, final DateTimeZone zone) {
 		this(date, zone, DateTimeFieldType.millisOfSecond());
 	}
 
 	public JodaDateTimeWrapper(final Date date, final DateTimeZone zone, final DateTimeFieldType accuracy) {
 		this(new DateTime(date.toInstant().toEpochMilli(), zone), accuracy);
 	}
 
	public JodaDateTimeWrapper(final LocalDate date) {
 		this(date::toDateTimeAtStartOfDay, DateTimeFieldType.dayOfMonth());
 	}

 	public JodaDateTimeWrapper(final LocalDate date, final DateTimeZone zone) {
 		this(date.toDateTimeAtStartOfDay(zone), DateTimeFieldType.dayOfMonth());
 	}

 	public JodaDateTimeWrapper(final LocalDate date, final DateTimeFieldType accuracy, final DateTimeZone zone) {
 		this(date.toDateTimeAtStartOfDay(zone), accuracy);
 	}

	public JodaDateTimeWrapper(final int year, final int month, final int dayOfMonth) {
  		this(new LocalDate(year, month, dayOfMonth));
  	}

  	public JodaDateTimeWrapper(final int year, final int month, final int dayOfMonth, final DateTimeZone zone) {
  		this(new LocalDate(year, month, dayOfMonth).toDateTimeAtStartOfDay(zone), DateTimeFieldType.dayOfMonth());
  	}

	public JodaDateTimeWrapper(final LocalDateTime date, final DateTimeFieldType accuracy) {
 		this(date::toDateTime, accuracy);
 	}

	public JodaDateTimeWrapper(final LocalDateTime date) {
  		this(date, DateTimeFieldType.millisOfSecond());
  	}

 	public JodaDateTimeWrapper(final LocalDateTime date, final DateTimeZone zone) {
 		this(date.toDateTime(zone));
 	}
 
 	public JodaDateTimeWrapper(final LocalDateTime date, final DateTimeFieldType accuracy, final DateTimeZone zone) {
 		this(date.toDateTime(zone), accuracy);
 	}
 
	public JodaDateTimeWrapper(final int year, final int month, final int dayOfMonth, final int hour,
 	        final int minute, final int second) {
 		this(new LocalDateTime(year, month, dayOfMonth, hour, minute, second), DateTimeFieldType.secondOfMinute());
 	}

 	public JodaDateTimeWrapper(final int year, final int month, final int dayOfMonth, final int hour,
 	        final int minute, final int second, final DateTimeZone zone) {
 		this(new LocalDateTime(year, month, dayOfMonth, hour, minute, second).toDateTime(zone), DateTimeFieldType.secondOfMinute());
 	}
 
	public JodaDateTimeWrapper(final int year, final int month, final int dayOfMonth, final int hour,
 	        final int minute, final int second, final int millis) {
 		this(new LocalDateTime(year, month, dayOfMonth, hour, minute, second, millis));
 	}

 	public JodaDateTimeWrapper(final int year, final int month, final int dayOfMonth, final int hour,
 	        final int minute, final int second, final int millis, final DateTimeZone zone) {
 		this(new LocalDateTime(year, month, dayOfMonth, hour, minute, second, millis).toDateTime(zone));
 	}
 
	private DateTimeZone getReferenceZone() {
 	  return zone != null ? zone : DateTimeZone.getDefault();
 	}

 	@Override
 	public long difference(final DateTime other, final DurationFieldType unit) {
	  DateTimeZone referenceZone = getReferenceZone();
	  PeriodType periodType = PeriodType.forFields(new DurationFieldType[]{ unit });
	  Period period = new Period(
 	    wrapped.apply(referenceZone).property(accuracy).roundFloorCopy(),
		other.withZone(referenceZone).property(accuracy).roundFloorCopy()
	  ).normalizedStandard(periodType);
	  return Math.abs(period.get(unit));
 	}
 
 	@Override
 	public boolean isAfter(final DateTime other) {
	  DateTimeZone referenceZone = getReferenceZone();
 		return wrapped.apply(referenceZone).property(accuracy).roundFloorCopy().toInstant().isAfter(other.withZone(referenceZone).property(accuracy).roundFloorCopy().toInstant());
 	}
 
 	@Override
 	public boolean isBefore(final DateTime other) {
	  DateTimeZone referenceZone = getReferenceZone();
 		return wrapped.apply(referenceZone).property(accuracy).roundFloorCopy().toInstant().isBefore(other.withZone(referenceZone).property(accuracy).roundFloorCopy().toInstant());
 	}
 
 	@Override
 	public boolean isSame(final DateTime other) {
	  DateTimeZone referenceZone = getReferenceZone();
 		return wrapped.apply(referenceZone).property(accuracy).roundFloorCopy().toInstant().equals(other.withZone(referenceZone).property(accuracy).roundFloorCopy().toInstant());
 	}

 	@Override
 	public DateTime unwrap() {
 		return wrapped.apply(getReferenceZone());
 	}
 
 	@Override
 	public TemporalWrapper<DateTime, DurationFieldType, DateTimeZone> withZone(final DateTimeZone zone) {
 		return new JodaDateTimeWrapper(wrapped, accuracy, zone);
 	}
}

