package com.example.app2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app2.R;
import com.example.app2.bean.NewsBean;

import java.util.ArrayList;

public class NewsRAdapter extends RecyclerView.Adapter {
    private ArrayList<NewsBean.NewsDTO> list;
    private Context context;

    public NewsRAdapter(ArrayList<NewsBean.NewsDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder myHolder = (ViewHolder) holder;
        NewsBean.NewsDTO newsDTO = list.get(position);
        myHolder.content.setText(newsDTO.getContent());
        myHolder.tile.setText(newsDTO.getTile());
        Glide.with(context).load(newsDTO.getImageUrl()).into(myHolder.imageUrl);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tile;
        private TextView content;
        private ImageView imageUrl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tile = (TextView) itemView.findViewById(R.id.tile);
            this.content = (TextView) itemView.findViewById(R.id.content);
            this.imageUrl = (ImageView) itemView.findViewById(R.id.imageUrl);
        }
    }
}
