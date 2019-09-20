package org.exparity.hamcrest.date.core;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

import org.exparity.hamcrest.date.core.function.DateFunction;
import org.exparity.hamcrest.date.core.function.InstantFunction;
import org.exparity.hamcrest.date.core.function.LocalDateFunction;
import org.exparity.hamcrest.date.core.function.LocalDateTimeFunction;
import org.exparity.hamcrest.date.core.function.LocalTimeFunction;
import org.exparity.hamcrest.date.core.function.OffsetDateTimeFunction;
import org.exparity.hamcrest.date.core.function.SqlDateFunction;
import org.exparity.hamcrest.date.core.function.ZonedDateTimeFunction;

/**
 * Static repository of {@link TemporalFunction} instances
 * 
 * @author Stewart Bissett
 */
public class TemporalFunctions {

	private TemporalFunctions() {}
	
	public static TemporalFunction<Date> JAVADATE = new DateFunction();
	public static TemporalFunction<java.sql.Date> SQLDATE = new SqlDateFunction();
	public static TemporalFunction<LocalDate> LOCALDATE = new LocalDateFunction();
	public static TemporalFunction<LocalTime> LOCALTIME = new LocalTimeFunction();
	public static TemporalFunction<LocalDateTime> LOCALDATETIME = new LocalDateTimeFunction();
	public static TemporalFunction<ZonedDateTime> ZONEDDATETIME = new ZonedDateTimeFunction();
    public static TemporalFunction<OffsetDateTime> OFFSETDATETIME = new OffsetDateTimeFunction();
	public static TemporalFunction<Instant> INSTANT = new InstantFunction();
}
