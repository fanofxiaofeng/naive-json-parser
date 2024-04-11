package com.study.parser;

import com.study.model.Digit;
import com.study.model.Digits;
import org.apache.commons.collections4.iterators.PeekingIterator;


public class DigitsParser implements Parser<Digits> {

    private final DigitParser digitParser = new DigitParser();

    @Override
    public Digits parse(PeekingIterator<Integer> peekingIterator) {
        if (!peekingIterator.hasNext()) {
            throw new IllegalArgumentException("peekingIterator is exhausted!");
        }

        Digit digit = digitParser.parse(peekingIterator);
        if (peekingIterator.hasNext() && qualified(peekingIterator.peek())) {
            return new Digits.CaseTwo(digit, parse(peekingIterator));
        }
        return new Digits.CaseOne(digit);
    }

    private boolean qualified(int n) {
        return n >= '0' && n <= '9';
    }
}
