package com.test.parser;

import com.study.model.Digits;
import com.study.parser.ArrayParser;
import com.study.parser.DigitsParser;
import com.study.presenter.ArrayPresenter;
import org.apache.commons.collections4.iterators.PeekingIterator;
import org.junit.Test;

public class ArrayParserTest {
    @Test
    public void test() {
        String s = "[ {}, \n" +
                "{\"k\" : \n" +
                "[\"hhh\", {\"kk\": [1,4]}]}\n" +
                "]";
        PeekingIterator<Integer> iterator = new PeekingIterator<>(s.codePoints().iterator());
        com.study.model.Array array = new ArrayParser().parse(iterator);
        new ArrayPresenter(false, 0).present(array);
    }
}
