package com.study.presenter;

import com.study.model.Value;

public class CaseTrueConvertor implements Convertor<Value.CaseTrue>{
    @Override
    public String convert(Value.CaseTrue caseTrue) {
        return caseTrue.toString();
    }
}
