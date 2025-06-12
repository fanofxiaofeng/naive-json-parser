package com.study.convertor;

import com.study.model.number.Digit;
import com.study.model.number.Integer;
import com.study.model.number.OneNine;
import com.study.util.StringUtils;

public class IntegerConvertor implements Convertor<Integer> {

    private final Convertor<Digit> digitConvertor = Digit::toString;
    private final Convertor<OneNine> oneNineConverter = OneNine::toString;

    private final DigitsConvertor digitsConvertor = new DigitsConvertor();

    @Override
    public String convert(Integer integer) {
        if (integer instanceof Integer.CaseOne caseOne) {
            return digitConvertor.convert(caseOne.digit());
        }
        if (integer instanceof Integer.CaseTwo caseTwo) {
            return StringUtils.fromStringArray(
                    oneNineConverter.convert(caseTwo.oneNine()),
                    digitsConvertor.convert(caseTwo.digits())
            );
        }
        if (integer instanceof Integer.CaseThree caseThree) {
            return StringUtils.fromStringArray(
                    "-",
                    digitConvertor.convert(caseThree.digit())
            );
        }
        if (integer instanceof Integer.CaseFour caseFour) {
            return StringUtils.fromStringArray(
                    "-",
                    oneNineConverter.convert(caseFour.oneNine()),
                    digitsConvertor.convert(caseFour.digits())
            );
        }
        String message = String.format("Unexpected type: [%s]", integer.getClass().getCanonicalName());
        throw new IllegalArgumentException(message);
    }
}
