package com.test.presenter;

import com.study.model.Json;
import com.study.presenter.JsonPresenter;
import com.study.util.ResultHolder;
import com.test.parser.TestBase;
import com.test.parser.util.Generator;
import com.test.parser.util.number.NumberGenerator;
import com.test.parser.util.string.StringGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ValuePresenterTest extends TestBase {

    @Test
    public void testSpecialValue() {
        Stream.of("true", "false", "null").forEach(this::validate);
    }

    @Test
    public void testNumberCase() {
        Generator numberGenerator = new NumberGenerator();
        IntStream.range(0, 100).mapToObj((i) -> numberGenerator.generate()).forEach(this::validate);
    }

    @Test
    public void testStringCase() {
        Generator stringGenerator = new StringGenerator();
        IntStream.range(0, 100).mapToObj((i) -> stringGenerator.generate()).forEach(this::validate);
    }

    private void validate(String value) {
        Stream.of(
                value,
                String.format(" \t\n\r%s", value),
                String.format("%s \t\n\r", value),
                String.format(" \t\n\r\r\n\n\t %s    \r\n\n\n\t\t  ", value)
        ).forEach(decoratedValue -> {
            Json json = parse(decoratedValue);

            ResultHolder resultHolder = new ResultHolder(4);
            JsonPresenter jsonPresenter = new JsonPresenter(resultHolder);

            jsonPresenter.present(json);
            Assert.assertEquals(value, resultHolder.collect());
        });
    }
}
