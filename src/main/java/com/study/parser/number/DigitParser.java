package com.study.parser.number;

import com.study.model.number.Digit;
import com.study.model.number.Zero;
import com.study.parser.Parser;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class DigitParser implements Parser<Digit> {
    private static final int CODE_POINT_FOR_ZERO = '0';

    @Override
    public Digit parse(PeekingIterator<Integer> peekingIterator) {
        verifyNotExhaustedYet(peekingIterator);
        int peek = peekingIterator.peek();
        if (peek == CODE_POINT_FOR_ZERO) {
            dropExpectedCodePoint(peekingIterator, CODE_POINT_FOR_ZERO);
            return Zero.getInstance();
        }

        return new OneNineParser().parse(peekingIterator);
    }
}
