package com.test.parser;

import com.study.model.Json;
import com.study.parser.JsonParser;
import com.study.presenter.JsonPresenter;
import org.apache.commons.collections4.iterators.PeekingIterator;
import org.junit.Test;

public class ArrayParserTest {
    @Test
    public void test() {
        String s = "  [1,2  ,3.1415926E0 , 2.3E1 ]";
        PeekingIterator<Integer> iterator = new PeekingIterator<>(s.codePoints().iterator());
        Json json = new JsonParser().parse(iterator);
//        new JsonPresenter().present(json);
    }
}
