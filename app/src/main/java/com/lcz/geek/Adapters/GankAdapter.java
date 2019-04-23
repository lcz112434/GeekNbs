package com.lcz.geek.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.lcz.geek.R;
import com.lcz.geek.bean.GankListBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by 李承泽 on 2019/4/19.
 */
public class GankAdapter extends RecyclerView.Adapter {
    private ArrayList<GankListBean.ResultsBean> mlist;
    private Context context;
    private String title;
    String img;

    public void setMlist(ArrayList<GankListBean.ResultsBean> mlist) {
        this.mlist = mlist;
    }

    public GankAdapter(ArrayList<GankListBean.ResultsBean> mlist, Context context, String title, String img) {
        this.mlist = mlist;
        this.context = context;
        this.title = title;
        this.img = img;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        if (viewType == 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.gank_item2, null);
            holder = new ViewHolder2(inflate);
        } else if (viewType == 2) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.gank_item, null);
            holder = new ViewHolder(inflate);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == 1) {
            ViewHolder2 viewHolder2 = (ViewHolder2) holder;
            Glide.with(context).load(R.drawable.asaaaaaaa).into(viewHolder2.ivAndroid);

        } else if (itemViewType == 2) {

            ViewHolder viewHolder = (ViewHolder) holder;
            if (title.equals("android")) {
                Glide.with(context).load(R.mipmap.ic_android).into(viewHolder.gank_iv);
            } else if (title.equals("iOS")) {
                Glide.with(context).load(R.mipmap.ic_ios).into(viewHolder.gank_iv);
            } else if (title.equals("前端")) {
                Glide.with(context).load(R.mipmap.ic_web).into(viewHolder.gank_iv);
            } else {
                Glide.with(context).load(R.mipmap.ic_android).into(viewHolder.gank_iv);
            }
            int posi2 = position - 1;
            GankListBean.ResultsBean resultsBean = mlist.get(posi2);
            viewHolder.gank_tv_title.setText(resultsBean.getDesc());
            viewHolder.gank_autor.setText(resultsBean.getWho());
            String publishedAt = resultsBean.getPublishedAt();
            String[] ts = publishedAt.split("T");
            if (ts[0] != null) {
                viewHolder.gank_time.setText(ts[0]);
            } else {
                viewHolder.gank_time.setText("2019-04-17");
            }
        }
    }

    @Override
    public int getItemCount() {
        return mlist.size() + 1;
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
        public TextView gank_tv_title;
        public TextView gank_autor;
        public TextView gank_time;
        public ImageView gank_iv;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.gank_tv_title = (TextView) rootView.findViewById(R.id.gank_tv_title);
            this.gank_autor = (TextView) rootView.findViewById(R.id.gank_autor);
            this.gank_time = (TextView) rootView.findViewById(R.id.gank_time);
            this.gank_iv = (ImageView) rootView.findViewById(R.id.gank_iv);
        }

    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        @BindView(R.id.iv1231)
        ImageView ivAndroid;
        @BindView(R.id.iv_new)
        ImageView iv_new;


        ViewHolder2(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
