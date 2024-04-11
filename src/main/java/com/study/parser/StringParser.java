package com.study.parser;

import com.study.model.Characters;
import com.study.model.String;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class StringParser implements Parser<com.study.model.String> {
    @Override
    public String parse(PeekingIterator<Integer> peekingIterator) {
        dropExpectedCodePoint(peekingIterator, '"');
        CharactersParser charactersParser = new CharactersParser();
        Characters characters = charactersParser.parse(peekingIterator);
        dropExpectedCodePoint(peekingIterator, '"');

        return new com.study.model.String('"', characters, '"');
    }
}
