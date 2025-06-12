package com.study.parser.number;

import com.study.model.number.Sign;
import com.study.parser.Parser;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class SignParser implements Parser<Sign> {

    @Override
    public Sign parse(PeekingIterator<Integer> peekingIterator) {
        if (!peekingIterator.hasNext()) {
            return Sign.ABSENT;
        }

        int peek = peekingIterator.peek();
        if (qualified(peek)) {
            int next = peekingIterator.next();
            return switch (next) {
                case '+' -> Sign.POSITIVE;
                case '-' -> Sign.NEGATIVE;
                default -> throw new IllegalArgumentException();
            };
        }
        return Sign.ABSENT;
    }

    private boolean qualified(int peek) {
        return peek == '+' || peek == '-';
    }
}
