package com.test.parser.string;

import com.study.model.string.Character;
import com.study.model.string.Escape;
import com.study.parser.string.CharacterParser;
import com.study.util.StringUtils;
import com.test.For;
import com.test.parser.util.ParseResultBuilder;
import com.test.parser.util.TestHelper;
import com.test.parser.util.string.CharacterGenerator;
import com.test.parser.util.string.HexGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.IntStream;

@For(Character.class)
public class CharacterParserTest {

    private final CharacterParser parser = new CharacterParser();
    private final ParseResultBuilder<Character> parseResultBuilder = new ParseResultBuilder<>();
    private final TestHelper<Character> testHelper = new TestHelper<>();

    @For(Character.CaseOne.class)
    @Test
    public void testCaseOne() {
        CharacterGenerator characterGenerator = new CharacterGenerator();

        Class<Character.CaseOne> type = Character.CaseOne.class;

        IntStream.range(0, 100).mapToObj(i -> characterGenerator.generate(type)).forEach(generatedResult -> {
            Character parseResult = parseResultBuilder.buildParseResult(parser, generatedResult);
            Character.CaseOne caseOne = testHelper.castTo(parseResult, type);
            Assert.assertEquals(generatedResult, StringUtils.fromCodePoint(caseOne.codePoint()));
        });
    }

    @For(Character.CaseTwo.class)
    @Test
    public void testCaseTwo() {
        Escape.SpecialCase[] candidates = Escape.SpecialCase.values();
        IntStream.range(0, candidates.length).forEach(index -> {
            String candidate = '\\' + StringUtils.fromCodePoint(candidates[index].getSymbol());
            Character parseResult = parseResultBuilder.buildParseResult(parser, candidate);
            Assert.assertTrue(parseResult instanceof Character.CaseTwo);
            Assert.assertTrue(((Character.CaseTwo) parseResult).escape() instanceof Escape.SpecialCase);
            int symbol = ((Escape.SpecialCase) ((Character.CaseTwo) parseResult).escape()).getSymbol();
            Assert.assertEquals(candidate, '\\' + StringUtils.fromCodePoint(symbol));
        });

        HexGenerator hexGenerator = new HexGenerator();
        for (int i = 0; i < 100; i++) {
            List<String> strings = IntStream.range(0, 4).mapToObj(n -> hexGenerator.generateRandomHex()).toList();

            StringJoiner joiner = new StringJoiner("", "\\u", "");
            strings.forEach(joiner::add);
            String value = joiner.toString();

            Character parseResult = parseResultBuilder.buildParseResult(parser, value);

            Assert.assertTrue(parseResult instanceof Character.CaseTwo);
            Assert.assertTrue(((Character.CaseTwo) parseResult).escape() instanceof Escape.GeneralCase);
            Escape.GeneralCase generalCase = ((Escape.GeneralCase) ((Character.CaseTwo) parseResult).escape());
            Assert.assertEquals('u', generalCase.u());
            Assert.assertEquals(strings.get(0), generalCase.hex1().toString());
            Assert.assertEquals(strings.get(1), generalCase.hex2().toString());
            Assert.assertEquals(strings.get(2), generalCase.hex3().toString());
            Assert.assertEquals(strings.get(3), generalCase.hex4().toString());
        }
    }
}
