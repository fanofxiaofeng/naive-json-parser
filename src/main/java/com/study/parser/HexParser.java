package com.study.parser;

import com.study.model.Digit;
import com.study.model.Hex;
import com.study.model.String;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class HexParser implements Parser<Hex> {
    @Override
    public Hex parse(PeekingIterator<Integer> peekingIterator) {
        verifyNotExhaustedYet(peekingIterator);

        int peek = peekingIterator.peek();
        if (!qualified(peek)) {
            java.lang.String message = java.lang.String.format("Unexpected peek: %s", peek);
            throw new IllegalArgumentException(message);
        }

        if (Digit.qualified(peek)) {
            Digit digit = new DigitParser().parse(peekingIterator);
            return new Hex.DigitCase(digit);
        }

        int next = peekingIterator.next();
        for (Hex.LetterCase e : Hex.LetterCase.values()) {
            if (e.getSymbol() == next) {
                return e;
            }
        }

        throw new IllegalArgumentException();
    }

    private boolean qualified(int codePoint) {
        if (Digit.qualified(codePoint)) {
            return true;
        }

        for (Hex.LetterCase e : Hex.LetterCase.values()) {
            if (e.getSymbol() == codePoint) {
                return true;
            }
        }
        return false;
    }

}
