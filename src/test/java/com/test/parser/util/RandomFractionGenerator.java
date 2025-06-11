package com.test.parser.util;

import com.study.model.Fraction;

public class RandomFractionGenerator extends AbstractRandomGenerator<Fraction> {

    private final RandomDigitsGenerator randomDigitsGenerator = new RandomDigitsGenerator(7);

    @Override
    public String generate() {
        return doGenerate(Fraction.class);
    }

    @Override
    public <T extends Fraction> String generate(Class<T> type) {
        if (type == Fraction.EmptyCase.class) {
            return "";
        }
        if (type == Fraction.NormalCase.class) {
            return "." + randomDigitsGenerator.generate();
        }
        throw new IllegalArgumentException(String.format("Unexpected type: %s", type.getCanonicalName()));
    }

    public static void main(String[] args) {
        RandomFractionGenerator generator = new RandomFractionGenerator();
        for (int i = 0; i < 10; i++) {
            System.out.printf("[%s]%n", generator.generate());
        }
    }
}
