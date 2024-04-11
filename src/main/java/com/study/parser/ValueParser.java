package com.study.parser;

import com.study.model.Value;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class ValueParser implements Parser<Value> {
    @Override
    public Value parse(PeekingIterator<Integer> peekingIterator) {
        int peek = peekingIterator.peek();

        return switch (peek) {
            case '{' -> new ObjectParser().parse(peekingIterator);
            case '[' -> new ArrayParser().parse(peekingIterator);
            case '"' -> new StringParser().parse(peekingIterator);
            case 't' -> new CaseTrueParser().parse(peekingIterator);
            case 'f' -> new CaseFalseParser().parse(peekingIterator);
            case 'n' -> new CaseNullParser().parse(peekingIterator);
            default -> new NumberParser().parse(peekingIterator);
        };

    }
}
