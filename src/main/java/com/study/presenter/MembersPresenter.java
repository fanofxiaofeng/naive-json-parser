package com.study.presenter;

import com.study.model.Members;
import com.study.util.PrintStreamWrapper;

public class MembersPresenter implements Presenter<Members> {
    private final PrintStreamWrapper printStreamWrapper = new PrintStreamWrapper();
    private final int indentLevel;

    public MembersPresenter(int indentLevel) {
        this.indentLevel = indentLevel;
    }

    @Override
    public void present(Members members) {
        if (members instanceof Members.CaseOne caseOne) {

        }
    }
}
