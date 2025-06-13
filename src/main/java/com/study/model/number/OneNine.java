package com.study.model.number;

import com.study.util.StringUtils;

/**
 * Format: <code>'1' . '9'</code>
 */
public enum OneNine implements Digit {
    ONE('1'),
    TWO('2'),
    THREE('3'),
    FOUR('4'),
    FIVE('5'),
    SIX('6'),
    SEVEN('7'),
    EIGHT('8'),
    NINE('9');

    private final int number;

    OneNine(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public java.lang.String toString() {
        return StringUtils.fromCodePoint(number);
    }
}
