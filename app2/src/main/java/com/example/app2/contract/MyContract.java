package com.example.app2.contract;

import com.example.app2.base.BaseView;
import com.example.app2.bean.BannerBean;
import com.example.app2.bean.NewsBean;
import com.example.app2.bean.QueryBean;
import com.example.app2.utils.net.NetCallBack;

public class MyContract {
    public interface InLoginModel {
        void login(String name, String pwd);

        boolean getData();
    }

    public interface InLoginPresenter {
        void login(String name, String pwd);

        boolean getData();
    }

    public interface InLoginView extends BaseView{
    }

    public interface InModel<B> {
        void getData(String url,NetCallBack<B> callBack);
    }

    public interface InPresenter{
        void getData(String url);
    }

    public interface InView<T> extends BaseView{
        void onSuccess(T t);

        void onFail(String error);
    }
}
