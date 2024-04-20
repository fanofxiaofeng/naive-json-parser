package com.study.presenter;

import com.study.model.Json;
import com.study.util.OutputHolder;

public class JsonPresenter extends AbstractPresenter<Json> {

    private final ElementPresenter elementPresenter = new ElementPresenter(outputHolder, false, 0);

    public JsonPresenter() {
        super(new OutputHolder());
    }

    @Override
    public void present(Json json) {
        elementPresenter.present(json.element());
        outputHolder.println();
    }

    public String collect() {
        return outputHolder.collect();
    }
}
