package com.study.parser;

import com.study.model.Characters;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class CharactersParser implements Parser<com.study.model.Characters> {
    @Override
    public Characters parse(PeekingIterator<Integer> peekingIterator) {
        // todo: probably wrong
        if (!peekingIterator.hasNext()) {
            return Characters.CaseOne.getInstance();
        }

        int peek = peekingIterator.peek();
        if (qualified(peek)) {
            CharacterParser characterParser = new CharacterParser();
            return new Characters.CaseTwo(characterParser.parse(peekingIterator), parse(peekingIterator));
        }

        return Characters.CaseOne.getInstance();
    }

    private boolean qualified(int codePoint) {
        if (codePoint == '\\') {
            return true;
        }
        if (codePoint == '"') {
            return false;
        }
        return codePoint >= 0x0020 && codePoint <= 0x10FFF;
    }
}
