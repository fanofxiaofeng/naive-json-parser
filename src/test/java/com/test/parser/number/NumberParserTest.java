package com.test.parser.number;

import com.study.model.number.Integer;
import com.study.model.number.Number;
import com.study.model.number.Exponent;
import com.study.model.number.Fraction;
import com.test.parser.TestBase;
import com.test.parser.util.number.ExponentGenerator;
import com.test.parser.util.number.FractionGenerator;
import com.test.parser.util.RelationBasedGenerator;
import com.test.parser.util.number.IntegerGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.lang.String;
import java.util.stream.Stream;

public class NumberParserTest extends TestBase {

    private final RelationBasedGenerator<Integer> integerGenerator = new IntegerGenerator();
    private final RelationBasedGenerator<Fraction> fractionGenerator = new FractionGenerator();
    private final RelationBasedGenerator<Exponent> exponentGenerator = new ExponentGenerator();

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
