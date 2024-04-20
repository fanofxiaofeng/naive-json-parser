package com.study.presenter;

@FunctionalInterface
public interface Presenter<T> {

    void present(T t);
}
