package com.example.app2.utils.net;

import com.example.app2.bean.BannerBean;
import com.example.app2.bean.NewsBean;
import com.example.app2.bean.QueryBean;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface NetApi {

    @GET()
    Observable<ResponseBody> get(@Url String url);

    @POST()
    @FormUrlEncoded
    Observable<ResponseBody> post(@Url String url);

    @POST()
    @FormUrlEncoded
    Observable<ResponseBody> postPar(@Url String url, @FieldMap HashMap<String, String> map);
}
