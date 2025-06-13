package com.test.parser.util;

import org.junit.Assert;

public class TestHelper<T> {

    private void fail(Class<? extends T> type) {
        Assert.fail("The parseResult is not an instance of " + type.getSimpleName());
    }

    public <S extends T> S castTo(T parseResult, Class<S> type) {
        if (!type.isAssignableFrom(parseResult.getClass())) {
            fail(type);
        }
        @SuppressWarnings("unchecked")
        S s = (S) parseResult;
        return s;
    }
}
