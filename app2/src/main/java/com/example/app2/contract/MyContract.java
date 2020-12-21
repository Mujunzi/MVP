package com.example.app2.contract;


import com.example.mylibrary.base.BaseModel;
import com.example.mylibrary.base.BaseView;
import com.example.mylibrary.utils.net.NetCallBack;

public class MyContract {
    public interface InLoginModel extends BaseModel {
        void login(String name, String pwd);

        boolean getData();
    }

    public interface InLoginPresenter {
        void login(String name, String pwd);

        boolean getData();
    }

    public interface InLoginView extends BaseView {
    }

    public interface InModel<B> extends BaseModel {
        void getData(String url, NetCallBack<B> callBack);
    }

    public interface InPresenter{
        void getData(String url);
    }

    public interface InView<T> extends BaseView{
        void onSuccess(T t);

        void onFail(String error);
    }
}
