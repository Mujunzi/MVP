package com.example.mylibrary.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public abstract class BaseAdapter<B extends BaseBean> extends RecyclerView.Adapter {
    protected ArrayList<B> list;
    protected Context context;

    public BaseAdapter(ArrayList<B> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(getLayoutId(), parent, false);
        return getViewHolder(view);
    }

    protected abstract RecyclerView.ViewHolder getViewHolder(View view);

    protected abstract int getLayoutId();

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        bindMyViewHolder(holder, position);
    }

    protected abstract void bindMyViewHolder(RecyclerView.ViewHolder holder, int position);

    @Override
    public int getItemCount() {
        return list.size();
    }
}
