package com.study.model.string;

public sealed interface Character permits
        Character.CaseOne,
        Character.CaseTwo {


    /**
     * Format: <code>'0020' . '10FFFF' - '"' - '\'</code> (the code point should be in the specified range)
     */
    record CaseOne(int codePoint) implements Character {

    }

    /**
     * Format: <code>'\' escape</code>
     *
     * @param reverseSolidus always a '\'
     * @param escape         the escape
     */
    record CaseTwo(int reverseSolidus, Escape escape) implements Character {

    }
}
