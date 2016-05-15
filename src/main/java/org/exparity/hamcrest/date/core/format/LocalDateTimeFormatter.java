/**
 *
 */
package org.exparity.hamcrest.date.core.format;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.exparity.hamcrest.date.core.TemporalFormatter;

/**
 * Implementation of a {@link TemporalFormatter} that can format a
 * {@link LocalDateTime}
 *
 * @author Stewart Bissett
 */
public class LocalDateTimeFormatter implements TemporalFormatter<LocalDateTime> {

	private static DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy hh:mm:ss.SSS a");
	private static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy");

	@Override
	public String describe(final LocalDateTime temporal) {
		return temporal.format(DATE_TIME_FORMAT);
	}

	@Override
	public String describeDate(final LocalDateTime temporal) {
		return temporal.format(DATE_FORMAT);
	}
}
