package com.study.presenter;

import com.study.convertor.*;
import com.study.model.Value;
import com.study.model.number.Number;
import com.study.model.string.String;
import com.study.util.ResultHolder;

public class ValuePresenter extends AbstractPresenter<Value> {
    private final boolean objectValue;
    private final int indentLevel;

    public ValuePresenter(ResultHolder resultHolder, boolean objectValue, int indentLevel) {
        super(resultHolder);
        this.objectValue = objectValue;
        this.indentLevel = indentLevel;
    }

    @Override
    public void present(Value value) {
        if (value instanceof com.study.model.Object object) {
            ObjectPresenter objectPresenter = new ObjectPresenter(resultHolder, objectValue, indentLevel);
            objectPresenter.present(object);
            return;
        }
        if (value instanceof com.study.model.Array array) {
            ArrayPresenter arrayPresenter = new ArrayPresenter(resultHolder, objectValue, indentLevel);
            arrayPresenter.present(array);
            return;
        }
        if (value instanceof String string) {
            StringConvertor stringConvertor = new StringConvertor();
            if (objectValue) {
                resultHolder.print(stringConvertor.convert(string));
            } else {
                resultHolder.printWithIndentLevel(stringConvertor.convert(string), indentLevel);
            }
            return;
        }
        if (value instanceof Number number) {
            NumberConvertor numberConvertor = new NumberConvertor();
            if (objectValue) {
                resultHolder.print(numberConvertor.convert(number));
            } else {
                resultHolder.printWithIndentLevel(numberConvertor.convert(number), indentLevel);
            }
            return;
        }
        if (value instanceof Value.CaseTrue caseTrue) {
            if (objectValue) {
                resultHolder.print(caseTrueConvertor.convert(caseTrue));
            } else {
                resultHolder.printWithIndentLevel(caseTrueConvertor.convert(caseTrue), indentLevel);
            }
            return;
        }
        if (value instanceof Value.CaseFalse caseFalse) {
            if (objectValue) {
                resultHolder.print(caseFalseConvertor.convert(caseFalse));
            } else {
                resultHolder.printWithIndentLevel(caseFalseConvertor.convert(caseFalse), indentLevel);
            }
            return;
        }
        if (value instanceof Value.CaseNull caseNull) {
            if (objectValue) {
                resultHolder.print(caseNullConvertor.convert(caseNull));
            } else {
                resultHolder.printWithIndentLevel(caseNullConvertor.convert(caseNull), indentLevel);
            }
            return;
        }

        throw new IllegalArgumentException();
    }
}
