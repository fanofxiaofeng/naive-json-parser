package com.study.convertor;

import com.study.model.Fraction;
import com.study.util.StringUtils;

public class FractionConvertor implements Convertor<Fraction> {
    private final DigitsConvertor digitsConvertor = new DigitsConvertor();

    @Override
    public String convert(Fraction fraction) {
        if (fraction instanceof Fraction.EmptyCase) {
            return "";
        }
        if (fraction instanceof Fraction.NormalCase normalCase) {
            return StringUtils.fromStringArray(
                    ".",
                    digitsConvertor.convert(normalCase.digits())
            );
        }
        throw new IllegalArgumentException();
    }
}
