package com.example.app2.contract;

import com.example.app2.bean.BannerBean;
import com.example.app2.bean.NewsBean;
import com.example.app2.bean.QueryBean;
import com.example.app2.callback.MyCallBack;

public class MyContract {
    public interface InLoginModel<T> {
        void login(String name, String pwd, MyCallBack<Boolean> callBack);

        boolean getData(Boolean isSuccess);
    }

    public interface InLoginView {
        void isLogin(boolean isLogin);
    }

    public interface InLoginPresenter {
        void login(String name, String pwd);
    }

    public interface InHomeModel {
        void banner(MyCallBack<BannerBean> callBack);
    }

    public interface InHomeView {
        void banner(BannerBean bannerBean);
    }

    public interface InHomePresenter {
        void banner();
    }

    public interface InNewsModel {
        void news(MyCallBack<NewsBean> callBack);
    }

    public interface InNewsView {
        void news(NewsBean newsBean);
    }

    public interface InNewsPresenter {
        void news();
    }

    public interface InQueryModel {
        void query(MyCallBack<QueryBean> callBack);
    }

    public interface InQueryView {
        void query(QueryBean queryBean);
    }

    public interface InQueryPresenter {
        void query();
    }
}
