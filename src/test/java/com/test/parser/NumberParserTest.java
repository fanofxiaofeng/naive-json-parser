package com.test.parser;

import com.study.model.Json;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Random;

public class NumberParserTest extends TestBase {

    @Test
    public void test() {
        Random random = new Random();

        int passCnt = 0;
        for (int i = 0; i < 100; i++) {
            String s = random.nextGaussian() + "";
            Json json = parse(s);
            String result = present(json);
            Assert.assertEquals(s, result.trim());
            passCnt++;

            System.out.printf("Test for number: [%s] passed%n", s);
        }

        System.out.printf("passCnt is: %s%n", passCnt);
    }

    @Test
    public void testWithFile() throws IOException {
        testWithFile("cases/simple/number1.json");
        testWithFile("cases/simple/number2.json");
    }
}
