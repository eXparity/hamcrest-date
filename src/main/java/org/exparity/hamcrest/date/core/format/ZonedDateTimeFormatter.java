package org.exparity.hamcrest.date.core.format;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.exparity.hamcrest.date.core.TemporalFormatter;

/**
 * Implementation of a {@link TemporalFormatter} that can format a
 * {@link ZonedDateTime}
 *
 * @author Stewart Bissett
 */
public class ZonedDateTimeFormatter implements TemporalFormatter<ZonedDateTime> {

	private static final String DATE_PATTERN = "EEE, dd MMM yyyy";

	private static final String DATE_TIME_PATTERN = "EEE, dd MMM yyyy hh:mm:ss.SSS a Z";
	
	private final DateTimeFormatter dateTimeFormatter;
	private final DateTimeFormatter dateFormat;

	public ZonedDateTimeFormatter() {
		this(Locale.getDefault(Locale.Category.FORMAT));
	}

	public ZonedDateTimeFormatter(Locale locale) {
		this.dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN, locale);
		this.dateFormat = DateTimeFormatter.ofPattern(DATE_PATTERN, locale);
	}

	@Override
	public String describe(final ZonedDateTime temporal) {
		return temporal.format(dateTimeFormatter);
	}

	@Override
	public String describeDate(final ZonedDateTime temporal) {
		return temporal.format(dateFormat);
	}

}
