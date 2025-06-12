package com.test.parser.number;

import com.study.model.number.Integer;
import com.study.model.number.Digit;
import com.study.model.number.OneNine;
import com.study.model.number.Zero;
import com.study.parser.number.IntegerParser;
import com.test.parser.util.DigitsHandler;
import com.test.parser.util.ParseResultBuilder;
import com.test.parser.util.RelationBasedGenerator;
import com.test.parser.util.number.IntegerGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.lang.String;
import java.util.StringJoiner;

public class IntegerParserTest {

    private final RelationBasedGenerator<Integer> integerGenerator = new IntegerGenerator();

    private final IntegerParser integerParser = new IntegerParser();

    private final ParseResultBuilder<Integer> parseResultBuilder = new ParseResultBuilder<>();

    private final DigitsHandler digitsHandler = new DigitsHandler();

    @Test
    public void testCaseOne() {
        String generatedResult = integerGenerator.generate(Integer.CaseOne.class);
        Integer parseResult = parseResultBuilder.buildParseResult(integerParser, generatedResult);

        Assert.assertTrue(parseResult instanceof Integer.CaseOne);

        Digit digit = ((Integer.CaseOne) parseResult).digit();
        Assert.assertTrue(digit instanceof Zero || digit instanceof OneNine);
        Assert.assertEquals(generatedResult, digit.toString());
    }

    @Test
    public void testCaseTwo() {
        String generatedResult = integerGenerator.generate(Integer.CaseTwo.class);
        Integer parseResult = parseResultBuilder.buildParseResult(integerParser, generatedResult);

        Assert.assertTrue(parseResult instanceof Integer.CaseTwo);

        StringJoiner joiner = new StringJoiner("");

        Digit digit = ((Integer.CaseTwo) parseResult).oneNine();
        joiner.add(digit.toString());
        digitsHandler.fillJoiner(((Integer.CaseTwo) parseResult).digits(), joiner);

        Assert.assertEquals(generatedResult, joiner.toString());
    }

    @Test
    public void testCaseThree() {
        String generatedResult = integerGenerator.generate(Integer.CaseThree.class);
        Integer parseResult = parseResultBuilder.buildParseResult(integerParser, generatedResult);

        Assert.assertTrue(parseResult instanceof Integer.CaseThree);

        Digit digit = ((Integer.CaseThree) parseResult).digit();
        Assert.assertTrue(digit instanceof Zero || digit instanceof OneNine);
        Assert.assertEquals(generatedResult, "-" + digit);
    }

    @Test
    public void testCaseFour() {
        String generatedResult = integerGenerator.generate(Integer.CaseFour.class);
        Integer parseResult = parseResultBuilder.buildParseResult(integerParser, generatedResult);

        Assert.assertTrue(parseResult instanceof Integer.CaseFour);

        StringJoiner joiner = new StringJoiner("", "-", "");

        Digit digit = ((Integer.CaseFour) parseResult).oneNine();
        joiner.add(digit.toString());
        digitsHandler.fillJoiner(((Integer.CaseFour) parseResult).digits(), joiner);

        Assert.assertEquals(generatedResult, joiner.toString());
    }
}
