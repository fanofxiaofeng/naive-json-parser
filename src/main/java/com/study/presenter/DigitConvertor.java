package com.study.presenter;

import com.study.model.OneNine;
import com.study.model.Zero;
import com.study.model.Digit;

public class DigitConvertor implements Convertor<Digit> {

    private final OneNineConverter oneNineConverter = new OneNineConverter();

    @Override
    public String convert(Digit digit) {
        if (digit instanceof Zero) {
            return "0";
        }
        if (digit instanceof OneNine oneNine) {
            return oneNineConverter.convert(oneNine);
        }
        throw new IllegalArgumentException();
    }
}
