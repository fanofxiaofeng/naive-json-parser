package com.study.model;

import com.study.convertor.CharactersConvertor;

public sealed interface Characters permits
        Characters.CaseOne,
        Characters.CaseTwo {

    /**
     * Empty case
     */
    final class CaseOne implements Characters {
        private static final Characters.CaseOne instance = new Characters.CaseOne();

        private CaseOne() {

        }

        public static CaseOne getInstance() {
            return instance;
        }

        @ForDebug
        @Override
        public java.lang.String toString() {
            return "";
        }
    }

    record CaseTwo(Character character, Characters characters) implements Characters {
        @ForDebug
        @Override
        public java.lang.String toString() {
            return new CharactersConvertor().convert(this);
        }
    }
}
