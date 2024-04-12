package com.study.model;

public non-sealed interface Array extends Value {
    record CaseOne(int leftBracket, Whitespace whitespace, int rightBracket) implements Array {

    }

    record CaseTwo(int leftBracket, Elements elements, int rightBracket) implements Array {

    }
}
