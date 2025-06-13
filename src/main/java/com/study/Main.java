package com.study;

import com.study.model.Json;
import com.study.parser.JsonParser;
import com.study.presenter.PresenterFacade;
import com.study.util.SimpleOptionHandler;
import org.apache.commons.collections4.iterators.PeekingIterator;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException {
        SimpleOptionHandler optionHandler = new SimpleOptionHandler(args);

        try (InputStream inputStream = optionHandler.isFileSpecified() ? new FileInputStream(optionHandler.getFileName()) : System.in) {
            byte[] bytes = inputStream.readAllBytes();
            String raw = new String(bytes, StandardCharsets.UTF_8);

            JsonParser jsonParser = new JsonParser();
            Json json = jsonParser.parse(new PeekingIterator<>(raw.codePoints().iterator()));

            PresenterFacade presenterFacade = new PresenterFacade();
            String result = presenterFacade.convertToString(json);
            System.out.println(result);
        }
    }
}
