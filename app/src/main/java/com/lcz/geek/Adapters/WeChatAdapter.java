package com.lcz.geek.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lcz.geek.CallBackss.ZhihuCallback.ItemClick;
import com.lcz.geek.R;
import com.lcz.geek.bean.WeChatListBean;

import java.util.ArrayList;

/**
 * Created by 李承泽 on 2019/4/17.
 */
public class WeChatAdapter extends RecyclerView.Adapter {
    private ArrayList<WeChatListBean.NewslistBean> mlist;
    private Context context;

    public void setMlist(ArrayList<WeChatListBean.NewslistBean> mlist) {
        this.mlist = mlist;
    }

    public WeChatAdapter(ArrayList<WeChatListBean.NewslistBean> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.wechat_item, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        final WeChatListBean.NewslistBean newslistBean = mlist.get(position);
        viewHolder.tv.setText(newslistBean.getTitle());
        Glide.with(context).load(newslistBean.getPicUrl()).into(viewHolder.iv);
        viewHolder.tv_name.setText(newslistBean.getDescription());
        viewHolder.tv_time.setText(newslistBean.getCtime());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mWechatitemclick!=null){
                    mWechatitemclick.itemclick(newslistBean.getUrl());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView iv;
        public TextView tv;
        public TextView tv_name;
        public TextView tv_time;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv = (ImageView) rootView.findViewById(R.id.iv);
            this.tv = (TextView) rootView.findViewById(R.id.tv);
            this.tv_name = (TextView) rootView.findViewById(R.id.tv_name);
            this.tv_time = (TextView) rootView.findViewById(R.id.tv_time);
        }
    }
    public interface  Wechatitemclick{
        void itemclick(String url);
    }
    private Wechatitemclick mWechatitemclick;

    public void setWechatitemclick(Wechatitemclick wechatitemclick) {
        mWechatitemclick = wechatitemclick;
    }
}
