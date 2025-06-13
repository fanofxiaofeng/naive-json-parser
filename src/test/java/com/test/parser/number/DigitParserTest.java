package com.test.parser.number;

import com.study.model.number.Digit;
import com.study.model.number.OneNine;
import com.study.model.number.Zero;
import com.study.parser.number.DigitParser;
import com.study.parser.number.DigitsParser;
import com.test.For;
import com.test.parser.util.ParseResultBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

@For({Digit.class, DigitsParser.class})
public class DigitParserTest {

    private final DigitParser parser = new DigitParser();
    private final ParseResultBuilder<Digit> parseResultBuilder = new ParseResultBuilder<>();

    @For({Zero.class, OneNine.class})
    @Test
    public void testAllCases() {
        IntStream.range(0, 10).forEach(value -> {
            Digit parseResult = parseResultBuilder.buildParseResult(parser, value + "");
            Assert.assertEquals(value + "", parseResult.toString());
        });
    }
}
