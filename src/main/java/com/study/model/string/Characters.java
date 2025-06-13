package com.study.model.string;

import com.study.convertor.CharactersConvertor;
import com.study.model.ForDebug;

/**
 * Format:
 * <ul>
 *     <li><code>""</code></li>
 *     <li><code>character characters</code></li>
 * </ul>
 */
public sealed interface Characters permits
        Characters.CaseOne,
        Characters.CaseTwo {

    /**
     * Format: <code>""</code>
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

    /**
     * Format: <code>character characters</code>
     *
     * @param character  the character
     * @param characters the characters
     */
    record CaseTwo(Character character, Characters characters) implements Characters {
        @ForDebug
        @Override
        public java.lang.String toString() {
            return new CharactersConvertor().convert(this);
        }
    }
}
