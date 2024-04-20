package com.study.presenter;

import com.study.model.Json;
import com.study.util.ResultHolder;

public class PresenterFacade {

    private final int indentWidthForEachLevel;

    public PresenterFacade(int indentWidthForEachLevel) {
        this.indentWidthForEachLevel = indentWidthForEachLevel;
    }

    public PresenterFacade() {
        this(4);
    }

    public String convertToString(Json json) {
        ResultHolder resultHolder = new ResultHolder(indentWidthForEachLevel);
        JsonPresenter jsonPresenter = new JsonPresenter(resultHolder);
        jsonPresenter.present(json);
        return resultHolder.collect();
    }
}
