package com.study.model;

public non-sealed interface Object extends Value {

    int LEFT_BRACE = '{';
    int RIGHT_BRACE = '}';

    record CaseOne(int leftBrace, Whitespace whitespace, int rightBrace) implements Object {

        @Override
        public int keyValuePairCount() {
            return 0;
        }
    }

    record CaseTwo(int leftBrace, Members members, int rightBrace) implements Object {

        @Override
        public int keyValuePairCount() {
            return members().memberCount();
        }
    }

    @ForDebug
    int keyValuePairCount();
}
