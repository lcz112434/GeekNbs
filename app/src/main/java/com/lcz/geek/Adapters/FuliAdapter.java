package com.lcz.geek.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lcz.geek.R;
import com.lcz.geek.bean.FuliBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 李承泽 on 2019/4/19.
 */
public class FuliAdapter extends RecyclerView.Adapter {
    private ArrayList<FuliBean.ResultsBean> mList;
    private Context context;

    public void setList(ArrayList<FuliBean.ResultsBean> list) {
        mList = list;
    }

    public FuliAdapter(ArrayList<FuliBean.ResultsBean> list, Context context) {
        mList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fuli_item, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        Glide.with(context).load(mList.get(position).getUrl()).into(viewHolder.ivFuli);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mItemclick!=null)
                    mItemclick.onitemclick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.iv_fuli)
        ImageView ivFuli;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
    public interface  itemclick{
        void onitemclick(int position);
    }
   private itemclick mItemclick;

    public void setItemclick(itemclick itemclick) {
        mItemclick = itemclick;
    }
}
