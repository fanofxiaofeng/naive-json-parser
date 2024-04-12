package com.study.parser;

import com.study.model.Json;
import com.study.presenter.JsonPresenter;
import org.apache.commons.collections4.iterators.PeekingIterator;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        JsonParser jsonParser = new JsonParser();
        InputStream inputStream = System.in;
        byte[] bytes = inputStream.readAllBytes();
        String raw = new String(bytes);
        Json json = jsonParser.parse(new PeekingIterator<>(raw.codePoints().iterator()));
        JsonPresenter jsonPresenter = new JsonPresenter();
        jsonPresenter.present(json);
    }
}
