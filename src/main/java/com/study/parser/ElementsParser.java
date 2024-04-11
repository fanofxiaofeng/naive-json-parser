package com.study.parser;

import com.study.model.Element;
import com.study.model.Elements;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class ElementsParser implements Parser<Elements> {

    private final ElementParser elementParser = new ElementParser();

    @Override
    public Elements parse(PeekingIterator<Integer> peekingIterator) {
        Element element = elementParser.parse(peekingIterator);

        if (peekingIterator.hasNext() && peekingIterator.peek() == ',') {
            dropExpectedCodePoint(peekingIterator, ',');
            return new Elements.CaseTwo(element, ',', parse(peekingIterator));
        }

        return new Elements.CaseOne(element);
    }
}
