package com.test.parser.util;

public interface RandomGenerator<T> {

    String generate();

    <S extends T> String generate(Class<S> type);
}
