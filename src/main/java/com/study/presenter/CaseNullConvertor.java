package com.study.presenter;

import com.study.model.Value;

public class CaseNullConvertor implements Convertor<Value.CaseNull> {
    @Override
    public String convert(Value.CaseNull caseNull) {
        return caseNull.toString();
    }
}
