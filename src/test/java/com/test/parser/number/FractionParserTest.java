package com.test.parser.number;

import com.study.model.number.Fraction;
import com.study.parser.number.FractionParser;
import com.test.parser.util.DigitsHandler;
import com.test.parser.util.ParseResultBuilder;
import com.test.parser.util.number.FractionGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.util.StringJoiner;

public class FractionParserTest {

    private final FractionGenerator fractionGenerator = new FractionGenerator();
    private final FractionParser fractionParser = new FractionParser();
    private final ParseResultBuilder<Fraction> parseResultBuilder = new ParseResultBuilder<>();
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
