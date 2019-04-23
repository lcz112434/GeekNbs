package com.lcz.geek.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lcz.geek.Base.BaseFragment;
import com.lcz.geek.R;
import com.lcz.geek.presenter.EmptyP;
import com.lcz.geek.view.EmptyV;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class Gold_bodyFragment extends BaseFragment<EmptyV, EmptyP> {


    @BindView(R.id.tv)
    TextView tv;
    Unbinder unbinder;

    public static Gold_bodyFragment getInstead(String text) {
        Gold_bodyFragment gold_bodyFragment = new Gold_bodyFragment();
        Bundle buandl = new Bundle();
        buandl.putString("text", text);
        gold_bodyFragment.setArguments(buandl);
//        gold_bodyFragment.

        return gold_bodyFragment;
    }

    public Gold_bodyFragment() {
        // Required empty public constructor
    }


    @Override
    protected void initView() {
        super.initView();
        Bundle arguments = getArguments();
        String text = arguments.getString("text");
        tv.setText(text);
    }

    @Override
    protected EmptyP initpresenter() {
        return new EmptyP();
    }

    @Override
    protected int getFragmentId() {
        return R.layout.fragment_gold_body;
    }


}
