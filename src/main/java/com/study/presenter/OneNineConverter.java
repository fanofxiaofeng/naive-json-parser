package com.study.presenter;

import com.study.model.OneNine;

public class OneNineConverter implements Convertor<OneNine> {
    @Override
    public String convert(OneNine oneNine) {
        return switch (oneNine) {
            case ONE -> "1";
            case TWO -> "2";
            case THREE -> "3";
            case FOUR -> "4";
            case FIVE -> "5";
            case SIX -> "6";
            case SEVEN -> "7";
            case EIGHT -> "8";
            case NINE -> "9";
        };
    }
}
