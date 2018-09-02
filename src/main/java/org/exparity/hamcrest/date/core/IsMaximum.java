package org.exparity.hamcrest.date.core;

import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ValueRange;
import java.util.function.Supplier;

import org.exparity.hamcrest.date.core.format.DatePartFormatter;
import org.hamcrest.Description;

/**
 * A base matcher that tests that the examined date has the maximum value for the given date part
 *
 * @author Stewart Bissett
 */
public class IsMaximum<T> extends DateMatcher<T> {

    private final ChronoField datePart;
    private final TemporalFieldAdapter<T> adapter;
    private final TemporalFieldRangeAdapter<T> rangeAdapter;
    private final DatePartFormatter formatter;
    private final Supplier<String> descriptionSupplier;
    private final ZoneId zone;

    private IsMaximum(final ChronoField datePart,
                      final TemporalFieldAdapter<T> adapter,
                      final TemporalFieldRangeAdapter<T> rangeAdapter,
                      final DatePartFormatter formatter,
                      final Supplier<String> descriptionSupplier,
                      final ZoneId zone) {
        this.datePart = datePart;
        this.adapter = adapter;
        this.rangeAdapter = rangeAdapter;
        this.formatter = formatter;
        this.descriptionSupplier = descriptionSupplier;
        this.zone = zone;
    }

    public IsMaximum(final ChronoField datePart,
                     final TemporalFieldAdapter<T> adapter,
                     final TemporalFieldRangeAdapter<T> rangeAdapter,
                     final DatePartFormatter formatter,
                     final Supplier<String> descriptionSupplier) {
        this.datePart = datePart;
        this.adapter = adapter;
        this.rangeAdapter = rangeAdapter;
        this.formatter = formatter;
        this.descriptionSupplier = descriptionSupplier;
        this.zone = ZoneId.systemDefault();
    }

    public IsMaximum(final ChronoField datePart,
                     final TemporalFieldAdapter<T> adapter,
                     final TemporalFieldRangeAdapter<T> rangeAdapter,
                     final DatePartFormatter formatter) {
        this(datePart, adapter, rangeAdapter, formatter, () -> "the date is the maximum value for " + formatter.describe(datePart));
    }

    @Override
    protected boolean matchesSafely(final T actual, final Description mismatchDesc) {
        long actualValue = this.adapter.asTemporalField(actual, zone);
        ValueRange range = this.rangeAdapter.asTemporalFieldRange(actual, zone);
        if (range.getMaximum() != actualValue) {
            mismatchDesc.appendText("date is the " + actualValue
                    + " "
                    + this.formatter.describe(this.datePart)
                    + " instead of "
                    + range.getMinimum()
                    + " "
                    + this.formatter.describe(this.datePart));
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void describeTo(final Description description) {
        description.appendText(this.descriptionSupplier.get());
    }

    @Override
   	public DateMatcher<T> atZone(ZoneId zone) {
   		return new IsMaximum<>(
   		    datePart,
          adapter,
          rangeAdapter,
          formatter,
          descriptionSupplier,
          zone
      );
   	}

}