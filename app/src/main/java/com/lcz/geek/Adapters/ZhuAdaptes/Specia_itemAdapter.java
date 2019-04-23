package com.lcz.geek.Adapters.ZhuAdaptes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lcz.geek.R;
import com.lcz.geek.bean.Zhihu.SpecialtemBean;

import java.util.ArrayList;

/**
 * Created by 李承泽 on 2019/4/14.
 */
public class Specia_itemAdapter extends RecyclerView.Adapter {
    private ArrayList<SpecialtemBean.StoriesBean> mList;
    private Context context;

    public void setList(ArrayList<SpecialtemBean.StoriesBean> list) {
        mList = list;
    }

    public Specia_itemAdapter(ArrayList<SpecialtemBean.StoriesBean> list, Context context) {
        mList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.hot_item, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SpecialtemBean.StoriesBean storiesBean = mList.get(position);
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.tv.setText(storiesBean.getTitle());
        Glide.with(context).load(storiesBean.getImages().get(0)).into(viewHolder.iv);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv;
        public TextView tv;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv = (ImageView) rootView.findViewById(R.id.iv);
            this.tv = (TextView) rootView.findViewById(R.id.tv);
        }

    }
}
