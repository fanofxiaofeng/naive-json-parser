package com.test.parser.util.string;

import com.study.model.string.Characters;
import com.test.parser.util.AbstractRelationBasedGenerator;
import com.test.parser.util.RelationBasedGenerator;

import java.util.StringJoiner;
import java.util.stream.IntStream;

public class CharactersGenerator extends AbstractRelationBasedGenerator<Characters> {

    private final RelationBasedGenerator<com.study.model.string.Character> characterGenerator = new CharacterGenerator();

    @Override
    public String generate() {
        return doGenerate(Characters.class);
    }

    @Override
    public <S extends Characters> String generate(Class<S> type) {
        if (type == Characters.CaseOne.class) {
            return "";
        }

        if (type == Characters.CaseTwo.class) {
            int len = 1 + random.nextInt(20);
            StringJoiner joiner = new StringJoiner("");
            IntStream.range(0, len).forEach(value -> {
                joiner.add(characterGenerator.generate());
            });
            return joiner.toString();
        }
        throw new IllegalArgumentException(String.format("Unexpected type: %s", type.getCanonicalName()));
    }

    public static void main(String[] args) {
        System.out.println(new CharactersGenerator().generate());
    }
}
