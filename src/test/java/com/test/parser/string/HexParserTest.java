package com.test.parser.string;

import com.study.model.string.Hex;
import com.study.parser.string.HexParser;
import com.study.util.StringUtils;
import com.test.For;
import com.test.parser.util.ParseResultBuilder;
import com.test.parser.util.TestHelper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

@For(Hex.class)
public class HexParserTest {

    private final HexParser parser = new HexParser();
    private final ParseResultBuilder<Hex> parseResultBuilder = new ParseResultBuilder<>();
    private final TestHelper<Hex> testHelper = new TestHelper<>();

    @For(Hex.DigitCase.class)
    @Test
    public void testDigitCase() {
        IntStream.range(0, 10).forEach(value -> {
            Hex parseResult = parseResultBuilder.buildParseResult(parser, value + "");
            Hex.DigitCase digitCase = testHelper.castTo(parseResult, Hex.DigitCase.class);
            Assert.assertEquals(value + "", digitCase.digit().toString());
        });
    }

    @For(Hex.LetterCase.class)
    @Test
    public void testLetterCaseCase() {
        Arrays.stream(Hex.LetterCase.values()).forEach(e -> {
            String candidate = e.toString();
            Hex parseResult = parseResultBuilder.buildParseResult(parser, candidate);
            Hex.LetterCase letterCase = testHelper.castTo(parseResult, Hex.LetterCase.class);
            Assert.assertEquals(candidate, StringUtils.fromCodePoint(letterCase.getSymbol()));
        });
    }
}
