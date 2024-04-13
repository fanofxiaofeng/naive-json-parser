package com.test.parser;

import com.study.model.Number;
import com.study.parser.NumberParser;
import com.study.convertor.NumberConvertor;
import com.study.util.StringUtils;
import org.apache.commons.collections4.iterators.PeekingIterator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class NumberParserTest {

    @Test
    public void test() {
        int passCnt = 0;
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            String s = random.nextGaussian() + "";
            PeekingIterator<Integer> peekingIterator = new PeekingIterator<>(s.codePoints().iterator());
            Number number = new NumberParser().parse(peekingIterator);
            String result = new NumberConvertor().convert(number);
            Assert.assertEquals(StringUtils.fromStringArray(s, " != ", result), s, result);
            passCnt++;
        }
        System.out.printf("passCnt is: %s%n", passCnt);
    }
}
