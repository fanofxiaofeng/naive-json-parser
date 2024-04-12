package com.study.presenter;

import com.study.model.Value;

public class ValuePresenter extends AbstractPresenter<Value> {
    private final boolean objectValue;
    private final int indentLevel;

    public ValuePresenter(boolean objectValue, int indentLevel) {
        this.objectValue = objectValue;
        this.indentLevel = indentLevel;
    }

    @Override
    public void present(Value value) {
        if (value instanceof com.study.model.Object object) {
            ObjectPresenter objectPresenter = new ObjectPresenter(objectValue, indentLevel);
            objectPresenter.present(object);
            return;
        }
        if (value instanceof com.study.model.Array array) {
            ArrayPresenter arrayPresenter = new ArrayPresenter(objectValue, indentLevel);
            arrayPresenter.present(array);
            return;
        }
        if (value instanceof com.study.model.String string) {
            StringConvertor stringConvertor = new StringConvertor();
            outputHolder.printWithIndentLevel(stringConvertor.convert(string), indentLevel);
            return;
        }
        if (value instanceof com.study.model.Number number) {
            NumberConvertor numberConvertor = new NumberConvertor();
            outputHolder.printWithIndentLevel(numberConvertor.convert(number), indentLevel);
            return;
        }
        if (value instanceof Value.CaseTrue caseTrue) {
            outputHolder.printWithIndentLevel(CaseTrueConvertor.getInstance().convert(caseTrue), indentLevel);
            return;
        }
        if (value instanceof Value.CaseFalse caseFalse) {
            CaseFalseConvertor caseFalseConvertor = new CaseFalseConvertor();
            outputHolder.printWithIndentLevel(caseFalseConvertor.convert(caseFalse), indentLevel);
            return;
        }
        if (value instanceof Value.CaseNull caseNull) {
            CaseNullConvertor caseNullConvertor = new CaseNullConvertor();
            outputHolder.printWithIndentLevel(caseNullConvertor.convert(caseNull), indentLevel);
            return;
        }

        throw new IllegalArgumentException();
    }
}
