/**
 *
 */
package org.exparity.hamcrest.date.core.format;

import java.time.LocalDateTime;

import org.exparity.hamcrest.date.core.TemporalFormatter;

/**
 * Implementation of a {@link TemporalFormatter} that can format a
 * {@link LocalDateTime}
 *
 * @author Stewart Bissett
 */
public class LocalDateTimeFormatter implements TemporalFormatter<LocalDateTime> {

	@Override
	public String describe(final LocalDateTime temporal) {
		return temporal.toString();
	}

}
