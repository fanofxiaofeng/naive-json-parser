package com.study.presenter;

import com.study.util.PrintStreamWrapper;

public class ObjectPresenter implements Presenter<com.study.model.Object> {
    private final PrintStreamWrapper printStreamWrapper = new PrintStreamWrapper();

    private final boolean belongsToElement;
    private final int indentLevel;

    public ObjectPresenter(boolean belongsToElement, int indentLevel) {
        this.belongsToElement = belongsToElement;
        this.indentLevel = indentLevel;
    }

    @Override
    public void present(com.study.model.Object object) {
        if (object instanceof com.study.model.Object.CaseOne) {
            if (belongsToElement) {
                printStreamWrapper.println("{}");
            } else {
                printStreamWrapper.printlnWithIndentLevel("{}", indentLevel);
            }
            return;
        }
        if (object instanceof com.study.model.Object.CaseTwo caseTwo) {
            if (belongsToElement) {
                printStreamWrapper.println("{");
            } else {
                printStreamWrapper.printlnWithIndentLevel("{", indentLevel);
            }
            // todo: for members


            printStreamWrapper.printlnWithIndentLevel("}", indentLevel);
        }
    }
}
