package com.example.app2.view.activity;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.app2.R;
import com.example.app2.adapter.FVAdapter;
import com.example.app2.base.BaseActivity;
import com.example.app2.bean.BannerBean;
import com.example.app2.contract.MyContract;
import com.example.app2.presenter.ImpHomePresenter;
import com.example.app2.utils.net.URLConstant;
import com.example.app2.view.fragment.NewsFragment;
import com.example.app2.view.fragment.QueryFragment;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class HomeActivity extends BaseActivity<ImpHomePresenter> implements MyContract.InView<BannerBean> {

    private Banner banner;
    private TabLayout tab;
    private ViewPager vp;
    private ArrayList<Fragment> list;
    private ArrayList<String> title;
    private NewsFragment newsFragment;
    private QueryFragment queryFragment;
    private FVAdapter adapter;
    private ArrayList<BannerBean.BannerlistDTO> bannerList;

    @Override
    protected void initData() {
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
        presenter.getData(URLConstant.BANNERLIST);
    }

    @Override
    protected void initView() {
        banner = findViewById(R.id.banner);
        tab = findViewById(R.id.tab);
        vp = findViewById(R.id.vp);
    }

    @Override
    protected ImpHomePresenter getPresenter() {
        return new ImpHomePresenter(this);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_home;
    }

    @Override
    public void onSuccess(BannerBean bannerBean) {
        bannerList = new ArrayList<>();
        bannerList.addAll(bannerBean.getBannerlist());
        banner.setImages(bannerList)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        BannerBean.BannerlistDTO bannerlistDTO = (BannerBean.BannerlistDTO) path;
                        Glide.with(HomeActivity.this).load(bannerlistDTO.getImageurl()).into(imageView);
                    }
                }).start();
    }

    @Override
    public void onFail(String error) {
        Log.e("TAG", "onFail: " + error);
    }
}