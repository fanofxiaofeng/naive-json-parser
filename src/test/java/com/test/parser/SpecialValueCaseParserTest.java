package com.test.parser;

import com.study.model.Json;
import com.study.parser.JsonParser;
import com.study.presenter.JsonPresenter;
import org.apache.commons.collections4.iterators.PeekingIterator;
import org.junit.Assert;
import org.junit.Test;

public class SpecialValueCaseParserTest {

    @Test
    public void test() {
        for (String value : new String[]{"true", "false", "null"}) {
            String s = String.format(" \t\n\r\r\n\n\t %s    \r\n\n\n\t\t  ", value);
            PeekingIterator<Integer> peekingIterator = new PeekingIterator<>(s.codePoints().iterator());
            Json json = new JsonParser().parse(peekingIterator);

            JsonPresenter jsonPresenter = new JsonPresenter();
            jsonPresenter.present(json);
            String output = jsonPresenter.collect();
            Assert.assertEquals(value, output.trim());
            System.out.printf("Test for: case [%s] passed%n", value);
        }
    }
}
