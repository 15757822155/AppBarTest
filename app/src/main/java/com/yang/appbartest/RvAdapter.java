package com.yang.appbartest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017-08-23 0023.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {
    Context mContext;
    List<Student> mList;

    public RvAdapter(Context context) {
        mContext = context;
    }

    public List<Student> getList() {
        return mList;
    }

    public void setList(List<Student> list) {
        mList = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_layout, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Student student = getList().get(position);
        holder.num.setText(student.getNum());
        holder.name.setText(student.getName());
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : getList().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView num;
        TextView name;

        public MyViewHolder(View itemView) {
            super(itemView);
            num = (TextView) itemView.findViewById(R.id.num);
            name = (TextView) itemView.findViewById(R.id.name);
        }
    }

    public static class Student {
        String num;
        String name;

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
