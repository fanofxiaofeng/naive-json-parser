package com.study.builder;

import com.study.model.Whitespace;

import java.util.List;

public class WhitespaceBuilder implements Builder<Whitespace> {
    @Override
    public Whitespace build(List<Integer> raw) {
        return new Whitespace(raw);
    }
}
