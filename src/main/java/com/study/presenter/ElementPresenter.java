package com.study.presenter;

import com.study.model.Element;
import com.study.model.Value;
import com.study.util.OutputHolder;

public class ElementPresenter extends AbstractPresenter<Element> {
    private final boolean objectValue;
    private final int indentLevel;

    public ElementPresenter(OutputHolder outputHolder, boolean objectValue, int indentLevel) {
        super(outputHolder);
        this.objectValue = objectValue;
        this.indentLevel = indentLevel;
    }

    @Override
    public void present(Element element) {
        Presenter<Value> valuePresenter = new ValuePresenter(outputHolder, objectValue, indentLevel);
        valuePresenter.present(element.value());
    }
}
