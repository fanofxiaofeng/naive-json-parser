package com.study.parser;

import com.study.model.Exponent;
import com.study.model.Fraction;
import com.study.model.Number;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class NumberParser implements Parser<Number> {

    private final IntegerParser integerParser = new IntegerParser();
    private final FractionParser fractionParser = new FractionParser();

    private final ExponentParser exponentParser = new ExponentParser();

    @Override
    public Number parse(PeekingIterator<Integer> peekingIterator) {
        com.study.model.Integer integer = integerParser.parse(peekingIterator);
        Fraction fraction = fractionParser.parse(peekingIterator);
        Exponent exponent = exponentParser.parse(peekingIterator);

        return new Number(integer, fraction, exponent);
    }
}
