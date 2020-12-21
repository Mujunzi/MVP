package com.example.app2.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app2.R;
import com.example.app2.bean.NewsBean;
import com.example.mylibrary.base.BaseAdapter;

import java.util.ArrayList;

public class NewsRAdapter extends BaseAdapter<NewsBean.NewsDTO> {

    public NewsRAdapter(ArrayList<NewsBean.NewsDTO> list, Context context) {
        super(list, context);
    }

    @Override
    protected RecyclerView.ViewHolder getViewHolder(View view) {
        return new ViewHolder(view);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.layout_item_news;
    }


    @Override
    protected void bindMyViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder myHolder = (ViewHolder) holder;
        NewsBean.NewsDTO newsDTO = list.get(position);
        myHolder.tile.setText(newsDTO.getTile());
        myHolder.content.setText(newsDTO.getContent());
        Glide.with(context).load(newsDTO.getImageUrl()).into(myHolder.imageUrl);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tile;
        private TextView content;
        private ImageView imageUrl;

        public ViewHolder(View itemView) {
            super(itemView);
            this.tile = (TextView) itemView.findViewById(R.id.tile);
            this.content = (TextView) itemView.findViewById(R.id.content);
            this.imageUrl = (ImageView) itemView.findViewById(R.id.imageUrl);
        }
    }
}
