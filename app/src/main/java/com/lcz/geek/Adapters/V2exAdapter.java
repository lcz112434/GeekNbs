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
import com.lcz.geek.R;
import com.lcz.geek.bean.V2exBean;

import java.util.ArrayList;

/**
 * Created by 李承泽 on 2019/4/21.
 */
public class V2exAdapter extends RecyclerView.Adapter {
    private ArrayList<V2exBean> mList;
    private Context context;

    public void setList(ArrayList<V2exBean> list) {
        mList = list;
    }

    public V2exAdapter(ArrayList<V2exBean> list, Context context) {
        mList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.v2ex_item, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        V2exBean v2exBean = mList.get(position);
        Glide.with(context).load(v2exBean.getImg()).into(viewHolder.v2_iv);
        viewHolder.v2_autor.setText(v2exBean.getAutor());
        viewHolder.v2_fenlei.setText(v2exBean.getFenlei());
        viewHolder.v2_num.setText(v2exBean.getNum());
        viewHolder.v2_old.setText("1分钟前-最后回复");
        viewHolder.v2_title.setText(v2exBean.getTitle());
        viewHolder.v2_oldautor.setText(v2exBean.getOld());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView v2_iv;
        public TextView v2_autor;
        public TextView v2_old;
        public TextView v2_oldautor;
        public TextView v2_fenlei;
        public TextView v2_num;
        public TextView v2_title;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.v2_iv = (ImageView) rootView.findViewById(R.id.v2_iv);
            this.v2_autor = (TextView) rootView.findViewById(R.id.v2_autor);
            this.v2_old = (TextView) rootView.findViewById(R.id.v2_old);
            this.v2_oldautor = (TextView) rootView.findViewById(R.id.v2_oldautor);
            this.v2_fenlei = (TextView) rootView.findViewById(R.id.v2_fenlei);
            this.v2_num = (TextView) rootView.findViewById(R.id.v2_num);
            this.v2_title = (TextView) rootView.findViewById(R.id.v2_title);
        }

    }
}
