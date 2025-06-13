package com.study.model;


/**
 * Format:
 * <ul>
 *     <li><code>'[' ws ']'</code></li>
 *     <li><code>'[' elements ']'</code></li>
 * </ul>
 */
public sealed interface Array extends Value permits
        Array.CaseOne,
        Array.CaseTwo {

    int LEFT_BRACKET = '[';
    int RIGHT_BRACKET = ']';

    /**
     * Format: <code>'[' ws ']'</code>
     *
     * @param leftBracket  always a '['
     * @param whitespace   the ws
     * @param rightBracket always a ']'
     */
    record CaseOne(int leftBracket, Whitespace whitespace, int rightBracket) implements Array {

        @Override
        public int elementCount() {
            return 0;
        }
    }

    /**
     * Format: <code>'[' elements ']'</code>
     *
     * @param leftBracket  always a '['
     * @param elements     the elements
     * @param rightBracket always a ']'
     */
    record CaseTwo(int leftBracket, Elements elements, int rightBracket) implements Array {

        @Override
        public int elementCount() {
            return elements.elementCount();
        }
    }

    @ForDebug
    int elementCount();
}
