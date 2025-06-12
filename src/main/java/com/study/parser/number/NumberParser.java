package com.study.parser.number;

import com.study.model.number.Exponent;
import com.study.model.number.Fraction;
import com.study.model.number.Number;
import com.study.parser.Parser;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class NumberParser implements Parser<Number> {

    private final IntegerParser integerParser = new IntegerParser();
    private final FractionParser fractionParser = new FractionParser();

    private final ExponentParser exponentParser = new ExponentParser();

    @Override
    public Number parse(PeekingIterator<Integer> peekingIterator) {
        com.study.model.number.Integer integer = integerParser.parse(peekingIterator);
        Fraction fraction = fractionParser.parse(peekingIterator);
        Exponent exponent = exponentParser.parse(peekingIterator);

        return new Number(integer, fraction, exponent);
    }
}
