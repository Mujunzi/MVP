package com.example.app2.presenter;

import com.example.app2.bean.QueryBean;
import com.example.app2.contract.MyContract;
import com.example.app2.model.ImpModel;
import com.example.mylibrary.base.BasePresenter;
import com.example.mylibrary.utils.net.NetCallBack;

public class ImpQueryPresenter extends BasePresenter<MyContract.InModel<QueryBean>, MyContract.InView> implements MyContract.InPresenter {
    public ImpQueryPresenter(MyContract.InView view) {
        super(view);
    }

    @Override
    protected MyContract.InModel<QueryBean> getModel() {
        return new ImpModel<QueryBean>();
    }

    @Override
    public void getData(String url) {
        model.getData(url, new NetCallBack<QueryBean>() {
            @Override
            public void onSuccess(QueryBean queryBean) {
                view.onSuccess(queryBean);
            }

            @Override
            public void onFail(String error) {
                view.onFail(error);
            }
        });
    }
}
