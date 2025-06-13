package com.study.model.string;

import com.study.convertor.StringConvertor;
import com.study.model.ForDebug;
import com.study.model.Value;

/**
 * Format: <code>'"' characters '"'</code>
 *
 * @param quotationMark1 always a '"'
 * @param characters     the characters
 * @param quotationMark2 always a '"'
 */
public record String(int quotationMark1, Characters characters, int quotationMark2) implements Value {

    @ForDebug
    @Override
    public java.lang.String toString() {
        return new StringConvertor().convert(this);
    }
}
