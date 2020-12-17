package com.example.app2.model;

import com.example.app2.bean.NewsBean;
import com.example.app2.contract.MyContract;
import com.example.app2.utils.net.NetCallBack;
import com.example.app2.utils.net.RetrofitUtils;
import com.example.app2.utils.net.URLConstant;

public class ImpNewModel implements MyContract.InModel<NewsBean> {

    @Override
    public void getData(NetCallBack<NewsBean> callBack) {
        RetrofitUtils instance = RetrofitUtils.getInstance();
        instance.get(URLConstant.NEWSLIST, callBack);
    }
}
