package com.test.parser;

import com.study.parser.StringParser;
import com.study.presenter.StringConvertor;
import org.apache.commons.collections4.iterators.PeekingIterator;
import org.junit.Assert;
import org.junit.Test;

public class StringParserTest {
    @Test
    public void test() {
        String s = "\"Hello world\"";
        PeekingIterator<Integer> peekingIterator = new PeekingIterator<>(s.codePoints().iterator());
        com.study.model.String string = new StringParser().parse(peekingIterator);
        String result = new StringConvertor().convert(string);
        Assert.assertEquals(s, result);
    }
}
