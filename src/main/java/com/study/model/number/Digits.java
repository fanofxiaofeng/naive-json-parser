package com.study.model.number;

/**
 * Format:
 * <ul>
 *     <li><code>digit</code></li>
 *     <li><code>digit digits</code></li>
 * </ul>
 */
public sealed interface Digits permits
        Digits.CaseOne,
        Digits.CaseTwo {

    /**
     * Format: <code>digit</code>
     *
     * @param digit the digit
     */
    record CaseOne(Digit digit) implements Digits {
    }

    /**
     * Format: <code>digit digits</code>
     *
     * @param digit  the digit
     * @param digits the digits
     */
    record CaseTwo(Digit digit, Digits digits) implements Digits {

    }
}
