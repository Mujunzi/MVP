package com.example.day1216_mvp1.base;

import android.util.Log;

import com.example.day1216_mvp1.contract.MyContract;
import com.example.day1216_mvp1.model.ImpModel;
import com.example.day1216_mvp1.presenter.ImpPresenter;

public abstract class BasePresenter<V, M> {
    protected V view;
    protected M model;

    public BasePresenter(V view) {
        this.view = view;
        model = getModel();
        Log.e("TAG", "BasePresenter");
    }

    protected abstract M getModel();
}
