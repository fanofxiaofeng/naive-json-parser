package com.study.presenter;

import com.study.model.Element;
import com.study.model.Json;

public class JsonPresenter extends AbstractPresenter<Json> {

    private final ElementPresenter elementPresenter = new ElementPresenter(false, 0);

    @Override
    public void present(Json json) {
        elementPresenter.present((Element) json);
        String result = outputHolder.collect();
        System.out.println(result);
    }
}
