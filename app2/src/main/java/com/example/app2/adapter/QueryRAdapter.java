package com.example.app2.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app2.R;
import com.example.app2.bean.QueryBean;
import com.example.mylibrary.base.BaseAdapter;

import java.util.ArrayList;

public class QueryRAdapter extends BaseAdapter<QueryBean.StudenlistDTO> {

    public QueryRAdapter(ArrayList<QueryBean.StudenlistDTO> list, Context context) {
        super(list, context);
    }

    @Override
    protected RecyclerView.ViewHolder getViewHolder(View view) {
        return new ViewHolder(view);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_item_query;
    }

    @Override
    protected void bindMyViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder myHolder = (ViewHolder) holder;
        QueryBean.StudenlistDTO studenlistDTO = list.get(position);
        myHolder.name.setText("姓名：" + studenlistDTO.getName());
        myHolder.skill.setText("机试成绩：" + studenlistDTO.getSkill() + "分");
        myHolder.theory.setText("理论成绩：" + studenlistDTO.getTheory() + "分");
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
