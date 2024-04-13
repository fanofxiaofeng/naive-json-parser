package com.study.parser;

import org.apache.commons.collections4.iterators.PeekingIterator;

@FunctionalInterface
public interface Parser<T> {

    int COMMA = ',';

    T parse(PeekingIterator<Integer> peekingIterator);

    default void dropExpectedCodePoint(PeekingIterator<Integer> peekingIterator, int expectedCodePoint) {
        int next = peekingIterator.next();
        if (next != expectedCodePoint) {
            java.lang.String message = java.lang.String.format("expectedCodePoint is: %s, but next is: %s", expectedCodePoint, next);
            throw new IllegalArgumentException(message);
        }
    }

    default void verifyNotExhaustedYet(PeekingIterator<Integer> peekingIterator) {
        if (!peekingIterator.hasNext()) {
            throw new IllegalArgumentException("peekingIterator is exhausted!");
        }
    }
}
