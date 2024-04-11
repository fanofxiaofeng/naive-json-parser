package com.study.presenter;

import com.study.model.Value;
import com.study.util.PrintStreamWrapper;

public class ValuePresenter implements Presenter<Value> {
    private final PrintStreamWrapper printStreamWrapper = new PrintStreamWrapper();
    private final boolean belongsToElement;
    private final int indentLevel;

    private final ObjectPresenter objectPresenter;
    private final ArrayPresenter arrayPresenter;

    private final StringConvertor stringConvertor = new StringConvertor();
    private final NumberConvertor numberConvertor = new NumberConvertor();

    private final CaseTrueConvertor caseTrueConvertor = new CaseTrueConvertor();
    private final CaseFalseConvertor caseFalseConvertor = new CaseFalseConvertor();
    private final CaseNullConvertor caseNullConvertor = new CaseNullConvertor();

    public ValuePresenter(boolean belongsToElement, int indentLevel) {
        this.belongsToElement = belongsToElement;
        this.indentLevel = indentLevel;
        this.objectPresenter = new ObjectPresenter(belongsToElement, indentLevel);
        this.arrayPresenter = new ArrayPresenter(belongsToElement, indentLevel);
    }

    @Override
    public void present(Value value) {
        if (value instanceof com.study.model.Object object) {
            objectPresenter.present(object);
            return;
        }
        if (value instanceof com.study.model.Array array) {
            arrayPresenter.present(array);
            return;
        }
        if (value instanceof com.study.model.String string) {
            printStreamWrapper.printlnWithIndentLevel(stringConvertor.convert(string), indentLevel);
            return;
        }
        if (value instanceof com.study.model.Number number) {
            printStreamWrapper.printlnWithIndentLevel(numberConvertor.convert(number), indentLevel);
            return;
        }
        if (value instanceof Value.CaseTrue caseTrue) {
            printStreamWrapper.printlnWithIndentLevel(caseTrueConvertor.convert(caseTrue), indentLevel);
            return;
        }
        if (value instanceof Value.CaseFalse caseFalse) {
            printStreamWrapper.printlnWithIndentLevel(caseFalseConvertor.convert(caseFalse), indentLevel);
            return;
        }
        if (value instanceof Value.CaseNull caseNull) {
            printStreamWrapper.printlnWithIndentLevel(caseNullConvertor.convert(caseNull), indentLevel);
            return;
        }
        throw new IllegalArgumentException();
    }
}
