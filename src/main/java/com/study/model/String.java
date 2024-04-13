package com.study.model;


import com.study.convertor.StringConvertor;

public record String(int quotationMark1, Characters characters, int quotationMark2) implements Value {

    @ForDebug
    @Override
    public java.lang.String toString() {
        return new StringConvertor().convert(this);
    }
}
