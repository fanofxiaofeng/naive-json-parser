package com.study.presenter;

import com.study.util.StringUtils;

public class StringConvertor implements Convertor<com.study.model.String> {

    private final CharactersConvertor charactersConvertor = new CharactersConvertor();

    @Override
    public java.lang.String convert(com.study.model.String string) {
        return StringUtils.fromStringArray(
                "\"",
                charactersConvertor.convert(string.characters()),
                "\""
        );
    }
}
