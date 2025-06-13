package com.test.presenter;

import com.study.model.Array;
import com.study.model.Elements;
import com.study.model.Json;
import com.study.presenter.JsonPresenter;
import com.study.util.ResultHolder;
import com.test.parser.TestBase;
import com.test.parser.util.Generator;
import com.test.parser.util.SpecialValueGenerator;
import com.test.parser.util.number.NumberGenerator;
import com.test.parser.util.string.StringGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
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

    /**
     * Test for random-length arrays that only contain below items
     * <ul>
     * <li><code>number</code></li>
     * <li><code>string</code></li>
     * <li><code>"null"</code></li>
     * <li><code>"true"</code></li>
     * <li><code>"false"</code></li>
     * </ul>
     */
    @Test
    public void testSimpleArrayCase() {
        List<Generator> generators = List.of(
                new NumberGenerator(),
                new StringGenerator(),
                new SpecialValueGenerator()
        );

        IntStream.range(0, 100).forEach(i -> {
            StringJoiner joiner = new StringJoiner("," + System.lineSeparator());
            int len = random.nextInt(10);
            List<String> generatedValues = new ArrayList<>(len);
            IntStream.range(0, len).forEach(j -> {
                int randomIndex = random.nextInt(generators.size());
                String generatedValue = generators.get(randomIndex).generate();
                generatedValues.add(generatedValue);
            });

            int indentWidthForEachLevel = random.nextInt(8);
            generatedValues.forEach(v -> joiner.add(" ".repeat(indentWidthForEachLevel) + v));
            String s = generatedValues.isEmpty() ? "[]" : String.format("[%s%s%s]",
                    System.lineSeparator(),
                    joiner,
                    System.lineSeparator()
            );
            validate(s, indentWidthForEachLevel);

            Json parseResult = parse(s);
            if (generatedValues.isEmpty()) {
                Assert.assertTrue(parseResult.element().value() instanceof Array.CaseOne);
            } else {
                Assert.assertTrue(parseResult.element().value() instanceof Array.CaseTwo);
                Elements remainingElements = ((Array.CaseTwo) parseResult.element().value()).elements();
                for (String generatedValue : generatedValues) {
                    Assert.assertTrue(remainingElements instanceof Elements.CaseOne || remainingElements instanceof Elements.CaseTwo);
                    if (remainingElements instanceof Elements.CaseOne caseOne) {
                        Assert.assertEquals(generatedValue, caseOne.element().value().toString());
                    } else {
                        Elements.CaseTwo caseTwo = (Elements.CaseTwo) remainingElements;
                        Assert.assertEquals(generatedValue, caseTwo.element().value().toString());
                        remainingElements = caseTwo.elements();
                    }
                }
            }
        });
    }

    private void validate(String value) {
        validate(value, 4);
    }

    private void validate(String value, int indentWidthForEachLevel) {
        Stream.of(
                value,
                String.format(" \t\n\r%s", value),
                String.format("%s \t\n\r", value),
                String.format(" \t\n\r\r\n\n\t %s    \r\n\n\n\t\t  ", value)
        ).forEach(decoratedValue -> {
            Json json = parse(decoratedValue);

            ResultHolder resultHolder = new ResultHolder(indentWidthForEachLevel);
            JsonPresenter jsonPresenter = new JsonPresenter(resultHolder);

            jsonPresenter.present(json);
            Assert.assertEquals(value, resultHolder.collect());
        });
    }

    @Test
    public void testWithFile() throws IOException {
        for (String name : new String[]{
                "cases/simple/array1.json",
                "cases/complex/1.json"
        }) {
            String s = readContentAsString(name);
            Json json = parse(s);
            String result = present(json, 2);
            System.out.println(result);
            Assert.assertEquals(s.trim(), result.trim());
        }
    }
}
