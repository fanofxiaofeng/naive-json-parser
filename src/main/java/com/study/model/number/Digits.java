package com.study.model.number;

public sealed interface Digits permits
        Digits.CaseOne,
        Digits.CaseTwo {

    record CaseOne(Digit digit) implements Digits {
    }

    record CaseTwo(Digit digit, Digits digits) implements Digits {

    }
}
