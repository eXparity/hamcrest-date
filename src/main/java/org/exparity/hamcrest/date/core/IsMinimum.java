package org.exparity.hamcrest.date.core;

import java.util.function.Supplier;

import org.hamcrest.Description;

/**
 * A base matcher that tests that the examined date has the maximum value for the given date part
 *
 * @author Stewart Bissett
 */
public class IsMinimum<T, U, Z> extends ZonedTemporalMatcher<T, Z> {

    private final U datePart;
    private final TemporalFieldAdapter<T, Z> adapter;
    private final TemporalFieldRangeAdapter<T, Z> rangeAdapter;
    private final TemporalUnitFormatter<U> formatter;
    private final Supplier<String> descriptionSupplier;
    private final Z zone;

    public IsMinimum(final U datePart,
                      final TemporalFieldAdapter<T, Z> adapter,
                      final TemporalFieldRangeAdapter<T, Z> rangeAdapter,
                      final TemporalUnitFormatter<U> formatter,
                      final Supplier<String> descriptionSupplier,
                      final Z zone) {
        this.datePart = datePart;
        this.adapter = adapter;
        this.rangeAdapter = rangeAdapter;
        this.formatter = formatter;
        this.descriptionSupplier = descriptionSupplier;
        this.zone = zone;
    }

    public IsMinimum(final U datePart,
                     final TemporalFieldAdapter<T, Z> adapter,
                     final TemporalFieldRangeAdapter<T, Z> minimumAdapter,
                     final TemporalUnitFormatter<U> formatter,
                     final Z zone) {
        this(datePart, adapter, minimumAdapter, formatter, () -> "the date is the minimum value for " + formatter.describe(datePart), zone);
    }

    @Override
    protected boolean matchesSafely(final T actual, final Description mismatchDesc) {
        long actualValue = this.adapter.asTemporalField(actual, zone);
        long minimumValue = this.rangeAdapter.getExtremum(actual, zone);
        if (minimumValue != actualValue) {
            mismatchDesc.appendText("date is the " + actualValue
                    + " "
                    + this.formatter.describe(this.datePart)
                    + " instead of "
                    + minimumValue
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
   	public ZonedTemporalMatcher<T, Z> atZone(Z zone) {
   		return new IsMinimum<>(
          datePart,
          adapter,
          rangeAdapter,
          formatter,
          descriptionSupplier,
          zone);
   	}

}