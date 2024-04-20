package com.study.parser;

import com.study.util.StringUtils;
import org.apache.commons.collections4.iterators.PeekingIterator;

@FunctionalInterface
public interface Parser<T> {

    int COMMA = ',';

    T parse(PeekingIterator<Integer> peekingIterator);

    default void dropExpectedCodePoint(PeekingIterator<Integer> peekingIterator, int expectedCodePoint) {
        if (!peekingIterator.hasNext()) {
            java.lang.String message =
                    java.lang.String.format("expectedCodePoint is: [%s](cp=%s), but peekingIterator is already exhausted",
                            StringUtils.fromCodePoint(expectedCodePoint),
                            expectedCodePoint
                    );
            throw new IllegalArgumentException(message);
        }
        int next = peekingIterator.next();
        if (next != expectedCodePoint) {
            java.lang.String message =
                    java.lang.String.format("expectedCodePoint is: [%s](cp=%s), but next is: [%s](cp=%s)",
                            StringUtils.fromCodePoint(expectedCodePoint),
                            expectedCodePoint,
                            StringUtils.fromCodePoint(next),
                            next
                    );
            throw new IllegalArgumentException(message);
        }
    }

    default void verifyNotExhaustedYet(PeekingIterator<Integer> peekingIterator) {
        if (!peekingIterator.hasNext()) {
            throw new IllegalArgumentException("peekingIterator is exhausted!");
        }
    }
}
