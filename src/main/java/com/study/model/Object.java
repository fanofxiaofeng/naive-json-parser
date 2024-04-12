package com.study.model;

public non-sealed interface Object extends Value {
    record CaseOne(int leftBrace, Whitespace whitespace, int rightBrace) implements Object {

    }

    record CaseTwo(int leftBrace, Members members, int rightBrace) implements Object {

    }
}
