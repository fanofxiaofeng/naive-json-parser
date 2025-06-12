package com.study.convertor;

import com.study.model.number.Sign;

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
