package org.exparity.hamcrest.date.core.wrapper;

import org.exparity.hamcrest.date.core.TemporalFieldWrapper;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.util.function.ToIntFunction;

public class FieldZonedDateTimeWrapper implements TemporalFieldWrapper<ZonedDateTime> {

  private final ToIntFunction<ZoneId> wrapped;
  private final ChronoField field;
  private final ZoneId zone;

  private FieldZonedDateTimeWrapper(final ToIntFunction<ZoneId> wrapped, final ChronoField field, final ZoneId zone) {
    this.wrapped = wrapped;
    this.field = field;
    this.zone = zone;
  }

  public FieldZonedDateTimeWrapper(final int value, final ChronoField field) {
    this.wrapped = (ignored) -> value;
    this.field = field;
    this.zone = ZoneId.systemDefault();
  }

  public FieldZonedDateTimeWrapper(final ZonedDateTime date, final ChronoField field) {
    this.wrapped = z -> date.withZoneSameInstant(z).get(field);
    this.field = field;
    this.zone = ZoneId.systemDefault();
  }

  @Override
  public boolean isAfter(final ZonedDateTime other) {
    return wrapped.applyAsInt(zone) > other.withZoneSameInstant(zone).get(field);
  }

  @Override
  public boolean isBefore(final ZonedDateTime other) {
    return wrapped.applyAsInt(zone) < other.withZoneSameInstant(zone).get(field);
  }

  @Override
  public boolean isSame(final ZonedDateTime other) {
    return wrapped.applyAsInt(zone) == other.withZoneSameInstant(zone).get(field);
  }

  @Override
  public int unwrap() {
    return wrapped.applyAsInt(zone);
  }

  @Override
  public TemporalFieldWrapper<ZonedDateTime> withZone(final ZoneId zone) {
    return new FieldZonedDateTimeWrapper(wrapped, field, zone);
  }

}
