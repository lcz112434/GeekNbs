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
import com.lcz.geek.bean.Zhihu.HotBean;

import java.util.ArrayList;

/**
 * Created by 李承泽 on 2019/4/11.
 */
public class HoAdapter extends RecyclerView.Adapter {
    private ArrayList<HotBean.RecentBean> mList;
    private Context context;

    public void setList(ArrayList<HotBean.RecentBean> list) {
        mList = list;
    }

    public HoAdapter(ArrayList<HotBean.RecentBean> list, Context context) {
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
        ViewHolder viewHolder= (ViewHolder) holder;
        final HotBean.RecentBean recentBean = mList.get(position);
        viewHolder.tv.setText(recentBean.getTitle());
        Glide.with(context).load(recentBean.getThumbnail()).into(viewHolder.iv);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mIteclick!=null){
                    mIteclick.itemclick(recentBean.getNews_id());
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
        public ImageView iv;
        public TextView tv;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv = (ImageView) rootView.findViewById(R.id.iv);
            this.tv = (TextView) rootView.findViewById(R.id.tv);
        }

    }
    public interface iteclick{
        void  itemclick(int id);
    }
    private iteclick mIteclick;

    public void setIteclick(iteclick iteclick) {
        mIteclick = iteclick;
    }
}
