/**
 * 
 */
package org.exparity.hamcrest.date.testutils;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.TimeZone;

/**
 * Static repository of {@link ZoneId}
 * 
 * @author Stewart Bissett
 */
public abstract class ZoneIds {

	public static final ZoneId UTC = ZoneId.of("UTC");
	public static final ZoneId PLUS1 = ZoneId.ofOffset("UTC", ZoneOffset.ofHours(1));;
	public static final ZoneId MINUS1 = ZoneId.ofOffset("UTC", ZoneOffset.ofHours(-1));

}
