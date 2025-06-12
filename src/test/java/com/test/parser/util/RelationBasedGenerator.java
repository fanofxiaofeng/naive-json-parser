package com.test.parser.util;

public interface RelationBasedGenerator<T> extends Generator {

    <S extends T> String generate(Class<S> type);
}
