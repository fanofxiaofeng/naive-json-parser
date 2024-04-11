package com.study.model;

public interface Elements {
    record CaseOne(Element element) implements Elements {

    }

    record CaseTwo(Element element, int comma, Elements elements) implements Elements {

    }
}
