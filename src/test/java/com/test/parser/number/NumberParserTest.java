package com.test.parser.number;

import com.study.model.number.Number;
import com.test.For;
import com.test.parser.TestBase;
import com.test.parser.util.number.ExponentGenerator;
import com.test.parser.util.number.FractionGenerator;
import com.test.parser.util.number.IntegerGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.lang.String;
import java.util.stream.Stream;

@For(Number.class)
public class NumberParserTest extends TestBase {

    private final IntegerGenerator integerGenerator = new IntegerGenerator();
    private final FractionGenerator fractionGenerator = new FractionGenerator();
    private final ExponentGenerator exponentGenerator = new ExponentGenerator();

    @Test
    public void testRandomNumber() {
        int passCnt = 0;
        for (int i = 0; i < 100; i++) {
            String iPart = integerGenerator.generate();
            String fPart = fractionGenerator.generate();
            String ePart = exponentGenerator.generate();

            String number = iPart + fPart + ePart;
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
