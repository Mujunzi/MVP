package com.example.app2.presenter;

import com.example.app2.base.BasePresenter;
import com.example.app2.bean.BannerBean;
import com.example.app2.callback.MyCallBack;
import com.example.app2.contract.MyContract;
import com.example.app2.model.ImpHomeModel;

public class ImpHomePresenter extends BasePresenter<MyContract.InHomeModel, MyContract.InHomeView> implements MyContract.InHomePresenter {
    public ImpHomePresenter(MyContract.InHomeView view) {
        super(view);
    }

    @Override
    protected MyContract.InHomeModel getModel() {
        return new ImpHomeModel();
    }

    @Override
    public void banner() {
        model.banner(new MyCallBack<BannerBean>() {
            @Override
            public void getData(BannerBean bannerBean) {
                view.banner(bannerBean);
            }
        });
    }
}
