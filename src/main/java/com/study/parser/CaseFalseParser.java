package com.study.parser;

import com.study.model.Value;

public class CaseFalseParser extends SpecialValueCaseParser {
    CaseFalseParser() {
        super("false", Value.CaseFalse.getInstance());
    }
}
