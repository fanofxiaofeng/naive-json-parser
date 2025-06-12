package com.test.parser.number;

import com.study.model.number.Sign;
import com.study.parser.number.SignParser;
import com.test.parser.util.ParseResultBuilder;
import org.junit.Assert;
import org.junit.Test;

public class SignParserTest {
    private final SignParser signParser = new SignParser();
    private final ParseResultBuilder<Sign> parseResultBuilder = new ParseResultBuilder<>();

    @Test
    public void testAbsentCase() {
        Sign parseResult = parseResultBuilder.buildParseResult(signParser, "");
        Assert.assertSame(Sign.ABSENT, parseResult);
    }

    @Test
    public void testNegativeCase() {
        Sign parseResult = parseResultBuilder.buildParseResult(signParser, "-");
        Assert.assertSame(Sign.NEGATIVE, parseResult);
    }

    @Test
    public void testPositiveCase() {
        Sign parseResult = parseResultBuilder.buildParseResult(signParser, "+");
        Assert.assertSame(Sign.POSITIVE, parseResult);
    }
}
