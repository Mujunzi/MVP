package com.example.app2.base;

import com.example.app2.contract.MyContract;

public abstract class BasePresenter<M,V extends BaseView> {
    protected M model;
    protected V view;

    public BasePresenter(V view) {
        this.view = view;
        model = getModel();
    }

    protected abstract M getModel();
}
