package com.test.parser.number;

import com.study.model.number.Digit;
import com.study.parser.number.DigitParser;
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
