package com.study.presenter;


import com.study.model.Array;
import com.study.util.PrintStreamWrapper;

public class ArrayPresenter implements Presenter<com.study.model.Array> {

    private final PrintStreamWrapper printStreamWrapper = new PrintStreamWrapper();
    private final boolean belongToElement;
    private final int indentLevel;

    private final ElementsPresenter elementsPresenter;

    public ArrayPresenter(boolean belongToElement, int indentLevel) {
        this.belongToElement = belongToElement;
        this.indentLevel = indentLevel;
        this.elementsPresenter = new ElementsPresenter(indentLevel + 1);
    }

    @Override
    public void present(Array array) {
        if (array instanceof Array.CaseOne caseOne) {
            if (belongToElement) {
                printStreamWrapper.print("[]");
            } else {
                printStreamWrapper.printlnWithIndentLevel("[]", indentLevel);
            }
            return;
        }
        if (array instanceof Array.CaseTwo caseTwo) {
            if (belongToElement) {
                printStreamWrapper.print("[");
            } else {
                printStreamWrapper.printlnWithIndentLevel("[", indentLevel);
            }
            elementsPresenter.present(caseTwo.elements());

            printStreamWrapper.printlnWithIndentLevel("]", indentLevel);
        }
    }
}
