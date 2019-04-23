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
import com.bumptech.glide.request.RequestOptions;
import com.lcz.geek.CallBackss.ZhihuCallback.ItemClick;
import com.lcz.geek.R;
import com.lcz.geek.bean.Zhihu.SpecialBean;

import java.util.ArrayList;

/**
 * Created by 李承泽 on 2019/4/11.
 */
public class SpecialAdapter extends RecyclerView.Adapter {
    private ArrayList<SpecialBean.DataBean> mList;
    private Context context;

    public void setList(ArrayList<SpecialBean.DataBean> list) {
        mList = list;
    }

    public SpecialAdapter(ArrayList<SpecialBean.DataBean> list, Context context) {
        mList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.special_item, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final SpecialBean.DataBean dataBean = mList.get(position);
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.tv.setText(dataBean.getDescription());
        viewHolder.tv_title.setText(dataBean.getName());
        Glide.with(context).load(dataBean.getThumbnail()).into(viewHolder.iv);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mItemClick!=null){
                    mItemClick.onitemclick(position,dataBean.getId());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView tv;
        public ImageView iv;
        public TextView tv_title;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv = (TextView) rootView.findViewById(R.id.tv);
            this.iv = (ImageView) rootView.findViewById(R.id.iv);
            this.tv_title = (TextView) rootView.findViewById(R.id.tv_title);
        }
    }
    private ItemClick mItemClick;

    public void setItemClick(ItemClick itemClick) {
        mItemClick = itemClick;
    }
}
