package com.study.convertor;

import com.study.model.string.String;
import com.study.util.StringUtils;

public class StringConvertor implements Convertor<String> {

    private final CharactersConvertor charactersConvertor = new CharactersConvertor();

    @Override
    public java.lang.String convert(String string) {
        return StringUtils.fromStringArray(
                "\"",
                charactersConvertor.convert(string.characters()),
                "\""
        );
    }
}
