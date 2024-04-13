package com.study.model;

public non-sealed interface Array extends Value {

    int LEFT_BRACKET = '[';
    int RIGHT_BRACKET = ']';

    record CaseOne(int leftBracket, Whitespace whitespace, int rightBracket) implements Array {

        @Override
        public int elementCount() {
            return 0;
        }
    }

    record CaseTwo(int leftBracket, Elements elements, int rightBracket) implements Array {

        @Override
        public int elementCount() {
            return elements.elementCount();
        }
    }

    @ForDebug
    int elementCount();
}
