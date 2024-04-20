package com.study.parser;

import com.study.model.Element;
import com.study.model.Json;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class JsonParser implements Parser<Json> {

    private final ElementParser elementParser = new ElementParser();

    @Override
    public Json parse(PeekingIterator<Integer> peekingIterator) {
        Element element = elementParser.parse(peekingIterator);
        if (peekingIterator.hasNext()) {
            throw new IllegalArgumentException("peekingIterator still have some element");
        }
        return new Json(element);
    }
}
