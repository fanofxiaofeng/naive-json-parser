package com.study.presenter;

import com.study.convertor.StringConvertor;
import com.study.model.Member;

public class MemberPresenter extends AbstractPresenter<Member> {

    private final int indentLevel;

    private final StringConvertor stringConvertor = new StringConvertor();
    private final ElementPresenter elementPresenter;

    public MemberPresenter(int indentLevel) {
        this.indentLevel = indentLevel;
        elementPresenter = new ElementPresenter(true, indentLevel);
    }

    @Override
    public void present(Member member) {
        outputHolder.printWithIndentLevel(stringConvertor.convert(member.string()), indentLevel);
        outputHolder.print(": ");
        elementPresenter.present(member.element());
    }
}
