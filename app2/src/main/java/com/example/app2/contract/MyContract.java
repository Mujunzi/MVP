package com.example.app2.contract;

import com.example.app2.bean.BannerBean;
import com.example.app2.bean.NewsBean;
import com.example.app2.bean.QueryBean;
import com.example.app2.callback.MyCallBack;

public class MyContract {
    public interface InLoginModel {
        void login(String name, String pwd);

        boolean getData();
    }

    public interface InLoginView {

    }

    public interface InLoginPresenter {
        void login(String name, String pwd);

        boolean getData();
    }




    public interface InHomeModel {
        void banner(MyCallBack<BannerBean> callBack);

        BannerBean getData();
    }

    public interface InHomeView {
        void banner(BannerBean bannerBean);
    }

    public interface InHomePresenter {
        void banner();

        BannerBean getData();
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
