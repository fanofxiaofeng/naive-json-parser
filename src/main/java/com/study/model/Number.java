package com.study.model;

import com.study.convertor.NumberConvertor;

public record Number(com.study.model.Integer integer, Fraction fraction, Exponent exponent) implements Value {

    @ForDebug
    @Override
    public java.lang.String toString() {
        return new NumberConvertor().convert(this);
    }
}
