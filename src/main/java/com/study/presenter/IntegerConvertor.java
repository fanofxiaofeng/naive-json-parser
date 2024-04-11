package com.study.presenter;


import com.study.util.StringUtils;

public class IntegerConvertor implements Convertor<com.study.model.Integer> {

    private final DigitConvertor digitConvertor = new DigitConvertor();
    private final OneNineConverter oneNineConverter = new OneNineConverter();
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
        throw new IllegalArgumentException();
    }
}
