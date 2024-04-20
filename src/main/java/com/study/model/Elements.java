package com.study.model;

public interface Elements {
    record CaseOne(Element element) implements Elements {

        @ForDebug
        @Override
        public int elementCount() {
            return 1;
        }
    }

    record CaseTwo(Element element, int comma, Elements elements) implements Elements {

        @ForDebug
        @Override
        public int elementCount() {
            return 1 + elements.elementCount();
        }
    }

    @ForDebug
    int elementCount();
}
