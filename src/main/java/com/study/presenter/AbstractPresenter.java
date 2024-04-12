package com.study.presenter;

import com.study.util.OutputHolder;

public abstract class AbstractPresenter<T> implements Presenter<T> {
    protected static final OutputHolder outputHolder = new OutputHolder();
}
