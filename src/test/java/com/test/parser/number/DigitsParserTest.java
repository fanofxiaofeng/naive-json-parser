package com.test.parser.number;

import com.study.model.number.Digits;
import com.study.parser.number.DigitsParser;
import com.test.For;
import com.test.parser.util.DigitsHandler;
import com.test.parser.util.ParseResultBuilder;
import com.test.parser.util.TestHelper;
import com.test.parser.util.number.DigitsGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

@For(Digits.class)
public class DigitsParserTest {

    private final DigitsParser digitsParser = new DigitsParser();
    private final DigitsHandler digitsHandler = new DigitsHandler();
    private final ParseResultBuilder<Digits> parseResultBuilder = new ParseResultBuilder<>();
    private final TestHelper<Digits> testHelper = new TestHelper<>();

    @For(value = Digits.CaseOne.class, desc = "One digit case (i.e. 0, 1, ... 9)")
    @Test
    public void testCaseOne() {
        IntStream.range(0, 10).forEach(value -> {
            Digits parseResult = parseResultBuilder.buildParseResult(digitsParser, value + "");
            Digits.CaseOne caseOne = testHelper.castTo(parseResult, Digits.CaseOne.class);
            Assert.assertEquals(value + "", caseOne.digit().toString());
        });
    }

    @For(Digits.CaseTwo.class)
    @Test
    public void testCaseTwo() {
        DigitsGenerator generator = new DigitsGenerator(20);
        IntStream.range(0, 100).mapToObj(i -> generator.generate(Digits.CaseTwo.class)).forEach(generatedValue -> {
            Digits parseResult = parseResultBuilder.buildParseResult(digitsParser, generatedValue);
//            System.out.println(parseResult);
            Digits.CaseTwo caseTwo = testHelper.castTo(parseResult, Digits.CaseTwo.class);
            String joinedResult = digitsHandler.buildJoinedResult(caseTwo);
            Assert.assertEquals(generatedValue, joinedResult);
        });
    }
}
