package com.example.day1216_mvp1.presenter;

import android.util.Log;

import com.example.day1216_mvp1.base.BasePresenter;
import com.example.day1216_mvp1.contract.MyContract;
import com.example.day1216_mvp1.model.ImpModel;

public class ImpPresenter extends BasePresenter<MyContract.InView, MyContract.InModel> implements MyContract.InPresenter {

    public ImpPresenter(MyContract.InView view) {
        super(view);
        Log.e("TAG", "ImpPresenter");
    }

    @Override
    public void loginP() {
        view.loginV();
    }

    @Override
    public String getLoginDataP() {
        Log.e("TAG", "getLoginDataP");
        return model.getLoginDataM();
    }

    @Override
    protected MyContract.InModel getModel() {
        Log.e("TAG", "getModel");
        return new ImpModel();
    }


}
