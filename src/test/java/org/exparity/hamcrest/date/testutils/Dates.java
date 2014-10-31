
package org.exparity.hamcrest.date.testutils;

import java.util.Date;
import static org.exparity.dates.en.FluentDateTime.*;

/**
 * Static repository of dates used for testing
 * 
 * @author Stewart Bissett
 */
public abstract class Dates {

	public static final Date JAN_1ST_2000_11_AM = JAN(1, 2000).at(11);
	public static final Date JAN_1ST_2012_11_AM = JAN(1, 2012).at(11);
	public static final Date JAN_1ST_2012_11_AM_GMT = JAN(1, 2012).at(11, TimeZones.GMT);
	public static final Date JAN_1ST_2012_11_PM = JAN(1, 2012).at(23);
	public static final Date JAN_1ST_2012_11_AM_PST = JAN(1, 2012).at(11, TimeZones.PST);
	public static final Date JAN_2ND_2012_11_AM = JAN(2, 2012).at(11);
	public static final Date JAN_3RD_2012_11_AM = JAN(3, 2012).at(11);
	public static final Date JAN_4TH_2012_11_AM = JAN(4, 2012).at(11);
	public static final Date JAN_5TH_2012_11_AM = JAN(5, 2012).at(11);
	public static final Date JAN_6TH_2012_11_AM = JAN(6, 2012).at(11);
	public static final Date JAN_7TH_2012_11_AM = JAN(7, 2012).at(11);
	public static final Date JAN_8TH_2012_11_AM = JAN(8, 2012).at(11);
	public static final Date JAN_31ST_2012_11_AM = JAN(31, 2012).at(11);
	public static final Date FEB_1ST_2012_11_AM = FEB(1, 2012).at(11);
	public static final Date MAR_1ST_2012_11_AM = MAR(1, 2012).at(11);
	public static final Date APR_1ST_2012_11_AM = APR(1, 2012).at(11);
	public static final Date MAY_1ST_2012_11_AM = MAY(1, 2012).at(11);
	public static final Date JUN_1ST_2012_11_AM = JUN(1, 2012).at(11);
	public static final Date JUN_15TH_2012_11_AM = JUN(15, 2012).at(11);
	public static final Date JUN_15TH_2012_11_PM = JUN(15, 2012).at(23);
	public static final Date JUL_1ST_2012_11_AM = JUL(1, 2012).at(11);
	public static final Date AUG_1ST_2012_11_AM = AUG(1, 2012).at(11);
	public static final Date SEP_1ST_2012_11_AM = SEP(1, 2012).at(11);
	public static final Date OCT_1ST_2012_11_AM = OCT(1, 2012).at(11);
	public static final Date NOV_1ST_2012_11_AM = NOV(1, 2012).at(11);
	public static final Date DEC_1ST_2012_11_AM = DEC(1, 2012).at(11);
	public static final Date JAN_1ST_2013_11_AM = JAN(1, 2013).at(11);
	public static final Date JAN_1ST_2100_11_AM = JAN(1, 2100).at(11);
}
