package com.study.model.number;

/**
 * Format:
 * <ul>
 *     <li><code>'0'</code></li>
 *     <li><code>onenine</code></li>
 * </ul>
 */
public sealed interface Digit
        permits Zero, OneNine {

    static boolean qualified(int codePoint) {
        return codePoint >= '0' && codePoint <= '9';
    }
}
