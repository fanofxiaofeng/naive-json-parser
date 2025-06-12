package com.study.parser;

import com.study.model.Element;
import com.study.model.Member;
import com.study.model.Whitespace;
import com.study.model.string.String;
import com.study.parser.string.StringParser;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class MemberParser implements Parser<Member> {

    private final WhitespaceParser whitespaceParser = new WhitespaceParser();
    private final StringParser stringParser = new StringParser();
    private final ElementParser elementParser = new ElementParser();

    @Override
    public Member parse(PeekingIterator<Integer> peekingIterator) {
        Whitespace ws1 = whitespaceParser.parse(peekingIterator);
        return parse(ws1, peekingIterator);
    }

    public Member parse(Whitespace ws1, PeekingIterator<Integer> peekingIterator) {
        String string = stringParser.parse(peekingIterator);
        Whitespace ws2 = whitespaceParser.parse(peekingIterator);
        dropExpectedCodePoint(peekingIterator, ':');
        Element element = elementParser.parse(peekingIterator);
        return new Member(ws1, string, ws2, ':', element);
    }
}
