package com.study.presenter;

import com.study.model.Element;
import com.study.model.Value;
import com.study.util.ResultHolder;

public class ElementPresenter extends AbstractPresenter<Element> {
    private final boolean objectValue;
    private final int indentLevel;

    public ElementPresenter(ResultHolder resultHolder, boolean objectValue, int indentLevel) {
        super(resultHolder);
        this.objectValue = objectValue;
        this.indentLevel = indentLevel;
    }

    @Override
    public void present(Element element) {
        Presenter<Value> valuePresenter = new ValuePresenter(resultHolder, objectValue, indentLevel);
        valuePresenter.present(element.value());
    }
}
