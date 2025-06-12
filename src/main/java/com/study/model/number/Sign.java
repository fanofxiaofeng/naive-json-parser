package com.study.model.number;

import java.lang.String;

public enum Sign {
    ABSENT(""),
    NEGATIVE("-"),
    POSITIVE("+");

    private final java.lang.String content;

    Sign(java.lang.String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
