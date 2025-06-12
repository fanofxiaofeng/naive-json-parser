package com.study.convertor;

import com.study.model.string.Character;
import com.study.util.StringUtils;

public class CharacterConvertor implements Convertor<Character> {

    private final EscapeConvertor escapeConvertor = new EscapeConvertor();

    @Override
    public String convert(Character character) {
        if (character instanceof Character.CaseOne caseOne) {
            return StringUtils.fromCodePoint(caseOne.codePoint());
        }
        if (character instanceof Character.CaseTwo caseTwo) {
            return StringUtils.fromStringArray(
                    "\\",
                    escapeConvertor.convert(caseTwo.escape())
            );
        }
        throw new IllegalArgumentException();
    }
}
