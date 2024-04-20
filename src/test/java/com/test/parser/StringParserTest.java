package com.test.parser;

import com.study.model.Json;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StringParserTest extends TestBase {
    @Test
    public void test() {
        for (String s : new String[]{
                "   \t\n\n\n\t \r  \"Hello world\"  \r",
                "  \"a\\r\\nb\\tc d\\r\\n\"",
                " \"\\ud83d\\ude02 \\n\""
        }) {
            Json json = parse(s);
            String result = present(json);
            System.out.println(result);
            Assert.assertEquals(s.trim(), result.trim());
        }
    }

    @Test
    public void testWithFile() throws IOException {
        String s = readContentAsString("cases/simple/string1.json");
        Json json = parse(s);
        String result = present(json);
        System.out.println(result);
        Assert.assertEquals(s.trim(), result.trim());
    }
}
