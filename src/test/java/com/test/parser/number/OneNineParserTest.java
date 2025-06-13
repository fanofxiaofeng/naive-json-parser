package com.test.parser.number;

import com.study.model.number.OneNine;
import com.study.parser.number.OneNineParser;
import com.test.For;
import com.test.parser.util.ParseResultBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

@For(OneNine.class)
public class OneNineParserTest {

    private final OneNineParser parser = new OneNineParser();
    private final ParseResultBuilder<OneNine> parseResultBuilder = new ParseResultBuilder<>();

    @For(value = OneNine.class, desc = "For all cases, i.e. 1, 2, 3, ... 9")
    @Test
    public void testAllCases() {
        IntStream.range(1, 10).forEach(v -> {
            OneNine parseResult = parseResultBuilder.buildParseResult(parser, v + "");
            Assert.assertEquals(v + "", parseResult.toString());
        });
    }
}
