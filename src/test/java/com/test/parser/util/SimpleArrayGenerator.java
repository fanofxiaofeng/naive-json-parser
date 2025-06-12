//package com.test.parser.util;
//
//import com.study.model.Array;
//
//public class SimpleArrayGenerator extends AbstractRelationBasedGenerator<Array> {
//
//    private final WhitespaceGenerator whitespaceGenerator = new WhitespaceGenerator(5);
//
//    @Override
//    public String generate() {
//        return doGenerate(Array.class);
//    }
//
//    @Override
//    public <S extends Array> String generate(Class<S> type) {
//        if (type == Array.CaseOne.class) {
//            return "\"[" + whitespaceGenerator.generate() + "]\"";
//        }
//        if (type == Array.CaseTwo.class) {
//
//        }
//
//        throw new IllegalArgumentException(String.format("Unexpected type: %s", type.getCanonicalName()));
//    }
//}
