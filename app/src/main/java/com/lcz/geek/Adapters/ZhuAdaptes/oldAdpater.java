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
import com.lcz.geek.bean.Zhihu.oldRibaoBean;

import java.util.ArrayList;

/**
 * Created by 李承泽 on 2019/4/18.
 */
public class oldAdpater extends RecyclerView.Adapter {
    private ArrayList<oldRibaoBean.StoriesBean> mOldlist;
    private Context mContext;
    private int time;

    public void setTime(int time) {
        this.time = time;
    }

    public void setOldlist(ArrayList<oldRibaoBean.StoriesBean> oldlist) {
        mOldlist = oldlist;
    }

    public oldAdpater(ArrayList<oldRibaoBean.StoriesBean> oldlist, Context context, int time) {
        mOldlist = oldlist;
        mContext = context;
        this.time = time;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        if (viewType == 1) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.text_item, null);
            holder = new ViewHolder(inflate);
        } else if (viewType == 2) {
            View inflate = LayoutInflater.from(mContext).inflate(R.layout.hot_item, null);
            holder = new ViewHolder2(inflate);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final int mposition = position - 1;
        if (mOldlist != null && mOldlist.size()>0) {

            if (holder instanceof ViewHolder) {
                ViewHolder viewHolder = (ViewHolder) holder;
                viewHolder.text_tv.setText(time+"");
            } else if (holder instanceof ViewHolder2) {
                oldRibaoBean.StoriesBean storiesBean = mOldlist.get(mposition); 

                ViewHolder2 viewHolder2 = (ViewHolder2) holder;
                viewHolder2.tv.setText(storiesBean.getTitle());
                Glide.with(mContext).load(storiesBean.getImages().get(0)).into(viewHolder2.iv);
            }
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mItemclick!=null){
                    mItemclick.onitemclick(mposition);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mOldlist.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        } else {
            return 2;
        }
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView text_tv;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.text_tv = (TextView) rootView.findViewById(R.id.text_tv);
        }

    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView iv;
        public TextView tv;

        public ViewHolder2(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.iv = (ImageView) rootView.findViewById(R.id.iv);
            this.tv = (TextView) rootView.findViewById(R.id.tv);
        }
    }
    public interface itemclick{
        void onitemclick(int position);
    }
    private itemclick mItemclick;

    public void setItemclick(itemclick itemclick) {
        mItemclick = itemclick;
    }
}
