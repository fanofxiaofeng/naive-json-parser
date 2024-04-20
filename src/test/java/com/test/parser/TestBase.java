package com.test.parser;

import com.study.model.Json;
import com.study.parser.JsonParser;
import com.study.presenter.PresenterFacade;
import org.apache.commons.collections4.iterators.PeekingIterator;
import org.junit.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public abstract class TestBase {
    protected Json parse(String s) {
        PeekingIterator<Integer> peekingIterator = new PeekingIterator<>(s.codePoints().iterator());
        return new JsonParser().parse(peekingIterator);
    }

    protected String present(Json json) {
        PresenterFacade presenterFacade = new PresenterFacade();
        return presenterFacade.convertToString(json);
    }

    protected String present(Json json, int indentWidthForEachLevel) {
        PresenterFacade presenterFacade = new PresenterFacade(indentWidthForEachLevel);
        return presenterFacade.convertToString(json);
    }

    protected String removeWhitespace(String s) {
        return s.replaceAll("[\t\r\n ]", "");
    }

    protected String readContentAsString(String name) throws IOException {
        try (InputStream inputStream = NumberParserTest.class.getClassLoader().getResourceAsStream(name)) {
            if (inputStream == null) {
                throw new IllegalArgumentException(String.format("resource: [%s] seems to be missing", name));
            }
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    protected void testWithFile(String name) throws IOException {
        String s = readContentAsString(name);
        Json json = parse(s);
        String result = present(json);
//        System.out.println(result);
        Assert.assertEquals(s.trim(), result.trim());
    }
}
