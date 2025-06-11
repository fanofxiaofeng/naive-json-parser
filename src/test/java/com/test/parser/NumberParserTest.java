package com.test.parser;

import com.study.model.*;
import com.study.model.Integer;
import com.study.model.Number;
import com.test.parser.util.RandomExponentGenerator;
import com.test.parser.util.RandomFractionGenerator;
import com.test.parser.util.RandomGenerator;
import com.test.parser.util.RandomIntegerGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.lang.String;
import java.util.stream.Stream;

public class NumberParserTest extends TestBase {

    private final RandomGenerator<Integer> integerGenerator = new RandomIntegerGenerator();
    private final RandomGenerator<Fraction> fractionGenerator = new RandomFractionGenerator();
    private final RandomGenerator<Exponent> exponentGenerator = new RandomExponentGenerator();

    @Test
    public void testForRandomNumber() {
        int passCnt = 0;
        for (int i = 0; i < 500; i++) {
            String number = integerGenerator.generate() + fractionGenerator.generate() + exponentGenerator.generate();
            validate(number, Number.class);
            passCnt++;

            System.out.printf("Test for number: [%s] passed%n", number);
        }

        System.out.printf("passCnt is: %s%n", passCnt);
    }

    @Test
    public void testInvalidNumber() {
        Stream.of(
                ".1",
                "1.2.3",
                "05",
                "+3",
                "-.1",
                "0.",
                "1.E2",
                "2.e1",
                "3E",
                "4e"
        ).forEach(badValue -> Assert.assertThrows(IllegalArgumentException.class, () -> validate(badValue, Number.class)));
    }


    @Test
    public void testWithFile() throws IOException {
        testWithFile("cases/simple/number1.json");
        testWithFile("cases/simple/number2.json");
    }
}
