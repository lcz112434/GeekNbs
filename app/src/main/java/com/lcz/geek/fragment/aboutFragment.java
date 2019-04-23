package com.lcz.geek.fragment;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lcz.geek.Base.BaseFragment;
import com.lcz.geek.R;
import com.lcz.geek.presenter.EmptyP;
import com.lcz.geek.view.EmptyV;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 李承泽 on 2019/4/3.
 */
public class aboutFragment extends BaseFragment<EmptyV, EmptyP> implements EmptyV {
    @BindView(R.id.tv_wechat)
    TextView tvWechat;
    @BindView(R.id.iv_wechat)
    ImageView ivWechat;
    Unbinder unbinder;
    @BindView(R.id.ll_about)
    LinearLayout llAbout;
    Unbinder unbinder1;

    @Override
    protected EmptyP initpresenter() {
        return new EmptyP();
    }

    @Override
    protected int getFragmentId() {
        return R.layout.activity_about;
    }


    @OnClick({R.id.tv_wechat, R.id.iv_wechat})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_wechat:
                inipop();
                break;
            case R.id.iv_wechat:
                inipop();
                break;
        }
    }

    private void inipop() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.popwindows_about, null);
        final PopupWindow popupWindow = new PopupWindow(inflate,
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(null);
        popupWindow.showAtLocation(llAbout, Gravity.CENTER,0,0);
        ImageView iv = inflate.findViewById(R.id.pop_iv);
        Glide.with(getContext()).load(R.drawable.lczwechat).into(iv);
        inflate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }
}
