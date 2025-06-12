package com.test.parser.util.number;

import com.study.model.number.Exponent;
import com.test.parser.util.AbstractRelationBasedGenerator;

import java.util.List;

public class ExponentGenerator extends AbstractRelationBasedGenerator<Exponent> {

    private final DigitsGenerator randomDigitsGenerator = new DigitsGenerator(7);

    @Override
    public String generate() {
        return doGenerate(Exponent.class);
    }

    @Override
    public <T extends Exponent> String generate(Class<T> type) {
        if (type == Exponent.EmptyCase.class) {
            return "";
        }
        if (type == Exponent.UppercaseECase.class) {
            return "E" + generateRandomSign() + randomDigitsGenerator.generate();
        }
        if (type == Exponent.LowercaseECase.class) {
            return "e" + generateRandomSign() + randomDigitsGenerator.generate();
        }
        throw new IllegalArgumentException(String.format("Unexpected type: %s", type.getCanonicalName()));
    }

    private String generateRandomSign() {
        List<String> signCandidates = List.of("", "+", "-");
        int randomIndex = random.nextInt(signCandidates.size());
        return signCandidates.get(randomIndex);
    }

    public static void main(String[] args) {
        ExponentGenerator generator = new ExponentGenerator();
        for (int i = 0; i < 20; i++) {
            System.out.printf("[%s]%n", generator.generate());
        }
    }

}
