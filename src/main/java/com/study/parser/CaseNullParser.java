package com.study.parser;

import com.study.model.Value;

public class CaseNullParser extends SpecialValueCaseParser {
    CaseNullParser() {
        super("null", Value.CaseNull.getInstance());
    }
}
