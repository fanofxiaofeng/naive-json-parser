package com.test.parser;

import com.study.model.Json;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ArrayParserTest extends TestBase {
    @Test
    public void testForBasicCase() {
        String s = String.format("  [1,2  ,3.1415926E0 , 2.3E1, \"%s\" ]",
                RandomStringUtils.randomAlphabetic(20));
        Json json = parse(s);
        String result = present(json, 4);
        System.out.println(result);
        Assert.assertEquals(removeWhitespace(s), removeWhitespace(result));
    }

    @Test
    public void testWithFile() throws IOException {
        for (String name : new String[]{
                "cases/simple/array1.json",
                "cases/complex/1.json"
        }) {
            String s = readContentAsString(name);
            Json json = parse(s);
            String result = present(json, 2);
            System.out.println(result);
            Assert.assertEquals(s.trim(), result.trim());
        }
    }
}
