package com.study.convertor;

import com.study.convertor.Convertor;
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
