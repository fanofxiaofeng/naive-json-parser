package com.study.presenter;

import com.study.model.Elements;
import com.study.util.OutputHolder;

public class ElementsPresenter extends AbstractPresenter<Elements> {

    private final boolean objectValue;

    private final int indentLevel;

    private final ElementPresenter elementPresenter;

    public ElementsPresenter(OutputHolder outputHolder, boolean objectValue, int indentLevel) {
        super(outputHolder);
        this.objectValue = objectValue;
        this.indentLevel = indentLevel;
        this.elementPresenter = new ElementPresenter(outputHolder, objectValue, indentLevel);
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
