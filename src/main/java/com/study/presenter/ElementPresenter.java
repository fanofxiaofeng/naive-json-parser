package com.study.presenter;

import com.study.model.Element;
import com.study.util.PrintStreamWrapper;

public class ElementPresenter implements Presenter<Element> {
    private final PrintStreamWrapper printStreamWrapper = new PrintStreamWrapper();
    private final int indentLevel;

    private final ValuePresenter valuePresenter;

    public ElementPresenter(int indentLevel) {
        this.indentLevel = indentLevel;
        this.valuePresenter = new ValuePresenter(true, indentLevel);
    }

    @Override
    public void present(Element element) {
        valuePresenter.present(element.value());
    }
}
