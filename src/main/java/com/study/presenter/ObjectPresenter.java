package com.study.presenter;

import com.study.model.Object;
import com.study.util.ResultHolder;

public class ObjectPresenter extends AbstractPresenter<com.study.model.Object> {
    private final boolean objectValue;
    private final int indentLevel;

    private final MembersPresenter membersPresenter;

    public ObjectPresenter(ResultHolder resultHolder, boolean objectValue, int indentLevel) {
        super(resultHolder);
        this.objectValue = objectValue;
        this.indentLevel = indentLevel;
        this.membersPresenter = new MembersPresenter(resultHolder, indentLevel + 1);
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
            resultHolder.print("{}");
        } else {
            resultHolder.printWithIndentLevel("{}", indentLevel);
        }
    }

    private void presentCaseTwo(Object.CaseTwo caseTwo) {
        if (objectValue) {
            resultHolder.println("{");
        } else {
            resultHolder.printlnWithIndentLevel("{", indentLevel);
        }
        membersPresenter.present(caseTwo.members());
        resultHolder.printWithIndentLevel("}", indentLevel);
    }
}
