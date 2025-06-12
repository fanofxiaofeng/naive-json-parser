package com.study.parser.number;

import com.study.model.number.Digits;
import com.study.model.number.Exponent;
import com.study.model.number.Sign;
import com.study.parser.Parser;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class ExponentParser implements Parser<Exponent> {

    private final SignParser signParser = new SignParser();

    private final DigitsParser digitsParser = new DigitsParser();

    @Override
    public Exponent parse(PeekingIterator<Integer> peekingIterator) {
        if (!peekingIterator.hasNext()) {
            return new Exponent.EmptyCase();
        }

        int peek = peekingIterator.peek();
        if (qualified(peek)) {
            int next = peekingIterator.next();
            Sign sign = signParser.parse(peekingIterator);
            Digits digits = digitsParser.parse(peekingIterator);
            return switch (next) {
                case Exponent.UPPERCASE_SYMBOL -> new Exponent.UppercaseECase(sign, digits);
                case Exponent.LOWERCASE_SYMBOL -> new Exponent.LowercaseECase(sign, digits);
                default -> throw new IllegalArgumentException();
            };
        }
        return new Exponent.EmptyCase();
    }

    private boolean qualified(int codePoint) {
        return codePoint == Exponent.UPPERCASE_SYMBOL || codePoint == Exponent.LOWERCASE_SYMBOL;
    }

}
