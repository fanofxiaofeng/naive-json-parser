package com.study.parser;

import com.study.model.Digit;
import com.study.model.Zero;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class DigitParser implements Parser<Digit> {
    @Override
    public Digit parse(PeekingIterator<Integer> peekingIterator) {
        verifyNotExhaustedYet(peekingIterator);
        int peek = peekingIterator.peek();
        if (peek == '0') {
            dropExpectedCodePoint(peekingIterator, '0');
            return Zero.getInstance();
        }

        return new OneNineParser().parse(peekingIterator);
    }
}
