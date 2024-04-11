package com.test.parser;

import com.study.model.Digits;
import com.study.parser.DigitsParser;
import com.study.presenter.DigitsConvertor;
import org.apache.commons.collections4.iterators.PeekingIterator;
import org.junit.Test;

public class DigitsParserTest {
    @Test
    public void test() {
        String s = "1002345679832985928609480890849038952429089023893809284932849023840239043a";
//        String s = "1a";
        PeekingIterator<Integer> iterator = new PeekingIterator<>(s.codePoints().iterator());
        Digits digits = new DigitsParser().parse(iterator);
        String result = new DigitsConvertor().convert(digits);
    }
}
