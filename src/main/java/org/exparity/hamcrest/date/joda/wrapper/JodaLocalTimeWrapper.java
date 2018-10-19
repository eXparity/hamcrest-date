package org.exparity.hamcrest.date.joda.wrapper;

import java.util.function.Supplier;

import org.exparity.hamcrest.date.core.TemporalWrapper;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationFieldType;
import org.joda.time.LocalTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;

/**
 * Implementation of a {@link TemporalWrapper} which wraps a Joda {@link LocalTime}
 * instance
 *
 * @author Thomas Naskali
 */
public class JodaLocalTimeWrapper implements TemporalWrapper<LocalTime, DurationFieldType, Void> {

	private final Supplier<LocalTime> wrapped;
	private final DateTimeFieldType accuracy;

 	private JodaLocalTimeWrapper(final Supplier<LocalTime> wrapped, final DateTimeFieldType accuracy) {
 		this.wrapped = wrapped;
 		this.accuracy = accuracy;
 	}

 	public JodaLocalTimeWrapper(final LocalTime date) {
 		this(() -> date, DateTimeFieldType.millisOfSecond());
 	}

	public JodaLocalTimeWrapper(final int hour, final int minute, final int second) {
 		this(new LocalTime(hour, minute, second));
	}

 	@Override
 	public long difference(final LocalTime other, DurationFieldType unit) {
		PeriodType periodType = PeriodType.forFields(new DurationFieldType[]{ unit });
		Period period = new Period(
			wrapped.get().property(accuracy).roundFloorCopy(),
			other.property(accuracy).roundFloorCopy()
		).normalizedStandard(periodType);
		return Math.abs(period.get(unit));
 	}

 	@Override
 	public boolean isAfter(final LocalTime other) {
 		return wrapped.get().property(accuracy).roundFloorCopy().isAfter(other.property(accuracy).roundFloorCopy());
 	}

 	@Override
 	public boolean isBefore(final LocalTime other) {
 		return wrapped.get().property(accuracy).roundFloorCopy().isBefore(other.property(accuracy).roundFloorCopy());
 	}

 	@Override
 	public boolean isSame(final LocalTime other) {
 		return wrapped.get().property(accuracy).roundFloorCopy().isEqual(other.property(accuracy).roundFloorCopy());
 	}

 	@Override
 	public LocalTime unwrap() {
 		return wrapped.get();
 	}

 	@Override
 	public String toString() {
 		return wrapped.get().toString();
 	}

 	@Override
 	public TemporalWrapper<LocalTime, DurationFieldType, Void> withZone(final Void ignored) {
 		return this;
 	}

}

