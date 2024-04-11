package com.study.parser;

import com.study.model.Members;
import com.study.model.Object;
import com.study.model.Whitespace;
import org.apache.commons.collections4.iterators.PeekingIterator;


public class ObjectParser implements Parser<com.study.model.Object> {

    private final WhitespaceParser whitespaceParser = new WhitespaceParser();

    @Override
    public Object parse(PeekingIterator<Integer> peekingIterator) {
        dropExpectedCodePoint(peekingIterator, '{');
        Whitespace whitespace = whitespaceParser.parse(peekingIterator);
        if (peekingIterator.peek() == '}') {
            dropExpectedCodePoint(peekingIterator, '}');
            return new Object.CaseOne('{', whitespace, '}');
        }

        MembersParser membersParser = new MembersParser();
        Members members = membersParser.parse(whitespace, peekingIterator);
        return new Object.CaseTwo('{', members, '}');
    }
}
