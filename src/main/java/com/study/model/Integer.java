package com.study.model;


public interface Integer {

    record CaseOne(Digit digit) implements Integer {

    }

    record CaseTwo(OneNine oneNine, Digits digits) implements Integer {

    }

    record CaseThree(int minus, Digit digit) implements Integer {
    }

    record CaseFour(int minus, OneNine oneNine, Digits digits) implements Integer {

    }
}
