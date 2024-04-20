package com.study.presenter;

import com.study.convertor.Convertor;
import com.study.model.Value;
import com.study.util.OutputHolder;

public abstract class AbstractPresenter<T> implements Presenter<T> {
    protected Convertor<Value.CaseTrue> caseTrueConvertor = caseTrue -> "true";
    protected Convertor<Value.CaseFalse> caseFalseConvertor = caseTrue -> "false";
    protected Convertor<Value.CaseNull> caseNullConvertor = caseTrue -> "null";

    protected final OutputHolder outputHolder;

    protected AbstractPresenter(OutputHolder outputHolder) {
        this.outputHolder = outputHolder;
    }
}
