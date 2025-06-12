package com.test.parser.util.number;

import com.study.model.number.Fraction;
import com.test.parser.util.AbstractRelationBasedGenerator;

public class FractionGenerator extends AbstractRelationBasedGenerator<Fraction> {

    private final DigitsGenerator randomDigitsGenerator = new DigitsGenerator(7);

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
        FractionGenerator generator = new FractionGenerator();
        for (int i = 0; i < 10; i++) {
            System.out.printf("[%s]%n", generator.generate());
        }
    }
}
