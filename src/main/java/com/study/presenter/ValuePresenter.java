package com.study.presenter;

import com.study.convertor.*;
import com.study.model.Value;
import com.study.util.OutputHolder;

public class ValuePresenter extends AbstractPresenter<Value> {
    private final boolean objectValue;
    private final int indentLevel;

    public ValuePresenter(OutputHolder outputHolder, boolean objectValue, int indentLevel) {
        super(outputHolder);
        this.objectValue = objectValue;
        this.indentLevel = indentLevel;
    }

    @Override
    public void present(Value value) {
        if (value instanceof com.study.model.Object object) {
            ObjectPresenter objectPresenter = new ObjectPresenter(outputHolder, objectValue, indentLevel);
            objectPresenter.present(object);
            return;
        }
        if (value instanceof com.study.model.Array array) {
            ArrayPresenter arrayPresenter = new ArrayPresenter(outputHolder, objectValue, indentLevel);
            arrayPresenter.present(array);
            return;
        }
        if (value instanceof com.study.model.String string) {
            StringConvertor stringConvertor = new StringConvertor();
            if (objectValue) {
                outputHolder.print(stringConvertor.convert(string));
            } else {
                outputHolder.printWithIndentLevel(stringConvertor.convert(string), indentLevel);
            }
            return;
        }
        if (value instanceof com.study.model.Number number) {
            NumberConvertor numberConvertor = new NumberConvertor();
            if (objectValue) {
                outputHolder.print(numberConvertor.convert(number));
            } else {
                outputHolder.printWithIndentLevel(numberConvertor.convert(number), indentLevel);
            }
            return;
        }
        if (value instanceof Value.CaseTrue caseTrue) {
            if (objectValue) {
                outputHolder.print(caseTrueConvertor.convert(caseTrue));
            } else {
                outputHolder.printWithIndentLevel(caseTrueConvertor.convert(caseTrue), indentLevel);
            }
            return;
        }
        if (value instanceof Value.CaseFalse caseFalse) {
            if (objectValue) {
                outputHolder.print(caseFalseConvertor.convert(caseFalse));
            } else {
                outputHolder.printWithIndentLevel(caseFalseConvertor.convert(caseFalse), indentLevel);
            }
            return;
        }
        if (value instanceof Value.CaseNull caseNull) {
            if (objectValue) {
                outputHolder.print(caseNullConvertor.convert(caseNull));
            } else {
                outputHolder.printWithIndentLevel(caseNullConvertor.convert(caseNull), indentLevel);
            }
            return;
        }

        throw new IllegalArgumentException();
    }
}
