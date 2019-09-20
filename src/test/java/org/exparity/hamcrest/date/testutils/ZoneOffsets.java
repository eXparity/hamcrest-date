package org.exparity.hamcrest.date.testutils;

import java.time.ZoneId;
import java.time.ZoneOffset;

/**
 * Static repository of {@link ZoneId}
 *
 * @author Stewart Bissett
 */
public abstract class ZoneOffsets {

	public static final ZoneOffset UTC = ZoneOffset.UTC; // 00:00
	public static final ZoneOffset CET = ZoneOffset.ofHours(1); // +01:00
	public static final ZoneOffset EST = ZoneOffset.ofHours(-5); // -05:00

}
