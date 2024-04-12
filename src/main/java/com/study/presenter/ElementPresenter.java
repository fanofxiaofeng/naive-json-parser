package com.study.presenter;

import com.study.model.Element;

public class ElementPresenter extends AbstractPresenter<Element> {
    private final boolean objectValue;
    private final int indentLevel;

    public ElementPresenter(boolean objectValue, int indentLevel) {
        this.objectValue = objectValue;
        this.indentLevel = indentLevel;
    }

    @Override
    public void present(Element element) {
        ValuePresenter valuePresenter = new ValuePresenter(objectValue, indentLevel);
        valuePresenter.present(element.value());
    }
}
