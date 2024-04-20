package com.study.presenter;

import com.study.convertor.StringConvertor;
import com.study.model.Member;
import com.study.util.ResultHolder;

public class MemberPresenter extends AbstractPresenter<Member> {

    private final int indentLevel;

    private final StringConvertor stringConvertor = new StringConvertor();
    private final ElementPresenter elementPresenter;

    public MemberPresenter(ResultHolder resultHolder, int indentLevel) {
        super(resultHolder);
        this.indentLevel = indentLevel;
        elementPresenter = new ElementPresenter(resultHolder,true, indentLevel);
    }

    @Override
    public void present(Member member) {
        resultHolder.printWithIndentLevel(stringConvertor.convert(member.string()), indentLevel);
        resultHolder.print(": ");
        elementPresenter.present(member.element());
    }
}
