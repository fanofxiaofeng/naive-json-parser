//package com.test.parser;
//
//import com.study.model.string.Characters;
//import com.study.parser.string.CharactersParser;
//import com.test.parser.util.ParseResultBuilder;
//import com.test.parser.util.string.RandomCharacterGenerator;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.StringJoiner;
//import java.util.stream.IntStream;
//
//public class CharactersParserTest extends TestBase {
//    private final CharactersParser parser = new CharactersParser();
//    private final ParseResultBuilder<Characters> parseResultBuilder = new ParseResultBuilder<>();
//
//    @Test
//    public void testCaseOne() {
//        Characters parseResult = parseResultBuilder.buildParseResult(parser, "");
//        Assert.assertTrue(parseResult instanceof Characters.CaseOne);
//        Assert.assertEquals("", parseResult.toString());
//    }
//
//    @Test
//    public void testCaseTwo() {
//        RandomCharacterGenerator randomCharacterGenerator = new RandomCharacterGenerator();
//        for (int i = 0; i < 100; i++) {
//            int length = 1 + random.nextInt(20);
//            StringJoiner joiner = new StringJoiner("");
//            IntStream.range(0, length).forEach(x -> joiner.add(randomCharacterGenerator.generate()));
//            String v = joiner.toString();
//            System.out.printf("v is [%s]%n", v);
//            Characters parseResult = parseResultBuilder.buildParseResult(parser, v);
//            Assert.assertTrue(parseResult instanceof Characters.CaseTwo);
//            Assert.assertEquals(v, parseResult.toString());
//        }
//    }
//}
