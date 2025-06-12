package com.test.parser.string;

import com.study.model.string.Hex;
import com.study.parser.string.HexParser;
import com.study.util.StringUtils;
import com.test.parser.util.ParseResultBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class HexParserTest {

    private final HexParser parser = new HexParser();
    private final ParseResultBuilder<Hex> parseResultBuilder = new ParseResultBuilder<>();

    @Test
    public void testDigitCase() {
        IntStream.range(0, 10).forEach(value -> {
            Hex parseResult = parseResultBuilder.buildParseResult(parser, value + "");
            Assert.assertTrue(parseResult instanceof Hex.DigitCase);
            Assert.assertEquals(value + "", ((Hex.DigitCase) parseResult).digit().toString());
        });
    }

    @Test
    public void testLetterCaseCase() {
        Hex[] candidates = Hex.LetterCase.values();
        IntStream.range(0, candidates.length).forEach(index -> {
            String candidate = candidates[index].toString();
            Hex parseResult = parseResultBuilder.buildParseResult(parser, candidate);
            Assert.assertTrue(parseResult instanceof Hex.LetterCase);
            Assert.assertEquals(candidate, StringUtils.fromCodePoint(((Hex.LetterCase) parseResult).getSymbol()));
        });
    }
}
