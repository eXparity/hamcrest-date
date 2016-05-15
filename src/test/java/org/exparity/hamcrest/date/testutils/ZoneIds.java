/**
 *
 */
package org.exparity.hamcrest.date.testutils;

import java.time.ZoneId;

/**
 * Static repository of {@link ZoneId}
 *
 * @author Stewart Bissett
 */
public abstract class ZoneIds {

	public static final ZoneId UTC = ZoneId.of("UTC");
	public static final ZoneId CET = ZoneId.of("Europe/Paris");
	public static final ZoneId EST = ZoneId.of("America/New_York");

}
