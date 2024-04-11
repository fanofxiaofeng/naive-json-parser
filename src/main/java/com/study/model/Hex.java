package com.study.model;

import com.study.util.StringUtils;

public interface Hex {
    record DigitCase(Digit digit) implements Hex {
        @Override
        public java.lang.String toString() {
            return digit.toString();
        }
    }

    enum LetterCase implements Hex {
        UPPERCASE_A('A'),
        UPPERCASE_B('B'),
        UPPERCASE_C('C'),
        UPPERCASE_D('D'),
        UPPERCASE_E('E'),
        UPPERCASE_F('F'),

        LOWERCASE_A('a'),

        LOWERCASE_B('b'),

        LOWERCASE_C('c'),

        LOWERCASE_D('d'),

        LOWERCASE_E('e'),

        LOWERCASE_F('f'),
        ;
        private final int symbol;

        LetterCase(int symbol) {
            this.symbol = symbol;
        }

        public int getSymbol() {
            return symbol;
        }

        @Override
        public java.lang.String toString() {
            return StringUtils.fromInt(symbol);
        }
    }
}
