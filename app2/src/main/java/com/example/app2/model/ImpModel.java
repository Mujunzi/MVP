package com.example.app2.model;


import com.example.app2.contract.MyContract;
import com.example.mylibrary.utils.net.NetCallBack;
import com.example.mylibrary.utils.net.RetrofitUtils;

public class ImpModel<T> implements MyContract.InModel<T> {

    @Override
    public void getData(String url, NetCallBack<T> callBack) {
        RetrofitUtils instance = RetrofitUtils.getInstance();
        instance.get(url, callBack);
    }
}
