package com.test.parser.number;

import com.study.model.number.Fraction;
import com.study.parser.number.FractionParser;
import com.test.For;
import com.test.parser.util.DigitsHandler;
import com.test.parser.util.ParseResultBuilder;
import com.test.parser.util.TestHelper;
import com.test.parser.util.number.FractionGenerator;
import org.junit.Assert;
import org.junit.Test;

@For(Fraction.class)
public class FractionParserTest {

    private final FractionGenerator fractionGenerator = new FractionGenerator();
    private final FractionParser fractionParser = new FractionParser();
    private final ParseResultBuilder<Fraction> parseResultBuilder = new ParseResultBuilder<>();
    private final DigitsHandler digitsHandler = new DigitsHandler();
    private final TestHelper<Fraction> testHelper = new TestHelper<>();

    @For(value = Fraction.EmptyCase.class, desc = "EmptyCase, i.e. \"\"")
    @Test
    public void testEmptyCase() {
        String generatedResult = fractionGenerator.generate(Fraction.EmptyCase.class);
        Fraction parseResult = parseResultBuilder.buildParseResult(fractionParser, generatedResult);
        Assert.assertTrue(parseResult instanceof Fraction.EmptyCase);
    }

    @For(Fraction.NormalCase.class)
    @Test
    public void testNormalCase() {
        Class<Fraction.NormalCase> type = Fraction.NormalCase.class;

        String generatedResult = fractionGenerator.generate(type);
        Fraction parseResult = parseResultBuilder.buildParseResult(fractionParser, generatedResult);

        Fraction.NormalCase normalCase = testHelper.castTo(parseResult, type);
        String joinedResult = digitsHandler.buildJoinedResult(normalCase.digits(), ".");
        Assert.assertEquals(generatedResult, joinedResult);
    }
}
