package com.study.presenter;

import com.study.model.Members;
import com.study.util.OutputHolder;

public class MembersPresenter extends AbstractPresenter<Members> {
    private final int indentLevel;

    private final MemberPresenter memberPresenter;

    public MembersPresenter(OutputHolder outputHolder, int indentLevel) {
        super(outputHolder);
        this.indentLevel = indentLevel;
        this.memberPresenter = new MemberPresenter(outputHolder, indentLevel);
    }

    @Override
    public void present(Members members) {
        if (members instanceof Members.CaseOne caseOne) {
            memberPresenter.present(caseOne.member());
            outputHolder.println();
            return;
        }
        if (members instanceof Members.CaseTwo caseTwo) {
            memberPresenter.present(caseTwo.member());
            outputHolder.println(",");
            present(caseTwo.members());
            return;
        }

        throw new IllegalArgumentException();
    }
}
