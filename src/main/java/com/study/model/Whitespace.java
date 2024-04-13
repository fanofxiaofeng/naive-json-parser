package com.study.model;

import java.util.List;

public record Whitespace(List<java.lang.Integer> raw) {
    @ForDebug
    int size() {
        return raw.size();
    }
}
