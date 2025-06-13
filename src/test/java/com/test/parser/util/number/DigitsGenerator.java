package com.test.parser.util.number;

import com.study.model.number.Digits;
import com.test.parser.util.AbstractRelationBasedGenerator;

import java.util.Random;
import java.util.StringJoiner;

public class DigitsGenerator extends AbstractRelationBasedGenerator<Digits> {

    private final Random random = new Random();

    private final int lenBound;

    /**
     * @param lenBound length bound (inclusive)
     */
    public DigitsGenerator(int lenBound) {
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
            if (lenBound < 2) {
                throw new IllegalArgumentException("lenBound should be greater than or equal to 2");
            }

            // Allowed values for len variable: 2, 3, 4, ... lenBound
            int len = random.nextInt(lenBound - 1) + 2;

            for (int i = 0; i < len; i++) {
                joiner.add("" + random.nextInt(10));
            }
            return joiner.toString();
        }
        throw new IllegalArgumentException(String.format("Unexpected type: %s", type.getCanonicalName()));
    }
}
