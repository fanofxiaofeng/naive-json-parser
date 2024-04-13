package com.study.parser;

import com.study.model.Array;
import com.study.model.Object;
import com.study.model.Value;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class ValueParser implements Parser<Value> {
    @Override
    public Value parse(PeekingIterator<Integer> peekingIterator) {
        int peek = peekingIterator.peek();

        Parser<? extends Value> parser = switch (peek) {
            case Object.LEFT_BRACE -> new ObjectParser();
            case Array.LEFT_BRACKET -> new ArrayParser();
            case '"' -> new StringParser();
            case 't' -> new CaseTrueParser();
            case 'f' -> new CaseFalseParser();
            case 'n' -> new CaseNullParser();
            case '-', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> new NumberParser();
            default -> throw new IllegalArgumentException();
        };

        return parser.parse(peekingIterator);
    }
}
