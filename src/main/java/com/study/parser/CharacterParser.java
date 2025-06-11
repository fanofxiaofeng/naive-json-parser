package com.study.parser;

import com.study.model.Character;
import com.study.model.Escape;
import com.study.util.StringUtils;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class CharacterParser implements Parser<com.study.model.Character> {

    @Override
    public Character parse(PeekingIterator<Integer> peekingIterator) {
        verifyNotExhaustedYet(peekingIterator);
        int peek = peekingIterator.peek();

        if (peek >= 0x0020 && peek <= 0x10FFFF) {
            if (peek == '\\') {
                dropExpectedCodePoint(peekingIterator, '\\');
                Escape escape = new EscapeParser().parse(peekingIterator);
                return new Character.CaseTwo('\\', escape);
            }

            if (peek == '"') {
                java.lang.String message = "Unexpected codePoint: [\"]";
                throw new IllegalArgumentException(message);
            }

            int next = peekingIterator.next();
            return new Character.CaseOne(next);
        }

        java.lang.String message =
                java.lang.String.format(
                        "Unexpected codePoint: %s (%s)",
                        StringUtils.fromCodePoint(peek),
                        "0x" + Integer.toHexString(peek)
                );
        throw new IllegalArgumentException(message);
    }
}
