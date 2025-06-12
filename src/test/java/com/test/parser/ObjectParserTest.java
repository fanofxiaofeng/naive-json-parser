package com.test.parser;

import com.study.model.*;
import com.study.model.Object;
import com.study.util.StringUtils;
import com.test.parser.util.Generator;
import com.test.parser.util.SpecialValueGenerator;
import com.test.parser.util.WhitespaceGenerator;
import com.test.parser.util.number.NumberGenerator;
import com.test.parser.util.string.StringGenerator;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class ObjectParserTest extends TestBase {

    @Test
    public void testSimpleCase() {
        WhitespaceGenerator wsGenerator = new WhitespaceGenerator(3);
        StringGenerator stringGenerator = new StringGenerator();
        List<Generator> generators = List.of(
                new NumberGenerator(),
                stringGenerator,
                new SpecialValueGenerator()
        );
        BiFunction<String, String, String> memberBuilder =
                (key, value) -> wsGenerator.generate() + key + wsGenerator.generate() + ":" + wsGenerator.generate() + value + wsGenerator.generate();
        for (int i = 0; i < 50; i++) {
            int len = random.nextInt(10);
            List<Pair<String, String>> pairs = new ArrayList<>(len);
            StringJoiner joiner = new StringJoiner(
                    ",",
                    StringUtils.fromCodePoint(Object.LEFT_BRACE),
                    StringUtils.fromCodePoint(Object.RIGHT_BRACE)
            );

            IntStream.range(0, len).forEach(index -> {
                String key = stringGenerator.generate();
                int randomIndex = random.nextInt(generators.size());
                String value = generators.get(randomIndex).generate();
                pairs.add(Pair.of(key, value));
                joiner.add(memberBuilder.apply(key, value));
            });
            if (pairs.isEmpty()) {
                validate(joiner.toString(), Object.CaseOne.class);
            } else {
                validate(joiner.toString(), Object.CaseTwo.class);
                Json parseResult = parse(joiner.toString());
                Assert.assertTrue(parseResult.element().value() instanceof Object.CaseTwo);
                Members remainedMembers = ((Object.CaseTwo) (parseResult).element().value()).members();
                for (Pair<String, String> pair : pairs) {
                    Assert.assertTrue(remainedMembers instanceof Members.CaseOne || remainedMembers instanceof Members.CaseTwo);
                    if (remainedMembers instanceof Members.CaseOne caseOne) {
                        Assert.assertEquals(pair.getKey(), caseOne.member().string().toString());
                        Assert.assertEquals(pair.getValue(), caseOne.member().element().value().toString());
                    }
                    if (remainedMembers instanceof Members.CaseTwo caseTwo) {
                        Assert.assertEquals(pair.getKey(), caseTwo.member().string().toString());
                        Assert.assertEquals(pair.getValue(), caseTwo.member().element().value().toString());

                        remainedMembers = caseTwo.members();
                    }
                }
            }
        }
    }
}
