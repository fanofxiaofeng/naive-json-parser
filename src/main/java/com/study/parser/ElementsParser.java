package com.study.parser;

import com.study.model.Element;
import com.study.model.Elements;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class ElementsParser implements Parser<Elements> {

    private final ElementParser elementParser = new ElementParser();

    @Override
    public Elements parse(PeekingIterator<Integer> peekingIterator) {
        Element element = elementParser.parse(peekingIterator);
        return parse(element, peekingIterator);
    }

    private Elements parse(Element element, PeekingIterator<Integer> peekingIterator) {
        if (peekingIterator.hasNext() && peekingIterator.peek() == COMMA) {
            dropExpectedCodePoint(peekingIterator, COMMA);
            return new Elements.CaseTwo(element, COMMA, parse(peekingIterator));
        }

        return new Elements.CaseOne(element);
    }
}
