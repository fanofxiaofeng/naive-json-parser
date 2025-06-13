package com.study.model.number;


/**
 * Format:
 * <ul>
 *     <li><code>digit</code></li>
 *     <li><code>oneNine digits</code></li>
 *     <li><code>'-' digit</code></li>
 *     <li><code>'-' oneNine digits</code></li>
 * </ul>
 */
public sealed interface Integer permits
        Integer.CaseOne,
        Integer.CaseTwo,
        Integer.CaseThree,
        Integer.CaseFour {

    /**
     * Format: <code>digit</code>
     *
     * @param digit the digit
     */
    record CaseOne(Digit digit) implements Integer {

    }

    /**
     * Format: <code>oneNine digits</code>
     *
     * @param oneNine the oneNine
     * @param digits  the digits
     */
    record CaseTwo(OneNine oneNine, Digits digits) implements Integer {

    }

    /**
     * Format: <code>'-' digit</code>
     *
     * @param minus always a '-'
     * @param digit the digit
     */
    record CaseThree(int minus, Digit digit) implements Integer {
    }

    /**
     * Format: <code>'-' oneNine digits</code>
     *
     * @param minus   always a '-'
     * @param oneNine the oneNine
     * @param digits  the digits
     */
    record CaseFour(int minus, OneNine oneNine, Digits digits) implements Integer {

    }
}
