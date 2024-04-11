package com.study.parser;

import com.study.model.Character;
import com.study.model.String;
import com.study.util.StringUtils;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class CharacterParser implements Parser<com.study.model.Character> {
    @Override
    public Character parse(PeekingIterator<Integer> peekingIterator) {
        verifyNotExhaustedYet(peekingIterator);
        int peek = peekingIterator.peek();

        if (peek == '\\') {
            dropExpectedCodePoint(peekingIterator, '\\');
            EscapeParser escapeParser = new EscapeParser();
            return new Character.CaseTwo('\\', escapeParser.parse(peekingIterator));
        }

        if (peek == '"') {
            java.lang.String message = "Unexpected codePoint: [\"]";
            throw new IllegalArgumentException(message);
        }

        if (peek >= 0x0020 && peek <= 0x10FFF) {
            int next = peekingIterator.next();
            return new Character.CaseOne(next);
        }

        java.lang.String message = java.lang.String.format("Unexpected codePoint: %s", StringUtils.fromInt(peek));
        throw new IllegalArgumentException(message);
    }
}
