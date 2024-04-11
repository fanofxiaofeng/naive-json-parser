package com.study.presenter;

@FunctionalInterface
public interface Convertor<T> {

    String convert(T t);
}
