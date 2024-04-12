package com.study.presenter;

import com.study.model.Elements;

public class ElementsPresenter extends AbstractPresenter<Elements> {

    private final boolean objectValue;

    private final int indentLevel;

    private final ElementPresenter elementPresenter;

    public ElementsPresenter(boolean objectValue, int indentLevel) {
        this.objectValue = objectValue;
        this.indentLevel = indentLevel;
        this.elementPresenter = new ElementPresenter(objectValue, indentLevel);
    }

    @Override
    public void present(Elements elements) {
        if (elements instanceof Elements.CaseOne caseOne) {
            elementPresenter.present(caseOne.element());
            return;
        }

        if (elements instanceof Elements.CaseTwo caseTwo) {
            elementPresenter.present(caseTwo.element());
            outputHolder.println(",");
            present(caseTwo.elements());
            return;
        }

        throw new IllegalArgumentException();
    }
}
