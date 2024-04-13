package com.study.convertor;

import com.study.model.Digit;
import com.study.model.Digits;
import com.study.util.StringUtils;

public class DigitsConvertor implements Convertor<Digits> {

    private final Convertor<Digit> digitConvertor = Digit::toString;

    @Override
    public String convert(Digits digits) {
        if (digits instanceof Digits.CaseOne caseOne) {
            return digitConvertor.convert(caseOne.digit());
        }
        if (digits instanceof Digits.CaseTwo caseTwo) {
            return StringUtils.fromStringArray(
                    digitConvertor.convert(caseTwo.digit()),
                    convert(caseTwo.digits())
            );
        }
        throw new IllegalArgumentException();
    }
}
