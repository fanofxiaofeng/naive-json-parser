package com.study.parser.number;

import com.study.model.number.OneNine;
import com.study.parser.Parser;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class OneNineParser implements Parser<OneNine> {
    @Override
    public OneNine parse(PeekingIterator<Integer> peekingIterator) {
        verifyNotExhaustedYet(peekingIterator);
        int next = peekingIterator.next();
        for (OneNine oneNine : OneNine.values()) {
            if (oneNine.getNumber() == next) {
                return oneNine;
            }
        }
        throw new IllegalArgumentException(java.lang.String.format("Unexpected next: %s", next));
    }
}
