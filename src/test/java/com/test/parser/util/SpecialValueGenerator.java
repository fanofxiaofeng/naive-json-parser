package com.test.parser.util;

import java.util.Random;
import java.util.stream.IntStream;

public class SpecialValueGenerator implements Generator {

    private final Random random = new Random();

    @Override
    public String generate() {
        String[] specialValues = new String[]{"true", "false", "null"};
        int randomIndex = random.nextInt(specialValues.length);
        return specialValues[randomIndex];
    }

    public static void main(String[] args) {
        SpecialValueGenerator generator = new SpecialValueGenerator();
        IntStream.range(0, 10).forEach(value -> System.out.println(generator.generate()));
    }
}
