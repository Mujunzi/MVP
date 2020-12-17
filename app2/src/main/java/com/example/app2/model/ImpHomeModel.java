package com.example.app2.model;

import com.example.app2.bean.BannerBean;
import com.example.app2.contract.MyContract;
import com.example.app2.utils.net.NetCallBack;
import com.example.app2.utils.net.RetrofitUtils;
import com.example.app2.utils.net.URLConstant;

public class ImpHomeModel implements MyContract.InModel<BannerBean> {

    @Override
    public void getData(NetCallBack<BannerBean> callBack) {
        RetrofitUtils instance = RetrofitUtils.getInstance();
        instance.get(URLConstant.BANNERLIST, callBack);
    }
}
