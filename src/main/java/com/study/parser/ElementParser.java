package com.study.parser;

import com.study.model.Element;
import com.study.model.Value;
import com.study.model.Whitespace;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class ElementParser implements Parser<Element> {

    private final WhitespaceParser whitespaceParser = new WhitespaceParser();
    private final ValueParser valueParser = new ValueParser();

    @Override
    public Element parse(PeekingIterator<Integer> peekingIterator) {
        Whitespace ws1 = whitespaceParser.parse(peekingIterator);
        Value value = valueParser.parse(peekingIterator);
        Whitespace ws2 = whitespaceParser.parse(peekingIterator);

        return new Element(ws1, value, ws2);
    }
}
