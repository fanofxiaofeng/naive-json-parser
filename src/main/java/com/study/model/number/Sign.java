package com.study.model.number;

import java.lang.String;

/**
 * Format:
 * <ul>
 *     <li><code>""</code></li>
 *     <li><code>'+'</code></li>
 *     <li><code>'-'</code></li>
 * </ul>
 */
public enum Sign {
    ABSENT(""),
    POSITIVE("+"),
    NEGATIVE("-");

    private final java.lang.String content;

    Sign(java.lang.String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
