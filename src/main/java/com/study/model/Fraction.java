package com.study.model;

public interface Fraction {

    class EmptyCase implements Fraction {
        private static final EmptyCase instance = new EmptyCase();

        private EmptyCase() {

        }

        public static EmptyCase getInstance() {
            return instance;
        }
    }

    record NormalCase(int dot, Digits digits) implements Fraction {
    }
}
