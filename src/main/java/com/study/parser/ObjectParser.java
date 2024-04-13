package com.study.parser;

import com.study.model.Members;
import com.study.model.Object;
import com.study.model.Whitespace;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class ObjectParser implements Parser<com.study.model.Object> {

    private final WhitespaceParser whitespaceParser = new WhitespaceParser();

    @Override
    public Object parse(PeekingIterator<Integer> peekingIterator) {
        dropExpectedCodePoint(peekingIterator, Object.LEFT_BRACE);
        Whitespace whitespace = whitespaceParser.parse(peekingIterator);
        if (peekingIterator.peek() == Object.RIGHT_BRACE) {
            dropExpectedCodePoint(peekingIterator, Object.RIGHT_BRACE);
            return new Object.CaseOne(Object.LEFT_BRACE, whitespace, Object.RIGHT_BRACE);
        }

        MembersParser membersParser = new MembersParser();
        Members members = membersParser.parse(whitespace, peekingIterator);
        dropExpectedCodePoint(peekingIterator, Object.RIGHT_BRACE);
        return new Object.CaseTwo(Object.LEFT_BRACE, members, Object.RIGHT_BRACE);
    }
}
