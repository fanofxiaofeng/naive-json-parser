package com.study.model;

/**
 * Format:
 * <ul>
 *     <li><code>'{' ws '}'</code></li>
 *     <li><code>'{' members '}'</code></li>
 * </ul>
 */
public sealed interface Object extends Value permits
        Object.CaseOne,
        Object.CaseTwo {

    int LEFT_BRACE = '{';
    int RIGHT_BRACE = '}';

    /**
     * Format: <code>'{' ws '}</code>
     *
     * @param leftBrace  always a '{'
     * @param whitespace the ws
     * @param rightBrace always a '}'
     */
    record CaseOne(int leftBrace, Whitespace whitespace, int rightBrace) implements Object {

        @Override
        public int keyValuePairCount() {
            return 0;
        }
    }

    /**
     * Format: <code>'{' members '}'</code>
     *
     * @param leftBrace  always a '{'
     * @param members    the members
     * @param rightBrace always a '}'
     */
    record CaseTwo(int leftBrace, Members members, int rightBrace) implements Object {

        @Override
        public int keyValuePairCount() {
            return members().memberCount();
        }
    }

    @ForDebug
    int keyValuePairCount();
}
