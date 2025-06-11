package com.study.convertor;

import com.study.model.Digit;
import com.study.model.Integer;
import com.study.model.OneNine;
import com.study.util.StringUtils;

public class IntegerConvertor implements Convertor<Integer> {

    private final Convertor<Digit> digitConvertor = Digit::toString;
    private final Convertor<OneNine> oneNineConverter = OneNine::toString;

    private final DigitsConvertor digitsConvertor = new DigitsConvertor();

    @Override
    public String convert(com.study.model.Integer integer) {
        if (integer instanceof com.study.model.Integer.CaseOne caseOne) {
            return digitConvertor.convert(caseOne.digit());
        }
        if (integer instanceof com.study.model.Integer.CaseTwo caseTwo) {
            return StringUtils.fromStringArray(
                    oneNineConverter.convert(caseTwo.oneNine()),
                    digitsConvertor.convert(caseTwo.digits())
            );
        }
        if (integer instanceof com.study.model.Integer.CaseThree caseThree) {
            return StringUtils.fromStringArray(
                    "-",
                    digitConvertor.convert(caseThree.digit())
            );
        }
        if (integer instanceof com.study.model.Integer.CaseFour caseFour) {
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
