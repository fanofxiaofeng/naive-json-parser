package com.study.model;

public non-sealed interface Object extends Value {
    record CaseOne(int left, Whitespace whitespace, int right) implements Object {

    }

    record CaseTwo(int left, Members members, int right) implements Object {

    }
}
