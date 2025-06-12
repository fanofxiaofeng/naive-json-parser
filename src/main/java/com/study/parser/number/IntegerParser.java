package com.study.parser.number;

import com.study.model.number.Digit;
import com.study.model.number.Digits;
import com.study.model.number.OneNine;
import com.study.parser.Parser;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class IntegerParser implements Parser<com.study.model.number.Integer> {

    private final DigitParser digitParser = new DigitParser();
    private final DigitsParser digitsParser = new DigitsParser();

    @Override
    public com.study.model.number.Integer parse(PeekingIterator<Integer> peekingIterator) {
        verifyNotExhaustedYet(peekingIterator);

        int peek = peekingIterator.peek();
        if (!isInitialCodePointValid(peek)) {
            java.lang.String message = java.lang.String.format("Unexpected codePoint: %s", peek);
            throw new IllegalArgumentException(message);
        }

        boolean isNegative = (peek == '-');
        if (isNegative) {
            dropExpectedCodePoint(peekingIterator, '-');
        }

        Digit digit = digitParser.parse(peekingIterator);
        if (!peekingIterator.hasNext() || !Digit.qualified(peekingIterator.peek())) {
            if (isNegative) {
                return new com.study.model.number.Integer.CaseThree('-', digit);
            }
            return new com.study.model.number.Integer.CaseOne(digit);
        }

        Digits digits = digitsParser.parse(peekingIterator);
        if (digit instanceof OneNine oneNine) {
            if (isNegative) {
                return new com.study.model.number.Integer.CaseFour('-', oneNine, digits);
            }
            return new com.study.model.number.Integer.CaseTwo(oneNine, digits);
        }
        throw new IllegalArgumentException("digit is not an instance of OneNine!");
    }

    private boolean isInitialCodePointValid(int codePoint) {
        if (codePoint == '-') {
            return true;
        }

        return (codePoint >= '0' && codePoint <= '9');
    }
}
