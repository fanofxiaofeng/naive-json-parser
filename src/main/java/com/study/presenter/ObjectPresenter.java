package com.study.presenter;

public class ObjectPresenter extends AbstractPresenter<com.study.model.Object> {
    private final boolean objectValue;
    private final int indentLevel;

    private final MembersPresenter membersPresenter;

    public ObjectPresenter(boolean objectValue, int indentLevel) {
        this.objectValue = objectValue;
        this.indentLevel = indentLevel;
        this.membersPresenter = new MembersPresenter(indentLevel + 1);
    }

    @Override
    public void present(com.study.model.Object object) {
        if (object instanceof com.study.model.Object.CaseOne) {
            if (objectValue) {
                outputHolder.print("{}");
            } else {
                outputHolder.printWithIndentLevel("{}", indentLevel);
            }
            return;
        }

        if (object instanceof com.study.model.Object.CaseTwo caseTwo) {
            if (objectValue) {
                outputHolder.println("{");
            } else {
                outputHolder.printlnWithIndentLevel("{", indentLevel);
            }
            membersPresenter.present(caseTwo.members());
            outputHolder.printWithIndentLevel("}", indentLevel);
            return;
        }

        throw new IllegalArgumentException();
    }
}
