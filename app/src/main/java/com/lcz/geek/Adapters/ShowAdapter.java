package com.lcz.geek.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.lcz.geek.CallBackss.TouchCallBack;
import com.lcz.geek.R;
import com.lcz.geek.bean.GoldBean;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by 李承泽 on 2019/4/18.
 */
public class ShowAdapter extends RecyclerView.Adapter implements TouchCallBack {

    private ArrayList<GoldBean> mList;
    private Context context;

    public ShowAdapter(ArrayList<GoldBean> list, Context context) {
        mList = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.show_item, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        final GoldBean goldBean = mList.get(position);
        viewHolder.tv_show.setText(goldBean.title);
        viewHolder.sc.setChecked(goldBean.checked);

        viewHolder.sc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                goldBean.checked = isChecked;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onItemMove(int fromposition, int toposition) {
        Collections.swap(mList, fromposition, toposition);

        notifyItemMoved(fromposition, toposition);
    }

    @Override
    public void onItemDelete(int position) {
        mList.remove(position);

        notifyItemRemoved(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public TextView tv_show;
        public SwitchCompat sc;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.tv_show = (TextView) rootView.findViewById(R.id.tv_show);
            this.sc = (SwitchCompat) rootView.findViewById(R.id.sc);
        }

    }
}
