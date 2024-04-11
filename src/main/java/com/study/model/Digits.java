package com.study.model;


public interface Digits {

    record CaseOne(Digit digit) implements Digits {

    }

    record CaseTwo(Digit digit, Digits digits) implements Digits {

    }
}
