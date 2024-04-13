package com.study.parser;

import com.study.model.Digit;
import com.study.model.Digits;
import com.study.model.OneNine;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class IntegerParser implements Parser<com.study.model.Integer> {

    private final DigitParser digitParser = new DigitParser();
    private final DigitsParser digitsParser = new DigitsParser();

    @Override
    public com.study.model.Integer parse(PeekingIterator<Integer> peekingIterator) {
        verifyNotExhaustedYet(peekingIterator);

        int peek = peekingIterator.peek();
        if (!qualified(peek)) {
            java.lang.String message = java.lang.String.format("Unexpected codePoint: %s", peek);
            throw new IllegalArgumentException(message);
        }

        boolean isNegative = peek == '-';
        if (isNegative) {
            dropExpectedCodePoint(peekingIterator, '-');
        }

        Digit digit = digitParser.parse(peekingIterator);
        if (!peekingIterator.hasNext() || !Digit.qualified(peekingIterator.peek())) {
            if (isNegative) {
                return new com.study.model.Integer.CaseThree('-', digit);
            }
            return new com.study.model.Integer.CaseOne(digit);
        }

        Digits digits = digitsParser.parse(peekingIterator);
        if (digit instanceof OneNine oneNine) {
            if (isNegative) {
                return new com.study.model.Integer.CaseFour('-', oneNine, digits);
            }
            return new com.study.model.Integer.CaseTwo(oneNine, digits);
        }
        throw new IllegalArgumentException("digit is not an instance of OneNine!");
    }

    private boolean qualified(int codePoint) {
        if (codePoint == '-') {
            return true;
        }

        return (codePoint >= '0' && codePoint <= '9');
    }
}
