package com.study.builder;

import java.util.List;

@FunctionalInterface
public interface Builder<T> {
    T build(List<Integer> raw);
}
