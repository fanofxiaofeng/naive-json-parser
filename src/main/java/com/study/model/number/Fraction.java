package com.study.model.number;

/**
 * Format:
 * <ul>
 *     <li><code>""</code></li>
 *     <li><code>'.' digits</code></li>
 * </ul>
 */
public sealed interface Fraction permits
        Fraction.EmptyCase,
        Fraction.NormalCase {

    /**
     * Format: <code>""</code>
     */
    final class EmptyCase implements Fraction {
        private static final EmptyCase instance = new EmptyCase();

        private EmptyCase() {

        }

        public static EmptyCase getInstance() {
            return instance;
        }
    }

    /**
     * Format: <code>'.' digits</code>
     *
     * @param dot    always a '.'
     * @param digits the digits
     */
    record NormalCase(int dot, Digits digits) implements Fraction {
    }
}
