package com.study.model;

import com.study.util.StringUtils;

public sealed interface Escape permits
        Escape.SpecialCase,
        Escape.GeneralCase {
    enum SpecialCase implements Escape {
        QUOTATION_MARK('"'),
        REVERSE_SOLIDUS('\\'),
        SOLIDUS('/'),
        BACKSPACE('b'),
        FORMFEED('f'),
        LINEFEED('n'),
        CARRIAGE_RETURN('r'),
        HORIZONTAL_TAB('t');

        private final int symbol;

        SpecialCase(int symbol) {
            this.symbol = symbol;
        }

        public int getSymbol() {
            return symbol;
        }

        @Override
        public java.lang.String toString() {
            return StringUtils.fromCodePoint(symbol);
        }
    }

    record GeneralCase(int u, Hex hex1, Hex hex2, Hex hex3, Hex hex4) implements Escape {

    }
}
