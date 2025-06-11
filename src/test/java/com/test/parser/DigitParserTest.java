package com.test.parser;

import com.study.model.Digit;
import com.study.parser.DigitParser;
import com.test.parser.util.ParseResultBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class DigitParserTest {
    private final DigitParser parser = new DigitParser();
    private final ParseResultBuilder<Digit> parseResultBuilder = new ParseResultBuilder<>();

    @Test
    public void testAllCases() {
        IntStream.range(0, 10).forEach(value -> {
            Digit parseResult = parseResultBuilder.buildParseResult(parser, value + "");
            Assert.assertEquals(value + "", parseResult.toString());
        });
    }
}
