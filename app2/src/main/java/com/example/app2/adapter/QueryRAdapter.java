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
import com.example.app2.bean.QueryBean;

import java.util.ArrayList;

public class QueryRAdapter extends RecyclerView.Adapter {
    private ArrayList<QueryBean.StudenlistDTO> list;
    private Context context;

    public QueryRAdapter(ArrayList<QueryBean.StudenlistDTO> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_query, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder myHolder = (ViewHolder) holder;
        QueryBean.StudenlistDTO studenlistDTO = list.get(position);
        myHolder.name.setText("姓名：" + studenlistDTO.getName());
        myHolder.skill.setText("机试成绩：" + studenlistDTO.getSkill() + "分");
        myHolder.theory.setText("理论成绩：" + studenlistDTO.getTheory() + "分");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView skill;
        private TextView theory;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = (TextView) itemView.findViewById(R.id.name);
            this.skill = (TextView) itemView.findViewById(R.id.skill);
            this.theory = (TextView) itemView.findViewById(R.id.theory);
        }
    }
}
