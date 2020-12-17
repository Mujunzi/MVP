package com.example.app2.model;

import com.example.app2.bean.QueryBean;
import com.example.app2.contract.MyContract;
import com.example.app2.utils.net.NetCallBack;
import com.example.app2.utils.net.RetrofitUtils;
import com.example.app2.utils.net.URLConstant;

public class ImpQueryModel implements MyContract.InModel<QueryBean> {

    @Override
    public void getData(NetCallBack<QueryBean> callBack) {
        RetrofitUtils instance = RetrofitUtils.getInstance();
        instance.get(URLConstant.QUERYLIST, callBack);
    }
}
