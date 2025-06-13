package com.test.parser.string;

import com.study.model.string.Escape;
import com.study.parser.string.EscapeParser;
import com.study.util.StringUtils;
import com.test.For;
import com.test.parser.TestBase;
import com.test.parser.util.ParseResultBuilder;
import com.test.parser.util.TestHelper;
import com.test.parser.util.string.HexGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;

@For(Escape.class)
public class EscapeParserTest extends TestBase {

    private final EscapeParser escapeParser = new EscapeParser();
    private final ParseResultBuilder<Escape> parseResultBuilder = new ParseResultBuilder<>();
    private final TestHelper<Escape> testHelper = new TestHelper<>();

    @For(Escape.SpecialCase.class)
    @Test
    public void testSpecialCase() {
        Arrays.stream(Escape.SpecialCase.values()).forEach(e -> {
            String candidate = StringUtils.fromCodePoint(e.getSymbol());
            Escape parseResult = parseResultBuilder.buildParseResult(escapeParser, candidate);
            Escape.SpecialCase specialCase = testHelper.castTo(parseResult, Escape.SpecialCase.class);
            Assert.assertEquals(candidate, StringUtils.fromCodePoint(specialCase.getSymbol()));
        });
    }

    @For(Escape.GeneralCase.class)
    @Test
    public void testGeneralCase() {
        HexGenerator hexGenerator = new HexGenerator();

        for (int i = 0; i < 100; i++) {
            List<String> strings = IntStream.range(0, 4).mapToObj(n -> hexGenerator.generateRandomHex()).toList();

            StringJoiner joiner = new StringJoiner("", "u", "");
            strings.forEach(joiner::add);
            String value = joiner.toString();

            Escape parseResult = parseResultBuilder.buildParseResult(escapeParser, value);

            Escape.GeneralCase generalCase = testHelper.castTo(parseResult, Escape.GeneralCase.class);
            Assert.assertEquals('u', generalCase.u());
            Assert.assertEquals(strings.get(0), generalCase.hex1().toString());
            Assert.assertEquals(strings.get(1), generalCase.hex2().toString());
            Assert.assertEquals(strings.get(2), generalCase.hex3().toString());
            Assert.assertEquals(strings.get(3), generalCase.hex4().toString());
        }
    }
}
