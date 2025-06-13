package com.study.model.number;

/**
 * Format:
 * <ul>
 *     <li><code>""</code></li>
 *     <li><code>'E' sign digits</code></li>
 *     <li><code>'e' sign digits</code></li>
 * </ul>
 */
public sealed interface Exponent permits
        Exponent.EmptyCase,
        Exponent.UppercaseECase,
        Exponent.LowercaseECase {

    int UPPERCASE_SYMBOL = 'E';
    int LOWERCASE_SYMBOL = 'e';

    /**
     * Format: <code>""</code>
     */
    final class EmptyCase implements Exponent {
    }

    /**
     * Format: <code>'E' sign digits</code>
     *
     * @param sign   the sign
     * @param digits the digits
     */
    record UppercaseECase(Sign sign, Digits digits) implements Exponent {
    }

    /**
     * Format: <code>'e' sign digits</code>
     *
     * @param sign   the sign
     * @param digits the digits
     */
    record LowercaseECase(Sign sign, Digits digits) implements Exponent {
    }
}
