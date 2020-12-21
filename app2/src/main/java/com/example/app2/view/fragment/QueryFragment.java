package com.example.app2.view.fragment;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app2.R;
import com.example.app2.adapter.QueryRAdapter;
import com.example.app2.bean.QueryBean;
import com.example.app2.contract.MyContract;
import com.example.app2.presenter.ImpQueryPresenter;
import com.example.mylibrary.base.BaseFragment;
import com.example.mylibrary.utils.net.URLConstant;

import java.util.ArrayList;
import java.util.List;

public class QueryFragment extends BaseFragment<ImpQueryPresenter> implements MyContract.InView<QueryBean> {

    private RecyclerView recy;
    private ArrayList<QueryBean.StudenlistDTO> list;
    private QueryRAdapter adapter;

//    @Override
//    protected ImpPresenter<QueryBean> getPresenter() {
//        return new ImpPresenter<QueryBean>(this);
//    }

    @Override
    protected ImpQueryPresenter getPresenter() {
        return new ImpQueryPresenter(this);
    }

    @Override
    protected void initData() {
        presenter.getData(URLConstant.QUERYLIST);
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
    public void onSuccess(QueryBean queryBean) {
        List<QueryBean.StudenlistDTO> studenlist = queryBean.getStudenlist();
        list.addAll(studenlist);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String error) {
        Log.e("TAG", "onFail: " + error);
    }
}