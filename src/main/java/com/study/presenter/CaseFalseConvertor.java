package com.study.presenter;

import com.study.model.Value;

public class CaseFalseConvertor implements Convertor<Value.CaseFalse> {
    @Override
    public String convert(Value.CaseFalse caseFalse) {
        return caseFalse.toString();
    }
}
