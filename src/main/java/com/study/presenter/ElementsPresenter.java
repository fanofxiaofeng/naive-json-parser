package com.study.presenter;

import com.study.model.Elements;
import com.study.util.PrintStreamWrapper;

public class ElementsPresenter implements Presenter<Elements> {
    private final PrintStreamWrapper printStreamWrapper = new PrintStreamWrapper();
    private final int indentLevel;

    public ElementsPresenter(int indentLevel) {
        this.indentLevel = indentLevel;
    }

    @Override
    public void present(Elements elements) {
        if (elements instanceof Elements.CaseOne caseOne) {

        }
    }
}
