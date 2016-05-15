package org.exparity.hamcrest.date.core;

import java.time.temporal.ChronoField;
import java.time.temporal.ValueRange;
import java.util.function.Supplier;

import org.exparity.hamcrest.date.core.format.DatePartFormatter;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

/**
 * A base matcher that tests that the examined date has the maximum value for the given date part
 *
 * @author Stewart Bissett
 */
public class IsMaximum<T> extends TypeSafeDiagnosingMatcher<T> {

    private final ChronoField datePart;
    private final TemporalAdapter<T> adapter;
    private final DatePartFormatter formatter;
    private final Supplier<String> descriptionSupplier;

    public IsMaximum(final ChronoField datePart,
            final TemporalAdapter<T> adapter,
            final DatePartFormatter formatter,
            final Supplier<String> descriptionSupplier) {
        this.datePart = datePart;
        this.adapter = adapter;
        this.formatter = formatter;
        this.descriptionSupplier = descriptionSupplier;
    }

    public IsMaximum(final ChronoField datePart, final TemporalAdapter<T> adapter, final DatePartFormatter formatter) {
        this(datePart, adapter, formatter, () -> "the date is the maximum value for " + formatter.describe(datePart));
    }

    @Override
    protected boolean matchesSafely(final T actual, final Description mismatchDesc) {
        long actualValue = this.datePart.getFrom(this.adapter.asTemporal(actual));
        ValueRange range = this.datePart.rangeRefinedBy(this.adapter.asTemporal(actual));
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
}