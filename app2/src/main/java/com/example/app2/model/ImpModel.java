package com.example.app2.model;

import com.example.app2.bean.NewsBean;
import com.example.app2.contract.MyContract;
import com.example.app2.utils.net.NetCallBack;
import com.example.app2.utils.net.RetrofitUtils;
import com.example.app2.utils.net.URLConstant;

public class ImpModel<T> implements MyContract.InModel<T> {

    @Override
    public void getData(String url,NetCallBack<T> callBack) {
        RetrofitUtils instance = RetrofitUtils.getInstance();
        instance.get(url, callBack);
    }
}
