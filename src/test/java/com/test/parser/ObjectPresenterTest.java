package com.test.parser;

import com.study.model.Json;
import org.junit.Assert;
import org.junit.Test;

public class ObjectPresenterTest extends TestBase {

    @Test
    public void test() {
        String s = "  {  \"name\": \"Tang\", \"start-year\": 618}";
        Json json = parse(s);
        String result = present(json);
        System.out.println(result);
        Assert.assertEquals(removeWhitespace(s), removeWhitespace(result));
    }
}
