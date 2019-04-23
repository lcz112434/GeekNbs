package com.lcz.geek.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lcz.geek.R;
import com.lcz.geek.utils.ToastUtil;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

public class TimeActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "TimeActivity";
    private ImageView mIvReturn;
    private Toolbar mTimeToobar;
    /**
     * 确定
     */
    private TextView mTimeTv;
    private MaterialCalendarView mCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        initView();
    }

    private void initView() {
        mIvReturn = (ImageView) findViewById(R.id.iv_return);
        mTimeToobar = (Toolbar) findViewById(R.id.time_toobar);
        mTimeToobar.setTitle("");
        setSupportActionBar(mTimeToobar);

        mTimeTv = (TextView) findViewById(R.id.time_tv);
        mTimeTv.setOnClickListener(this);
        mIvReturn.setOnClickListener(this);
        mCalendarView = (MaterialCalendarView) findViewById(R.id.calendarView);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;

            case R.id.time_tv:
                gettimer();
                break;

            case R.id.iv_return:
                finish();
                break;
        }
    }

    private void gettimer() {
        CalendarDay day = mCalendarView.getSelectedDate();
        String s22 = "";
        String s33 = "";
        String s44 = "";
        String time = "";
        if (day != null) {
            String s = day.toString();
            String substring = s.substring(11);
            String[] split = substring.split("-");
            for (int i = 0; i < split.length; i++) {
                s22 = split[1];
                s44 = split[2];
                Log.i("tag", s44);
                int i1 = Integer.parseInt(s22);

                int i2 = i1 + 1;
                s33 = i2 + "";
                if (s33.length() < 2) {
                    StringBuilder sb = new StringBuilder(s33);
                    sb.insert(0, "0");
                    s33 = sb.toString();
                }

                Log.d(TAG, "gettimer: " + s44.length());
                if (s44.length() < 3) {
                    StringBuilder sb = new StringBuilder(s44);
                    sb.insert(0, "0");
                    s44 = sb.toString();
                }
                Log.i("tag", s44);
                String s123 = (split[0] + s33 + s44).toString();
                Log.i("tag", s123);

                StringBuffer sb = new StringBuffer();
                sb.append(s123);
                String substring1 = sb.substring(1, 9);
                time = substring1;
                Log.d(TAG, "gettimer: " + time);
            }

            int i = Integer.parseInt(time);
            Log.i("tag", "i:" + i);

            getintent(i);
        }
    }

    private void getintent(int i) {
        Intent intent = getIntent();
        intent.putExtra("time", i);
        setResult(260, intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        gettimer();
    }
}
