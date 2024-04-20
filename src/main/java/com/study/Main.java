package com.study;

import com.study.model.Json;
import com.study.parser.JsonParser;
import com.study.presenter.JsonPresenter;
import org.apache.commons.collections4.iterators.PeekingIterator;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        try (InputStream inputStream = System.in) {
            byte[] bytes = inputStream.readAllBytes();
            String raw = new String(bytes, StandardCharsets.UTF_8);

            JsonParser jsonParser = new JsonParser();
            Json json = jsonParser.parse(new PeekingIterator<>(raw.codePoints().iterator()));

            JsonPresenter jsonPresenter = new JsonPresenter();
            jsonPresenter.present(json);
            String output = jsonPresenter.collect();
            System.out.println(output);
        }
    }
}
