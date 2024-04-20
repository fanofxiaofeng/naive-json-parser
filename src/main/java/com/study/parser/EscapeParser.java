package com.study.parser;

import com.study.model.Escape;
import com.study.model.Hex;
import com.study.util.StringUtils;
import org.apache.commons.collections4.iterators.PeekingIterator;

import java.util.stream.IntStream;

public class EscapeParser implements Parser<Escape> {
    @Override
    public Escape parse(PeekingIterator<Integer> peekingIterator) {
        dropExpectedCodePoint(peekingIterator, '\\');

        verifyNotExhaustedYet(peekingIterator);
        int peek = peekingIterator.peek();
        if (peek == 'u') {
            dropExpectedCodePoint(peekingIterator, 'u');
            HexParser hexParser = new HexParser();
            Hex[] hexElements = new Hex[4];
            IntStream.range(0, 4).forEach((int i) -> hexElements[i] = hexParser.parse(peekingIterator));
            return new Escape.GeneralCase('u', hexElements[0], hexElements[1], hexElements[2], hexElements[3]);
        }

        for (Escape.SpecialCase specialCase : Escape.SpecialCase.values()) {
            if (specialCase.getSymbol() == peek) {
                dropExpectedCodePoint(peekingIterator, specialCase.getSymbol());
                return specialCase;
            }
        }

        java.lang.String message = java.lang.String.format("Unexpected codePoint: %s", StringUtils.fromCodePoint(peek));
        throw new IllegalArgumentException(message);
    }
}
