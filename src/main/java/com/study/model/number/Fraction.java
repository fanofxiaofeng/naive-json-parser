package com.study.model.number;

public sealed interface Fraction permits
        Fraction.EmptyCase,
        Fraction.NormalCase {

    final class EmptyCase implements Fraction {
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
