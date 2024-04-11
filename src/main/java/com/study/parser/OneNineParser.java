package com.study.parser;

import com.study.model.OneNine;
import com.study.model.String;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class OneNineParser implements Parser<OneNine> {
    @Override
    public OneNine parse(PeekingIterator<Integer> peekingIterator) {
        if (!peekingIterator.hasNext()) {
            throw new IllegalArgumentException("peekingIterator has been exhausted!");
        }
        int next = peekingIterator.next();
        for (OneNine oneNine : OneNine.values()) {
            if (oneNine.getNumber() == next) {
                return oneNine;
            }
        }
        throw new IllegalArgumentException(java.lang.String.format("Unexpected next: %s", next));
    }
}
