package com.study.presenter;

import com.study.model.Array;
import com.study.model.Elements;
import com.study.util.ResultHolder;

public class ArrayPresenter extends AbstractPresenter<com.study.model.Array> {

    private final boolean objectValue;
    private final int indentLevel;

    public ArrayPresenter(ResultHolder resultHolder, boolean objectValue, int indentLevel) {
        super(resultHolder);
        this.objectValue = objectValue;
        this.indentLevel = indentLevel;
    }

    @Override
    public void present(Array array) {
        if (array instanceof Array.CaseOne) {
            presentCaseOne();
            return;
        }

        if (array instanceof Array.CaseTwo caseTwo) {
            presentCaseTwo(caseTwo);
            return;
        }

        throw new IllegalArgumentException();
    }

    private void presentCaseOne() {
        if (objectValue) {
            resultHolder.print("[]");
        } else {
            resultHolder.printWithIndentLevel("[]", indentLevel);
        }
    }

    private void presentCaseTwo(Array.CaseTwo caseTwo) {
        if (objectValue) {
            resultHolder.println("[");
        } else {
            resultHolder.printlnWithIndentLevel("[", indentLevel);
        }

        Presenter<Elements> elementsPresenter = new ElementsPresenter(resultHolder, false, indentLevel + 1);
        elementsPresenter.present(caseTwo.elements());

        resultHolder.println();
        resultHolder.printWithIndentLevel("]", indentLevel);
    }
}
