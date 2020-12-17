package com.example.app2.view.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.example.app2.R;
import com.example.app2.adapter.QueryRAdapter;
import com.example.app2.base.BaseFragment;
import com.example.app2.bean.QueryBean;
import com.example.app2.contract.MyContract;
import com.example.app2.presenter.ImpQueryPresenter;

import java.util.ArrayList;

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

}