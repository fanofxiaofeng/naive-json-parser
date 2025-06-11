package com.test.parser;

import com.study.model.Fraction;
import com.study.parser.FractionParser;
import com.test.parser.util.DigitsHandler;
import com.test.parser.util.ParseResultBuilder;
import com.test.parser.util.RandomFractionGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.util.StringJoiner;

public class FractionParserTest {

    private final RandomFractionGenerator fractionGenerator = new RandomFractionGenerator();
    private final FractionParser fractionParser = new FractionParser();
    private final ParseResultBuilder<com.study.model.Fraction> parseResultBuilder = new ParseResultBuilder<>();
    private final DigitsHandler digitsHandler = new DigitsHandler();

    @Test
    public void testEmptyCase() {
        String generatedResult = fractionGenerator.generate(Fraction.EmptyCase.class);
        Fraction parseResult = parseResultBuilder.buildParseResult(fractionParser, generatedResult);
        Assert.assertTrue(parseResult instanceof Fraction.EmptyCase);
    }

    @Test
    public void testNormalCase() {
        String generatedResult = fractionGenerator.generate(Fraction.NormalCase.class);
        Fraction parseResult = parseResultBuilder.buildParseResult(fractionParser, generatedResult);
        Assert.assertTrue(parseResult instanceof Fraction.NormalCase);

        StringJoiner joiner = new StringJoiner("", ".", "");
        digitsHandler.fillJoiner(((Fraction.NormalCase) parseResult).digits(), joiner);
        Assert.assertEquals(generatedResult, joiner.toString());
    }
}
