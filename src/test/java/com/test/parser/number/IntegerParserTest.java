package com.test.parser.number;

import com.study.model.number.Integer;
import com.study.model.number.Digit;
import com.study.parser.number.IntegerParser;
import com.test.For;
import com.test.parser.util.DigitsHandler;
import com.test.parser.util.ParseResultBuilder;
import com.test.parser.util.TestHelper;
import com.test.parser.util.number.IntegerGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.lang.String;

@For(Integer.class)
public class IntegerParserTest {

    private final IntegerGenerator integerGenerator = new IntegerGenerator();
    private final IntegerParser integerParser = new IntegerParser();
    private final ParseResultBuilder<Integer> parseResultBuilder = new ParseResultBuilder<>();
    private final DigitsHandler digitsHandler = new DigitsHandler();
    private final TestHelper<Integer> testHelper = new TestHelper<>();

    @For(value = Integer.CaseOne.class, desc = "For CaseOne, i.e. 0, 1, 2, ... 9")
    @Test
    public void testCaseOne() {
        Class<Integer.CaseOne> type = Integer.CaseOne.class;

        String generatedResult = integerGenerator.generate(type);
        Integer parseResult = parseResultBuilder.buildParseResult(integerParser, generatedResult);

        Integer.CaseOne caseOne = testHelper.castTo(parseResult, type);
        Digit digit = caseOne.digit();
        Assert.assertEquals(generatedResult, digit.toString());
    }

    @For(Integer.CaseTwo.class)
    @Test
    public void testCaseTwo() {
        Class<Integer.CaseTwo> type = Integer.CaseTwo.class;

        String generatedResult = integerGenerator.generate(type);
        Integer parseResult = parseResultBuilder.buildParseResult(integerParser, generatedResult);

        Integer.CaseTwo caseTwo = testHelper.castTo(parseResult, type);
        Digit digit = caseTwo.oneNine();
        String joinedResult = digitsHandler.buildJoinedResult(caseTwo.digits(), digit);
        Assert.assertEquals(generatedResult, joinedResult);
    }

    @For(Integer.CaseThree.class)
    @Test
    public void testCaseThree() {
        Class<Integer.CaseThree> type = Integer.CaseThree.class;

        String generatedResult = integerGenerator.generate(type);
        Integer parseResult = parseResultBuilder.buildParseResult(integerParser, generatedResult);

        Integer.CaseThree caseThree = testHelper.castTo(parseResult, type);
        Digit digit = caseThree.digit();
        Assert.assertEquals(generatedResult, "-" + digit);
    }

    @For(Integer.CaseFour.class)
    @Test
    public void testCaseFour() {
        Class<Integer.CaseFour> type = Integer.CaseFour.class;

        String generatedResult = integerGenerator.generate(type);
        Integer parseResult = parseResultBuilder.buildParseResult(integerParser, generatedResult);

        Integer.CaseFour caseFour = testHelper.castTo(parseResult, type);
        Digit digit = caseFour.oneNine();
        String joinedResult = digitsHandler.buildJoinedResult(caseFour.digits(), "-", digit);
        Assert.assertEquals(generatedResult, joinedResult);
    }
}
