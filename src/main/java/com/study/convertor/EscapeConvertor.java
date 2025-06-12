package com.study.convertor;

import com.study.model.string.Escape;
import com.study.util.StringUtils;

public class EscapeConvertor implements Convertor<Escape> {
    @Override
    public String convert(Escape escape) {
        if (escape instanceof Escape.SpecialCase specialCase) {
            return specialCase.toString();
        }

        if (escape instanceof Escape.GeneralCase generalCase) {
            return StringUtils.fromStringArray(
                    "u",
                    generalCase.hex1().toString(),
                    generalCase.hex2().toString(),
                    generalCase.hex3().toString(),
                    generalCase.hex4().toString()
            );
        }
        throw new IllegalArgumentException();
    }
}
