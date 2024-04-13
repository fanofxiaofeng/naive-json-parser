package com.study.parser;

import com.study.model.Member;
import com.study.model.Members;
import com.study.model.Whitespace;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class MembersParser implements Parser<Members> {

    private final MemberParser memberParser = new MemberParser();

    @Override
    public Members parse(PeekingIterator<Integer> peekingIterator) {
        Member member = memberParser.parse(peekingIterator);
        if (peekingIterator.hasNext() && peekingIterator.peek() == COMMA) {
            dropExpectedCodePoint(peekingIterator, COMMA);
            return new Members.CaseTwo(member, COMMA, parse(peekingIterator));
        }
        return new Members.CaseOne(member);
    }

    public Members parse(Whitespace whitespace, PeekingIterator<Integer> peekingIterator) {
        Member member = memberParser.parse(whitespace, peekingIterator);
        if (peekingIterator.hasNext() && peekingIterator.peek() == COMMA) {
            dropExpectedCodePoint(peekingIterator, COMMA);
            return new Members.CaseTwo(member, COMMA, parse(peekingIterator));
        }
        return new Members.CaseOne(member);
    }
}
