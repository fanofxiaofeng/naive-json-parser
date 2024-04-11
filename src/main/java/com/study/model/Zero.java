package com.study.model;

public final class Zero implements Digit {

    private Zero() {

    }

    private static final Zero instance = new Zero();

    public static Zero getInstance() {
        return instance;
    }

    @Override
    public java.lang.String toString() {
        return "0";
    }
}
