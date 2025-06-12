package com.test.parser;

import com.study.model.*;
import com.study.util.StringUtils;
import com.test.parser.util.*;
import com.test.parser.util.number.NumberGenerator;
import com.test.parser.util.string.StringGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.IntStream;

public class ArrayParserTest extends TestBase {

    @Test
    public void testSimpleCase() {
        List<Generator> generators = List.of(
                new NumberGenerator(),
                new StringGenerator(),
                new SpecialValueGenerator()
        );
        WhitespaceGenerator whitespaceGenerator = new WhitespaceGenerator(5);
        Function<String, String> elementBuilder =
                (var) -> whitespaceGenerator.generate() + var + whitespaceGenerator.generate();
        for (int i = 0; i < 20; i++) {
            int cnt = random.nextInt(5);
            StringJoiner joiner = new StringJoiner(
                    ",",
                    StringUtils.fromCodePoint(Array.LEFT_BRACKET),
                    StringUtils.fromCodePoint(Array.RIGHT_BRACKET)
            );
            List<String> generatedValues = new ArrayList<>(cnt);
            IntStream.range(0, cnt).forEach(index -> {
                Generator pickedGenerator = generators.get(random.nextInt(generators.size()));
                generatedValues.add(pickedGenerator.generate());
            });
            generatedValues.forEach(generatedValue -> joiner.add(elementBuilder.apply(generatedValue)));
//            System.out.println(joiner);
            if (cnt == 0) {
                validate(joiner.toString(), Array.CaseOne.class);
            } else {
                validate(joiner.toString(), Array.CaseTwo.class);
                Json parseResult = parse(joiner.toString());
                Assert.assertTrue(parseResult.element().value() instanceof Array.CaseTwo);
                Elements remainedElements = ((Array.CaseTwo) (parseResult).element().value()).elements();
                for (String generatedValue : generatedValues) {
                    Assert.assertTrue(remainedElements instanceof Elements.CaseOne || remainedElements instanceof Elements.CaseTwo);
                    if (remainedElements instanceof Elements.CaseOne caseOne) {
                        Assert.assertEquals(generatedValue, caseOne.element().value().toString());
                        remainedElements = null;
                    } else {
                        Elements.CaseTwo caseTwo = (Elements.CaseTwo) remainedElements;
                        Assert.assertEquals(generatedValue, caseTwo.element().value().toString());
                        remainedElements = caseTwo.elements();
                    }
                }
            }
        }
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
