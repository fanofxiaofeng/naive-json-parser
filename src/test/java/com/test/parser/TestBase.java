package com.test.parser;

import com.study.model.Json;
import com.study.model.Value;
import com.study.parser.JsonParser;
import com.study.presenter.PresenterFacade;
import org.apache.commons.collections4.iterators.PeekingIterator;
import org.junit.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.stream.Stream;

public abstract class TestBase {

    protected final Random random = new Random();

    private final JsonParser jsonParser = new JsonParser();

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

    protected String readContentAsString(String name) throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(name)) {
            if (inputStream == null) {
                throw new IllegalArgumentException(String.format("resource: [%s] seems to be missing", name));
            }
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    protected <T extends Value> void validate(String value, Class<T> expectedClass) {
        Stream.of(
                value,
                String.format(" \t\n\r%s", value),
                String.format("%s \t\n\r", value),
                String.format(" \t\n\r\r\n\n\t %s    \r\n\n\n\t\t  ", value)
        ).forEach(s -> {
            PeekingIterator<java.lang.Integer> peekingIterator = new PeekingIterator<>(s.codePoints().iterator());
            Json json = jsonParser.parse(peekingIterator);
            Assert.assertSame(expectedClass, json.element().value().getClass());
        });
    }

    protected void testWithFile(String name) throws IOException {
        String s = readContentAsString(name);
        Json json = parse(s);
        String result = present(json);
//        System.out.println(result);
        Assert.assertEquals(s.trim(), result.trim());
    }
}
