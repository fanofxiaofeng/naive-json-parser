package com.study.model.number;

public sealed interface Integer permits
        Integer.CaseOne,
        Integer.CaseTwo,
        Integer.CaseThree,
        Integer.CaseFour {

    record CaseOne(Digit digit) implements Integer {

    }

    record CaseTwo(OneNine oneNine, Digits digits) implements Integer {

    }

    record CaseThree(int minus, Digit digit) implements Integer {
    }

    record CaseFour(int minus, OneNine oneNine, Digits digits) implements Integer {

    }
}
