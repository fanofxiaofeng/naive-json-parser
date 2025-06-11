package com.study.model;

public sealed interface Character permits
        Character.CaseOne,
        Character.CaseTwo {

    record CaseOne(int codePoint) implements Character {

    }

    record CaseTwo(int reverseSolidus, Escape escape) implements Character {

    }
}
