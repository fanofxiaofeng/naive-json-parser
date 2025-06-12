package com.study.convertor;

import com.study.model.number.Exponent;
import com.study.util.StringUtils;

public class ExponentConvertor implements Convertor<Exponent> {
    private final SignConvertor signConvertor = new SignConvertor();
    private final DigitsConvertor digitsConvertor = new DigitsConvertor();

    @Override
    public String convert(Exponent exponent) {
        if (exponent instanceof Exponent.EmptyCase) {
            return "";
        }
        if (exponent instanceof Exponent.UppercaseECase uppercaseECase) {
            return StringUtils.fromStringArray(
                    "E",
                    signConvertor.convert(uppercaseECase.sign()),
                    digitsConvertor.convert(uppercaseECase.digits())
            );
        }
        if (exponent instanceof Exponent.LowercaseECase lowercaseECase) {
            return StringUtils.fromStringArray(
                    "e",
                    signConvertor.convert(lowercaseECase.sign()),
                    digitsConvertor.convert(lowercaseECase.digits())
            );
        }
        throw new IllegalArgumentException();
    }
}
