package com.lcz.geek.Adapters.ZhuAdaptes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lcz.geek.R;
import com.lcz.geek.bean.Zhihu.RibaoBean;

import java.util.ArrayList;

/**
 * Created by 李承泽 on 2019/4/14.
 */
public class RibaoVpAdapter extends PagerAdapter{
    private ArrayList<View> mViewList;
    private Context context;
    private ArrayList<RibaoBean.TopStoriesBean> mList_banner;

    public void setList_banner(ArrayList<RibaoBean.TopStoriesBean> list_banner) {
        mList_banner = list_banner;
    }

    public RibaoVpAdapter(ArrayList<View> viewList, Context context, ArrayList<RibaoBean.TopStoriesBean> list_banner) {
        mViewList = viewList;
        this.context = context;
        mList_banner = list_banner;
    }

    @Override
    public int getCount() {
        return mViewList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        final RibaoBean.TopStoriesBean topStoriesBean = mList_banner.get(position);
        View view = mViewList.get(position);
        ImageView iv = view.findViewById(R.id.ribao_vp_iv);
        TextView tv = view.findViewById(R.id.ribao_vp_tv);
        tv.setText(topStoriesBean.getTitle());
        Glide.with(context).load(topStoriesBean.getImage()).centerCrop().into(iv);
        container.addView(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mItemclick!=null){
                    mItemclick.onitemclick(position,topStoriesBean);
                }
            }
        });
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
        View view = mViewList.get(position);
        container.removeView(view);
    }

    public interface itemclick{
        void onitemclick(int position,RibaoBean.TopStoriesBean topStoriesBean);
    }
    private itemclick mItemclick;

    public void setItemclick(itemclick itemclick) {
        mItemclick = itemclick;
    }
}
