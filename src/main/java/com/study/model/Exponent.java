package com.study.model;

public interface Exponent {

    int UPPERCASE_SYMBOL = 'E';
    int LOWERCASE_SYMBOL = 'e';

    class EmptyCase implements Exponent {
    }

    record UppercaseECase(Sign sign, Digits digits) implements Exponent {
    }

    record LowercaseECase(Sign sign, Digits digits) implements Exponent {
    }
}
