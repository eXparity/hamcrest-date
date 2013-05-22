/*
 * Copyright (c) Modular IT Limited.
 */

package uk.co.it.modular.hamcrest.date.testutils;

import java.util.TimeZone;

/**
 * Static repository of timezone used for testing
 * 
 * @author Stewart Bissett
 */
public abstract class TimeZones {

	public static final TimeZone PST = TimeZone.getTimeZone("PST");
	public static final TimeZone GMT = TimeZone.getTimeZone("GMT");

}
