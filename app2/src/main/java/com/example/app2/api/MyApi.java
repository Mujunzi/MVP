package com.example.app2.api;

import com.example.app2.bean.BannerBean;
import com.example.app2.bean.NewsBean;
import com.example.app2.bean.QueryBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyApi {
    String url = "http://cdwan.cn:7000/exam2003/";

    @GET("abannerlist.json")
    Observable<BannerBean> bannerList();

    @GET("anewslist.json")
    Observable<NewsBean> newsList();

    @GET("astudent.json")
    Observable<QueryBean> queryList();
}
