package com.study.presenter;

import com.study.model.Array;

public class ArrayPresenter extends AbstractPresenter<com.study.model.Array> {

    private final boolean objectValue;
    private final int indentLevel;

    private final ElementsPresenter elementsPresenter;

    public ArrayPresenter(boolean objectValue, int indentLevel) {
        this.objectValue = objectValue;
        this.indentLevel = indentLevel;
        this.elementsPresenter = new ElementsPresenter(objectValue, indentLevel + 1);
    }

    @Override
    public void present(Array array) {
        if (array instanceof Array.CaseOne) {
            if (objectValue) {
                outputHolder.print("[]");
            } else {
                outputHolder.printWithIndentLevel("[]", indentLevel);
            }
            return;
        }
        if (array instanceof Array.CaseTwo caseTwo) {
            if (objectValue) {
                outputHolder.println("[");
            } else {
                outputHolder.printlnWithIndentLevel("[", indentLevel);
            }
            elementsPresenter.present(caseTwo.elements());
            outputHolder.println();
            outputHolder.printWithIndentLevel("]", indentLevel);
            return;
        }

        throw new IllegalArgumentException();
    }
}
