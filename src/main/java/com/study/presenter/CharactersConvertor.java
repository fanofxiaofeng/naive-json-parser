package com.study.presenter;

import com.study.model.Characters;
import com.study.util.StringUtils;

public class CharactersConvertor implements Convertor<Characters> {

    private final CharacterConvertor characterConvertor = new CharacterConvertor();

    @Override
    public String convert(Characters character) {
        if (character instanceof Characters.CaseOne) {
            return "";
        }
        if (character instanceof Characters.CaseTwo caseTwo) {
            return StringUtils.fromStringArray(
                    characterConvertor.convert(caseTwo.character()),
                    convert(caseTwo.characters())
            );
        }
        throw new IllegalArgumentException();
    }
}
