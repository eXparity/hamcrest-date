package org.exparity.hamcrest.date.core.format;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.exparity.hamcrest.date.core.TemporalFormatter;

/**
 * Implementation of a {@link TemporalFormatter} that can format a {@link LocalDate}
 *
 * @author Stewart Bissett
 */
public class LocalDateFormatter implements TemporalFormatter<LocalDate> {

	private static final String DATE_PATTERN = "EEE, dd MMM yyyy";
	
	private final DateTimeFormatter dateTimeFormatter;
	private final DateTimeFormatter dateFormatter;

	public LocalDateFormatter(Locale locale) {
		this.dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_PATTERN, locale);
		this.dateFormatter = DateTimeFormatter.ofPattern(DATE_PATTERN, locale);
	}

	public LocalDateFormatter() {
		this(Locale.getDefault(Locale.Category.FORMAT));
	}

	@Override
	public String describe(final LocalDate temporal) {
		return temporal.format(dateTimeFormatter);
	}

	@Override
	public String describeDate(final LocalDate temporal) {
		return temporal.format(dateFormatter);
	}

}
