package com.study.parser;

import com.study.model.*;
import org.apache.commons.collections4.iterators.PeekingIterator;

import java.lang.Integer;

public class ArrayParser implements Parser<com.study.model.Array> {
    private final WhitespaceParser whitespaceParser = new WhitespaceParser();

    @Override
    public Array parse(PeekingIterator<Integer> peekingIterator) {
        dropExpectedCodePoint(peekingIterator, com.study.model.Array.LEFT_BRACKET);
        Whitespace whitespace = whitespaceParser.parse(peekingIterator);
        if (peekingIterator.peek() == Array.RIGHT_BRACKET) {
            dropExpectedCodePoint(peekingIterator, Array.RIGHT_BRACKET);
            return new Array.CaseOne(Array.LEFT_BRACKET, whitespace, Array.RIGHT_BRACKET);
        }

        Value value = new ValueParser().parse(peekingIterator);
        Whitespace ws2 = whitespaceParser.parse(peekingIterator);
        Element element = new Element(whitespace, value, ws2);

        ElementsParser elementsParser = new ElementsParser();
        Elements elements = elementsParser.parse(element, peekingIterator);

        dropExpectedCodePoint(peekingIterator, Array.RIGHT_BRACKET);
        return new Array.CaseTwo(Array.LEFT_BRACKET, elements, Array.RIGHT_BRACKET);
    }
}
