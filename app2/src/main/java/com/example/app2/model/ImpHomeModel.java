package com.example.app2.model;

import android.util.Log;

import com.example.app2.api.MyApi;
import com.example.app2.bean.BannerBean;
import com.example.app2.callback.MyCallBack;
import com.example.app2.contract.MyContract;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImpHomeModel implements MyContract.InHomeModel {

    @Override
    public void banner(MyCallBack<BannerBean> callBack) {
        new Retrofit.Builder()
                .baseUrl(MyApi.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(MyApi.class)
                .bannerList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull BannerBean bannerBean) {
                        callBack.getData(bannerBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("TAG", "onError: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
