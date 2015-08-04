package org.exparity.hamcrest.localdate;

import static java.time.format.DateTimeFormatter.ofPattern;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * Base class for all LocalDate  {@link org.hamcrest.Matcher} implementations
 * 
 * @author Stewart Bissett
 */
abstract class AbstractLocalDateMatcher extends TypeSafeDiagnosingMatcher<LocalDate> {

	private static final DateTimeFormatter DATE_FORMAT = ofPattern("dd MMM yyyy");

	/**
	 * Format the date into a string showing milliseconds
	 */
	protected String formatDate(final LocalDate date) {
		return date.format(DATE_FORMAT);
	}

}
