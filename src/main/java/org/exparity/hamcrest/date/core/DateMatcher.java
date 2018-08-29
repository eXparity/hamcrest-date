package org.exparity.hamcrest.date.core;

import java.time.ZoneId;

import org.hamcrest.TypeSafeDiagnosingMatcher;

public abstract class DateMatcher<T> extends TypeSafeDiagnosingMatcher<T> {

    public abstract DateMatcher<T> atZone(ZoneId zone);

}
