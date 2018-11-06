package org.exparity.hamcrest.date.joda.wrapper;

import org.exparity.hamcrest.date.core.TemporalFieldWrapper;
import org.joda.time.DateTimeFieldType;
import org.joda.time.LocalTime;

/**
 * Implementation of {@link TemporalFieldWrapper} which wraps a temporal field of a Joda {@link LocalTime} instance.
 *
 * @author Thomas Naskali
 */
public class FieldJodaLocalTimeWrapper implements TemporalFieldWrapper<LocalTime, Void> {

  private final int wrapped;
  private final DateTimeFieldType field;

  public FieldJodaLocalTimeWrapper(final int value, final DateTimeFieldType field) {
    this.wrapped = value;
    this.field = field;
  }

  public FieldJodaLocalTimeWrapper(final LocalTime date, final DateTimeFieldType field) {
    this(date.get(field), field);
  }

  @Override
  public boolean isAfter(final LocalTime other) {
    return wrapped > other.get(field);
  }

  @Override
  public boolean isBefore(final LocalTime other) {
    return wrapped < other.get(field);
  }

  @Override
  public boolean isSame(final LocalTime other) {
    return wrapped == other.get(field);
  }

  @Override
  public int unwrap() {
    return wrapped;
  }

  @Override
  public TemporalFieldWrapper<LocalTime, Void> withZone(final Void ignored) {
    return this;
  }

}
