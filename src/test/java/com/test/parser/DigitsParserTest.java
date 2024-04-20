package com.test.parser;

import com.study.model.Json;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

public class DigitsParserTest extends TestBase {
    @Test
    public void testForOneDigitCase() {
        for (int i = 0; i < 10; i++) {
            String s = i + "";
            Json json = parse(s);
            String result = present(json);
            Assert.assertEquals(s, result.trim());
        }
    }

    @Test
    public void testForTwoDigitsCase() {
        for (int i = 10; i < 100; i++) {
            String s = i + "";
            Json json = parse(s);
            String result = present(json);
            Assert.assertEquals(s, result.trim());
        }
    }

    @Test
    public void testForGeneralCase() {
        for (int i = 0; i < 100; i++) {
            String randomNumber = RandomStringUtils.randomNumeric(1, 100);
            if (randomNumber.startsWith("0") && !randomNumber.equals("0")) {
                continue;
            }

            Json json = parse(randomNumber);
            String result = present(json);
            Assert.assertEquals(randomNumber, result.trim());
            System.out.printf("Test passed for number: [%s]%n", randomNumber);
        }
    }
}
