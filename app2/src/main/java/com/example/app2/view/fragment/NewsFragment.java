package com.example.app2.view.fragment;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app2.R;
import com.example.app2.adapter.NewsRAdapter;
import com.example.app2.bean.NewsBean;
import com.example.app2.contract.MyContract;
import com.example.app2.presenter.ImpNewPresenter;
import com.example.mylibrary.base.BaseFragment;
import com.example.mylibrary.utils.net.URLConstant;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends BaseFragment<ImpNewPresenter> implements MyContract.InView<NewsBean> {

    private RecyclerView recy;
    private ArrayList<NewsBean.NewsDTO> list;
    private NewsRAdapter adapter;

    @Override
    protected ImpNewPresenter getPresenter() {
        return new ImpNewPresenter(this);
    }

    @Override
    protected void initData() {
        presenter.getData(URLConstant.NEWSLIST);
    }

    @Override
    protected void initView(View view) {
        recy = view.findViewById(R.id.recy_nf);
        list = new ArrayList<>();
        adapter = new NewsRAdapter(list, getContext());
        recy.setLayoutManager(new LinearLayoutManager(getContext()));
        recy.setAdapter(adapter);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    public void onSuccess(NewsBean newsBean) {
        List<NewsBean.NewsDTO> news = newsBean.getNews();
        list.addAll(news);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String error) {
        Log.e("TAG", "onFail: " + error);
    }
}