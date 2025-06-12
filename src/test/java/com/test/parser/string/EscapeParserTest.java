package com.test.parser.string;

import com.study.model.string.Escape;
import com.study.parser.string.EscapeParser;
import com.study.util.StringUtils;
import com.test.parser.TestBase;
import com.test.parser.util.ParseResultBuilder;
import com.test.parser.util.string.HexGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class EscapeParserTest extends TestBase {

    private final EscapeParser escapeParser = new EscapeParser();
    private final ParseResultBuilder<Escape> parseResultBuilder = new ParseResultBuilder<>();

    @Test
    public void testSpecialCase() {
        Escape.SpecialCase[] candidates = Escape.SpecialCase.values();
        IntStream.range(0, candidates.length).forEach(index -> {
            String candidate = StringUtils.fromCodePoint(candidates[index].getSymbol());
            Escape parseResult = parseResultBuilder.buildParseResult(escapeParser, candidate);
            Assert.assertTrue(parseResult instanceof Escape.SpecialCase);
            Assert.assertEquals(candidate, StringUtils.fromCodePoint(((Escape.SpecialCase) parseResult).getSymbol()));
        });
    }

    @Test
    public void testGeneralCase() {
        HexGenerator hexGenerator = new HexGenerator();

        for (int i = 0; i < 100; i++) {
            List<String> strings = IntStream.range(0, 4).mapToObj(n -> hexGenerator.generateRandomHex()).toList();

            StringJoiner joiner = new StringJoiner("", "u", "");
            strings.forEach(joiner::add);
            String value = joiner.toString();

            Escape parseResult = parseResultBuilder.buildParseResult(escapeParser, value);

            Assert.assertTrue(parseResult instanceof Escape.GeneralCase);
            Assert.assertEquals('u', ((Escape.GeneralCase) parseResult).u());
            Assert.assertEquals(strings.get(0), ((Escape.GeneralCase) parseResult).hex1().toString());
            Assert.assertEquals(strings.get(1), ((Escape.GeneralCase) parseResult).hex2().toString());
            Assert.assertEquals(strings.get(2), ((Escape.GeneralCase) parseResult).hex3().toString());
            Assert.assertEquals(strings.get(3), ((Escape.GeneralCase) parseResult).hex4().toString());
        }
    }
}
