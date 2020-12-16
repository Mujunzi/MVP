package com.example.app2.view.activity;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.app2.R;
import com.example.app2.adapter.FVAdapter;
import com.example.app2.api.MyApi;
import com.example.app2.base.BaseActivity;
import com.example.app2.bean.BannerBean;
import com.example.app2.contract.MyContract;
import com.example.app2.presenter.ImpHomePresenter;
import com.example.app2.view.fragment.NewsFragment;
import com.example.app2.view.fragment.QueryFragment;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends BaseActivity<MyContract.InHomePresenter> implements MyContract.InHomeView {


    private Banner banner;
    private TabLayout tab;
    private ViewPager vp;
    private ArrayList<Fragment> list;
    private ArrayList<String> title;
    private NewsFragment newsFragment;
    private QueryFragment queryFragment;
    private FVAdapter adapter;
    private ImpHomePresenter presenter;
    private ArrayList<BannerBean.BannerlistDTO> bannerList;

    @Override
    protected void initData() {
        initBanner();
        list = new ArrayList<>();
        title = new ArrayList<>();

        newsFragment = new NewsFragment();
        queryFragment = new QueryFragment();

        list.add(newsFragment);
        list.add(queryFragment);

        title.add("学校新闻");
        title.add("班级成绩查询");

        adapter = new FVAdapter(getSupportFragmentManager(), list, title);

        vp.setAdapter(adapter);

        tab.setupWithViewPager(vp);
    }

    private void initBanner() {
        Log.e("TAG", "initBanner");
        bannerList = new ArrayList<>();

        presenter.banner();
    }

    @Override
    protected void initView() {
        banner = findViewById(R.id.banner);
        tab = findViewById(R.id.tab);
        vp = findViewById(R.id.vp);
    }

    @Override
    protected MyContract.InHomePresenter getPresenter() {
        presenter = new ImpHomePresenter(this);
        return presenter;
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_home;
    }

    @Override
    public void banner(BannerBean bannerBean) {
        Log.e("TAG", "banner");
        List<BannerBean.BannerlistDTO> dtoList = bannerBean.getBannerlist();
        bannerList.addAll(dtoList);
        banner.setImages(bannerList)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Log.e("TAG", "displayImage");
                        BannerBean.BannerlistDTO banner = (BannerBean.BannerlistDTO) path;
                        Glide.with(HomeActivity.this).load(banner.getImageurl()).into(imageView);
                    }
                })
                .start();
    }
}