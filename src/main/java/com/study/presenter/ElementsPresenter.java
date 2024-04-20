package com.study.presenter;

import com.study.model.Elements;
import com.study.util.ResultHolder;

public class ElementsPresenter extends AbstractPresenter<Elements> {

    private final boolean objectValue;

    private final int indentLevel;

    private final ElementPresenter elementPresenter;

    public ElementsPresenter(ResultHolder resultHolder, boolean objectValue, int indentLevel) {
        super(resultHolder);
        this.objectValue = objectValue;
        this.indentLevel = indentLevel;
        this.elementPresenter = new ElementPresenter(resultHolder, objectValue, indentLevel);
    }

    @Override
    public void present(Elements elements) {
        if (elements instanceof Elements.CaseOne caseOne) {
            elementPresenter.present(caseOne.element());
            return;
        }

        if (elements instanceof Elements.CaseTwo caseTwo) {
            elementPresenter.present(caseTwo.element());
            resultHolder.println(",");
            present(caseTwo.elements());
            return;
        }

        throw new IllegalArgumentException();
    }
}
