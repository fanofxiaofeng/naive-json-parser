package com.test.parser.number;

import com.study.model.number.Exponent;
import com.study.parser.number.ExponentParser;
import com.test.For;
import com.test.parser.util.DigitsHandler;
import com.test.parser.util.ParseResultBuilder;
import com.test.parser.util.TestHelper;
import com.test.parser.util.number.ExponentGenerator;
import org.junit.Assert;
import org.junit.Test;

@For(Exponent.class)
public class ExponentParserTest {

    private final ExponentGenerator exponentGenerator = new ExponentGenerator();
    private final ExponentParser exponentParser = new ExponentParser();
    private final ParseResultBuilder<Exponent> parseResultBuilder = new ParseResultBuilder<>();
    private final DigitsHandler digitsHandler = new DigitsHandler();
    private final TestHelper<Exponent> testHelper = new TestHelper<>();

    @For(value = Exponent.EmptyCase.class, desc = "EmptyCase, i.e. \"\"")
    @Test
    public void testEmptyCase() {
        String generatedResult = exponentGenerator.generate(Exponent.EmptyCase.class);
        Exponent parseResult = parseResultBuilder.buildParseResult(exponentParser, generatedResult);
        Assert.assertTrue(parseResult instanceof Exponent.EmptyCase);
    }

    @For(Exponent.UppercaseECase.class)
    @Test
    public void testUppercaseECase() {
        Class<Exponent.UppercaseECase> type = Exponent.UppercaseECase.class;

        String generatedResult = exponentGenerator.generate(type);
        Exponent parseResult = parseResultBuilder.buildParseResult(exponentParser, generatedResult);
        Exponent.UppercaseECase uppercaseECase = testHelper.castTo(parseResult, type);
        String joinedResult = digitsHandler.buildJoinedResult(uppercaseECase.digits(), "E", uppercaseECase.sign());
        Assert.assertEquals(generatedResult, joinedResult);
    }

    @For(Exponent.LowercaseECase.class)
    @Test
    public void testLowercaseECase() {
        Class<Exponent.LowercaseECase> type = Exponent.LowercaseECase.class;

        String generatedResult = exponentGenerator.generate(type);
        Exponent parseResult = parseResultBuilder.buildParseResult(exponentParser, generatedResult);
        Exponent.LowercaseECase lowercaseECase = testHelper.castTo(parseResult, type);
        String joinedResult = digitsHandler.buildJoinedResult(lowercaseECase.digits(), "e", lowercaseECase.sign());
        Assert.assertEquals(generatedResult, joinedResult);
    }
}