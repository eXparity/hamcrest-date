package org.exparity.hamcrest.date.core;

/**
 * Exception thrown when a temporal type cannot be converted to another
 */
public class TemporalConversionException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public TemporalConversionException(String message) {
		super(message);
	}
}
