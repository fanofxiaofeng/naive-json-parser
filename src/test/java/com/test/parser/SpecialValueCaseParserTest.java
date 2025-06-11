package com.test.parser;

import com.study.model.Value;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.stream.Stream;

public class SpecialValueCaseParserTest extends TestBase {

    @Test
    public void testNullCase() {
        validate("null", Value.CaseNull.class);
    }

    @Test
    public void testInvalidNullCase() {
        Stream.of(
                "Null",
                "NULL",
                "nulll",
                "nul"
        ).forEach(badValue -> Assert.assertThrows(IllegalArgumentException.class, () -> validate(badValue, Value.CaseNull.class)));
    }

    @Test
    public void testTrueCase() {
        validate("true", Value.CaseTrue.class);
    }

    @Test
    public void testInvalidTrueCase() {
        Stream.of(
                "True",
                "TRUE",
                "truee",
                "truth",
                "t",
                "T"
        ).forEach(badValue -> Assert.assertThrows(IllegalArgumentException.class, () -> validate(badValue, Value.CaseTrue.class)));
    }

    @Test
    public void testFalseCase() {
        validate("false", Value.CaseFalse.class);
    }

    @Test
    public void testInvalidFalseCase() {
        Stream.of(
                "False",
                "FALSE",
                "falsee",
                "falsy",
                "f",
                "F"
        ).forEach(badValue -> Assert.assertThrows(IllegalArgumentException.class, () -> validate(badValue, Value.CaseTrue.class)));
    }

    @Test
    public void testWithFile() throws IOException {
        testWithFile("cases/simple/true.json");
        testWithFile("cases/simple/false.json");
        testWithFile("cases/simple/null.json");
    }
}
