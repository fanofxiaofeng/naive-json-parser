package com.test.parser.util;

import java.util.stream.Stream;

public class RandomIntegerGenerator extends AbstractRandomGenerator<com.study.model.Integer> {

    private final RandomDigitsGenerator randomDigitsGenerator = new RandomDigitsGenerator(TAIL_LEN_BOUND);

    private static final int TAIL_LEN_BOUND = 7;

    @Override
    public String generate() {
        return doGenerate(com.study.model.Integer.class);
    }

    @Override
    public <T extends com.study.model.Integer> String generate(Class<T> type) {
        if (type == com.study.model.Integer.CaseOne.class) {
            return "" + random.nextInt(10);
        }
        if (type == com.study.model.Integer.CaseTwo.class) {
            return (1 + random.nextInt(9)) + randomDigitsGenerator.generate();
        }
        if (type == com.study.model.Integer.CaseThree.class) {
            return "-" + generate(com.study.model.Integer.CaseOne.class);
        }
        if (type == com.study.model.Integer.CaseFour.class) {
            return "-" + generate(com.study.model.Integer.CaseTwo.class);
        }
        throw new IllegalArgumentException(String.format("Unexpected type: %s", type.getCanonicalName()));
    }

    public static void main(String[] args) {
        RandomIntegerGenerator generator = new RandomIntegerGenerator();
        Stream.of(
                com.study.model.Integer.CaseOne.class,
                com.study.model.Integer.CaseTwo.class,
                com.study.model.Integer.CaseThree.class,
                com.study.model.Integer.CaseFour.class
        ).forEach(type -> {
            System.out.printf("For type: [%s], below random samples are generated%n", type.getCanonicalName());
            for (int i = 0; i < 15; i++) {
                System.out.printf("Sample[%s]: %s%n", i, generator.generate(type));
            }
            System.out.println();
        });
    }
}
