package com.test.parser;

import com.study.model.Json;
import com.test.parser.util.RandomCharacterGenerator;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.StringJoiner;
import java.util.function.IntConsumer;
import java.util.stream.Stream;

public class StringParserTest extends TestBase {

    private final RandomCharacterGenerator characterGenerator = new RandomCharacterGenerator();

    @Test
    public void testQuotationMark() {
        Stream.of(
                "\"\\\"\"", // "\""
                "\"\\u0022\""
        ).forEach(value -> validate(value, com.study.model.String.class));
    }

    @Test
    public void testReverseSolidus() {
        Stream.of(
                "\"\\\\\"", // "\\"
                "\"\\u005c\"",
                "\"\\u005C\""
        ).forEach(value -> validate(value, com.study.model.String.class));
    }

    @Test
    public void testSolidus() {
        Stream.of(
                "\"\\/\"", // "\/"
                "\"/\"", // "/"
                "\"\\u002f\"",
                "\"\\u002F\""
        ).forEach(value -> validate(value, com.study.model.String.class));
    }

    @Test
    public void testBackspace() {
        Stream.of(
                "\"\\b\"", // "\b"
                "\"\\u0008\""
        ).forEach(value -> validate(value, com.study.model.String.class));
    }

    @Test
    public void testFormfeed() {
        Stream.of(
                "\"\\f\"", // "\f"
                "\"\\u000c\"",
                "\"\\u000C\""
        ).forEach(value -> validate(value, com.study.model.String.class));
    }

    @Test
    public void testLinefeed() {
        Stream.of(
                "\"\\n\"", // "\n"
                "\"\\u000a\"",
                "\"\\u000A\""
        ).forEach(value -> validate(value, com.study.model.String.class));
    }

    @Test
    public void testCarriageReturn() {
        Stream.of(
                "\"\\r\"", // "\r"
                "\"\\u000d\"",
                "\"\\u000D\""
        ).forEach(value -> validate(value, com.study.model.String.class));
    }

    @Test
    public void testHorizontalTab() {
        Stream.of(
                "\"\\t\"", // "\t"
                "\"\\u0009\""
        ).forEach(value -> validate(value, com.study.model.String.class));
    }

    @Test
    public void testHex() {
        IntConsumer validateCodePoint = (cp) -> {
            String lowerHex = StringUtils.leftPad(Integer.toHexString(cp), 4, '0');
            String upperHex = lowerHex.toUpperCase(Locale.US);
            Stream.of(lowerHex, upperHex).forEach(h -> {
                String fullForm = String.format("\"\\u%s\"", h);
                validate(fullForm, com.study.model.String.class);
                Json json = parse(fullForm);
                String result = present(json);
                Assert.assertEquals(fullForm.trim(), result.trim());
            });
        };

        // Test for small code points
        for (int i = 0; i <= 0x100; i++) {
            validateCodePoint.accept(i);
        }

        // Random code point test
        for (int i = 0; i < 100; i++) {
            int cp = random.nextInt(0x10FFFF + 1);
            validateCodePoint.accept(cp);
        }
    }

    @Test
    public void test() {
        Stream.of(
                "\"\"",
                "\"Hello world\"",
                "\"a\\r\\nb\\tc d\\r\\n\"",
                "\"\\ud83d\\ude02 \\n\""
        ).forEach(value -> validate(value, com.study.model.String.class));

        for (int i = 0; i < 100; i++) {
            int len = 1 + random.nextInt(20);
            StringJoiner joiner = new StringJoiner("", "\"", "\"");
            for (int j = 0; j < len; j++) {
                joiner.add(characterGenerator.generate());
            }
            System.out.println(i);
            System.out.println(joiner);
            validate(joiner.toString(), com.study.model.String.class);
        }
    }

    @Test
    public void testWithFile() throws IOException {
        String s = readContentAsString("cases/simple/string1.json");
        Json json = parse(s);
        String result = present(json);
        System.out.println(result);
        Assert.assertEquals(s.trim(), result.trim());
    }
}
