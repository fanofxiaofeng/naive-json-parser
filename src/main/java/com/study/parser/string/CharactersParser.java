package com.study.parser.string;

import com.study.model.string.Characters;
import com.study.model.string.Character;
import com.study.parser.Parser;
import org.apache.commons.collections4.iterators.PeekingIterator;

public class CharactersParser implements Parser<Characters> {
    @Override
    public Characters parse(PeekingIterator<Integer> peekingIterator) {
        if (!peekingIterator.hasNext()) {
            throw new IllegalArgumentException("Expected more character(s), but the iterator is already exhausted!");
        }

        int peek = peekingIterator.peek();
//        System.out.printf("next cp is: %s%n", StringUtils.fromCodePoint(peek));
        if (peek == '"') {
            return Characters.CaseOne.getInstance();
        }
        Character character = new CharacterParser().parse(peekingIterator);
        return new Characters.CaseTwo(character, parse(peekingIterator));
    }
}
