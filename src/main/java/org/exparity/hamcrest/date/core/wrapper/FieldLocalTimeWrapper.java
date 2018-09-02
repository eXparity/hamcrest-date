package org.exparity.hamcrest.date.core.wrapper;

import org.exparity.hamcrest.date.core.TemporalFieldWrapper;

import java.time.*;
import java.time.temporal.ChronoField;
import java.util.function.ToIntFunction;

public class FieldLocalTimeWrapper implements TemporalFieldWrapper<LocalTime> {

  private final ToIntFunction<ZoneId> wrapped;
  private final ChronoField field;
  private final ZoneId zone;

  private FieldLocalTimeWrapper(final ToIntFunction<ZoneId> wrapped, final ChronoField field, final ZoneId zone) {
    this.wrapped = wrapped;
    this.field = field;
    this.zone = zone;
  }

  public FieldLocalTimeWrapper(final int value, final ChronoField field) {
    this.wrapped = (ignored) -> value;
    this.field = field;
    this.zone = ZoneId.systemDefault();
  }

  public FieldLocalTimeWrapper(final LocalTime date, final ChronoField field) {
    this.wrapped = (ignored) -> date.get(field);
    this.field = field;
    this.zone = ZoneId.systemDefault();
  }

  @Override
  public boolean isAfter(final LocalTime other) {
    return wrapped.applyAsInt(zone) > other.get(field);
  }

  @Override
  public boolean isBefore(final LocalTime other) {
    return wrapped.applyAsInt(zone) < other.get(field);
  }

  @Override
  public boolean isSame(final LocalTime other) {
    return wrapped.applyAsInt(zone) == other.get(field);
  }

  @Override
  public int unwrap() {
    return wrapped.applyAsInt(zone);
  }

  @Override
  public TemporalFieldWrapper<LocalTime> withZone(final ZoneId zone) {
    return new FieldLocalTimeWrapper(wrapped, field, zone);
  }

}
