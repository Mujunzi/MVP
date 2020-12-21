package com.example.app2.presenter;

import com.example.app2.bean.BannerBean;
import com.example.app2.contract.MyContract;
import com.example.app2.model.ImpModel;
import com.example.mylibrary.base.BasePresenter;
import com.example.mylibrary.utils.net.NetCallBack;

public class ImpHomePresenter extends BasePresenter<MyContract.InModel<BannerBean>, MyContract.InView> implements MyContract.InPresenter {
    public ImpHomePresenter(MyContract.InView view) {
        super(view);
    }

    @Override
    protected MyContract.InModel<BannerBean> getModel() {
        return new ImpModel<BannerBean>();
    }

    @Override
    public void getData(String url) {
        model.getData(url, new NetCallBack<BannerBean>() {
            @Override
            public void onSuccess(BannerBean bannerBean) {
                view.onSuccess(bannerBean);
            }

            @Override
            public void onFail(String error) {
                view.onFail(error);
            }
        });
    }
}
