package com.example.app2.presenter;

import com.example.app2.base.BasePresenter;
import com.example.app2.bean.BannerBean;
import com.example.app2.utils.net.NetCallBack;
import com.example.app2.contract.MyContract;
import com.example.app2.model.ImpHomeModel;

public class ImpHomePresenter extends BasePresenter<MyContract.InModel<BannerBean>, MyContract.InView> implements MyContract.InPresenter {
    public ImpHomePresenter(MyContract.InView view) {
        super(view);
    }

    @Override
    protected MyContract.InModel<BannerBean> getModel() {
        return new ImpHomeModel();
    }

    @Override
    public void getData() {
        model.getData(new NetCallBack<BannerBean>() {
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
