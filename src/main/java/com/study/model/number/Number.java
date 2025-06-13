package com.study.model.number;

import com.study.convertor.NumberConvertor;
import com.study.model.ForDebug;
import com.study.model.Value;

/**
 * Format: <code>integer fraction exponent</code>
 *
 * @param integer  the integer
 * @param fraction the fraction
 * @param exponent the exponent
 */
public record Number(Integer integer, Fraction fraction, Exponent exponent) implements Value {

    @ForDebug
    @Override
    public java.lang.String toString() {
        return new NumberConvertor().convert(this);
    }
}
