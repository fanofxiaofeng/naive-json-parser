package com.test.parser;

import com.study.model.Exponent;
import com.study.parser.ExponentParser;
import com.test.parser.util.DigitsHandler;
import com.test.parser.util.ParseResultBuilder;
import com.test.parser.util.RandomExponentGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.util.StringJoiner;

public class ExponentParserTest {
    private final RandomExponentGenerator exponentGenerator = new RandomExponentGenerator();
    private final ExponentParser exponentParser = new ExponentParser();
    private final ParseResultBuilder<Exponent> parseResultBuilder = new ParseResultBuilder<>();
    private final DigitsHandler digitsHandler = new DigitsHandler();

    @Test
    public void testEmptyCase() {
        String generatedResult = exponentGenerator.generate(Exponent.EmptyCase.class);
        Exponent parseResult = parseResultBuilder.buildParseResult(exponentParser, generatedResult);
        Assert.assertTrue(parseResult instanceof Exponent.EmptyCase);
    }

    @Test
    public void testUppercaseECase() {
        String generatedResult = exponentGenerator.generate(Exponent.UppercaseECase.class);
        Exponent parseResult = parseResultBuilder.buildParseResult(exponentParser, generatedResult);
        Assert.assertTrue(parseResult instanceof Exponent.UppercaseECase);

        StringJoiner joiner = new StringJoiner("", "E", "");
        joiner.add(((Exponent.UppercaseECase) parseResult).sign().toString());
        digitsHandler.fillJoiner(((Exponent.UppercaseECase) parseResult).digits(), joiner);
        Assert.assertEquals(generatedResult, joiner.toString());
    }

    @Test
    public void testLowercaseECase() {
        String generatedResult = exponentGenerator.generate(Exponent.LowercaseECase.class);
        Exponent parseResult = parseResultBuilder.buildParseResult(exponentParser, generatedResult);
        Assert.assertTrue(parseResult instanceof Exponent.LowercaseECase);

        StringJoiner joiner = new StringJoiner("", "e", "");
        joiner.add(((Exponent.LowercaseECase) parseResult).sign().toString());
        digitsHandler.fillJoiner(((Exponent.LowercaseECase) parseResult).digits(), joiner);
        Assert.assertEquals(generatedResult, joiner.toString());
    }
}