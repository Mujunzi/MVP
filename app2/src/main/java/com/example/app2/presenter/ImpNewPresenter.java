package com.example.app2.presenter;

import com.example.app2.base.BasePresenter;
import com.example.app2.bean.NewsBean;
import com.example.app2.utils.net.NetCallBack;
import com.example.app2.contract.MyContract;
import com.example.app2.model.ImpNewModel;

public class ImpNewPresenter extends BasePresenter<MyContract.InNewsModel, MyContract.InNewsView> implements MyContract.InNewsPresenter {


    public ImpNewPresenter(MyContract.InNewsView view) {
        super(view);
    }

    @Override
    protected MyContract.InNewsModel getModel() {
        return new ImpNewModel();
    }


    @Override
    public void getData() {
        model.getData(new NetCallBack<NewsBean>() {
            @Override
            public void onSuccess(NewsBean newsBean) {
                view.onSuccess(newsBean);
            }

            @Override
            public void onFail(String error) {
                view.onFail(error);
            }
        });
    }
}
