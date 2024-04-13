package com.test.parser;

import com.study.model.Json;
import com.study.parser.JsonParser;
import com.study.presenter.JsonPresenter;
import org.apache.commons.collections4.iterators.PeekingIterator;
import org.junit.Test;

public class JsonParserTest {
    @Test
    public void test() {
        String s = "{\"Greeting\": \"Hello, world\", \"Special numbers to X\": [4.2E1, 23E0, 3.14158  ]}";
//        String s = "[[[[[[[[12345678.89012E-34567]]]]]]]]";
//        String s = "  {\"k1\" :  true,\t\t\n\"k2  (This key name looks weird)\": false, \"[k3](this key name looks weird too)\": null}";
//        String s = "{\"key\": [[[\r[\n\t  {\"key\":  \"some value\"}]   ]]]}";
//        String s = "[   {\"Message\": \"Hello, world\", \"Some special numbers\": [4.2E1, 23E0, 3.1415926 ], \"Today is Saturday\" : true, \"Needs to work\": false, \"Test for null\": null}]";
        PeekingIterator<Integer> iterator = new PeekingIterator<>(s.codePoints().iterator());
        Json json = new JsonParser().parse(iterator);
        new JsonPresenter().present(json);
    }
}
