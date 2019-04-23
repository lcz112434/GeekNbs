package com.lcz.geek.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lcz.geek.R;
import com.lcz.geek.bean.Car;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 李承泽 on 2019/4/22.
 */
public class NodyAdapter extends RecyclerView.Adapter {
    private ArrayList<Car> mList;
    private Context context;

    public NodyAdapter(ArrayList<Car> list, Context context) {
        mList = list;
        this.context = context;
    }

    public void setList(ArrayList<Car> list) {
        mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.node_item, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        if(mList.get(position).getTitle().equals("")){

        }else {
            viewHolder.nodeTv.setText(mList.get(position).getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.node_tv)
        TextView nodeTv;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
