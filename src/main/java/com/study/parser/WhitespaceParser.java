package com.study.parser;

import com.study.builder.WhitespaceBuilder;
import com.study.model.Whitespace;
import org.apache.commons.collections4.iterators.PeekingIterator;

import java.util.ArrayList;
import java.util.List;

public class WhitespaceParser implements Parser<Whitespace> {
    @Override
    public Whitespace parse(PeekingIterator<Integer> peekingIterator) {
        List<Integer> result = new ArrayList<>();

        while (peekingIterator.hasNext()) {
            int peek = peekingIterator.peek();
            if (qualified(peek)) {
                int next = peekingIterator.next();
                result.add(next);
                continue;
            }
            break;
        }

        return new WhitespaceBuilder().build(result);
    }

    private boolean qualified(int e) {
        return switch (e) {
            case 0x0020, 0x000A, 0x000D, 0x0009 -> true;
            default -> false;
        };
    }
}
