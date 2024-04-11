package com.study.parser;

import com.study.model.*;
import org.apache.commons.collections4.iterators.PeekingIterator;

import java.lang.Integer;

public class ArrayParser implements Parser<com.study.model.Array> {
    private final WhitespaceParser whitespaceParser = new WhitespaceParser();

    @Override
    public Array parse(PeekingIterator<Integer> peekingIterator) {
        dropExpectedCodePoint(peekingIterator, '[');
        Whitespace whitespace = whitespaceParser.parse(peekingIterator);
        if (peekingIterator.peek() == ']') {
            dropExpectedCodePoint(peekingIterator, ']');
            return new Array.CaseOne('[', whitespace, ']');
        }
        Value value = new ValueParser().parse(peekingIterator);
        Whitespace ws2 = whitespaceParser.parse(peekingIterator);

        Element element = new Element(whitespace, value, ws2);
        if (peekingIterator.hasNext() && peekingIterator.peek() == ',') {
            dropExpectedCodePoint(peekingIterator, ',');
            ElementsParser elementsParser = new ElementsParser();
            Elements elements = new Elements.CaseTwo(element, ',', elementsParser.parse(peekingIterator));
            return new Array.CaseTwo('[', elements, ']');
        } else {
            return new Array.CaseTwo('[', new Elements.CaseOne(element), ']');
        }
    }
}
