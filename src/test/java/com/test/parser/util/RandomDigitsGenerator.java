package com.test.parser.util;

import com.study.model.Digits;

import java.util.Random;
import java.util.StringJoiner;

public class RandomDigitsGenerator extends AbstractRandomGenerator<Digits> {

    private final Random random = new Random();

    private final int lenBound;

    /**
     * @param lenBound length bound (inclusive)
     */
    public RandomDigitsGenerator(int lenBound) {
        this.lenBound = lenBound;
    }

    @Override
    public String generate() {
        return doGenerate(Digits.class);
    }

    @Override
    public <S extends Digits> String generate(Class<S> type) {
        if (type == Digits.CaseOne.class) {
            return "" + random.nextInt(10);
        }
        if (type == Digits.CaseTwo.class) {
            StringJoiner joiner = new StringJoiner("");
            int len = 1 + random.nextInt(lenBound);
            for (int i = 0; i < len; i++) {
                joiner.add("" + random.nextInt(10));
            }
            return joiner.toString();
        }
        throw new IllegalArgumentException(String.format("Unexpected type: %s", type.getCanonicalName()));
    }
}
