package com.study.parser;

import com.study.model.Characters;
import com.study.model.String;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class StringParser implements Parser<com.study.model.String> {

    private static final int quotationMark = '"';

    @Override
    public String parse(PeekingIterator<Integer> peekingIterator) {
        dropExpectedCodePoint(peekingIterator, quotationMark);
        Characters characters = new CharactersParser().parse(peekingIterator);
        dropExpectedCodePoint(peekingIterator, quotationMark);

        return new com.study.model.String(quotationMark, characters, quotationMark);
    }
}
