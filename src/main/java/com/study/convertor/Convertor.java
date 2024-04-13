package com.study.convertor;

@FunctionalInterface
public interface Convertor<T> {

    String convert(T t);
}
