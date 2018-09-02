package org.exparity.hamcrest.date.core;

import java.time.ZoneId;
import java.time.temporal.ValueRange;

@FunctionalInterface
public interface TemporalFieldRangeAdapter<T> {

  ValueRange asTemporalFieldRange(final T source, final ZoneId zone);

}
