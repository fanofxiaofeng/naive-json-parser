package com.test.parser;

import com.study.model.Json;
import com.study.presenter.JsonPresenter;
import org.junit.Assert;
import org.junit.Test;

public class DigitsParserTest extends TestBase {
    @Test
    public void testForOneDigitCase() {
        for (int i = 0; i < 10; i++) {
            String s = i + "";
            Json json = parse(s);
            JsonPresenter jsonPresenter = new JsonPresenter();
            jsonPresenter.present(json);
            String output = jsonPresenter.collect();
            Assert.assertEquals(s, output.trim());
        }
    }

    @Test
    public void testForTwoDigitsCase() {
        for (int i = 10; i < 100; i++) {
            String s = i + "";
            Json json = parse(s);
            JsonPresenter jsonPresenter = new JsonPresenter();
            jsonPresenter.present(json);
            String output = jsonPresenter.collect();
            Assert.assertEquals(s, output.trim());
        }
    }
}
