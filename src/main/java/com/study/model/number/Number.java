package com.study.model.number;

import com.study.convertor.NumberConvertor;
import com.study.model.ForDebug;
import com.study.model.Value;

public record Number(Integer integer, Fraction fraction, Exponent exponent) implements Value {

    @ForDebug
    @Override
    public java.lang.String toString() {
        return new NumberConvertor().convert(this);
    }
}
