package com.test.parser.util.number;

import com.test.parser.util.Generator;

import java.util.stream.IntStream;

public class NumberGenerator implements Generator {
    private final IntegerGenerator integerGenerator = new IntegerGenerator();
    private final FractionGenerator fractionGenerator = new FractionGenerator();
    private final ExponentGenerator exponentGenerator = new ExponentGenerator();

    @Override
    public String generate() {
        return integerGenerator.generate() + fractionGenerator.generate() + exponentGenerator.generate();
    }

    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();
        IntStream.range(0, 100).forEach(value -> System.out.println(numberGenerator.generate()));
    }
}
