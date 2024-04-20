package com.study.presenter;

import com.study.model.Members;
import com.study.util.ResultHolder;

public class MembersPresenter extends AbstractPresenter<Members> {
    private final int indentLevel;

    private final MemberPresenter memberPresenter;

    public MembersPresenter(ResultHolder resultHolder, int indentLevel) {
        super(resultHolder);
        this.indentLevel = indentLevel;
        this.memberPresenter = new MemberPresenter(resultHolder, indentLevel);
    }

    @Override
    public void present(Members members) {
        if (members instanceof Members.CaseOne caseOne) {
            memberPresenter.present(caseOne.member());
            resultHolder.println();
            return;
        }
        if (members instanceof Members.CaseTwo caseTwo) {
            memberPresenter.present(caseTwo.member());
            resultHolder.println(",");
            present(caseTwo.members());
            return;
        }

        throw new IllegalArgumentException();
    }
}
