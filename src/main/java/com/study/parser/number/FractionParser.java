package com.study.parser.number;

import com.study.model.number.Digits;
import com.study.model.number.Fraction;
import com.study.parser.Parser;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class FractionParser implements Parser<Fraction> {

    private final DigitsParser digitsParser = new DigitsParser();

    @Override
    public Fraction parse(PeekingIterator<Integer> peekingIterator) {
        if (!peekingIterator.hasNext()) {
            return Fraction.EmptyCase.getInstance();
        }

        int peek = peekingIterator.peek();
        if (qualified(peek)) {
            dropExpectedCodePoint(peekingIterator, '.');
            Digits digits = digitsParser.parse(peekingIterator);
            return new Fraction.NormalCase('.', digits);
        }

        return Fraction.EmptyCase.getInstance();
    }

    private boolean qualified(int codePoint) {
        return codePoint == '.';
    }
}
