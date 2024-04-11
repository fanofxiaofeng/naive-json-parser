package com.study.presenter;

import com.study.model.Member;
import com.study.util.PrintStreamWrapper;

public class MemberPresenter implements Presenter<Member> {

    private final PrintStreamWrapper printStreamWrapper = new PrintStreamWrapper();
    private final int indentLevel;

    private final StringConvertor stringConvertor = new StringConvertor();
    private final ElementPresenter elementPresenter;

    public MemberPresenter(int indentLevel) {
        this.indentLevel = indentLevel;
        elementPresenter = new ElementPresenter(indentLevel + 1);
    }

    @Override
    public void present(Member member) {
        printStreamWrapper.print(stringConvertor.convert(member.string()));
        printStreamWrapper.print(": ");
        elementPresenter.present(member.element());
    }
}
