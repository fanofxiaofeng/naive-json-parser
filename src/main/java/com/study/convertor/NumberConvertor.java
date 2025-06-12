package com.study.convertor;

import com.study.model.number.Number;
import com.study.util.StringUtils;

public class NumberConvertor implements Convertor<Number> {

    private final IntegerConvertor integerConvertor = new IntegerConvertor();
    private final FractionConvertor fractionConvertor = new FractionConvertor();

    private final ExponentConvertor exponentConvertor = new ExponentConvertor();

    @Override
    public String convert(Number number) {
        return StringUtils.fromStringArray(
                integerConvertor.convert(number.integer()),
                fractionConvertor.convert(number.fraction()),
                exponentConvertor.convert(number.exponent())
        );
    }
}
