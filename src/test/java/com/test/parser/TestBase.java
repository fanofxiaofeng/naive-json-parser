package com.test.parser;

import com.study.model.Json;
import com.study.parser.JsonParser;
import org.apache.commons.collections4.iterators.PeekingIterator;

public abstract class TestBase {
    protected Json parse(String s) {
        PeekingIterator<Integer> peekingIterator = new PeekingIterator<>(s.codePoints().iterator());
        return new JsonParser().parse(peekingIterator);
    }
}
