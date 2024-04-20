package com.test.parser;

import com.study.model.Json;
import com.study.parser.JsonParser;
import org.apache.commons.collections4.iterators.PeekingIterator;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SpecialValueCaseParserTest extends TestBase {

    @Test
    public void test() {
        for (String value : new String[]{"true", "false", "null"}) {
            String s = String.format(" \t\n\r\r\n\n\t %s    \r\n\n\n\t\t  ", value);
            PeekingIterator<Integer> peekingIterator = new PeekingIterator<>(s.codePoints().iterator());
            Json json = new JsonParser().parse(peekingIterator);

            String result = present(json);
            Assert.assertEquals(value, result.trim());
            System.out.printf("Test for: case [%s] passed%n", value);
        }
    }

    @Test
    public void testWithFile() throws IOException {
        testWithFile("cases/simple/true.json");
        testWithFile("cases/simple/false.json");
        testWithFile("cases/simple/null.json");
    }
}
