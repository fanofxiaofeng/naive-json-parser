package com.test.parser;

import com.study.convertor.StringConvertor;
import com.study.model.Element;
import com.study.model.Json;
import com.study.model.Value;
import com.study.parser.JsonParser;
import org.apache.commons.collections4.iterators.PeekingIterator;
import org.junit.Assert;
import org.junit.Test;

public class StringParserTest {
    @Test
    public void test() {
        String s = "   \t\n\n\n\t \r  \"Hello world\"  \r";
        PeekingIterator<Integer> peekingIterator = new PeekingIterator<>(s.codePoints().iterator());
        Json json = new JsonParser().parse(peekingIterator);
        Value value = ((Element) json).value();
        Assert.assertTrue(value instanceof com.study.model.String);
        String result = new StringConvertor().convert((com.study.model.String) value);
        System.out.println(result);
    }
}
