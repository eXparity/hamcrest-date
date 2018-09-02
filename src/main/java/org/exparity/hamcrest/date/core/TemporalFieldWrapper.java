package org.exparity.hamcrest.date.core;

import java.time.ZoneId;

/**
 * Wrapper which wraps a temporal field so it can support the operations required
 * by the matchers
 *
 * @author Thomas Naskali
 */
public interface TemporalFieldWrapper<T> {

  /**
   * @param other a temporal to test against
   * @return <code>true</code> if this temporal field is after the other
   */
  boolean isAfter(final T other);

  /**
   * @param other a temporal to test against
   * @return <code>true</code> if this temporal field is before the other
   */
  boolean isBefore(final T other);

  /**
   * @param other a temporal to test against
   * @return <code>true</code> if this temporal field is the same as the other
   */
  boolean isSame(final T other);

  /**
   * @return a the wrapped value
   */
  int unwrap();

  /**
   *
   * @param zone a zone to apply to the wrapped value
   * @return a copy of the wrapper at the desired zone
   */
  TemporalFieldWrapper<T> withZone(ZoneId zone);

}
