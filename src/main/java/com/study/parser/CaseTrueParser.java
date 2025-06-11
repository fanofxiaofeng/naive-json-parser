package com.study.parser;

import com.study.model.Value;

public class CaseTrueParser extends SpecialValueCaseParser {
    CaseTrueParser() {
        super("true", Value.CaseTrue.getInstance());
    }
}
