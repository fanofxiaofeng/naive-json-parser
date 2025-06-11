package com.test.parser;

import com.study.model.OneNine;
import com.study.parser.OneNineParser;
import com.test.parser.util.ParseResultBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class OneNineParserTest {
    private final OneNineParser parser = new OneNineParser();
    private final ParseResultBuilder<OneNine> parseResultBuilder = new ParseResultBuilder<>();

    @Test
    public void testAllCases() {
        IntStream.range(1, 10).forEach(v -> {
            OneNine parseResult = parseResultBuilder.buildParseResult(parser, v + "");
            Assert.assertEquals(v + "", parseResult.toString());
        });
    }
}
