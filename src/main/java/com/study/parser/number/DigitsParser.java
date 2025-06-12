package com.study.parser.number;

import com.study.model.number.Digit;
import com.study.model.number.Digits;
import com.study.parser.Parser;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class DigitsParser implements Parser<Digits> {

    private final DigitParser digitParser = new DigitParser();

    @Override
    public Digits parse(PeekingIterator<Integer> peekingIterator) {
        verifyNotExhaustedYet(peekingIterator);
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
