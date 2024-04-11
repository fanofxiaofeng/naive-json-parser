package com.study.presenter;

import com.study.model.Number;
import com.study.util.StringUtils;

public class NumberConvertor implements Convertor<com.study.model.Number> {

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
