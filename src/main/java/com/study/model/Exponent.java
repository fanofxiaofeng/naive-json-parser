package com.study.model;

public sealed interface Exponent permits
        Exponent.EmptyCase,
        Exponent.UppercaseECase,
        Exponent.LowercaseECase {

    int UPPERCASE_SYMBOL = 'E';
    int LOWERCASE_SYMBOL = 'e';

    final class EmptyCase implements Exponent {
    }

    record UppercaseECase(Sign sign, Digits digits) implements Exponent {
    }

    record LowercaseECase(Sign sign, Digits digits) implements Exponent {
    }
}
