package com.example.app2.contract;

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

    public interface InLoginView {
    }

    public interface InHomeModel {
        void getData(NetCallBack<BannerBean> bannerBeanNetCallBack);
    }

    public interface InHomePresenter {
        void getData();
    }

    public interface InHomeView {
        void onSuccess(BannerBean bannerBean);

        void onFail(String error);
    }


    public interface InNewsModel {
        void getData(NetCallBack<NewsBean> newsBeanNetCallBack);
    }

    public interface InNewsPresenter {
        void getData();
    }

    public interface InNewsView {
        void onFail(String error);

        void onSuccess(NewsBean newsBean);
    }

    public interface InQueryModel {
    }

    public interface InQueryPresenter {
    }

    public interface InQueryView {
    }
}
