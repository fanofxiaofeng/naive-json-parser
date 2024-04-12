package com.study.presenter;

import com.study.model.Value;

public class CaseTrueConvertor implements Convertor<Value.CaseTrue> {

    private static final CaseTrueConvertor instance = new CaseTrueConvertor();

    private CaseTrueConvertor() {

    }
    @Override
    public String convert(Value.CaseTrue caseTrue) {
        return caseTrue.toString();
    }

    public static CaseTrueConvertor getInstance() {
        return instance;
    }
}
