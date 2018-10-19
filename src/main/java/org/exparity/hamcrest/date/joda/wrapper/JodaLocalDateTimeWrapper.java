package org.exparity.hamcrest.date.joda.wrapper;

import java.util.function.Supplier;

import org.exparity.hamcrest.date.core.TemporalWrapper;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationFieldType;
import org.joda.time.LocalDateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;

/**
 * Implementation of a {@link TemporalWrapper} which wraps a Joda {@link LocalDateTime}
 * instance
 *
 * @author Thomas Naskali
 */
public class JodaLocalDateTimeWrapper implements TemporalWrapper<LocalDateTime, DurationFieldType, Void> {

 	private final Supplier<LocalDateTime> wrapped;
 	private final DateTimeFieldType accuracy;

	public JodaLocalDateTimeWrapper(final Supplier<LocalDateTime> wrapped, final DateTimeFieldType accuracy) {
		this.wrapped = wrapped;
		this.accuracy = accuracy;
	}

	public JodaLocalDateTimeWrapper(final Supplier<LocalDateTime> wrapped) {
 		this(wrapped, DateTimeFieldType.millisOfSecond());
 	}

	public JodaLocalDateTimeWrapper(final LocalDateTime date, final DateTimeFieldType accuracy) {
		this(() -> date, accuracy);
	}

	public JodaLocalDateTimeWrapper(final LocalDateTime date) {
 		this(date, DateTimeFieldType.millisOfSecond());
 	}

	public JodaLocalDateTimeWrapper(final int year, final int month, final int dayOfMonth) {
		this(() -> new LocalDateTime(year, month, dayOfMonth, 0, 0, 0, 0), DateTimeFieldType.dayOfMonth());
	}

	public JodaLocalDateTimeWrapper(final int year, final int month, final int dayOfMonth, final int hour, final int minute, final int second) {
		this(() -> new LocalDateTime(year, month, dayOfMonth, hour, minute, second, 0), DateTimeFieldType.secondOfMinute());
	}

	public JodaLocalDateTimeWrapper(final int year, final int month, final int dayOfMonth, final int hour, final int minute, final int second, final int millis) {
		this(() -> new LocalDateTime(year, month, dayOfMonth, hour, minute, second, millis), DateTimeFieldType.millisOfSecond());
	}

 	@Override
 	public long difference(final LocalDateTime other, DurationFieldType unit) {
	  PeriodType periodType = PeriodType.forFields(new DurationFieldType[]{ unit });
	  Period period = new Period(
 	    wrapped.get().property(accuracy).roundFloorCopy(),
		other.property(accuracy).roundFloorCopy()
	  ).normalizedStandard(periodType);
	  return Math.abs(period.get(unit));
 	}

 	@Override
 	public boolean isAfter(final LocalDateTime other) {
 		return wrapped.get().property(accuracy).roundFloorCopy().isAfter(other.property(accuracy).roundFloorCopy());
 	}

 	@Override
 	public boolean isBefore(final LocalDateTime other) {
 		return wrapped.get().property(accuracy).roundFloorCopy().isBefore(other.property(accuracy).roundFloorCopy());
 	}

 	@Override
 	public boolean isSame(final LocalDateTime other) {
 		return wrapped.get().property(accuracy).roundFloorCopy().isEqual(other.property(accuracy).roundFloorCopy());
 	}

 	@Override
 	public LocalDateTime unwrap() {
 		return wrapped.get();
 	}

 	@Override
 	public String toString() {
 		return wrapped.get().toString();
 	}

 	@Override
 	public TemporalWrapper<LocalDateTime, DurationFieldType, Void> withZone(final Void zone) {
 		return this;
 	}

}

