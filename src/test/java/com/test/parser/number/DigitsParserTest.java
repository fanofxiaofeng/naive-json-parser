package com.test.parser.number;

import com.study.model.number.Digits;
import com.study.parser.number.DigitsParser;
import com.test.parser.TestBase;
import com.test.parser.util.DigitsHandler;
import com.test.parser.util.ParseResultBuilder;
import com.test.parser.util.number.DigitsGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.util.StringJoiner;
import java.util.stream.IntStream;

public class DigitsParserTest extends TestBase {

    private final DigitsParser digitsParser = new DigitsParser();
    private final DigitsHandler digitsHandler = new DigitsHandler();
    private final ParseResultBuilder<Digits> parseResultBuilder = new ParseResultBuilder<>();

    @Test
    public void testCaseOne() {
        IntStream.range(0, 10).forEach(value -> {
            Digits parseResult = parseResultBuilder.buildParseResult(digitsParser, value + "");
            Assert.assertTrue(parseResult instanceof Digits.CaseOne);
            Assert.assertEquals(value + "", ((Digits.CaseOne) parseResult).digit().toString());
        });
    }

    @Test
    public void testCaseTwo() {
        DigitsGenerator generator = new DigitsGenerator(20);
        for (int i = 0; i < 100; i++) {
            String raw = generator.generate();
            Digits parseResult = parseResultBuilder.buildParseResult(digitsParser, raw);
            StringJoiner joiner = new StringJoiner("");
            digitsHandler.fillJoiner(parseResult, joiner);
            Assert.assertEquals(raw, joiner.toString());
        }
    }
}
