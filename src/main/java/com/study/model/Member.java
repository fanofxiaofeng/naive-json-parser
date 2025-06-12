package com.study.model;

import com.study.model.string.String;

public record Member(
        Whitespace ws1,
        String string,
        Whitespace ws2,
        int colon,
        Element element) {
}
