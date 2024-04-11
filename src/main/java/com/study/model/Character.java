package com.study.model;

public interface Character {

    record CaseOne(int codePoint) implements Character {

    }

    record CaseTwo(int reverseSolidus, Escape escape) implements Character {

    }
}
