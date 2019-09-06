package org.exparity.hamcrest.date.core.format;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.exparity.hamcrest.date.core.TemporalFormatter;

/**
 * Implementation of a {@link TemporalFormatter} that can format a
 * {@link LocalDateTime}
 *
 * @author Stewart Bissett
 */
public class LocalDateTimeFormatter implements TemporalFormatter<LocalDateTime> {

	private static final String DATE_FORMAT = "EEE, dd MMM yyyy";
	private static final String DATE_TIME_PATTERN = "EEE, dd MMM yyyy hh:mm:ss.SSS a";
	private final DateTimeFormatter dateTimeFormatter;
	private final DateTimeFormatter dateFormat;

	public LocalDateTimeFormatter() {
		this(Locale.getDefault(Locale.Category.FORMAT));
	}

	public LocalDateTimeFormatter(Locale locale) {
		this.dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN, locale);
		this.dateFormat = DateTimeFormatter.ofPattern(DATE_FORMAT, locale);
	}

	@Override
	public String describe(final LocalDateTime temporal) {
		return temporal.format(dateTimeFormatter);
	}

	@Override
	public String describeDate(final LocalDateTime temporal) {
		return temporal.format(dateFormat);
	}
}
