package com.test.parser;

import com.study.model.Json;
import com.study.parser.JsonParser;
import org.apache.commons.collections4.iterators.PeekingIterator;
import org.junit.Test;

public class JsonParserTest {
    @Test
    public void test() {

        String s = "[1,2,3]";
//        String s = "1a";
        PeekingIterator<Integer> iterator = new PeekingIterator<>(s.codePoints().iterator());
        Json json = new JsonParser().parse(iterator);
        int a = 42;
    }
}
