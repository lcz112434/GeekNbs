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
import com.lcz.geek.CallBackss.ZhihuCallback.ItemClick;
import com.lcz.geek.R;
import com.lcz.geek.bean.Zhihu.RibaoBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

/**
 * Created by 李承泽 on 2019/4/11.
 */
public class RibaoAdapter extends RecyclerView.Adapter {
    private ArrayList<RibaoBean.StoriesBean> mList_item;
    private Context context;

    public void setList_item(ArrayList<RibaoBean.StoriesBean> list_item) {
        mList_item = list_item;
    }


    public RibaoAdapter(ArrayList<RibaoBean.StoriesBean> list_item, Context context) {
        mList_item = list_item;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.ribao_item2, null);
        holder = new ViewHolder2(inflate);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final int mposition = position;
        if (holder instanceof ViewHolder2) {
            RibaoBean.StoriesBean storiesBean = mList_item.get(mposition);
            ViewHolder2 viewHolder2 = (ViewHolder2) holder;
            viewHolder2.tv.setText(storiesBean.getTitle());
            Glide.with(context).load(storiesBean.getImages().get(0)).into(viewHolder2.iv);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mItemclick!=null){
                    mItemclick.onitemclick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList_item.size();
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
