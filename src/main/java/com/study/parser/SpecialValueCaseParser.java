package com.study.parser;

import com.study.model.Value;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class SpecialValueCaseParser implements Parser<Value> {
    protected final String name;
    protected final Value valueInstance;

    protected SpecialValueCaseParser(String name, Value valueInstance) {
        this.name = name;
        this.valueInstance = valueInstance;
    }

    @Override
    public Value parse(PeekingIterator<Integer> peekingIterator) {
        for (char c : name.toCharArray()) {
            dropExpectedCodePoint(peekingIterator, c);
        }

        return valueInstance;
    }
}
