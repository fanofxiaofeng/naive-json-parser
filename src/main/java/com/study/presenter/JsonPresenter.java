package com.study.presenter;

import com.study.model.Json;
import com.study.util.ResultHolder;

public class JsonPresenter extends AbstractPresenter<Json> {

    private final ElementPresenter elementPresenter = new ElementPresenter(resultHolder, false, 0);

    public JsonPresenter(ResultHolder resultHolder) {
        super(resultHolder);
    }

    @Override
    public void present(Json json) {
        elementPresenter.present(json.element());
        resultHolder.println();
    }
}
