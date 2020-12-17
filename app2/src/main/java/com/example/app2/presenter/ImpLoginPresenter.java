package com.example.app2.presenter;

import com.example.app2.base.BasePresenter;
import com.example.app2.callback.MyCallBack;
import com.example.app2.contract.MyContract;
import com.example.app2.model.ImpLoginModel;

public class ImpLoginPresenter extends BasePresenter<MyContract.InLoginModel, MyContract.InLoginView> implements MyContract.InLoginPresenter {
    public ImpLoginPresenter(MyContract.InLoginView view) {
        super(view);
    }

    @Override
    protected MyContract.InLoginModel getModel() {
        return new ImpLoginModel();
    }

    @Override
    public void login(String name, String pwd) {
        model.login(name, pwd);

    }

    @Override
    public boolean getData() {
        boolean isSuccess = model.getData();
        return isSuccess;
    }
}
