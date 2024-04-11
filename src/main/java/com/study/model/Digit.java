package com.study.model;

public sealed interface Digit
        permits Zero, OneNine {

    static boolean qualified(int codePoint) {
        return codePoint >= '0' && codePoint <= '9';
    }
}
