package com.study.presenter;

import com.study.model.Array;
import com.study.model.Elements;
import com.study.util.OutputHolder;

public class ArrayPresenter extends AbstractPresenter<com.study.model.Array> {

    private final boolean objectValue;
    private final int indentLevel;

    public ArrayPresenter(OutputHolder outputHolder, boolean objectValue, int indentLevel) {
        super(outputHolder);
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
            outputHolder.print("[]");
        } else {
            outputHolder.printWithIndentLevel("[]", indentLevel);
        }
    }

    private void presentCaseTwo(Array.CaseTwo caseTwo) {
        if (objectValue) {
            outputHolder.println("[");
        } else {
            outputHolder.printlnWithIndentLevel("[", indentLevel);
        }

        Presenter<Elements> elementsPresenter = new ElementsPresenter(outputHolder, false, indentLevel + 1);
        elementsPresenter.present(caseTwo.elements());

        outputHolder.println();
        outputHolder.printWithIndentLevel("]", indentLevel);
    }
}
