package com.test.parser.util;

import com.study.model.Character;
import com.study.model.Escape;
import com.study.util.StringUtils;

import java.util.StringJoiner;

public class RandomCharacterGenerator extends AbstractRandomGenerator<Character> {

    @Override
    public String generate() {
        return doGenerate(Character.class);
    }

    @Override
    public <S extends Character> String generate(Class<S> type) {
        if (type == Character.CaseOne.class) {
            while (true) {
                int cp = random.nextInt(0x10FFFF + 1);
                if (cp >= 0x0020 && cp != '\"' && cp != '\\') {
                    return StringUtils.fromCodePoint(cp);
                }
            }
        }
        if (type == Character.CaseTwo.class) {
            boolean hexEscape = random.nextBoolean();
            if (hexEscape) {
                int cp = random.nextInt(0x10FFFF + 1);
                char[] cs = StringUtils.fromCodePoint(cp).toCharArray();
                StringJoiner joiner = new StringJoiner("");
                for (char c : cs) {
                    String s = org.apache.commons.lang3.StringUtils.leftPad(Integer.toHexString(c), 4, '0');
                    joiner.add(String.format("\\u%s", s));
                }
                return joiner.toString();
            }
            int index = random.nextInt(Escape.SpecialCase.values().length);
            return String.format("\\%s", Escape.SpecialCase.values()[index]);
        }
        throw new IllegalArgumentException(String.format("Unexpected type: %s", type.getCanonicalName()));
    }

    public static void main(String[] args) {
        RandomCharacterGenerator generator = new RandomCharacterGenerator();
        for (int i = 0; i < 100; i++) {
            String result = generator.generate();
            if (result.codePoints().toArray().length > 1) {
                System.out.printf("[%s]%n", result);
            } else {
                StringJoiner joiner = new StringJoiner(", ");
                result.codePoints().forEach(cp -> joiner.add("0x" + Integer.toHexString(cp)));
                System.out.printf("[%s] (%s)%n", result, joiner);
            }
        }
    }
}
