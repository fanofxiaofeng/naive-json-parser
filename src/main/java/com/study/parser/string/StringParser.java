package com.study.parser.string;

import com.study.model.string.Characters;
import com.study.model.string.String;
import com.study.parser.Parser;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class StringParser implements Parser<String> {

    private static final int quotationMark = '"';

    @Override
    public String parse(PeekingIterator<Integer> peekingIterator) {
        dropExpectedCodePoint(peekingIterator, quotationMark);
        Characters characters = new CharactersParser().parse(peekingIterator);
        dropExpectedCodePoint(peekingIterator, quotationMark);

        return new String(quotationMark, characters, quotationMark);
    }
}
