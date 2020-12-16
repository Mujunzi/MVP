package com.example.app2.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app2.R;
import com.example.app2.adapter.NewsRAdapter;
import com.example.app2.adapter.QueryRAdapter;
import com.example.app2.api.MyApi;
import com.example.app2.base.BaseFragment;
import com.example.app2.bean.NewsBean;
import com.example.app2.bean.QueryBean;
import com.example.app2.contract.MyContract;
import com.example.app2.presenter.ImpNewPresenter;
import com.example.app2.presenter.ImpQueryPresenter;

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

public class QueryFragment extends BaseFragment<ImpQueryPresenter> implements MyContract.InQueryView {

    private RecyclerView recy;
    private ArrayList<QueryBean.StudenlistDTO> list;
    private QueryRAdapter adapter;

    @Override
    protected ImpQueryPresenter getPresenter() {
        return new ImpQueryPresenter(this);
    }

    @Override
    protected void initData() {
        presenter.query();
    }

    @Override
    protected void initView(View view) {
        recy = view.findViewById(R.id.recy_nf);
        list = new ArrayList<>();
        adapter = new QueryRAdapter(list, getContext());
        recy.setLayoutManager(new LinearLayoutManager(getContext()));
        recy.setAdapter(adapter);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    public void query(QueryBean queryBean) {
        list.addAll(queryBean.getStudenlist());
        adapter.notifyDataSetChanged();
    }
}