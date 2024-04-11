package com.study.presenter;

import com.study.model.Sign;

public class SignConvertor implements Convertor<Sign> {
    @Override
    public String convert(Sign sign) {
        return switch (sign) {
            case ABSENT -> "";
            case POSITIVE -> "+";
            case NEGATIVE -> "-";
        };
    }
}
