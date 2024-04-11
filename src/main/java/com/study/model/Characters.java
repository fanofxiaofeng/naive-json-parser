package com.study.model;

public interface Characters {

    class CaseOne implements Characters {
        private static final Characters.CaseOne instance = new Characters.CaseOne();

        private CaseOne() {

        }

        public static CaseOne getInstance() {
            return instance;
        }
    }

    record CaseTwo(Character character, Characters characters) implements Characters {

    }
}
