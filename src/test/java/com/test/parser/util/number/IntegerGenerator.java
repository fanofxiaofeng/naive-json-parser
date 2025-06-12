package com.test.parser.util.number;

import com.study.model.number.Integer;
import com.test.parser.util.AbstractRelationBasedGenerator;

import java.util.stream.Stream;

public class IntegerGenerator extends AbstractRelationBasedGenerator<Integer> {

    private final DigitsGenerator randomDigitsGenerator = new DigitsGenerator(TAIL_LEN_BOUND);

    private static final int TAIL_LEN_BOUND = 7;

    @Override
    public String generate() {
        return doGenerate(Integer.class);
    }

    @Override
    public <T extends Integer> String generate(Class<T> type) {
        if (type == Integer.CaseOne.class) {
            return "" + random.nextInt(10);
        }
        if (type == Integer.CaseTwo.class) {
            return (1 + random.nextInt(9)) + randomDigitsGenerator.generate();
        }
        if (type == Integer.CaseThree.class) {
            return "-" + generate(Integer.CaseOne.class);
        }
        if (type == Integer.CaseFour.class) {
            return "-" + generate(Integer.CaseTwo.class);
        }
        throw new IllegalArgumentException(String.format("Unexpected type: %s", type.getCanonicalName()));
    }

    public static void main(String[] args) {
        IntegerGenerator generator = new IntegerGenerator();
        Stream.of(
                Integer.CaseOne.class,
                Integer.CaseTwo.class,
                Integer.CaseThree.class,
                Integer.CaseFour.class
        ).forEach(type -> {
            System.out.printf("For type: [%s], below random samples are generated%n", type.getCanonicalName());
            for (int i = 0; i < 15; i++) {
                System.out.printf("Sample[%s]: %s%n", i, generator.generate(type));
            }
            System.out.println();
        });
    }
}
