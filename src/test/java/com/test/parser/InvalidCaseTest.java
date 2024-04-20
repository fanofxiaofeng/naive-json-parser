package com.test.parser;

import com.study.model.Json;
import org.junit.Test;

import java.io.IOException;

public class InvalidCaseTest extends TestBase {

    @Test(expected = IllegalArgumentException.class)
    public void test1() {
        String s = "\"abc";
        Json json = parse(s);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithFile() throws IOException {
        testWithFile("cases/simple/invalid_case.json");
    }
}
