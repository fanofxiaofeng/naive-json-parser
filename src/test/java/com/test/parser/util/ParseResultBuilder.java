package com.test.parser.util;

import com.study.parser.Parser;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class ParseResultBuilder<T> {

    public T buildParseResult(Parser<T> parser, String generatedResult) {
        var peekingIterator = new PeekingIterator<>(generatedResult.codePoints().iterator());
        return parser.parse(peekingIterator);
    }
}
