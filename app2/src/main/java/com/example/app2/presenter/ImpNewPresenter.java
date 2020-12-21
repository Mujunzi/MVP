package com.example.app2.presenter;

import com.example.app2.bean.NewsBean;
import com.example.app2.contract.MyContract;
import com.example.app2.model.ImpModel;
import com.example.mylibrary.base.BasePresenter;
import com.example.mylibrary.utils.net.NetCallBack;

public class ImpNewPresenter extends BasePresenter<MyContract.InModel<NewsBean>, MyContract.InView> implements MyContract.InPresenter {
    public ImpNewPresenter(MyContract.InView view) {
        super(view);
    }

    @Override
    protected MyContract.InModel<NewsBean> getModel() {
        return new ImpModel<NewsBean>();
    }

    @Override
    public void getData(String url) {
        model.getData(url,new NetCallBack<NewsBean>() {
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
