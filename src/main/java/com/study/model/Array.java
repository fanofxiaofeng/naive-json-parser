package com.study.model;

public non-sealed interface Array extends Value {
    record CaseOne(int left, Whitespace whitespace, int right) implements Array {

    }

    record CaseTwo(int left, Elements elements, int right) implements Array {

    }
}
