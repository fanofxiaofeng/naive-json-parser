package com.study.model;

public record Member(Whitespace ws1,
                     com.study.model.String string,
                     Whitespace ws2,
                     int colon,
                     Element element) {
}
