package com.example.app2.presenter;

import com.example.app2.base.BasePresenter;
import com.example.app2.bean.QueryBean;
import com.example.app2.utils.net.NetCallBack;
import com.example.app2.contract.MyContract;
import com.example.app2.model.ImpQueryModel;

public class ImpQueryPresenter extends BasePresenter<MyContract.InQueryModel, MyContract.InQueryView> implements MyContract.InQueryPresenter {


    public ImpQueryPresenter(MyContract.InQueryView view) {
        super(view);
    }

    @Override
    protected MyContract.InQueryModel getModel() {
        return new ImpQueryModel();
    }

}
