package org.exparity.hamcrest.date.core.wrapper;

import org.exparity.hamcrest.date.core.TemporalFieldWrapper;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.function.ToIntFunction;

/**
 * Implementation of {@link org.exparity.hamcrest.date.core.TemporalFieldWrapper} to compare temporal fields of
 * {@link Date} objects.
 *
 * @author Thomas Naskali
 */
public class FieldDateWrapper implements TemporalFieldWrapper<Date> {

  private final ToIntFunction<ZoneId> wrapped;
  private final ChronoField field;
  private final ZoneId zone;

  private FieldDateWrapper(final ToIntFunction<ZoneId> wrapped, final ChronoField field, final ZoneId zone) {
    this.wrapped = wrapped;
    this.field = field;
    this.zone = zone;
  }

  public FieldDateWrapper(final int value, final ChronoField field) {
    this.wrapped = (ignored) -> value;
    this.field = field;
    this.zone = ZoneId.systemDefault();
  }

  public FieldDateWrapper(Date date, ChronoField field) {
    this.wrapped = z -> date.toInstant().atZone(z).get(field);
    this.field = field;
    this.zone = ZoneId.systemDefault();
  }

  @Override
  public boolean isAfter(Date other) {
    return wrapped.applyAsInt(zone) > other.toInstant().atZone(zone).get(field);
  }

  @Override
  public boolean isBefore(Date other) {
    return wrapped.applyAsInt(zone) < other.toInstant().atZone(zone).get(field);
  }

  @Override
  public boolean isSame(Date other) {
    return wrapped.applyAsInt(zone) == other.toInstant().atZone(zone).get(field);
  }

  @Override
  public int unwrap() {
    return wrapped.applyAsInt(zone);
  }

  @Override
  public TemporalFieldWrapper<Date> withZone(ZoneId zone) {
    return new FieldDateWrapper(wrapped, field, zone);
  }

}
