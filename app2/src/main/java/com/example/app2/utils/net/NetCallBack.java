package com.example.app2.utils.net;

public interface NetCallBack<B> {
    void onSuccess(B b);

    void onFail(String error);
}
