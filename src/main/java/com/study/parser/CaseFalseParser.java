package com.study.parser;

import com.study.model.Value;

public class CaseFalseParser extends SpecialValueCaseParser {
    protected CaseFalseParser() {
        super("false", Value.CaseFalse.getInstance());
    }
}
