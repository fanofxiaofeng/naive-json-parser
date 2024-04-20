package com.study.model;

public interface Whitespace {

    class EmptyCase implements Whitespace {

        private static final EmptyCase instance = new EmptyCase();

        private EmptyCase() {

        }

        public static EmptyCase getInstance() {
            return instance;
        }

        @ForDebug
        @Override
        public java.lang.String toString() {
            return "";
        }

        @ForDebug
        @Override
        public int size() {
            return 0;
        }
    }

    record NormalCase(int codePoint, Whitespace whitespace) implements Whitespace {

        @ForDebug
        @Override
        public int size() {
            return 1 + whitespace.size();
        }

        /**
         * As there is no need to see the details of {@link Whitespace} instances,
         * return a string that contains only space should be OK.
         *
         * @return a {@link java.lang.String} that contains only space and its length
         * is exactly the same with the return value for {@link NormalCase#size()}
         */
        @ForDebug
        @Override
        public java.lang.String toString() {
            return " ".repeat(size());
        }
    }

    @ForDebug
    int size();
}
