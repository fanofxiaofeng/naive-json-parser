package com.study.presenter;

import com.study.model.Object;
import com.study.util.OutputHolder;

public class ObjectPresenter extends AbstractPresenter<com.study.model.Object> {
    private final boolean objectValue;
    private final int indentLevel;

    private final MembersPresenter membersPresenter;

    public ObjectPresenter(OutputHolder outputHolder, boolean objectValue, int indentLevel) {
        super(outputHolder);
        this.objectValue = objectValue;
        this.indentLevel = indentLevel;
        this.membersPresenter = new MembersPresenter(outputHolder, indentLevel + 1);
    }

    @Override
    public void present(com.study.model.Object object) {
        if (object instanceof com.study.model.Object.CaseOne) {
            presentCaseOne();
            return;
        }

        if (object instanceof com.study.model.Object.CaseTwo caseTwo) {
            presentCaseTwo(caseTwo);
            return;
        }

        throw new IllegalArgumentException();
    }

    private void presentCaseOne() {
        if (objectValue) {
            outputHolder.print("{}");
        } else {
            outputHolder.printWithIndentLevel("{}", indentLevel);
        }
    }

    private void presentCaseTwo(Object.CaseTwo caseTwo) {
        if (objectValue) {
            outputHolder.println("{");
        } else {
            outputHolder.printlnWithIndentLevel("{", indentLevel);
        }
        membersPresenter.present(caseTwo.members());
        outputHolder.printWithIndentLevel("}", indentLevel);
    }
}
