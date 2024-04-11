package com.study.presenter;


import com.study.util.StringUtils;

public class CharacterConvertor implements Convertor<com.study.model.Character> {

    private final EscapeConvertor escapeConvertor = new EscapeConvertor();

    @Override
    public String convert(com.study.model.Character character) {
        if (character instanceof com.study.model.Character.CaseOne caseOne) {
            return StringUtils.fromInt(caseOne.codePoint());
        }
        if (character instanceof com.study.model.Character.CaseTwo caseTwo) {
            return StringUtils.fromStringArray(
                    "\\",
                    escapeConvertor.convert(caseTwo.escape())
            );
        }
        throw new IllegalArgumentException();
    }
}
