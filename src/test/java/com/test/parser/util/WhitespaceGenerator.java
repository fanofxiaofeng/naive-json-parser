package com.test.parser.util;

import com.study.model.Whitespace;
import com.study.util.StringUtils;

import java.util.StringJoiner;
import java.util.stream.IntStream;

public class WhitespaceGenerator extends AbstractRelationBasedGenerator<Whitespace> {

    private final int lenBound;

    public WhitespaceGenerator(int lenBound) {
        this.lenBound = lenBound;
    }

    @Override
    public String generate() {
        return doGenerate(Whitespace.class);
    }

    @Override
    public <S extends Whitespace> String generate(Class<S> type) {
        if (type == Whitespace.EmptyCase.class) {
            return "";
        }
        int[] candidates = new int[]{0x0020, 0x000A, 0x000D, 0x0009};
        if (type == Whitespace.NormalCase.class) {
            StringJoiner joiner = new StringJoiner("");
            int len = 1 + random.nextInt(lenBound);
            for (int i = 0; i < len; i++) {
                joiner.add(StringUtils.fromCodePoint(candidates[random.nextInt(candidates.length)]));
            }
            return joiner.toString();
        }

        throw new IllegalArgumentException(String.format("Unexpected type: %s", type.getCanonicalName()));
    }

    public static void main(String[] args) {
        WhitespaceGenerator generator = new WhitespaceGenerator(5);
        IntStream.range(0, 20).forEach(value -> System.out.printf("[%s]%n", generator.generate()));
    }
}
