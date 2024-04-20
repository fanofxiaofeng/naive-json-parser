package com.study.parser;

import com.study.model.Whitespace;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class WhitespaceParser implements Parser<Whitespace> {
    @Override
    public Whitespace parse(PeekingIterator<Integer> peekingIterator) {
        if (!peekingIterator.hasNext()) {
            return Whitespace.EmptyCase.getInstance();
        }
        int peek = peekingIterator.peek();
        if (!qualified(peek)) {
            return Whitespace.EmptyCase.getInstance();
        }

        return new Whitespace.NormalCase(peekingIterator.next(), parse(peekingIterator));
    }

    private boolean qualified(int e) {
        return switch (e) {
            case 0x0020, 0x000A, 0x000D, 0x0009 -> true;
            default -> false;
        };
    }
}
