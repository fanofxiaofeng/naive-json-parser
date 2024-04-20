package com.test.parser;

import com.study.model.Json;
import com.study.presenter.JsonPresenter;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class NumberParserTest extends TestBase {

    @Test
    public void test() {
        Random random = new Random();

        int passCnt = 0;
        for (int i = 0; i < 100; i++) {
            String s = random.nextGaussian() + "";
            Json json = parse(s);

            JsonPresenter jsonPresenter = new JsonPresenter();
            jsonPresenter.present(json);
            String output = jsonPresenter.collect();
            Assert.assertEquals(s, output.trim());
            passCnt++;

            System.out.printf("Test for number: [%s] passed%n", s);
        }

        System.out.printf("passCnt is: %s%n", passCnt);
    }
}
