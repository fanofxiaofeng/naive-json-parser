package com.test.parser;

import com.study.model.Whitespace;
import com.study.parser.WhitespaceParser;
import com.test.parser.util.ParseResultBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class WhitespaceParserTest extends TestBase {
    private final WhitespaceParser parser = new WhitespaceParser();
    private final ParseResultBuilder<Whitespace> parseResultBuilder = new ParseResultBuilder<>();

    @Test
    public void testEmptyCase() {
        Whitespace parseResult = parseResultBuilder.buildParseResult(parser, "");
        Assert.assertTrue(parseResult instanceof Whitespace.EmptyCase);
        Assert.assertEquals("", parseResult.toString());
    }

    @Test
    public void testNormalCase() {
        int[] candidates = new int[]{0x0020, 0x000A, 0x000D, 0x0009};
        for (int i = 0; i < 100; i++) {
            int len = 1 + random.nextInt(20);
            int[] components = new int[len];
            IntStream.range(0, len).forEach(index -> components[index] = candidates[random.nextInt(candidates.length)]);
            Whitespace parseResult = parseResultBuilder.buildParseResult(parser, new String(components, 0, components.length));
            Whitespace remainingPart = parseResult;
            Assert.assertTrue(parseResult instanceof Whitespace.NormalCase);
            for (int j = 0; j < len; j++) {
                Assert.assertEquals(components[j], ((Whitespace.NormalCase) remainingPart).codePoint());
                remainingPart = ((Whitespace.NormalCase) remainingPart).whitespace();
            }
            Assert.assertTrue(remainingPart instanceof Whitespace.EmptyCase);
        }
    }
}
