/**
 * 
 */
package org.exparity.hamcrest.date.core;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
