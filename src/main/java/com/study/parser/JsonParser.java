package com.study.parser;

import com.study.model.Json;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class JsonParser implements Parser<Json> {

    private final ElementParser elementParser = new ElementParser();

    @Override
    public Json parse(PeekingIterator<Integer> peekingIterator) {
        return elementParser.parse(peekingIterator);
    }
}
