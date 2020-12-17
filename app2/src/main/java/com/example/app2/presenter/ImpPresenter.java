package com.example.app2.presenter;

import com.example.app2.base.BasePresenter;
import com.example.app2.contract.MyContract;
import com.example.app2.model.ImpModel;
import com.example.app2.utils.net.NetCallBack;

public class ImpPresenter<T> extends BasePresenter<MyContract.InModel<T>, MyContract.InView> implements MyContract.InPresenter {
    public ImpPresenter(MyContract.InView view) {
        super(view);
    }

    @Override
    protected MyContract.InModel<T> getModel() {
        return new ImpModel<T>();
    }

    @Override
    public void getData(String url) {
        model.getData(url,new NetCallBack<T>() {
            @Override
            public void onSuccess(T t) {
                view.onSuccess(t);
            }

            @Override
            public void onFail(String error) {
                view.onFail(error);
            }
        });
    }
}
