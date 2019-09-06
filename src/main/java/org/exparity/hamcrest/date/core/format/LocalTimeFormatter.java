package org.exparity.hamcrest.date.core.format;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.exparity.hamcrest.date.core.TemporalFormatter;

/**
 * Implementation of a {@link TemporalFormatter} that can format a
 * {@link LocalTime}
 *
 * @author Stewart Bissett
 */
public class LocalTimeFormatter implements TemporalFormatter<LocalTime> {

	private static final String TIME_PATTERN = "hh:mm:ss a";
	private final DateTimeFormatter formatter;;

	public LocalTimeFormatter(Locale locale) {
		this.formatter = DateTimeFormatter.ofPattern(TIME_PATTERN, locale);
	}
	
	public LocalTimeFormatter() {
		this(Locale.getDefault(Locale.Category.FORMAT));
	}

	@Override
	public String describe(final LocalTime temporal) {
		return temporal.format(formatter);
	}

	@Override
	public String describeDate(final LocalTime temporal) {
		throw new UnsupportedOperationException("describeDate is not supported against LocalTime");
	}
}
